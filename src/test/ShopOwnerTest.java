package test;

import main.Address;
import main.ShopOwner;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ShopOwnerTest {

    @Test
    void lookupInventory() {
        List<Address> addresses = new ArrayList<>();
        addresses.add(new Address("1", "5000", "11", "Long Beach", "CA", "USA", "90015", false));
        ShopOwner owner = new ShopOwner("1", "Alex", "+15623339999",
                addresses, "Admin123");

        owner.getAllInventoryItems();
    }
}