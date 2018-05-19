/*
Formal Specification
---------------------------------
1 Task Formulation
Implement a class that can store a collection of Inventory Locations and persist
these to a file on the computers disk. This will include methods to traverse the 
list, add, delete, update and sort entries along with a save method to persist
the data to a disk file.

2 Specification
Constructor which retrieves the list from a file store
   Input: N/A, Output: N/A
Method to allow user save changes made to the list
   Input: Updated Inventory Location Identifier, Output: N/A
Method to allow user to delete a Inventory Location
   Input: Inventory Location Identifier to Delete, Output: N/A
Method to allow user get the next Inventory Location ID available
   Input: N/A, Output: Next available ID
Method to retrieve the current Inventory Location as the user traverses the list
   Input: N/A, Output: Current Inventory Location
Method to traverse up and down through the list 
   Input: N/A, Output: Move result (true/false)
Method to Sort the list by more than one attribute
   Input: N/A, Output: (indirectly the sorted list)

3 Problem Solving
Problem has been solved using a combination of techniques which include:
   a) A class to represent each Stock Item   
   b) An array list to store a collection of Inventory Location
   c) Logic to stream the collection to a file store
   d) A sort algorithm to sort the list by more than one attribute

4 Top Down Construction
Constructor which retrieves the list from a file store
   Open the file and stream its content to an internal buffer
   Convert the internal butter to the collection list
   If the file does not exist, create an empty list
Method to allow user save changes made to the list
   Validate the inputs 
        Insure no duplicated Part Numbers
        If an update request has been received then make sure the entry exists
        Price must be greater than zero
   Output the list to the file location

Method to allow user to delete a stock item
   
Method to allow user get the next Stock Item ID available
   
Method to retrieve the current Stock Item as the user traverses the list
   
Method to traverse up and down through the list 
   

5 Bottom-Up Verification
6 Coding
See coding in this class

7 Testing
See InventoryLocation Test harness class


 */

package exercise05.pkg7;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Class to persist a store or warehouse location/stock tracker, persistence is  
 * achieved though a simple serialised store in a locally stored file. 
 * Note: This is a single user solution.
 *
 * @author Adrian O'Sullivan Student ID 16230124 
 */
public class InventoryLocationCollection {

