package main;

import java.util.List;
import java.util.Map;

public class Invoice {
    private String invoiceId;
    private Double grandTotal;
    private List<Product> products;
    private Map<String, Integer> productQuantities;

    public Invoice(String invoiceId, Double grandTotal, List<Product> products, Map<String, Integer> productQuantities) {
        this.invoiceId = invoiceId;
        this.grandTotal = grandTotal;
        this.products = products;
        this.productQuantities = productQuantities;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(Double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Map<String, Integer> getProductQuantities() {
        return productQuantities;
    }

    public void setProductQuantities(Map<String, Integer> productQuantities) {
        this.productQuantities = productQuantities;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceId='" + invoiceId + '\'' +
                ", grandTotal=" + grandTotal +
                ", products=" + products +
                ", productQuantities=" + productQuantities +
                '}';
    }

    public double claculateGrandTotal() {
        for(var qnt:productQuantities){

        }
    }
}
