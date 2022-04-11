import exception.FoundNotException;
import exception.InvalidInputException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class ShopOwnerTest {

    ShopOwner owner;

    @BeforeEach
    void instantiateShopOwner() {
        List<Address> addresses = new ArrayList<>();
        addresses.add(new Address("1", "5000", "11", "Long Beach", "CA", "USA", "90015", false));
        this.owner = new ShopOwner("1", "Alex", "+15623339999",
                addresses, "Admin123");
    }

    /*
    Inventory Look Up Test Cases
    */
    @Test
    void testLookupInventory() {

        // Given
        Map<String, StockItem> inventoryItemMap = this.owner.getAllInventoryItems();

        // Perform
        int totalInventoryItems = inventoryItemMap.size();

        // Compare
        Assertions.assertEquals(10, totalInventoryItems);

    }

    @Test
    void testLookupInventoryItem() throws InvalidInputException, FoundNotException {
        // Given
        // this.owner

        // Perform
        StockItem inventoryItem = this.owner.lookupInventoryItem("2");

        // Compare
        Assertions.assertAll("Compare StockItem",
                () -> Assertions.assertEquals("2", inventoryItem.getProductId()),
                () -> Assertions.assertEquals("Hitachi AC", inventoryItem.getProductName()),
                () -> Assertions.assertEquals("AC01", inventoryItem.getProductCode()),
                () -> Assertions.assertEquals(120, inventoryItem.getProductQuantity()),
                () -> Assertions.assertEquals(1000, inventoryItem.getProductCapacity())
        );

    }

    @Test
    void testLookupInventoryItemWithEmptyString() {

        // Given
        Map<String, StockItem> inventoryItemMap = this.owner.getAllInventoryItems();

        // Perform

        // Compare
        Throwable invalidInputException = Assertions.assertThrows(InvalidInputException.class, () -> {
            this.owner.lookupInventoryItem("");
        }, "InvalidInputException was Expected");

        Assertions.assertEquals("Input should not be empty", invalidInputException.getMessage());

    }

    @Test
    void testLookupInventoryItemNotInInventory() {

        // Given

        // Perform

        // Compare
        Throwable foundNotException = Assertions.assertThrows(FoundNotException.class, () -> {
            this.owner.lookupInventoryItem("100");
        }, "FoundNotException was Expected");

        Assertions.assertEquals("Stock Item not found", foundNotException.getMessage());

    }

    @Test
    void testSearchInventoryItem() throws InvalidInputException, FoundNotException {

        // Given
        Map<String, StockItem> inventoryItemMap = this.owner.getAllInventoryItems();

        // Perform
        Map<String, StockItem> searchedInventoryItems = this.owner.searchInventoryItem("Hitachi");
        Map.Entry<String, StockItem> entry = searchedInventoryItems.entrySet().iterator().next();

        // Compare
        Assertions.assertEquals("StockItem{productId='2', productName='Hitachi AC', productCode='AC01', productQuantity=120, productCapacity=1000}", entry.getValue().toString());

    }

    @Test
    void testSearchInventoryItemWithEmptyString() {

        // Given

        // Perform

        // Compare
        Throwable invalidInputException = Assertions.assertThrows(InvalidInputException.class, () -> {
            this.owner.searchInventoryItem("");
        }, "InvalidInputException was Expected");

        Assertions.assertEquals("Input should not be empty", invalidInputException.getMessage());

    }

    @Test
    void testSearchInventoryItemNotInInventory() {

        // Given

        // Perform

        // Compare
        Throwable foundNotException = Assertions.assertThrows(FoundNotException.class, () -> {
            this.owner.searchInventoryItem("Sony");
        }, "FoundNotException was Expected");

        Assertions.assertEquals("Inventory item not found", foundNotException.getMessage());

    }

    /*
    Invoice Generate Test Cases
    */
    @Test
    void testGenerateInvoice() {
        // Given
        // this.owner

        // Perform
        Invoice invoice = this.owner.generateInvoice("1", "1", 600.0);

        // Compare
        Assertions.assertAll("Test Invoice",
                () -> Assertions.assertEquals("1", invoice.getInvoiceId()),
                () -> Assertions.assertEquals(false, invoice.getInvoiceStatus()),
                () -> Assertions.assertEquals(500.0, invoice.getAmountDue())
        );
    }

    @Test
    void testPayInvoiceInstallmentPayment() {
        // Given
        // this.owner

        // Perform
        Invoice invoice = this.owner.payInvoiceInstallmentPayment("1", 100.0);

        // Compare
        Assertions.assertAll("Test Invoice",
                () -> Assertions.assertEquals("1", invoice.getInvoiceId()),
                () -> Assertions.assertEquals(false, invoice.getInvoiceStatus()),
                () -> Assertions.assertEquals(400.0, invoice.getAmountDue())
        );
    }

}