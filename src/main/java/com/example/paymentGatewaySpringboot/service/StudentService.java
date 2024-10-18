package com.example.paymentGatewaySpringboot.service;

import com.example.paymentGatewaySpringboot.StudentOrder;
import com.example.paymentGatewaySpringboot.repo.StudentOrderRepo;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class StudentService {

    // connecting the database to service layer
    @Autowired
    private StudentOrderRepo studentRepo;

    // access the values of razorpay key and secret
    @Value("${razorpay.key.id}")
    private String razorPayKey;
    @Value("${razorpay.secret.key}")
    private String razorPaySecretKey;

    // it is used to communicate with the razorpay app
    private RazorpayClient client;
    public StudentOrder createOrder(StudentOrder stuOrder) throws Exception {

        // create method accepts only jsonobject so order should convert to json format
        JSONObject orderReq= new JSONObject();
        orderReq.put("amount", stuOrder.getAmount() * 100) ; // amount in paisa
        orderReq.put("currency", "INR");
        orderReq.put("receipt", stuOrder.getEmail());

        // passing the key and sercet key to client
        this.client=new RazorpayClient(razorPayKey,razorPaySecretKey);

        //create order in razorpay
        Order razorPayOrder = client.orders.create(orderReq);

        stuOrder.setRazorpayOrderId(razorPayOrder.get("id"));
        stuOrder.setOrderStatus(razorPayOrder.get("status"));

        studentRepo.save(stuOrder);

        return stuOrder;
    }

    public StudentOrder updateOrder(Map<String,String> responsePayLoad){

        String razorPayOrderId= responsePayLoad.get("razorpay_order_id");
        StudentOrder order= studentRepo.findByRazorpayOrderId(razorPayOrderId);
        order.setOrderStatus("Payment_completed");
        StudentOrder updatedOrder =studentRepo.save(order);
        return updatedOrder;
    }

}
