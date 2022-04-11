public class OrderItem {

    String orderItemId;
    Product product;
    int quantity;

    public OrderItem(String orderItemId, Product product, int quantity) {
        this.orderItemId = orderItemId;
        this.product = product;
        this.quantity = quantity;
    }

    public String getOrderItemId() {
        return orderItemId;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "orderItemId='" + orderItemId + '\'' +
                ", product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
