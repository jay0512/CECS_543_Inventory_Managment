package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    public List<StockItem> lookupInventory() {

        return getAllInventoryItems();
    }

    public List<StockItem> getAllInventoryItems() {
        List<StockItem> inventoryItems = new ArrayList<>();
        String line;
        try {
            BufferedReader br = new BufferedReader(new FileReader("/Users/jay/IdeaProjects/CECS_543_Inventory_Managment/src/assets/InventoryStock.csv"));
            while ((line = br.readLine()) != null) {
                String[] employee = line.split(",");
                StockItem stockItem = new StockItem(employee[0], employee[1], employee[2], Integer.parseInt(employee[3]), Integer.parseInt(employee[4]));
                inventoryItems.add(stockItem);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return inventoryItems;
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
        return "ShopOwner{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", addresses=" + addresses +
                ", password='" + password + '\'' +
                '}';
    }
}
