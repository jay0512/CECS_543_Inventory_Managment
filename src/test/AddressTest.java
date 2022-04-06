package test;

import main.Address;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AddressTest {
    @Test
    public void testAddress() {
        // Given
        Address address = new Address("1", "1234 ABC street", "404", "Long Beach", "CA", "USA", "90888", true);

        // Compare
        Assertions.assertAll("Test Address",
                () -> Assertions.assertEquals("1", address.getAddressId()),
                () -> Assertions.assertEquals("1234 ABC street", address.getStreet()),
                () -> Assertions.assertEquals("404", address.getApt()),
                () -> Assertions.assertEquals("Long Beach", address.getCity()),
                () -> Assertions.assertEquals("CA", address.getState()),
                () -> Assertions.assertEquals("USA", address.getCountry()),
                () -> Assertions.assertEquals("90888", address.getZipCode()),
                () -> Assertions.assertEquals(true, address.getDefault())
        );
    }
}