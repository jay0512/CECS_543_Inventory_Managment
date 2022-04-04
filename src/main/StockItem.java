package main;

public class StockItem {

    private String productId;
    private String productName;
    private String productCode;
    private int productQuantity;
    private int productCapacity;

    public StockItem(String productId, String productName, String productCode, int productQuantity, int productCapacity) {
        this.productId = productId;
        this.productName = productName;
        this.productCode = productCode;
        this.productQuantity = productQuantity;
        this.productCapacity = productCapacity;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public int getProductCapacity() {
        return productCapacity;
    }

    public void setProductCapacity(int productCapacity) {
        this.productCapacity = productCapacity;
    }

    @Override
    public String toString() {
        return "StockItem{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", productCode='" + productCode + '\'' +
                ", productQuantity=" + productQuantity +
                ", productCapacity=" + productCapacity +
                '}';
    }
}
