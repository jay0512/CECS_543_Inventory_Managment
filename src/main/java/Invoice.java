import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Invoice {
    private String invoiceId;
    private LocalDateTime invoiceDate;
    private LocalDateTime invoiceUpdateDate;
    private String orderId;
    private Boolean invoiceStatus;
    private double amountDue;
    private double totalOrderAmount;


    public Invoice(String invoiceId, LocalDateTime invoiceDate, LocalDateTime invoiceUpdateDate, String orderId, Boolean invoiceStatus, double amountDue, double totalOrderAmount) {
        this.invoiceId = invoiceId;
        this.invoiceDate = invoiceDate;
        this.invoiceUpdateDate = invoiceUpdateDate;
        this.orderId = orderId;
        this.invoiceStatus = invoiceStatus;
        this.amountDue = amountDue;
        this.totalOrderAmount = totalOrderAmount;
    }

    public static Invoice getInvoiceById(String invoiceId) {
        Map<String, Invoice> invoices = getAllInvoices();
        return invoices.get(invoiceId);
    }

    public static Map<String, Invoice> getAllInvoices() {
        Map<String, Invoice> invoices = new HashMap<>();
        try {
            List<String[]> dataList = FileUtils.getDataFromFile("Invoice.csv");
            for (String[] data : dataList) {
                Invoice invoice = new Invoice(data[0], LocalDateTime.parse(data[1]), LocalDateTime.parse(data[2]), data[3], Boolean.parseBoolean(data[4]), Double.parseDouble(data[4]), Double.parseDouble(data[5]));
                invoices.put(data[0], invoice);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return invoices;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public LocalDateTime getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDateTime invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public LocalDateTime getInvoiceUpdateDate() {
        return invoiceUpdateDate;
    }

    public void setInvoiceUpdateDate(LocalDateTime invoiceUpdateDate) {
        this.invoiceUpdateDate = invoiceUpdateDate;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Boolean getInvoiceStatus() {
        return invoiceStatus;
    }

    public void setInvoiceStatus(Boolean invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }

    public double getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(double amountDue) {
        this.amountDue = amountDue;
    }

    public double getTotalOrderAmount() {
        return totalOrderAmount;
    }

    public void setTotalOrderAmount(double totalOrderAmount) {
        this.totalOrderAmount = totalOrderAmount;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceId='" + invoiceId + '\'' +
                ", invoiceDate=" + invoiceDate +
                ", invoiceUpdateDate=" + invoiceUpdateDate +
                ", orderId='" + orderId + '\'' +
                ", invoiceStatus=" + invoiceStatus +
                ", amountDue=" + amountDue +
                '}';
    }

}
