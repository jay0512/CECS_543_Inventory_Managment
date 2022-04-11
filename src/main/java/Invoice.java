import exception.FoundNotException;
import exception.InvalidInputException;
import exception.LimitExceedException;

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

    public static Invoice getInvoiceById(String invoiceId) throws FoundNotException, InvalidInputException {
        if (invoiceId.isEmpty() || invoiceId.equals("")) {
            throw new InvalidInputException("Input should not be empty");
        }

        Map<String, Invoice> invoices = getAllInvoices();

        Invoice result = invoices.get(invoiceId);
        if (result == null)
            throw new FoundNotException("Invoice not found");

        return result;
    }

    public static Map<String, Invoice> getAllInvoices() {
        Map<String, Invoice> invoices = new HashMap<>();
        try {
            List<String[]> dataList = FileUtils.getDataFromFile("Invoice.csv");
            for (String[] data : dataList) {
                Invoice invoice = new Invoice(data[0], LocalDateTime.parse(data[1]), LocalDateTime.parse(data[2]), data[3], Boolean.parseBoolean(data[4]), Double.parseDouble(data[5]), Double.parseDouble(data[6]));
                invoices.put(data[0], invoice);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return invoices;
    }

    public static Invoice generateInvoice(String invoiceId, Order order, double amountPaid) throws LimitExceedException {
        if (order.getTotalOrderAmount() < amountPaid) {
            throw new LimitExceedException("Amount paid cannot be more than amount due");
        }
        boolean invoiceStatus = (order.getTotalOrderAmount() > amountPaid) ? false : true;
        Invoice invoice = new Invoice(invoiceId, LocalDateTime.now(), LocalDateTime.now(), order.getOrderId(), invoiceStatus, order.getTotalOrderAmount() - amountPaid, order.getTotalOrderAmount());

        return invoice;
    }

    public static Invoice payInvoiceInstallmentPayment(Invoice invoice, double amountPaid) throws LimitExceedException {
        if (amountPaid > invoice.getAmountDue()) {
            throw new LimitExceedException("Amount paid cannot be more than amount due");
        }
        invoice.setAmountDue(invoice.getAmountDue() - amountPaid);

        if (invoice.getAmountDue() == 0.0) {
            invoice.setInvoiceStatus(true);
        }
        invoice.setInvoiceUpdateDate(LocalDateTime.now());

        return invoice;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public LocalDateTime getInvoiceUpdateDate() {
        return invoiceUpdateDate;
    }

    public void setInvoiceUpdateDate(LocalDateTime invoiceUpdateDate) {
        this.invoiceUpdateDate = invoiceUpdateDate;
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
