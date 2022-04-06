package test;

import main.Address;
import main.ShopOwner;
import main.StockItem;
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

    @Test
    void lookupInventory() {

        // Given
        Map<String, StockItem> inventoryItemMap = this.owner.getAllInventoryItems();

        // Perform
        int totalInventoryItems = inventoryItemMap.size();

        // Compare
        Assertions.assertEquals(10, totalInventoryItems);

    }

    @Test
    void lookupInventoryItem() {
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
    void searchInventoryItem() {

        // Given
        Map<String, StockItem> inventoryItemMap = this.owner.getAllInventoryItems();

        // Perform
        Map<String, StockItem> searchedInventoryItems = this.owner.searchInventoryItem("Hitachi");
        Map.Entry<String, StockItem> entry = searchedInventoryItems.entrySet().iterator().next();

        // Compare
        Assertions.assertEquals("StockItem{productId='2', productName='Hitachi AC', productCode='AC01', productQuantity=120, productCapacity=1000}", entry.getValue().toString());

    }
}