/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
}
