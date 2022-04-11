import exception.FoundNotException;
import exception.InvalidInputException;
import exception.LimitExceedException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class InvoiceTest {

    Invoice invoice;

    @BeforeEach
    void instantiateInvoice() {
        this.invoice = new Invoice("1", LocalDateTime.now(), LocalDateTime.now(), "1", false, 500.0, 1100.0);
    }

    @Test
    void testGetInvoiceById() throws InvalidInputException, FoundNotException {
        // Given
        // this.owner

        // Perform
        Invoice invoice = Invoice.getInvoiceById("1");

        // Compare
        Assertions.assertAll("Compare StockItem",
                () -> Assertions.assertEquals("1", invoice.getInvoiceId()),
                () -> Assertions.assertEquals(500.0, invoice.getAmountDue()),
                () -> Assertions.assertEquals(false, invoice.getInvoiceStatus())
        );

    }

    @Test
    void testGetInvoiceByIdWithEmptyString() {

        // Given

        // Perform

        // Compare
        Throwable invalidInputException = Assertions.assertThrows(InvalidInputException.class, () -> {
            Invoice.getInvoiceById("");
        }, "InvalidInputException was Expected");

        Assertions.assertEquals("Input should not be empty", invalidInputException.getMessage());

    }

    @Test
    void testGetInvoiceByIdNotInDatabase() {

        // Given

        // Perform

        // Compare
        Throwable foundNotException = Assertions.assertThrows(FoundNotException.class, () -> {
            Invoice.getInvoiceById("3");
        }, "FoundNotException was Expected");

        Assertions.assertEquals("Invoice not found", foundNotException.getMessage());

    }

    @Test
    public void testGenerateInvoice() throws LimitExceedException {
        // Given
        List<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(new OrderItem("1", new Product("3", "TLC Microwave", "MW01", "Microwave with latest technology", 250.0, 200.0), 2));
        orderItems.add(new OrderItem("2", new Product("2", "Hitachi AC", "AC01", "AC with full comfort", 120.0, 100.0), 5));

        CustomerOrder customerOrder = new CustomerOrder();
        customerOrder.setOrderId("1");
        customerOrder.setOrderItems(orderItems);
        customerOrder.setCustomerId("1");

        CustomerOrder order = customerOrder.createOrder(customerOrder, 100.0);

        // Perform
        Invoice invoice = Invoice.generateInvoice("2", order, 500.0);


        // Compare
        Assertions.assertAll("Test Invoice",
                () -> Assertions.assertEquals("2", invoice.getInvoiceId()),
                () -> Assertions.assertEquals(false, invoice.getInvoiceStatus()),
                () -> Assertions.assertEquals(600.0, invoice.getAmountDue())
        );

    }

    @Test
    void testPayInvoiceInstallmentPaymentWithLimitExceed() {
        // Given
        // this.owner

        // Perform

        // Compare

        Throwable limitExceedException = Assertions.assertThrows(LimitExceedException.class, () -> {
            Invoice invoice = Invoice.payInvoiceInstallmentPayment(this.invoice, 1000.0);

        }, "LimitExceedException was Expected");

        Assertions.assertEquals("Amount paid cannot be more than amount due", limitExceedException.getMessage());

    }
}
