/*
 */
package exercise05.pkg7;

import javax.swing.JOptionPane;

/**
 * Class StockItem CreateSampleData used to enter data into StockItemCollection
 *
 * @author Mary Cronin 0510661,  Adrian O'Sullivan 16230124
 */
class StockItemCreateSampleData {

    private StockItemCollection stockCollection; //creates an object of type StockItemCollection

    /**
     * Loading test data into stockCollection, using a Try Catch block to handle
     * exception
     */
    StockItemCreateSampleData() {
        try {
            stockCollection = new StockItemCollection();
            stockCollection.loadStockCollection();

            stockCollection.addStockItem(new StockItem(stockCollection.getNextID(), 1010, "Bounty", "ChocolateBar", 1.00));
            stockCollection.addStockItem(new StockItem(stockCollection.getNextID(), 1002, "Dime", "ChocolateBar", .80));
            stockCollection.addStockItem(new StockItem(stockCollection.getNextID(), 1035, "Aero", "ChocolateBar", 1.20));
            stockCollection.addStockItem(new StockItem(stockCollection.getNextID(), 1004, "Flake", "ChocolateBar", 1.10));
            stockCollection.addStockItem(new StockItem(stockCollection.getNextID(), 1105, "Twirl", "ChocolateBar", 1.50));
            stockCollection.saveStockItem(0);
            JOptionPane.showMessageDialog(null, "Test StockItems Created", "Sucess", JOptionPane.INFORMATION_MESSAGE);
        } catch (ApplicationException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Problem", JOptionPane.ERROR_MESSAGE);
        }

    }
}
