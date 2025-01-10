package com.project.Quan_li_cafe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import com.project.Quan_li_cafe.service.EmailService;
import com.project.Quan_li_cafe.dtos.createOrderDTO;
import com.project.Quan_li_cafe.service.TemporaryOrderStorage;
import com.project.Quan_li_cafe.service.createOrder;
import com.project.Quan_li_cafe.dtos.orderdetailDTO;
import com.project.Quan_li_cafe.models.productEN;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/email")
public class EmailCO {

    @Autowired
    private EmailService emailService;

    @Autowired
    private TemporaryOrderStorage temporaryOrderStorage;

    @Autowired
    private createOrder createOrder;

    @PostMapping("/send")
    public String sendEmail(@RequestBody Map<String, Object> requestData) {
        try {
            // Lấy dữ liệu từ request
            String toEmail = (String) requestData.get("mail");
            String name = (String) requestData.get("name");
            String phone = (String) requestData.get("phone");
            String address = (String) requestData.get("address");
            String staffName = (String) requestData.get("staffName");
            int id_staff = (int) requestData.get("id_staff");
            List<Map<String, Object>> orderDetails = (List<Map<String, Object>>) requestData.get("orderDetail");

            // Xây dựng chuỗi chi tiết đơn hàng
            List<orderdetailDTO> orderDetailDTOList = new ArrayList<>();
            StringBuilder orderDetailsString = new StringBuilder();
            int totalPrice = 0;
            for (Map<String, Object> item : orderDetails) {
                String productName = (String) ((Map<String, Object>) item.get("id_pro")).get("name");
                int amount = (int) item.get("amount");
                int price = (int) ((Map<String, Object>) item.get("id_pro")).get("price");
                int id = (int) ((Map<String, Object>) item.get("id_pro")).get("id");
                productEN product = new productEN();
                product.setId(id);
                int total = price * amount;
                totalPrice += total;

                orderdetailDTO orderDetailDTO = new orderdetailDTO();
                orderDetailDTO.setId_pro(product);
                orderDetailDTO.setAmount(amount);
                orderDetailDTOList.add(orderDetailDTO);

                orderDetailsString
                        .append(String.format("- %s: %d x %d = %d VND\n", productName, amount, price, total));
            }

            createOrderDTO dto = new createOrderDTO();
            dto.setName(name);
            dto.setMail(toEmail);
            dto.setPhone(phone);
            dto.setAddress(address);
            dto.setId_staff(id_staff);
            dto.setOrderDetail(orderDetailDTOList);

            String token = temporaryOrderStorage.savecreateOrderDTO(dto);


            // Gửi email
            

            emailService.sendOrderConfirmation(toEmail, name, phone, address, staffName, orderDetailsString.toString(),
                    totalPrice, token);

            return "Email đã được gửi thành công!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Gửi email thất bại: " + e.getMessage();
        }
    }

    @GetMapping("/confirm")
    public String confirmOrder(@RequestParam String token) {
        try {
            createOrder.saveOrderFromRedisToDatabase(token);
            emailService.sendNotifyOk(token);
            temporaryOrderStorage.removecreateOrderDTO(token);
            return "Xác nhận đơn hàng thành công!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Xác nhận đơn hàng thất bại: " + e.getMessage();
        }
    }
}
