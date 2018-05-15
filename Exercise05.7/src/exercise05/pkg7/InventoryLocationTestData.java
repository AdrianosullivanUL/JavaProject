/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise05.pkg7;

import javax.swing.JOptionPane;

/**
 * [Class Title Here]
 *
 * @author Adrian O'Sullivan Student ID 16230124 Last Modified [dd/mm/yyyy]
 */
public class InventoryLocationTestData {

    private InventoryLocationCollection inventoryCollection;

    public InventoryLocationTestData() {
        try {
            inventoryCollection = new InventoryLocationCollection();
            inventoryCollection.loadInventoryCollection();
            inventoryCollection.addInventoryLocation(new InventoryLocation(inventoryCollection.getNextID(), 1, 1, 1, 21));
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
            inventoryCollection.saveInventoryCollection();
            JOptionPane.showMessageDialog(null, "Test Inventory Locations created", "Sucess", JOptionPane.INFORMATION_MESSAGE);
        } catch (ApplicationException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Problem", JOptionPane.ERROR_MESSAGE);
        }
    }
}
