
import exception.FoundNotException;
import exception.InvalidInputException;
import exception.LimitExceedException;

import java.io.IOException;
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

    public StockItem lookupInventoryItem(String productId) throws FoundNotException, InvalidInputException {
        if (productId.isEmpty() || productId.equals("")) {
            throw new InvalidInputException("Input should not be empty");
        }

        Map<String, StockItem> stockItems = getAllInventoryItems();

        StockItem result = stockItems.get(productId);
        if (result == null)
            throw new FoundNotException("Stock Item not found");

        return result;

    }

    public Map<String, StockItem> lookupInventory() {
        return getAllInventoryItems();
    }

    public Map<String, StockItem> searchInventoryItem(String searchString) throws InvalidInputException, FoundNotException {

        if (searchString.isEmpty() || searchString.equals("")) {
            throw new InvalidInputException("Input should not be empty");
        }


        Map<String, StockItem> stockItems = getAllInventoryItems();
        Map<String, StockItem> result = new HashMap<>();
        for (var entry : stockItems.entrySet()) {
            if (entry.getValue().getProductName().contains(searchString) ||
                    entry.getValue().getProductCode().contains(searchString)) {
                result.put(entry.getKey(), entry.getValue());
            }
        }

        if (result.isEmpty())
            throw new FoundNotException("Inventory item not found");

        return result;
    }

    public Map<String, StockItem> getAllInventoryItems() {
        Map<String, StockItem> inventoryItemMap = new HashMap<>();

        try {
            List<String[]> dataList = FileUtils.getDataFromFile("InventoryStock.csv");
            for (String[] data : dataList) {
                StockItem stockItem = new StockItem(data[0], data[1], data[2], Integer.parseInt(data[3]), Integer.parseInt(data[4]));
                inventoryItemMap.put(data[0], stockItem);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return inventoryItemMap;
    }

    public Invoice generateInvoice(String invoiceId, String orderId, double amountPaid) {
        CustomerOrder order = CustomerOrder.getCustomerOrder(orderId);

        Invoice invoice = null;
        try {
            invoice = Invoice.generateInvoice(invoiceId, order, amountPaid);
        } catch (LimitExceedException e) {
            e.printStackTrace();
        }

        return invoice;
    }

    public Invoice payInvoiceInstallmentPayment(String invoiceId, double amountPaid) {
        Invoice invoice = null;
        try {
            invoice = Invoice.getInvoiceById(invoiceId);
        } catch (FoundNotException e) {
            e.printStackTrace();
        } catch (InvalidInputException e) {
            e.printStackTrace();
        }

        Invoice updatedInvoice = null;
        try {
            updatedInvoice = Invoice.payInvoiceInstallmentPayment(invoice, amountPaid);
        } catch (LimitExceedException e) {
            e.printStackTrace();
        }

        return updatedInvoice;
    }

    public Invoice updateInvoice(String invoiceId, Invoice updatedInvoice) {
        Invoice invoice = null;
        try {
            invoice = Invoice.getInvoiceById(invoiceId);
        } catch (FoundNotException e) {
            e.printStackTrace();
        } catch (InvalidInputException e) {
            e.printStackTrace();
        }
        invoice.setInvoiceUpdateDate(updatedInvoice.getInvoiceUpdateDate());
        invoice.setAmountDue(updatedInvoice.getAmountDue());
        invoice.setInvoiceStatus(updatedInvoice.getInvoiceStatus());

        return invoice;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ShopOwner{" + "userId='" + userId + '\'' + ", name='" + name + '\'' + ", contactNumber='" + contactNumber + '\'' + ", addresses=" + addresses + ", password='" + password + '\'' + '}';
    }

}
