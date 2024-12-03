# Sử dụng base image có cài đặt JDK
FROM openjdk:21-jdk-slim

# Đặt thư mục làm việc trong container
WORKDIR /app

# Copy file JAR từ thư mục target vào container
COPY target/websiteSellingLaptop-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080 (hoặc port mà ứng dụng của bạn sử dụng)
EXPOSE 8080

# Lệnh khởi chạy ứng dụng Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]
