/*
Formal Specification
---------------------------------
1 Task Formulation
Create a class that can store information that represents an inventory
location in a store or warehouse. Each location will store stock if a single 
stock item which is represented in this module by the Stock Item class

2 Specification
Depending on the request, one of the following will be input or output: 
   Section, Aisle, Rack,Shelf, Stock Item ID & Quantity
Each of the above will support storing positive integers

Stock Item Id will be a link to the matching Stock Item Class entry for this 
location if populated

The user will be able to create a location with or without stock, a quantity will
not be possible without stock however. Negative values will not be supported

3 Problem Solving
Standard class implementation with setters and getters to store the location
attributes. Validation will prevent the user from inputing invalid values

4 Top Down Construction
When creating the class:
     1) receive a set of parameters to allow the creation of a location either 
     with or without a stock item
     2) Populate each attribute of the class, validate each entry and report 
     errors if found

Allow user to change the value of each attribute of the class, when changes are 
made, these also need to be validated for negative values. For the quantity 
attribute, do not allow unless a stock item is populated

5 Bottom-Up Verification
Create new Stock Item
Location 1, Section 0, Aisle 1, Shelf 1, Rack 1, Expected Result: Valid entry
Location 0, Section 0,Aisle 0, Shelf 0, Rack 0, Stock Item Id 0, Quantity 0 Expected Result: Valid entry
Location -1, Section 0,Aisle 0, Shelf 0, Rack 0, Stock Item Id 0, Quantity 0 Expected Result: Invalid entry
Location 0, Section -1,Aisle 0, Shelf 0, Rack 0, Stock Item Id 0, Quantity 0 Expected Result: Invalid entry
Location 0, Section 0,Aisle -1, Shelf 0, Rack 0, Stock Item Id 0, Quantity 0 Expected Result: Invalid entry
Location 0, Section 0,Aisle 0, Shelf -1, Rack 0, Stock Item Id 0, Quantity 0 Expected Result: Invalid entry
Location 0, Section 0,Aisle 0, Shelf 0, Rack -1, Stock Item Id 0, Quantity 0 Expected Result: Invalid entry
Location 0, Section 0,Aisle 0, Shelf 0, Rack 0, Stock Item Id -1, Quantity 0 Expected Result: Invalid entry
Location 0, Section 0,Aisle 0, Shelf 0, Rack 0, Stock Item Id 0, Quantity -1 Expected Result: Invalid entry
Location 0, Section 0,Aisle 0, Shelf 0, Rack 0, Stock Item Id 0, Quantity 1 Expected Result: Invalid entry


6 Coding
Language is Java 

Variable Types
  Location int
  Aisle int 
  Shelf int
  Rack int
  Stock Item ID int
  Quantity int

7 Testing
See StockItemTestHarness class for test cases

 */
package exercise05.pkg7;

import java.io.Serializable;

