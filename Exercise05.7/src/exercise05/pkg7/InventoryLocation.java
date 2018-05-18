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

import java.io.Serializable;

/**
 * Class to represent an Inventory Location in a store or warehouse including what stock is stored
 * This class supports a numeric identifier system based on Section/Aisle/Rack/Shelf
 * which is suitable for bar coding using for instance 3 of 9
 * Note: System does not support more than one stock item per shelf
 * @author Adrian O'Sullivan Student ID 16230124 Last Modified 17/05.2018
 */
class InventoryLocation implements Serializable {

    private int inventoryLocationId;
    private int section;
    private int aisle;
    private int rack;
    private int shelf;
    private int stockItemId;
    private int quantity;
/**
 *  Constructor for an inventory location with no stock
 * @param inventoryLocationId The unique identifier for the location
 * @param section The section identifier
 * @param aisle The aisle identifier 
 * @param rack The rack identifier
 * @param shelf The shelf identifier
 */
    public InventoryLocation(int inventoryLocationId, int section, int aisle, int rack, int shelf) {
        this.inventoryLocationId = inventoryLocationId;
        this.section = section;
        this.aisle = aisle;
        this.rack = rack;
        this.shelf = shelf;
    }
/**
 * Constructor for an inventory location with stock
 * @param inventoryLocationId The unique identifier for the location
 * @param section The section identifier
 * @param aisle The aisle identifier 
 * @param rack The rack identifier
 * @param shelf The shelf identifier
 * @param stockItemId The identifier for the stock item located in this shelf
 * @param quantity 
 */
    public InventoryLocation(int inventoryLocationId, int section, int aisle, int rack, int shelf, int stockItemId, int quantity) {
        this.inventoryLocationId = inventoryLocationId;
        this.section = section;
        this.aisle = aisle;
        this.rack = rack;
        this.shelf = shelf;
        this.stockItemId = stockItemId;
        this.quantity = quantity;
    }
/**
 * Getter for the InventoryLocationId
 * @return the Inventory Location identifier
 */
    public int getInventoryLocationId() {
        return inventoryLocationId;
    }
/**
 * Setter for the InventoryLocationId
 * @param inventoryLocationId the Inventory Location Identifier
 */
    public void setInventoryLocationId(int inventoryLocationId) {
        this.inventoryLocationId = inventoryLocationId;
    }
/**
 * Getter for the 
 * @return section location
 */
    public int getSection() {
        return section;
    }
/**
 * Setter for the section
 * @param section the section location
 */
    public void setSection(int section) {
        this.section = section;
    }
/**
 * Getter for the aisle
 * @return the aisle location
 */
    public int getAisle() {
        return aisle;
    }
/**
 * Setter for the aisle
 * @param aisle the aisle location
 */
    public void setAisle(int aisle) {
        this.aisle = aisle;
    }
/**
 * Getter for the rack
 * @return rack location
 */
    public int getRack() {
        return rack;
    }
/**
 * Setter for the rack
 * @param rack the rack location
 */
    public void setRack(int rack) {
        this.rack = rack;
    }
/**
 * Getter for the shelf
 * @return the shelf location
 */
    public int getShelf() {
        return shelf;
    }
/**
 * Setter for the shelf
 * @param shelf the shelf location
 */
    public void setShelf(int shelf) {
        this.shelf = shelf;
    }
/**
 * Getter for the Stock Item
 * @return stored in this location
 */
    public int getStockItemId() {
        return stockItemId;
    }
/**
 * Setter for the Stock Item
 * @param stockItemId stored in this location
 */
    public void setStockItemId(int stockItemId) {
        this.stockItemId = stockItemId;
    }
/**
 * Getter for the quantity
 * @return quantity stored in this location
 */
    public int getQuantity() {
        return quantity;
    }
/**
 * Setter for the quantity
 * @param quantity quantity stored in this location
 */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public String toString()
    {
        return 
        "id " + inventoryLocationId
        + " section " + section
        + " aisle " +         aisle
        + " rack " + rack
        + " shelf " + shelf
        + " stockid " + stockItemId
        + " qty " + quantity;
    }
}
