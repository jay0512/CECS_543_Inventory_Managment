package main;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Invoice {
    private String invoiceId;
    private LocalDateTime invoiceDate;
    private LocalDateTime invoiceUpdateDate;
    private String orderId;
    private Boolean invoiceStatus;
    private double amountDue;

    public Invoice(String invoiceId, LocalDateTime invoiceDate, LocalDateTime invoiceUpdateDate, String orderId, Boolean invoiceStatus, double amountDue) {
        this.invoiceId = invoiceId;
        this.invoiceDate = invoiceDate;
        this.invoiceUpdateDate = invoiceUpdateDate;
        this.orderId = orderId;
        this.invoiceStatus = invoiceStatus;
        this.amountDue = amountDue;
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
