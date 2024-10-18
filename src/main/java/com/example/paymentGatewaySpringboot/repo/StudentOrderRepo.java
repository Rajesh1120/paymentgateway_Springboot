package com.example.paymentGatewaySpringboot.repo;

import com.example.paymentGatewaySpringboot.StudentOrder;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentOrderRepo extends JpaRepository<StudentOrder, Integer> {
    public  StudentOrder findByRazorpayOrderId(String orderId);
}
