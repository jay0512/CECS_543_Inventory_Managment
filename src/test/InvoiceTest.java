package test;

import main.Invoice;
import main.Product;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InvoiceTest {

    @Test
    public void testGenerateInvoice() throws  Exception{
        List<Product> products = new ArrayList<>();
        products.add(new Product("1","TV", "Samsung TV", 100.0));

        Map<String, Integer> productQuantities = new HashMap<>();
        productQuantities.put("1",2);


        Invoice invoice = new Invoice("1", 200.0, products, productQuantities);

        System.out.println(invoice.claculateGrandTotal());
    }
}
