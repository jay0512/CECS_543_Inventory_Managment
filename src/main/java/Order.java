import java.time.LocalDateTime;
import java.util.List;

public abstract class Order {

    private String orderId;
    private String customerId;
    private List<OrderItem> orderItems;
    private double totalOrderAmount;
    private LocalDateTime orderDate;

    public abstract OrderItem getOrderItemDetails(String orderItemId);

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public double getTotalOrderAmount() {
        return totalOrderAmount;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }
}
