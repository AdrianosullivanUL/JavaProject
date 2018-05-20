/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise05.pkg7;

/**
 * Class StockItemTast Harness to execute Testing for the Stock Item Collection
 *
 * @author Mary Cronin 0510661
 *
 */
class StockItemTestHarness {
    StockItemCollection stockCollection;
    
    public static void main(String args[]) {
        StockItemTestHarness stockItemTestHarness = new StockItemTestHarness();
        stockItemTestHarness.ExecuteTests();
    }

    private void ExecuteTests() {

        TestStockItemClass();
        TestStockItemCollectionClass();

    }

    /**
     * Method to test Adding,negative StockID,negative PartNumber, Blank StockName
     * Blank Description and No Unit Price
     */
    private void TestStockItemClass() {
        StockItem stockItem;
        System.out.println("Inventory Class Testing");
        System.out.println("_______________________");
        System.out.println("Test #1 - Add a stock item");
        try {
            stockItem = new StockItem(9990, 99999, "Test Name", "Test Desc", 1.00);
        } catch (ApplicationException ex) {
            System.out.println("  **TEST FAIL: " + ex.getMessage());
        }
        System.out.println("  Test Passed");

        System.out.println("Test #2 - Negative Stock Item Id");
        try {
            stockItem = new StockItem(-1, 99999, "Test Name", "Test Desc", 1.00);
        } catch (ApplicationException ex) {
            System.out.println("  Pass: " + ex.getMessage());
        }

        System.out.println("Test #3 - Negative Part Number Id");
        try {
            stockItem = new StockItem(9990, -1, "Test Name", "Test Desc", 1.00);
        } catch (ApplicationException ex) {
            System.out.println("  Pass: " + ex.getMessage());
        }
        
        System.out.println("Test #4 - Blank stock name");
        try {
            stockItem = new StockItem(9990, 9998, "", "Test Desc", 1.00);
        } catch (ApplicationException ex) {
            System.out.println("  Pass: " + ex.getMessage());
        } 
        System.out.println("Test #5 - Blank description");
        try {
            stockItem = new StockItem(9990, 9998, "Test Name", "", 1.00);
        } catch (ApplicationException ex) {
            System.out.println("  Pass: " + ex.getMessage());
        }  
        
        System.out.println("Test #6 - Negative unit price");
        try {
            stockItem = new StockItem(9990, 9998, "Test Name", "Test Desc",-1.0);
        } catch (ApplicationException ex) {
            System.out.println("  Pass: " + ex.getMessage());
        }        
    }

    private void TestStockItemCollectionClass() {
   
     try {
            StockItemCollection stockCollection = new StockItemCollection();
            int stockCount = stockCollection.size();
            System.out.println(" ");
        System.out.println("Stock Collection Class Testing");
        System.out.println("__________________________________");            

            // add 5 valid rows
            System.out.println("Test #1 - Add 3 valid rows");
            AddNewStockItemTest(true, "Add valid record", new StockItem(9990, 99990, "Test", "A", 1));
            AddNewStockItemTest(true, "Add valid record", new StockItem(9991, 99991, "Test1", "B", 2));
            AddNewStockItemTest(true, "Add valid record", new StockItem(9992, 99992, "Test2", "C", 3));
            if (Integer.compare(stockCount + 5, stockCollection.size()) != 0) {
                System.out.println("**TEST FAIL: add of 5 rows, count of rows does not match those added");
            }

            // Add a duplicate row
            System.out.println("Test #2 - Add a duplicated row");
            AddNewStockItemTest(false, "Add a duplicate part number", new StockItem(9993, 99990, "Test", "A", 1));

            // delete a row that doesnt exist
            System.out.println("Test #3 - Try to delete a rown that does not exist");
            DeleteStockItemTest(false, "Delete row that doesnt exist ", 9995);

            // Add a negative stock row 
            System.out.println("Test #6 - Add a negative quantity row");
            try {
                AddNewStockItemTest(false, "Add location with negative quantity row", new StockItem(9993, 99993, "Test", "A", -1));
            } catch (ApplicationException ex) {
                System.out.println("  Pass: Test Description Try to set negative quantity");
            }

            // Delete all test rows
            System.out.println("Test #7 - Delete 5 test rows");
            DeleteStockItemTest(true, "Delete row ", 9990);
            DeleteStockItemTest(true, "Delete row ", 9991);
            DeleteStockItemTest(true, "Delete row ", 9992);

 
            if (Integer.compare(stockCollection.size(), stockCount) != 0) {
                System.out.println("**TEST FAIL: delete 5 rows, count of rows does not match those added (" + stockCollection.size() + " Vs " + stockCount + ")");
            }

        } catch (ApplicationException ex) {
            System.out.println("TEST HARNESS FAILURE: " + ex.getMessage());
        }
    }

    private void AddNewStockItemTest(boolean ExpectPassOutcome, String testDescription, StockItem stockItem) throws ApplicationException {

        try {
            stockCollection.addStockItem(stockItem);
            if (ExpectPassOutcome == true) {
                System.out.println("  Pass: Test Description " + testDescription + " Added:" + stockItem.toString());
            } else {
                System.out.println("**TEST FAIL: Test Description " + testDescription + " Added:" + stockItem.toString());
            }
        } catch (ApplicationException ex) {
            if (ExpectPassOutcome == false) {
                System.out.println("  Pass: Application Exception " + ex.getMessage() + " : " + stockItem.toString());
            } else {
                System.out.println("TEST HARNESS FAIL " + ex.getMessage());
            }
        }
    }

    private void DeleteStockItemTest(boolean ExpectPassOutcome, String testDescription, int stockItemId) throws ApplicationException {
        try {
            stockCollection.deleteStockItem(stockItemId);
            if (ExpectPassOutcome == true) {
                System.out.println("  Pass: Test Description " + testDescription + " Deleted Id: " + stockItemId);
            } else {
                System.out.println("**TEST FAIL: Test Description " + testDescription + " Deleted Id: " + stockItemId);
            }
        } catch (ApplicationException ex) {
            if (ExpectPassOutcome == false) {
                System.out.println("  Pass: Application Exception " + ex.getMessage() + " Id: " + stockItemId);
            } else {
                System.out.println("APPLICATION FAIL " + ex.getMessage());
            }

        }
    }

    private void UpdateStockItemTest(boolean ExpectPassOutcome, String testDescription, int stockItemId) {
        try {

            stockCollection.saveStockItem(stockItemId);
            if (ExpectPassOutcome == true) {
                System.out.println("  Pass: Test Description " + testDescription + " Result Id:" + stockItemId);
            } else {
                System.out.println("**TEST FAIL: Test Description " + testDescription + " Result Id:" + stockItemId);
            }

        } catch (ApplicationException ex) {
            if (ExpectPassOutcome == false) {
                System.out.println("  Pass: Application Exception " + ex.getMessage() + " Id:" + stockItemId);
            } else {
                System.out.println("**APPLICATION FAIL " + ex.getMessage());
            }
        }
    }

    private StockItem GetStockItem(int stockItemId) throws ApplicationException {
        StockItem stockItem = null;

        stockCollection.moveToHeadLocation();
        while (stockCollection.moveToNextStockItem()) {
            if (Integer.compare(stockItemId, stockCollection.getCurrentStockItem().getStockItemId()) == 0) {
                stockItem = stockCollection.getCurrentStockItem();
                break;
            }
        }
        return stockItem;
    }
}
