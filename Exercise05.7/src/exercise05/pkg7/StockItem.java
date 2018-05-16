/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise05.pkg7;

/**
 *
 * @author 501834813
 */
public class StockItem {
private int StockItemId;
private  String Name;
private String Description;
private double UnitPrice;

    public StockItem(int StockItemId, String Name, String Description, double UnitPrice) {
        this.StockItemId = StockItemId;
        this.Name = Name;
        this.Description = Description;
        this.UnitPrice = UnitPrice;
    }

    public int getStockItemId() {
        return StockItemId;
    }

    public void setStockItemId(int StockItemId) {
        this.StockItemId = StockItemId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(double UnitPrice) {
        this.UnitPrice = UnitPrice;
    }



    
}
