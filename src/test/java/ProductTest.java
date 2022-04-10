import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProductTest {
    @Test
    public void testProduct() {
        // Given
        Product product = new Product("3", "TLC Microwave", "MW01", "Microwave with latest technology", 250.0, 200.0);

        // Compare
        Assertions.assertAll("Test Product",
                () -> Assertions.assertEquals("3", product.getProductId()),
                () -> Assertions.assertEquals("TLC Microwave", product.getName()),
                () -> Assertions.assertEquals("MW01", product.getProductCode()),
                () -> Assertions.assertEquals("Microwave with latest technology", product.getDescription()),
                () -> Assertions.assertEquals(250.0, product.getSellingPrice()),
                () -> Assertions.assertEquals(200.0, product.getCostPrice())
        );
    }
}