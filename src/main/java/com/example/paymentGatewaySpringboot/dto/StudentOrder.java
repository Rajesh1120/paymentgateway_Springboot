package com.example.paymentGatewaySpringboot;
import jakarta.persistence.*;


@Entity
@Table(name="student_orders")
public class StudentOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;
    private String name;
    private String email;
    private String phno;
    private String course;
    private Integer amount;
    private String orderStatus;
    private String razorpayOrderId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRazorpayOrderId() {
        return razorpayOrderId;
    }

    public void setRazorpayOrderId(String razorpayOrderId) {
        this.razorpayOrderId = razorpayOrderId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getPhno() {
        return phno;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString(){
        return "Studentorder [orderId="+ orderId+",name=" + name + "" +
                ",email =" + email + ", phno=" +phno + ", course=" + course + ", amount=" + amount +
                ", orderStatus =" + orderStatus + ",razorpayOrderId=" + razorpayOrderId + "]";

    }
}
