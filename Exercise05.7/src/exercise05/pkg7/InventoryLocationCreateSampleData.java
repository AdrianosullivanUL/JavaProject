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
 * Create a set of sample locations and store on file
 *
 * @author Adrian O'Sullivan Student ID 16230124 
 */
public class InventoryLocationCreateSampleData {

    private InventoryLocationCollection inventoryCollection;

    public InventoryLocationCreateSampleData() {
        try {
            inventoryCollection = new InventoryLocationCollection();
            inventoryCollection.loadInventoryCollection();
            
            // Delete all existing entries
            inventoryCollection.moveToTailLocation();
            while (inventoryCollection.moveToPreviousInventoryLocation())
            {
                inventoryCollection.deleteInventoryLocation(inventoryCollection.getCurrentInventoryLocation().getInventoryLocationId());
            }
            
            // Load a new set of sample entries
            inventoryCollection.addInventoryLocation(new InventoryLocation(inventoryCollection.getNextID(), 5, 1, 1, 21));
            inventoryCollection.addInventoryLocation(new InventoryLocation(inventoryCollection.getNextID(), 1, 2, 2, 22));
            inventoryCollection.addInventoryLocation(new InventoryLocation(inventoryCollection.getNextID(), 1, 3, 2, 23));
            inventoryCollection.addInventoryLocation(new InventoryLocation(inventoryCollection.getNextID(), 2, 1, 3, 24));
            inventoryCollection.addInventoryLocation(new InventoryLocation(inventoryCollection.getNextID(), 2, 2, 4, 25));
            inventoryCollection.addInventoryLocation(new InventoryLocation(inventoryCollection.getNextID(), 2, 3, 5, 26));
            inventoryCollection.addInventoryLocation(new InventoryLocation(inventoryCollection.getNextID(), 3, 1, 6, 27));
            inventoryCollection.addInventoryLocation(new InventoryLocation(inventoryCollection.getNextID(), 3, 2, 7, 28));
            inventoryCollection.addInventoryLocation(new InventoryLocation(inventoryCollection.getNextID(), 3, 3, 8, 29));
            inventoryCollection.addInventoryLocation(new InventoryLocation(inventoryCollection.getNextID(), 4, 1, 9, 30));
            inventoryCollection.addInventoryLocation(new InventoryLocation(inventoryCollection.getNextID(), 4, 2, 10, 31));
            inventoryCollection.addInventoryLocation(new InventoryLocation(inventoryCollection.getNextID(), 4, 3, 11, 32));
            inventoryCollection.saveInventoryCollection(0);
            JOptionPane.showMessageDialog(null, inventoryCollection.size() + " sample Inventory Locations created", "Sucess", JOptionPane.INFORMATION_MESSAGE);
        } catch (ApplicationException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Problem", JOptionPane.ERROR_MESSAGE);
        }
    }
}
