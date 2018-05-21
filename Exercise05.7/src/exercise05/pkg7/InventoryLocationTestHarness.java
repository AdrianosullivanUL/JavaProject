/*

 */
package exercise05.pkg7;

/**
 * Execute test plan for the Inventory Location Collection
 *
 * @author Adrian O'Sullivan Student ID 16230124
 *
 */
class InventoryLocationTestHarness {

    InventoryLocationCollection inventoryCollection;

    /**
     * Entry point for executing this test harness
     *
     * @param args not used
     */
    public static void main(String args[]) {
        InventoryLocationTestHarness inventoryLocationTestHarness = new InventoryLocationTestHarness();
        inventoryLocationTestHarness.ExecuteTests();
    }

    /**
     * Execute tests for the Inventory Location class and also the matching
     * collection class
     */
    private void ExecuteTests() {

        TestInventoryLocationClass();
        TestInventoryLocationCollectionClass();

    }

    /**
     * Execute a set of tests against the Inventory Location Class
     */
    private void TestInventoryLocationClass() {
        InventoryLocation inventoryLocation;
        System.out.println("Inventory Class Testing");
        System.out.println("_______________________");
        System.out.println("Test #1 - Add a location without stock item");
        try {
            inventoryLocation = new InventoryLocation(9996, 6, 10, 15, 0, 1, 1);
        } catch (ApplicationException ex) {
            System.out.println("  **TEST FAIL: " + ex.getMessage());
        }
        System.out.println("  Test Passed");

        System.out.println("Test #2 - Add a location with stock item");
        try {
            inventoryLocation = new InventoryLocation(9996, 6, 10, 15, 0);
        } catch (ApplicationException ex) {
            System.out.println("  **TEST FAIL: " + ex.getMessage());
        }
        System.out.println("  Test Passed");

        System.out.println("Test #3 - Add a location with negative Id");
        try {
            inventoryLocation = new InventoryLocation(-1, 6, 10, 15, 0, 1, 1);
        } catch (ApplicationException ex) {
            System.out.println("  Pass: " + ex.getMessage());
        }

        System.out.println("Test #4 - Add a location with negative section");
        try {
            inventoryLocation = new InventoryLocation(9996, -1, 10, 15, 0, 1, 1);
        } catch (ApplicationException ex) {
            System.out.println("  Pass: " + ex.getMessage());
        }
        System.out.println("Test #5 - Add a location with negative aisle");
        try {
            inventoryLocation = new InventoryLocation(9996, 6, -10, 15, 0, 1, 1);
        } catch (ApplicationException ex) {
            System.out.println("  Pass: " + ex.getMessage());
        }

        System.out.println("Test #6 - Add a location with negative rack");
        try {
            inventoryLocation = new InventoryLocation(9996, 6, 10, -15, 0, 1, 1);
        } catch (ApplicationException ex) {
            System.out.println("  Pass: " + ex.getMessage());
        }

        System.out.println("Test #7 - Add a location with negative shelf");
        try {
            inventoryLocation = new InventoryLocation(9996, 6, 10, 15, -1, 1, 1);
        } catch (ApplicationException ex) {
            System.out.println("  Pass: " + ex.getMessage());
        }

        System.out.println("Test #8 - Add a location with negative stock item Id");
        try {
            inventoryLocation = new InventoryLocation(9996, 6, 10, 15, 0, -1, 1);
        } catch (ApplicationException ex) {
            System.out.println("  Pass: " + ex.getMessage());
        }

        System.out.println("Test #9 - Add a location with negative quantity");
        try {
            inventoryLocation = new InventoryLocation(9996, 6, 10, 15, 0, 1, -1);
        } catch (ApplicationException ex) {
            System.out.println("  Pass: " + ex.getMessage());
        }

        System.out.println("Test #10 - Try to set a quantity with no part");
        try {
            inventoryLocation = new InventoryLocation(9996, 6, 10, 15, 0, 0, 1);
        } catch (ApplicationException ex) {
            System.out.println("  Pass: Test Description Try to set negative quantity");
        }

    }

