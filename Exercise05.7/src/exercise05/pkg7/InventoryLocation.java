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
