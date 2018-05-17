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
public class StockItemTestData {
    private StockItemCollection stockCollection;

    public StockItemTestData() {
    try {
            stockCollection = new StockItemCollection();
            stockCollection.loadStockCollection();
            
            stockCollection.addStockItem(new StockItem(stockCollection.getNextID(), 1000, "Bounty","ChocolateBar",1.00));
            stockCollection.addStockItem(new StockItem(stockCollection.getNextID(), 1002, "Dime","ChocolateBar",.80));
            stockCollection.addStockItem(new StockItem(stockCollection.getNextID(), 1003, "Aero","ChocolateBar",1.20));
            stockCollection.addStockItem(new StockItem(stockCollection.getNextID(), 1004, "Flake","ChocolateBar",1.10));
            stockCollection.addStockItem(new StockItem(stockCollection.getNextID(), 1005, "Twirl","ChocolateBar",1.50));
            stockCollection.saveStockCollection();
            JOptionPane.showMessageDialog(null, "Test StockItems Created", "Sucess", JOptionPane.INFORMATION_MESSAGE);
        } catch (ApplicationException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Problem", JOptionPane.ERROR_MESSAGE);
        }
    
}
}