    private List<InventoryLocation> inventoryStore;
    private int currentEntryIndex = -1;
/**
 * Constructor which loads the collection from file 
 * @throws ApplicationException 
 */
    public InventoryLocationCollection() throws ApplicationException {
        try {
            loadInventoryCollection();
        } catch (ApplicationException ex) {
            throw ex;
        }
    }
/**
 * Load the inventory list from file and create a new list if it doesn't already exist
 * @throws ApplicationException to handle issues with accessing the file storage
 */
    public void loadInventoryCollection()
            throws ApplicationException {
        try {
            FileInputStream fileInputStream = new FileInputStream("inventoryStore.dat");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            inventoryStore = (List<InventoryLocation>) objectInputStream.readObject();
            objectInputStream.close();
            currentEntryIndex = -1;

        } catch (FileNotFoundException ex1) {
            // First time run or file has been deleted, create a new empty collection
            inventoryStore = new ArrayList<InventoryLocation>();
        } catch (IOException ex2) {
            throw new ApplicationException("I/O error loading the inventoryStore.dat file");

        } catch (ClassNotFoundException ex3) {
            throw new ApplicationException("Class Not Found loading the inventoryStore.dat file");
        } finally {

        }
    }
/**
 * Save any changes made to the file store
 * @param updatedInventoryLocationId WHen an inventory has been updated, this id is provided to support validation
 * @throws ApplicationException to handle issues with file access and also validation errors
 */
    void saveInventoryCollection(int updatedInventoryLocationId)
            throws ApplicationException {
        try {
            if (updatedInventoryLocationId != 0) {
                validateUpdates(updatedInventoryLocationId);
            }
            FileOutputStream fileOutputStream = new FileOutputStream("inventoryStore.dat");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(inventoryStore);
            objectOutputStream.close();
        } catch (FileNotFoundException ex1) {
            throw new ApplicationException("File inventoryStore.dat not found");
        } catch (IOException ex2) {
            throw new ApplicationException("I/O error loading the inventoryStore.dat file");

        } finally {

        }
    }
/**
 * Assign the next available identifier to the caller
 * @return the last saved id + 1
 */
    int getNextID() {
        int returnId = 0;
        if (inventoryStore != null && inventoryStore.size() > 0) {
            InventoryLocation inventoryLocation = inventoryStore.get(inventoryStore.size() - 1);
            returnId = inventoryLocation.getInventoryLocationId() + 1;
        } else {
            returnId = 1;
        }
        return returnId;
    }
/**
 * Get the number of locations stored
 * @return collection size
 */
    int size() {
        return inventoryStore.size();
    }
/**
 * Add a new inventory location
 * @param inventoryLocation pre-populated location
 * @throws ApplicationException to handle any issues with adding the new location
 */
    void addInventoryLocation(InventoryLocation inventoryLocation)
            throws ApplicationException {
        for (InventoryLocation existingInventoryLocation : inventoryStore) {
            if (checkForDuplicateLocation(existingInventoryLocation, inventoryLocation)) {
                throw new ApplicationException("Cannot add this entry, location already exists");
            }
        }
        if (inventoryLocation.getQuantity() < 0) {
            throw new ApplicationException("Quantity cannot be negative");
        }
        inventoryStore.add(inventoryLocation);
    }
/**
 * Validate changes made to the location entry
 * @param updateInventoryLocationId the identifier of the updated entry
 * @throws ApplicationException to handle issues with the update
 */
    private void validateUpdates(int updateInventoryLocationId)
            throws ApplicationException {

        InventoryLocation inventoryLocation = null;
        for (InventoryLocation findInventoryLocation : inventoryStore) {
            if (Integer.compare(updateInventoryLocationId, findInventoryLocation.getInventoryLocationId()) == 0) {
                inventoryLocation = findInventoryLocation;
                break;
            }
        }
        if (inventoryLocation == null) {
            throw new ApplicationException("Problem validating updates, cannot find inventory location id " + updateInventoryLocationId);
        }

        for (InventoryLocation existingInventoryLocation : inventoryStore) {
            if (existingInventoryLocation.getInventoryLocationId() != inventoryLocation.getInventoryLocationId()
                    && checkForDuplicateLocation(existingInventoryLocation, inventoryLocation)) {
                throw new ApplicationException("Cannot update this entry, location already exists elsewhere");
            }
        }
        if (inventoryLocation.getQuantity() < 0) {
            throw new ApplicationException("Quantity cannot be negative");
        }
        if (inventoryLocation.getStockItemId() == 0 && inventoryLocation.getQuantity() > 0) {
            throw new ApplicationException("You cannot have a stock without selecting a stock item");
        }
    }
/**
 * Delete an inventory item
 * @param inventoryLocationId The identifier of the location to delete
 * @throws ApplicationException issus with doing the delete
 */
    void deleteInventoryLocation(int inventoryLocationId) throws ApplicationException {
        boolean deleted = true;
        for (int i = 0; i <= inventoryStore.size() - 1; i++) {
            if (Integer.compare(inventoryLocationId, inventoryStore.get(i).getInventoryLocationId()) == 0) {
                inventoryStore.remove(i);
                deleted = true;
            }
            if (deleted == false) {
                throw new ApplicationException("Entry not deleted");
            }
        }
    }
/**
 * return the current inventory item that the current inventory index is pointing to
 * @return the current inventory item
 */
    public InventoryLocation getCurrentInventoryLocation() {
        InventoryLocation inventoryLocation = null;
        if (currentEntryIndex > -1 && currentEntryIndex <= inventoryStore.size() - 1) {
            inventoryLocation = inventoryStore.get(currentEntryIndex);
        }
        return inventoryLocation;
    }
/**
 * Move to the position at the head of the list, this positions the indexer to support iterating through the list
 */
    public void moveToHeadLocation() {
        currentEntryIndex = -1;
    }
        public void moveToTailLocation() {
        currentEntryIndex = inventoryStore.size(); // Note: forced to be 1 greater than the index location
    }
/**
 * Move to the next inventory location, supports iterating through each item in the list
 * @return true if the next location exists, false if the end of the list 
 */
    public boolean moveToNextInventoryLocation() {
        boolean returnValue = true;

        if (inventoryStore != null && currentEntryIndex < (inventoryStore.size() - 1)) {
            currentEntryIndex++;
        } else {
            returnValue = false;
        }
        return returnValue;
    }
/**
 * Move to the previous inventory location, supports iterating through each item in the list
 * @return true if the previous location exists, false if the end of the list
 */
    boolean moveToPreviousInventoryLocation() {
        boolean returnValue = true;

        if (inventoryStore != null && currentEntryIndex > 0) {
            currentEntryIndex--;
        } else {
            returnValue = false;
        }
        return returnValue;
    }
/**
 * Check and see if the location add/edit will result in a duplicated location
 * @param existing the existing location
 * @param updated the location being updated
 * @return true if the result will cause duplication, false if not
 */
    private boolean checkForDuplicateLocation(InventoryLocation existing, InventoryLocation updated) {
        boolean result = false;
        if (existing.getSection() == updated.getSection()
                && existing.getAisle() == updated.getAisle()
                && existing.getRack() == updated.getRack()
                && existing.getShelf() == updated.getShelf()) {
            result = true;
        }
        return result;
    }
/**
 * Sort the list by a pre-defined key
 * @param sortKey which attribute to sort by
 */
    public void sortBy(String sortKey) {
        if (sortKey == "Section") {
            Collections.sort(inventoryStore, new InventoryLocationSectionComparator());
            moveToHeadLocation();
        }
        if (sortKey == "Entry Sequence (default)") {
            Collections.sort(inventoryStore, new InventoryLocationIdComparator());
            moveToHeadLocation();

        }
    }
/**
 * Define a comparator to support sorting by Section
 */
    private class InventoryLocationSectionComparator implements Comparator<InventoryLocation> {

        public int compare(InventoryLocation self, InventoryLocation other) {

            return Integer.valueOf(self.getSection()).compareTo(other.getSection());
        }
    }
/**
 * Define a comparator to sort by entry sequence (id)
 */
    private class InventoryLocationIdComparator implements Comparator<InventoryLocation> {

        public int compare(InventoryLocation self, InventoryLocation other) {
            return Integer.valueOf(self.getInventoryLocationId()).compareTo(other.getInventoryLocationId());
        }
    }
}
