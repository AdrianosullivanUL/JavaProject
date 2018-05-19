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

/**
 * Execute test plan for the Inventory Location Collection
 *
 * @author Adrian O'Sullivan Student ID 16230124
 *
 */
class InventoryLocationTestHarness {

    InventoryLocationCollection inventoryCollection;

    /*    
    private int inventoryLocationId;
    private int section;
    private int aisle;
    private int rack;
    private int shelf;
    private int stockItemId;
    private int quantity;
     */
    public static void main(String args[]) {
        InventoryLocationTestHarness inventoryLocationTestHarness = new InventoryLocationTestHarness();
        inventoryLocationTestHarness.ExecuteTests();
    }

    private void ExecuteTests() {
        try {
            inventoryCollection = new InventoryLocationCollection();

            int inventoryCount = inventoryCollection.size();

            // add 5 valid rows
            AddNewLocationTest(true, "Add valid record", new InventoryLocation(9990, 1, 6, 11, 0));
            AddNewLocationTest(true, "Add valid record", new InventoryLocation(9991, 2, 7, 12, 0));
            AddNewLocationTest(true, "Add valid record", new InventoryLocation(9992, 3, 8, 13, 0));
            AddNewLocationTest(true, "Add valid record", new InventoryLocation(9993, 4, 9, 14, 0));
            AddNewLocationTest(true, "Add valid record", new InventoryLocation(9994, 5, 10, 15, 0));
            if (Integer.compare(inventoryCount + 5, inventoryCollection.size()) != 0) {
                System.out.println("**TEST FAIL: add of 5 rows, count of rows does not match those added");
            }

            // Add a duplicate row
            AddNewLocationTest(false, "Add a duplicate row", new InventoryLocation(9994, 5, 10, 15, 0));

            // delete a row that doesnt exist
            DeleteLocationTest(false, "Delete row that doesnt exist ", 9995);

            // Update a row
            InventoryLocation inventoryLocation = GetLocation(9990);
            inventoryLocation.setQuantity(1);
            UpdateLocationTest(false, "Update qty with no part", inventoryLocation.getInventoryLocationId());

            // Delete all test rows
            DeleteLocationTest(true, "Delete row ", 9990);
            DeleteLocationTest(true, "Delete row ", 9991);
            DeleteLocationTest(true, "Delete row ", 9992);
            DeleteLocationTest(true, "Delete row ", 9993);
            DeleteLocationTest(true, "Delete row ", 9994);
            if (Integer.compare(inventoryCount, inventoryCollection.size()) != 0) {
                System.out.println("**TEST FAIL: delete 5 rows, count of rows does not match those added");
            }

        } catch (ApplicationException ex) {
            System.out.println("Application Exception " + ex.getMessage());
        }
    }

    private void AddNewLocationTest(boolean ExpectPassOutcome, String testDescription, InventoryLocation inventoryLocation) throws ApplicationException {

        try {
            inventoryCollection.addInventoryLocation(inventoryLocation);
            System.out.println("Pass: Test Description " + testDescription + " Added:" + inventoryLocation.toString());
        } catch (ApplicationException ex) {
            if (ExpectPassOutcome) {
                System.out.println("**TEST FAIL: Application Exception " + ex.getMessage() + " : " + inventoryLocation.toString());
            }
        }

    }

    private void DeleteLocationTest(boolean ExpectPassOutcome, String testDescription, int inventoryLocationId) throws ApplicationException {
        try {
            inventoryCollection.deleteInventoryLocation(inventoryLocationId);
            System.out.println("Pass: Test Description " + testDescription + " Deleted Id: " + inventoryLocationId);
        } catch (ApplicationException ex) {
            if (ExpectPassOutcome) {
                System.out.println("**TEST FAIL: Application Exception " + ex.getMessage() + " Id: " + inventoryLocationId);
            }
        }
    }

    private void UpdateLocationTest(boolean ExpectPassOutcome, String testDescription, int inventoryLocationId) {
        try {

            inventoryCollection.saveInventoryCollection(inventoryLocationId);
            System.out.println("Pass: Test Description " + testDescription + " Result Id:" + inventoryLocationId);

        } catch (ApplicationException ex) {
            if (ExpectPassOutcome) {
                System.out.println("**TEST FAIL: Application Exception " + ex.getMessage() + " Id:" + inventoryLocationId);
            }
        }
    }

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
