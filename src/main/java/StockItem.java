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

    public String getProductName() {
        return productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public int getProductCapacity() {
        return productCapacity;
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