    /**
     * Execute a set of tests against the Inventory Location Collection Class
     */
    private void TestInventoryLocationCollectionClass() {
        try {
            inventoryCollection = new InventoryLocationCollection();
            int inventoryCount = inventoryCollection.size();
            System.out.println(" ");
            System.out.println("Inventory Collection Class Testing");
            System.out.println("__________________________________");

            // add 5 valid rows
            System.out.println("Test #1 - Add 5 valid rows");
            AddNewLocationTest(true, "Add valid record", new InventoryLocation(9990, 1, 6, 11, 0));
            AddNewLocationTest(true, "Add valid record", new InventoryLocation(9991, 2, 7, 12, 0));
            AddNewLocationTest(true, "Add valid record", new InventoryLocation(9992, 3, 8, 13, 0));
            AddNewLocationTest(true, "Add valid record", new InventoryLocation(9993, 4, 9, 14, 0));
            AddNewLocationTest(true, "Add valid record", new InventoryLocation(9994, 5, 10, 15, 0));
            if (Integer.compare(inventoryCount + 5, inventoryCollection.size()) != 0) {
                System.out.println("**TEST FAIL: add of 5 rows, count of rows does not match those added");
            }

            // Add a duplicate row
            System.out.println("Test #2 - Add a duplicated row");
            AddNewLocationTest(false, "Add a duplicate row", new InventoryLocation(9994, 5, 10, 15, 0));

            // delete a row that doesnt exist
            System.out.println("Test #3 - Try to delete a rown that does not exist");
            DeleteLocationTest(false, "Delete row that doesnt exist ", 9995);

            // Add a stock row 
            System.out.println("Test #5 - Add a stock with quantity row");
            AddNewLocationTest(true, "Add location with stock row", new InventoryLocation(9996, 6, 10, 15, 0, 1, 1));

            // Add a negative stock row 
            System.out.println("Test #6 - Add a negative quantity row");
            try {
                AddNewLocationTest(false, "Add location with negative quantity row", new InventoryLocation(9994, 5, 10, 15, 0, 1, -1));
            } catch (ApplicationException ex) {
                System.out.println("  Pass: Test Description Try to set negative quantity");
            }

            // Delete all test rows
            System.out.println("Test #7 - Delete 5 test rows");
            DeleteLocationTest(true, "Delete row ", 9990);
            DeleteLocationTest(true, "Delete row ", 9991);
            DeleteLocationTest(true, "Delete row ", 9992);
            DeleteLocationTest(true, "Delete row ", 9993);
            DeleteLocationTest(true, "Delete row ", 9994);
            DeleteLocationTest(true, "Delete row ", 9996);
            if (Integer.compare(inventoryCollection.size(), inventoryCount) != 0) {
                System.out.println("**TEST FAIL: delete 5 rows, count of rows does not match those added (" + inventoryCollection.size() + " Vs " + inventoryCount + ")");
            }

        } catch (ApplicationException ex) {
            System.out.println("TEST HARNESS FAILURE: " + ex.getMessage());
        }
    }

    /**
     * Create a new location and report the result
     *
     * @param ExpectPassOutcome will the test produce a pass result
     * @param testDescription What is being tested
     * @param inventoryLocation The inventory location to create
     */
    private void AddNewLocationTest(boolean ExpectPassOutcome, String testDescription, InventoryLocation inventoryLocation) {

        try {
            inventoryCollection.addInventoryLocation(inventoryLocation);
            if (ExpectPassOutcome == true) {
                System.out.println("  Pass: Test Description " + testDescription + " Added:" + inventoryLocation.toString());
            } else {
                System.out.println("**TEST FAIL: Test Description " + testDescription + " Added:" + inventoryLocation.toString());
            }
        } catch (ApplicationException ex) {
            if (ExpectPassOutcome == false) {
                System.out.println("  Pass: Application Exception " + ex.getMessage() + " : " + inventoryLocation.toString());
            } else {
                System.out.println("TEST HARNESS FAIL " + ex.getMessage());
            }
        }
    }

    /**
     * Delete a location and report the result
     *
     * @param ExpectPassOutcome Will the test result in a pass
     * @param testDescription What is being tested
     * @param inventoryLocationId What location id to delete
     */
    private void DeleteLocationTest(boolean ExpectPassOutcome, String testDescription, int inventoryLocationId) {
        try {
            inventoryCollection.deleteInventoryLocation(inventoryLocationId);
            if (ExpectPassOutcome == true) {
                System.out.println("  Pass: Test Description " + testDescription + " Deleted Id: " + inventoryLocationId);
            } else {
                System.out.println("**TEST FAIL: Test Description " + testDescription + " Deleted Id: " + inventoryLocationId);
            }
        } catch (ApplicationException ex) {
            if (ExpectPassOutcome == false) {
                System.out.println("  Pass: Application Exception " + ex.getMessage() + " Id: " + inventoryLocationId);
            } else {
                System.out.println("APPLICATION FAIL " + ex.getMessage());
            }

        }
    }

    /**
     * Execute an Update to an inventory location
     *
     * @param ExpectPassOutcome Will the test result in a pass
     * @param testDescription What is being tested
     * @param inventoryLocationId What inventory location is being updated
     */
    private void UpdateLocationTest(boolean ExpectPassOutcome, String testDescription, int inventoryLocationId) {
        try {

            inventoryCollection.saveInventoryCollection(inventoryLocationId);
            if (ExpectPassOutcome == true) {
                System.out.println("  Pass: Test Description " + testDescription + " Result Id:" + inventoryLocationId);
            } else {
                System.out.println("**TEST FAIL: Test Description " + testDescription + " Result Id:" + inventoryLocationId);
            }

        } catch (ApplicationException ex) {
            if (ExpectPassOutcome == false) {
                System.out.println("  Pass: Application Exception " + ex.getMessage() + " Id:" + inventoryLocationId);
            } else {
                System.out.println("**APPLICATION FAIL " + ex.getMessage());
            }
        }
    }

    /**
     * Get an inventory location
     *
     * @param InventoryLocationId What location id to find
     * @return An inventory Location
     * @throws ApplicationException Handles issues with not finding, etc.
     */
    private InventoryLocation GetLocation(int InventoryLocationId) throws ApplicationException {
        InventoryLocation inventoryLocation = null;

        inventoryCollection.moveToHeadLocation();
        while (inventoryCollection.moveToNextInventoryLocation()) {
            if (Integer.compare(InventoryLocationId, inventoryCollection.getCurrentInventoryLocation().getInventoryLocationId()) == 0) {
                inventoryLocation = inventoryCollection.getCurrentInventoryLocation();
                break;
            }
        }
        return inventoryLocation;
    }
}
