package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopOwner extends User {

    private String userId;
    private String name;
    private String contactNumber;
    private List<Address> addresses;
    private String password;

    public ShopOwner(String userId, String name, String contactNumber, List<Address> addresses, String password) {
        super(userId, name, contactNumber, addresses);
        this.password = password;
    }

    public StockItem lookupInventoryItem(String productId) {
        Map<String, StockItem> stockItems = getAllInventoryItems();

        return stockItems.get(productId);

    }

    public Map<String, StockItem> lookupInventory() {
        return getAllInventoryItems();
    }

    public Map<String, StockItem> searchInventoryItem(String searchString) {
        Map<String, StockItem> stockItems = getAllInventoryItems();
        Map<String, StockItem> result = new HashMap<>();
        for (var entry : stockItems.entrySet()) {
            if (entry.getValue().getProductName().contains(searchString) ||
                    entry.getValue().getProductCode().contains(searchString)) {
                result.put(entry.getKey(), entry.getValue());
            }
        }

        return result;
    }

    public Map<String, StockItem> getAllInventoryItems() {
        Map<String, StockItem> inventoryItemMap = new HashMap<>();
        String line;
        try {
            BufferedReader br = new BufferedReader(new FileReader(getSeatRequestsFilePath("InventoryStock.csv")));
            boolean isHeader = true;
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }
                String[] employee = line.split(",");
                StockItem stockItem = new StockItem(employee[0], employee[1], employee[2], Integer.parseInt(employee[3]), Integer.parseInt(employee[4]));
                inventoryItemMap.put(employee[0], stockItem);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return inventoryItemMap;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "ShopOwner{" + "userId='" + userId + '\'' + ", name='" + name + '\'' + ", contactNumber='" + contactNumber + '\'' + ", addresses=" + addresses + ", password='" + password + '\'' + '}';
    }

    public static String getSeatRequestsFilePath(String fileName) {
        var currentPath = Paths.get(System.getProperty("user.dir"));
        var filePath = Paths.get(currentPath.toString(), "src", "assets", fileName);
        return filePath.toString();
    }
}
