import java.util.List;

public class WareHouse {

    String warehouseId;
    String wareHouseName;
    List<StockItem> stockItem;
    Address wareHouseAddress;

    public WareHouse(String warehouseId, String wareHouseName, List<StockItem> stockItem, Address wareHouseAddress) {
        this.warehouseId = warehouseId;
        this.wareHouseName = wareHouseName;
        this.stockItem = stockItem;
        this.wareHouseAddress = wareHouseAddress;
    }

}
