/*
Formal Specification
---------------------------------
1 Task Formulation

2 Specification
   Input: N/A, Output: N/A

3 Problem Solving

4 Top Down Construction

5 Bottom-Up Verification

6 Coding
See coding in this class

7 Testing

 */
package exercise05.pkg7;

import javax.swing.JOptionPane;

/**
 * Class StockItem CreateSampleData used enter data into StockItemCollection
 *
 * @author Mary Cronin 0510661
 */
public class StockItemCreateSampleData {

    private StockItemCollection stockCollection; //creates an object of type StockItemCollection

    /**
     * Loading test data into stockCollection, using a Try Catch block to handle
     * exception
     */
    public StockItemCreateSampleData() {
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
