import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerOrder extends Order {

    private String orderId;
    private String customerId;
    private List<OrderItem> orderItems;
    private double totalOrderAmount;
    private double discountAmount;
    private LocalDateTime orderDate;

    public CustomerOrder() {

    }

    public static CustomerOrder getCustomerOrder(String orderId) {
        Map<String, CustomerOrder> orders = getAllOrders();

        return orders.get(orderId);
    }

    public static Map<String, CustomerOrder> getAllOrders() {
        Map<String, CustomerOrder> orders = new HashMap<>();

        try {
            List<String[]> dataList = FileUtils.getDataFromFile("Order.csv");
            for (String[] data : dataList) {
                CustomerOrder customerOrder = new CustomerOrder();

                customerOrder.setOrderId(data[0]);
                customerOrder.setCustomerId(data[1]);
                customerOrder.setOrderItems(getOrderItems(data[2]));
                customerOrder.setTotalOrderAmount(Double.parseDouble(data[3]));
                customerOrder.setDiscountAmount(Double.parseDouble(data[4]));
                customerOrder.setOrderDate(LocalDateTime.parse(data[5]));

                orders.put(data[0], customerOrder);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return orders;
    }

    public static List<OrderItem> getOrderItems(String orderItemsString) {
        List<OrderItem> orderItems = new ArrayList<>();
        Matcher m = Pattern.compile("(?<=\\{).+?(?=\\})").matcher(orderItemsString);
        while (m.find()) {
            String[] data = m.group().split("|");
            OrderItem orderItem = new OrderItem(data[0], Product.getProductById(data[1]), Integer.parseInt(data[2]));

            orderItems.add(orderItem);
        }

        return orderItems;
    }

    public CustomerOrder createOrder(Order order) {
        return createOrder(order, 0.0);
    }

    public CustomerOrder createOrder(Order order, double discountAmount) {
        CustomerOrder customerOrder = new CustomerOrder();

        customerOrder.setOrderId(order.getOrderId());
        customerOrder.setCustomerId(order.getCustomerId());
        customerOrder.setOrderItems(order.getOrderItems());
        customerOrder.setTotalOrderAmount(calculateGrandTotal());
        customerOrder.setDiscountAmount(discountAmount);
        customerOrder.setOrderDate(LocalDateTime.now());

        return customerOrder;
    }

    public CustomerOrder updateOrder(Order order) {
        return updateOrder(order, 0.0);
    }

    public CustomerOrder updateOrder(Order order, double discountAmount) {
        CustomerOrder customerOrder = new CustomerOrder();

        customerOrder.setOrderId(order.getOrderId());
        customerOrder.setCustomerId(order.getCustomerId());
        customerOrder.setOrderItems(order.getOrderItems());
        customerOrder.setTotalOrderAmount(calculateGrandTotal());
        customerOrder.setDiscountAmount(discountAmount);
        customerOrder.setOrderDate(LocalDateTime.now());

        return customerOrder;
    }

    @Override
    public OrderItem getOrderItemDetails(String orderItemId) {
        for (OrderItem item : orderItems) {
            if (item.getOrderItemId().equals(orderItemId)) {
                return item;
            }
        }
        return null;
    }

    public double calculateGrandTotal() {
        double totalOrderAmount = 0;

        for (var orderItem : orderItems) {
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

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
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
