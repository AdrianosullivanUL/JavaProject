/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise05.pkg7;

import java.io.Serializable;

/**
 * [Class Title Here]
 *
 * @author Adrian O'Sullivan Student ID 16230124 Last Modified [dd/mm/yyyy]
 */
class InventoryLocation implements Serializable {

    private int inventoryLocationId;
    private int section;
    private int aisle;
    private int rack;
    private int shelf;
    private int stockItemId;
    private int quantity;

    public InventoryLocation(int inventoryLocationId, int section, int aisle, int rack, int shelf) {
        this.inventoryLocationId = inventoryLocationId;
        this.section = section;
        this.aisle = aisle;
        this.rack = rack;
        this.shelf = shelf;
    }

    public InventoryLocation(int inventoryLocationId, int section, int aisle, int rack, int shelf, int stockItemId, int quantity) {
        this.inventoryLocationId = inventoryLocationId;
        this.section = section;
        this.aisle = aisle;
        this.rack = rack;
        this.shelf = shelf;
        this.stockItemId = stockItemId;
        this.quantity = quantity;
    }

    public int getInventoryLocationId() {
        return inventoryLocationId;
    }

    public void setInventoryLocationId(int inventoryLocationId) {
        this.inventoryLocationId = inventoryLocationId;
    }

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }

    public int getAisle() {
        return aisle;
    }

    public void setAisle(int aisle) {
        this.aisle = aisle;
    }

    public int getRack() {
        return rack;
    }

    public void setRack(int rack) {
        this.rack = rack;
    }

    public int getShelf() {
        return shelf;
    }

    public void setShelf(int shelf) {
        this.shelf = shelf;
    }

    public int getStockItemId() {
        return stockItemId;
    }

    public void setStockItemId(int stockItemId) {
        this.stockItemId = stockItemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
