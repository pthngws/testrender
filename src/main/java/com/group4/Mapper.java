package com.group4;

import com.group4.entity.*;
import com.group4.model.*;

import java.util.stream.Collectors;

public class Mapper {
    public static OrderModel toOrderModel(OrderEntity order) {
        if (order == null) {
            return null;
        }
        OrderModel model = new OrderModel();
        model.setOrderId(order.getOrderId());
        //model.setUser(Mapper.toUserModel(order.getUser()));
        model.setShippingAddress(toAddressModel(order.getShippingAddress()));
        model.setOrderDate(order.getOrderDate());
        model.setReceiveDate(order.getReceiveDate());
        model.setShippingStatus(order.getShippingStatus());
        model.setPayment(toPaymentModel(order.getPayment()));
        model.setShippingMethod(order.getShippingMethod());
        model.setPhoneNumber(order.getPhoneNumber());
        model.setNote(order.getNote());
        model.setListLineItems(order.getListLineItems()
                .stream()
                .map(Mapper::toLineItemModel)
                .collect(Collectors.toList()));
        return model;
    }

    public static PaymentModel toPaymentModel(PaymentEntity entity) {
        PaymentModel model = new PaymentModel();
        model.setPaymentID(entity.getPaymentID());
        model.setPaymentDate(entity.getPaymentDate());
        model.setPaymentStatus(entity.getPaymentStatus());
        model.setPaymentMethod(entity.getPaymentMethod());
        model.setTotal(entity.getTotal());
        model.setOrder(toOrderModel(entity.getOrder()));
        return model;
    }

    public static AddressModel toAddressModel(AddressEntity entity) {
        if (entity == null) {
            return null;
        }
        AddressModel model = new AddressModel();
        model.setAddressID(entity.getAddressID());
        model.setCountry(entity.getCountry());
        model.setProvince(entity.getProvince());
        model.setDistrict(entity.getDistrict());
        model.setCommune(entity.getCommune());
        model.setOther(entity.getOther());

        return model;
    }

    public static LineItemModel toLineItemModel(LineItemEntity lineItem) {
        if (lineItem == null) {
            return null;
        }
        LineItemModel model = new LineItemModel();
        model.setId(lineItem.getId());
        model.setProduct(Mapper.toProductModel(lineItem.getProduct()));
        model.setQuantity(lineItem.getQuantity());
        model.setOrder(Mapper.toOrderModel(lineItem.getOrder()));
        return model;
    }

    public static CategoryModel toCategoryModel(CategoryEntity entity) {
        if (entity == null) {
            return null;
        }

        CategoryModel model = new CategoryModel();
        model.setCategoryID(entity.getCategoryID());
        model.setName(entity.getName());
        model.setDescription(entity.getDescription());

        return model;
    }

    public static ManufacturerModel toManufacturerModel(ManufacturerEntity entity) {
        if (entity == null) {
            return null;
        }

        ManufacturerModel model = new ManufacturerModel();
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setAddress(entity.getAddress());

        model.setProducts(entity.getProducts()
                .stream()
                .map(Mapper::toProductModel)
                .collect(Collectors.toList()));
        return model;
    }

    public static ChatModel toChatModel(ChatEntity entity) {
        if (entity == null) {
            return null;
        }

        ChatModel model = new ChatModel();
        model.setChatID(entity.getChatID());
        //model.setCustomerID(entity.getCustomerID());
        model.setSentTime(entity.getSentTime());
        model.setContentMessage(entity.getContentMessage());

        return model;
    }

    public static ProductModel toProductModel(ProductEntity entity) {
        if (entity == null) {
            return null;
        }

        ProductModel model = new ProductModel();
        model.setProductID(entity.getProductID());
        model.setName(entity.getName());
        model.setPrice(entity.getPrice());
        model.setStatus(entity.getStatus());
        model.setCategory(toCategoryModel(entity.getCategory()));
        model.setManufacturer(Mapper.toManufacturerModel(entity.getManufacturer()));
        model.setDetail(toProductDetailModel(entity.getDetail()));

        return model;
    }

    public static ProductDetailModel toProductDetailModel(ProductDetailEntity entity) {
        if (entity == null) {
            return null;
        }

        ProductDetailModel model = new ProductDetailModel();
        model.setProductDetailID(entity.getProductDetailID());
        model.setRAM(entity.getRAM());
        model.setCPU(entity.getCPU());
        model.setGPU(entity.getGPU());
        model.setMonitor(entity.getMonitor());
        model.setCharger(entity.getCharger());
        model.setDisk(entity.getDisk());
        model.setConnect(entity.getConnect());
        model.setLAN(entity.getLAN());
        model.setWIFI(entity.getWIFI());
        model.setBluetooth(entity.getBluetooth());
        model.setAudio(entity.getAudio());
        model.setWebcam(entity.getWebcam());
        model.setOperationSystem(entity.getOperationSystem());
        model.setWeight(entity.getWeight());
        model.setColor(entity.getColor());
        model.setSize(entity.getSize());
        model.setDescription(entity.getDescription());
        if (entity.getImages() != null) {
            model.setImages(entity.getImages().stream()
                    .map(Mapper::toImageItemModel)
                    .collect(Collectors.toList()));
        }

        return model;
    }

    public static ImageItemModel toImageItemModel(ImageItemEntity entity) {
        ImageItemModel model = new ImageItemModel();
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setImageUrl(entity.getImageUrl());
        model.setProductDetail(toProductDetailModel(entity.getProductDetail()));
        return model;
    }

    public static UserModel toUserModel(UserEntity entity) {
        if (entity == null) {
            return null;
        }

        UserModel model = new UserModel();
        model.setUserID(entity.getUserID());
        model.setName(entity.getName());
        model.setEmail(entity.getEmail());
        model.setPassword(entity.getPassword());
        model.setGender(entity.getGender());
        model.setPhone(entity.getPhone());
        model.setAddress(toAddressModel(entity.getAddress()));

        return model;
    }
}