/**
 * Class to represent an Inventory Location in a store or warehouse including
 * what stock is stored This class supports a numeric identifier system based on
 * Section/Aisle/Rack/Shelf which is suitable for bar coding using for instance
 * 3 of 9 Note: System does not support more than one stock item per shelf
 *
 * @author Adrian O'Sullivan Student ID 16230124
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
     * Constructor for an inventory location with no stock
     *
     * @param inventoryLocationId The unique identifier for the location
     * @param section The section identifier
     * @param aisle The aisle identifier
     * @param rack The rack identifier
     * @param shelf The shelf identifier
     */
    public InventoryLocation(int inventoryLocationId, int section, int aisle, int rack, int shelf) throws ApplicationException {
        /* Note: 
         By using setters we are forcing validation of the new location entries
         this could be further improved by creating seperate private validators for
         each instance variable and have these called from here and also the
         setter. THis would overcome issues with the user being able to 
         override the setter.
         */
        setInventoryLocationId(inventoryLocationId);
        setSection(section);
        setAisle(aisle);
        setRack(rack);
        setShelf(shelf);
    }

    /**
     * Constructor for an inventory location with stock
     *
     * @param inventoryLocationId The unique identifier for the location
     * @param section The section identifier
     * @param aisle The aisle identifier
     * @param rack The rack identifier
     * @param shelf The shelf identifier
     * @param stockItemId The identifier for the stock item located in this
     * shelf
     * @param quantity
     */
    public InventoryLocation(int inventoryLocationId, int section, int aisle, int rack, int shelf, int stockItemId, int quantity) throws ApplicationException {
        setInventoryLocationId(inventoryLocationId);
        setSection(section);
        setAisle(aisle);
        setRack(rack);
        setShelf(shelf);
        setStockItemId(stockItemId);
        setQuantity(quantity);
    }

    /**
     * Getter for the InventoryLocationId
     *
     * @return the Inventory Location identifier
     */
    public int getInventoryLocationId() {
        return inventoryLocationId;
    }

    /**
     * Setter for the InventoryLocationId
     *
     * @param inventoryLocationId the Inventory Location Identifier
     * @throws ApplicationException if new value is negative
     */
    public void setInventoryLocationId(int inventoryLocationId) throws ApplicationException {
        // We are programmers, of course you can have a zero location id
        if (inventoryLocationId < 0) {
            throw new ApplicationException("System does not support negative Inventory Location Id numbers");
        }
        this.inventoryLocationId = inventoryLocationId;
    }

    /**
     * Getter for the section
     *
     * @return section location
     */
    public int getSection() {
        return section;
    }

    /**
     * Setter for the section
     *
     * @param section the section location
     * @throws ApplicationException if new value is negative
     */
    public void setSection(int section) throws ApplicationException {
        if (section < 0) {
            throw new ApplicationException("System does not support negative section numbers");
        }
        this.section = section;
    }

    /**
     * Getter for the aisle
     *
     * @return the aisle location
     */
    public int getAisle() {
        return aisle;
    }

    /**
     * Setter for the aisle
     *
     * @param aisle the aisle location
     * @throws ApplicationException if new value is negative
     */
    public void setAisle(int aisle) throws ApplicationException {
        if (aisle < 0) {
            throw new ApplicationException("System does not support negative aisle numbers");
        }

        this.aisle = aisle;
    }

    /**
     * Getter for the rack
     *
     * @return rack location
     */
    public int getRack() {
        return rack;
    }

    /**
     * Setter for the rack
     *
     * @param rack the rack location
     * @throws ApplicationException if new value is negative
     */
    public void setRack(int rack) throws ApplicationException {
        if (rack < 0) {
            throw new ApplicationException("System does not support negative rack numbers");
        }

        this.rack = rack;
    }

    /**
     * Getter for the shelf
     *
     * @return the shelf location
     */
    public int getShelf() {
        return shelf;
    }

    /**
     * Setter for the shelf
     *
     * @param shelf the shelf location
     * @throws ApplicationException if new value is negative
     */
    public void setShelf(int shelf) throws ApplicationException {
        if (shelf < 0) {
            throw new ApplicationException("System does not support negative shelf numbers");
        }
        this.shelf = shelf;
    }

    /**
     * Getter for the Stock Item
     *
     * @return stored in this location
     */
    public int getStockItemId() {
        return stockItemId;
    }

    /**
     * Setter for the Stock Item
     *
     * @param stockItemId stored in this location
     * @throws ApplicationException if new value is negative
     */
    public void setStockItemId(int stockItemId) throws ApplicationException {
        if (stockItemId < 0) {
            throw new ApplicationException("System does not support negative Stock Item Id's");
        }
        this.stockItemId = stockItemId;
    }

    /**
     * Getter for the quantity
     *
     * @return quantity stored in this location
     */
    public int getQuantity() {

        return quantity;
    }

    /**
     * Setter for the quantity
     *
     * @param quantity quantity stored in this location
     * @throws ApplicationException if new value is negative
     */
    public void setQuantity(int quantity) throws ApplicationException {
        if (quantity < 0) {
            throw new ApplicationException("System does not support negative quantities");
        }
        if (stockItemId == 0 && quantity > 0) {
            throw new ApplicationException("You must have a stock item before entering a quantity");
        }
        this.quantity = quantity;
    }
/**
 * Convert the class into a string
 * @return String representation of the class
 */
    public String toString() {
        return "id " + inventoryLocationId
                + " section " + section
                + " aisle " + aisle
                + " rack " + rack
                + " shelf " + shelf
                + " stockid " + stockItemId
                + " qty " + quantity;
    }
}
