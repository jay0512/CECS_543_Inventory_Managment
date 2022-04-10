import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class CustomerOrderTest {

    CustomerOrder order;

    @BeforeEach
    void instantiateOrder() {

        List<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(new OrderItem("1", new Product("3", "TLC Microwave", "MW01", "Microwave with latest technology", 250.0, 200.0), 2));
        orderItems.add(new OrderItem("2", new Product("2", "Hitachi AC", "AC01", "AC with full comfort", 120.0, 100.0), 5));

        CustomerOrder customerOrder = new CustomerOrder();
        customerOrder.setOrderId("1");
        customerOrder.setOrderItems(orderItems);
        customerOrder.setCustomerId("1");

        this.order = customerOrder.createOrder(customerOrder, 100.0);

    }

    @Test
    void getOrderItemDetails() {
        // Given
        // this.order

        // Perform
        OrderItem orderItem = order.getOrderItemDetails("2");

        // Compare
        Assertions.assertAll("Test getOrderItemDetails",
                () -> Assertions.assertEquals("2", orderItem.getOrderItemId()),
                () -> Assertions.assertEquals("Product{productId='2', name='Hitachi AC', productCode='AC01', description='AC with full comfort', sellingPrice=120.0, costPrice=100.0}", orderItem.getProduct().toString()),
                () -> Assertions.assertEquals(5, orderItem.getQuantity())
        );

    }

    @Test
    void calculateGrandTotal() {
        // Given
        // this.order

        // Perform
        double totalOrderAmount = order.getTotalOrderAmount();

        // Compare
        Assertions.assertEquals(1100.0, totalOrderAmount);
    }
}