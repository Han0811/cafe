package com.project.Quan_li_cafe.service;

import com.project.Quan_li_cafe.dtos.createOrderDTO;

import org.springframework.beans.factory.annotation.Autowired;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.project.Quan_li_cafe.service.TemporaryOrderStorage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private TemporaryOrderStorage temporaryOrderStorage;

    public void sendOrderConfirmation(String toEmail, String name, String phone, String address,
            String staffName, String orderDetails, int totalPrice, String token) {
        String subject = "Xác nhận đơn hàng của bạn";
        String body = "<html>" +
                "<body>" +
                "<h3>Chào " + name + ",</h3>" +
                "<p>Đơn hàng của bạn đã được ghi nhận. Vui lòng xác nhận để hoàn tất.</p>" +
                "<p>Thông tin đơn hàng:</p>" +
                "<pre>" + orderDetails + "</pre>" +
                "<p>Tổng giá: " + totalPrice + " VND</p>" +
                "<p><a href='http://localhost:8080/email/confirm?token=" + token + "'>" +
                "<button style='background-color: #4CAF50; color: white; padding: 10px 24px; border: none;'>Xác nhận đơn hàng</button>"
                +
                "</a></p>" +
                "<p>Cảm ơn bạn đã mua sắm tại cửa hàng của chúng tôi!</p>" +
                "</body>" +
                "</html>";
        try {
            // Khởi tạo MimeMessage
            MimeMessage message = mailSender.createMimeMessage();

            // Sử dụng MimeMessageHelper để cấu hình email
            MimeMessageHelper helper = new MimeMessageHelper(message, true); // true để gửi email với body là HTML
            helper.setTo(toEmail);
            helper.setSubject(subject);
            helper.setText(body, true); // true để body là HTML

            // Gửi email
            mailSender.send(message); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String sendNotify(String token) {
        createOrderDTO dto = temporaryOrderStorage.getOcreateOrderDTO(token);
        if(dto == null) {
            dto = new createOrderDTO();
            dto.setMail(dto.getMail());
            dto.setName("an");

        }
        String subject = "Thông báo hủy đơn hàng của bạn";
        String body = "<html>" +
                "<body>" +
                "<h3>Chào " + dto.getName() + ",</h3>" +
                "<p>Đơn hàng của bạn đã bị hủy do quá hạn thời gian.</p>" +
                "<p>Thông tin đơn hàng:</p>" +
                // "<pre>" + dto.getOrderDetail() + "</pre>" +
                "<p>Cảm ơn bạn đã ghé thăm cửa hàng của chúng tôi!</p>" +
                "</body>" +
                "</html>";
    try {
            // Khởi tạo MimeMessage
            MimeMessage message = mailSender.createMimeMessage();

            // Sử dụng MimeMessageHelper để cấu hình email
            MimeMessageHelper helper = new MimeMessageHelper(message, true); // true để gửi email với body là HTML
            helper.setTo(dto.getMail());
            helper.setSubject(subject);
            helper.setText(body, true); // true để body là HTML

            // Gửi email
            mailSender.send(message); 
            return "Email đã được gửi thành công!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Gửi email thất bại: " + e.getMessage();
        }
    }

    public String sendNotifyOk(String token) {
        createOrderDTO dto = temporaryOrderStorage.getOcreateOrderDTO(token);
        String subject = "Thông báo đơn hàng";
        String body = "<html>" +
                "<body>" +
                "<p>Đơn hàng của bạn đã được xác nhận.</p>" +
                "<p>Cảm ơn bạn đã ghé thăm cửa hàng của chúng tôi!</p>" +
                "</body>" +
                "</html>";
    try {
            // Khởi tạo MimeMessage
            MimeMessage message = mailSender.createMimeMessage();

            // Sử dụng MimeMessageHelper để cấu hình email
            MimeMessageHelper helper = new MimeMessageHelper(message, true); // true để gửi email với body là HTML
            helper.setTo(dto.getMail());
            helper.setSubject(subject);
            helper.setText(body, true); // true để body là HTML

            // Gửi email
            mailSender.send(message); 
            return "Email đã được gửi thành công!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Gửi email thất bại: " + e.getMessage();
        }
    }
}
