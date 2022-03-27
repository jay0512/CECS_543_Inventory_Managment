package main;


import java.time.LocalDateTime;
import java.util.List;

public class CustomerOrder extends Order {

    private String orderId;
    private String customerId;
    private List<OrderItem> orderItems;
    private double totalOrderAmount;
    private double discountAmount;
    private LocalDateTime orderDate;

    public CustomerOrder(String orderId, String customerId, List<OrderItem> orderItems, double totalOrderAmount, double discountAmount, LocalDateTime orderDate) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderItems = orderItems;
        this.totalOrderAmount = totalOrderAmount;
        this.discountAmount = discountAmount;
        this.orderDate = orderDate;
    }

    public CustomerOrder createOrder(Order order) {
        CustomerOrder customerOrder = new CustomerOrder(order.getOrderId(), order.getCustomerId() ,order.getOrderItems(),order.getTotalOrderAmount(),0.0, order.getOrderDate());
        return customerOrder;
    }

    public CustomerOrder updateOrder(Order order) {
        CustomerOrder customerOrder = new CustomerOrder(order.getOrderId(), order.getCustomerId() ,order.getOrderItems(),order.getTotalOrderAmount(),0.0, order.getOrderDate());
        return customerOrder;
    }

    @Override
    public OrderItem getOrderItemDetails(String orderItemId) {
        for(OrderItem item : orderItems){
            if(item.getOrderItemId().equals(orderItemId)){
                return item;
            }
        }
        return null;
    }

    public double claculateGrandTotal() {
        double totalOrderAmount = 0;

        for(var  orderItem :orderItems){
            totalOrderAmount = totalOrderAmount + orderItem.getProduct().getSellingPrice() * orderItem.getQuantity();
        }

        return totalOrderAmount;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public double getTotalOrderAmount() {
        return totalOrderAmount;
    }

    public void setTotalOrderAmount(double totalOrderAmount) {
        this.totalOrderAmount = totalOrderAmount;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "CustomerOrder{" +
                "orderId='" + orderId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", orderItems=" + orderItems +
                ", totalOrderAmount=" + totalOrderAmount +
                ", discountAmount=" + discountAmount +
                ", orderDate=" + orderDate +
                '}';
    }
}
