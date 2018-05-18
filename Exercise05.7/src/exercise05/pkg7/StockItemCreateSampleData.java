/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise05.pkg7;

import javax.swing.JOptionPane;

/**
 *
 * @author 501834813
 */
public class StockItemCreateSampleData {
    private StockItemCollection stockCollection;

    public StockItemCreateSampleData() {
    try {
            stockCollection = new StockItemCollection();
            stockCollection.loadStockCollection();
            
                        // Delete all existing entries
            stockCollection.moveToTailLocation();
            while (stockCollection.moveToPreviousStockItem())
            {
                stockCollection.deleteStockItem(stockCollection.getCurrentStockItem().getStockItemId());
            }
            
            stockCollection.addStockItem(new StockItem(stockCollection.getNextID(), 1010, "Bounty","ChocolateBar",1.00));
            stockCollection.addStockItem(new StockItem(stockCollection.getNextID(), 1002, "Dime","ChocolateBar",.80));
            stockCollection.addStockItem(new StockItem(stockCollection.getNextID(), 1035, "Aero","ChocolateBar",1.20));
            stockCollection.addStockItem(new StockItem(stockCollection.getNextID(), 1004, "Flake","ChocolateBar",1.10));
            stockCollection.addStockItem(new StockItem(stockCollection.getNextID(), 1105, "Twirl","ChocolateBar",1.50));
            stockCollection.saveStockItem(0);
            JOptionPane.showMessageDialog(null, stockCollection.size() + " sample StockItems Created", "Sucess", JOptionPane.INFORMATION_MESSAGE);
        } catch (ApplicationException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Problem", JOptionPane.ERROR_MESSAGE);
        }
    
}
}
