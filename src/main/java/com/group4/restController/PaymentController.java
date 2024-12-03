package com.group4.restController;

import com.group4.config.ResponseObject;
import com.group4.dto.PaymentDTO;
import com.group4.dto.QRPaymentRequest;
import com.group4.service.IPaymentService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {
    private final IPaymentService paymentService;
    //Tạo mã QR thanh toán.
    @PostMapping("/qr")
    public ResponseEntity<Map<String, Object>> generateQRPayment(@RequestBody QRPaymentRequest request) {
        String qrCode = paymentService.generateQr(request.getAmount(), request.getOrderId());
        return ResponseEntity.ok(Map.of("qrCode", qrCode));
    }

    @GetMapping("qr-callback")
    public void qrPayCallbackHandler(HttpServletRequest request){

    }

    @GetMapping("/vn-pay")
    public ResponseObject<PaymentDTO> bankPay(HttpServletRequest request) {
        return new ResponseObject<>(HttpStatus.OK, "Success", paymentService.createVnPayPayment(request));
    }
    @GetMapping("/vn-pay-callback")
    public void bankPayCallbackHandler(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String status = request.getParameter("vnp_ResponseCode");
        if (status.equals("00")) {
            response.getWriter().write(
                    "<script>" +
                            "alert('Đơn hàngd đã thanh toán thành công');"+
                            "</script>"
            );
            response.sendRedirect("/order-history");
            //return new ResponseObject<>(HttpStatus.OK, "Success", new PaymentDTO("00", "Success", ""));
        } else {
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write(
                    "<script>" +
                         "alert('Thanh toán thất bại. Vui lòng thử lại!');" + // Hiển thị popup lỗi//
                            "window.history.back();" + // Quay lại trang trước đó
                    "</script>"
            );
            //return new ResponseObject<>(HttpStatus.BAD_REQUEST, "Failed", null);
        }
    }
}

