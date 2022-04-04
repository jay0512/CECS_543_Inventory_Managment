package main;

import java.util.List;

public class WareHouse {

    private String warehouseId;
    private String wareHouseName;
    private List<StockItem> stockItem;
    private Address wareHouseAddress;

    public WareHouse(String warehouseId, String wareHouseName, List<StockItem> stockItem, Address wareHouseAddress) {
        this.warehouseId = warehouseId;
        this.wareHouseName = wareHouseName;
        this.stockItem = stockItem;
        this.wareHouseAddress = wareHouseAddress;
    }

    public String getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getWareHouseName() {
        return wareHouseName;
    }

    public void setWareHouseName(String wareHouseName) {
        this.wareHouseName = wareHouseName;
    }

    public List<StockItem> getStockItem() {
        return stockItem;
    }

    public void setStockItem(List<StockItem> stockItem) {
        this.stockItem = stockItem;
    }

    public Address getWareHouseAddress() {
        return wareHouseAddress;
    }

    public void setWareHouseAddress(Address wareHouseAddress) {
        this.wareHouseAddress = wareHouseAddress;
    }

    @Override
    public String toString() {
        return "WareHouse{" +
                "warehouseId='" + warehouseId + '\'' +
                ", wareHouseName='" + wareHouseName + '\'' +
                ", stockItem=" + stockItem +
                ", wareHouseAddress=" + wareHouseAddress +
                '}';
    }
}
