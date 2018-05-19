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
 * Class to represent a StockItem, Each Stock Item has the following information
 * saved against it: StockItemID- Unique Identifier, PartNumber - Stock Part
 * Number- this is used for sorting PartName, Part Description, Unit Price
 *
 *
 * @author Mary Cronin 0510661
 */
public class StockItem implements Serializable {

    private int StockItemId;
    private int PartNumber;
    private String Name;
    private String Description;
    private double UnitPrice;

    /**
     * StockItem Constructor
     *
     * @param StockItemId- Unique identifier
     * @param PartNunber - Stock Item Part Number(used for Bubble Sort)
     * @param Name - Stock Item Name
     * @param Description - Stock Item Description
     * @param UnitPrice - Unit Price
     */
    public StockItem(int StockItemId, int PartNunber, String Name, String Description, double UnitPrice) {
        this.StockItemId = StockItemId;
        this.PartNumber = PartNunber;
        this.Name = Name;
        this.Description = Description;
        this.UnitPrice = UnitPrice;
    }

    /**
     * Accessor for StockId
     *
     * @return StockItem ID
     */
    public int getStockItemId() {
        return StockItemId;
    }

    /**
     * Mutator for StockId
     *
     * @param StockItemId
     */
    public void setStockItemId(int StockItemId) {
        this.StockItemId = StockItemId;
    }

    /**
     * Accessor for PartNumber
     *
     * @return PartNumber
     */
    public int getPartNumber() {
        return PartNumber;
    }

    /**
     * Mutator for PartNumber
     *
     * @param PartNumber
     */
    public void setPartNumber(int PartNumber) {
        this.PartNumber = PartNumber;
    }

    /**
     * Accessor for Name
     *
     * @return Name
     */
    public String getName() {
        return Name;
    }

    /**
     * Mutator for Name
     *
     * @param Name
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * Accessor for Description
     *
     * @return
     */
    public String getDescription() {
        return Description;
    }

    /**
     * Mutator for Description
     *
     * @param Description
     */
    public void setDescription(String Description) {
        this.Description = Description;
    }

    /**
     * Accessor for UnitPrice
     *
     * @return UnitPrice
     */
    public double getUnitPrice() {
        return UnitPrice;
    }

    /**
     * Mutator for UnitPrice
     *
     * @param UnitPrice
     */
    public void setUnitPrice(double UnitPrice) {
        this.UnitPrice = UnitPrice;
    }

}
