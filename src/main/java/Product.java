import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Product {

    private String productId;
    private String name;
    private String productCode;
    private String description;
    private Double sellingPrice;
    private Double costPrice;

    public Product(String productId, String name, String productCode, String description, Double sellingPrice, Double costPrice) {
        this.productId = productId;
        this.name = name;
        this.productCode = productCode;
        this.description = description;
        this.sellingPrice = sellingPrice;
        this.costPrice = costPrice;
    }

    public static Product getProductById(String productId) {
        Map<String, Product> products = getAllProducts();

        return products.get(productId);

    }

    public static Map<String, Product> getAllProducts() {
        Map<String, Product> products = new HashMap<>();
        try {
            List<String[]> dataList = FileUtils.getDataFromFile("Product.csv");
            for (String[] data : dataList) {
                Product product = new Product(data[0], data[1], data[2], data[3], Double.parseDouble(data[4]), Double.parseDouble(data[5]));
                products.put(data[0], product);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return products;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getProductCode() {
        return productCode;
    }

    public String getDescription() {
        return description;
    }

    public Double getSellingPrice() {
        return sellingPrice;
    }

    public Double getCostPrice() {
        return costPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", name='" + name + '\'' +
                ", productCode='" + productCode + '\'' +
                ", description='" + description + '\'' +
                ", sellingPrice=" + sellingPrice +
                ", costPrice=" + costPrice +
                '}';
    }

}
