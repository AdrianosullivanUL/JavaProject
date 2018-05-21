/*
ADT Formal Specification
========================
1 What an ADT should do: Creates a Stock Item and Provide methods 
to retrieve values of attributes (accessors) and to modify (mutators)
Specifications
StockItem():initialise the variables of the object stock Item
pre : None
post :Stock item created

getStockItemId() provide access to the value of variable  StockID
pre :None
post : Access to StockID

setStockItemId(int StockItemId) -mutator for StockID, assign values to the variables 
stockId of object stockItem.
pre: StockItemiD > 0
post: value is assigned to StockId

getPartNumber() provide access to the value of variable PartNumber
pre :None
post : Access to getPartNumber

setPartNumber(int PartNumber) -mutator for PartNumber, assign values to the variables 
PartNumber of object stockItem.
pre: PartNumber > 0
post: value is assigned to PartNumber

getName() provide access to the value of variable Name
pre :None
post : Access to Name

setName(String Name) -mutator for Name, assign values to the variables 
Name of object stockItem.
pre: Name is not null
post: value is assigned to Name

getDescription() provide access to the value of variable Description
pre :None
post : Access to Description

setDescription(String Description) -mutator for Description, assign values to the variable
Description of object stockItem.
pre: Description is not null
post: value is assigned to Description

getUnitPrice() provide access to the value of variable UnitPrice
pre :None
post : Access to UnitPrice

setUnitPrice(double UnitPrice) -mutator for UnitPrice, assign values to the variable
UnitPrice of object stockItem.
pre: nitPrice > 0.0
post: value is assigned to UnitPrice

toString(): Creates a string representation of a StockItem
Pre:  object is a valid stockItem
Post:The stockItem object remains unchanged.

2. User’s View of Services
    public StockItem(int StockItemId, int PartNunber, String Name, String Description, double UnitPrice) throws ApplicationException{
    public int getStockItemId() 
    public void setStockItemId(int StockItemId) 
    public int getPartNumber() 
    public void setPartNumber(int PartNumber) 
    public String getName() 
    public void setName(String Name) 
    public String getDescription() 
    public void setDescription(String Description)
    public double getUnitPrice() 
    public void setUnitPrice(double UnitPrice) 
    public String toString() 

3. Internal Data Representation
    Access  type    Variable
    private int     StockItemId
    private int     PartNumber
    private String  Name
    private String  Description
    private double  UnitPrice

4. Remaining/Auxiliary Definitions
    None

5. Coding
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
     * @param StockItemId Unique identifier for StockItem
     * @param PartNunber Stock Item Part Number(used for Bubble Sort)
     * @param Name Stock Item Name
     * @param Description Stock Item Description
     * @param UnitPrice Unit Price
     * @throws ApplicationException
     */
    public StockItem(int StockItemId, int PartNunber, String Name, String Description, double UnitPrice) throws ApplicationException {
        setStockItemId(StockItemId);
        setPartNumber(PartNunber);
        setName(Name);
        setDescription(Description);
        setUnitPrice(UnitPrice);
    }

    /**
     * Accessor for StockItemId
     *
     * @return StockItemId
     */
    public int getStockItemId() {
        return StockItemId;
    }

    /**
     * Mutator for StockitemId
     *
     * @param StockItemId unique identifier for stockItem, must be greater than
     * 0 to be assigned
     * @throws ApplicationException if stockItemId is negative
     */
    public void setStockItemId(int StockItemId) throws ApplicationException {
        if (StockItemId < 0) {
            throw new ApplicationException("System does not support negative stock item Id numbers");
        }
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
     * @param PartNumber- Entry must be greater than 0 before entry is assigned
     * to PartNumber
     * @throws ApplicationException if PartNumber is negative
     */
    public void setPartNumber(int PartNumber) throws ApplicationException {
        if (PartNumber < 0) {
            throw new ApplicationException("System does not support negative part numbers");
        }
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
     * @param Name, not null before entry is assigned to Name
     * @throws ApplicationException if Name is null
     */
    public void setName(String Name) throws ApplicationException {
        if (Name.length() <= 0) {
            throw new ApplicationException("You must give the stock item a name");
        }
        this.Name = Name;
    }

    /**
     * Accessor for Description
     *
     * @return Description
     */
    public String getDescription() {
        return Description;
    }

    /**
     * Mutator for Description
     *
     * @param Description - not null before entry is assigned to Description
     * @throws ApplicationException if Description is null
     */
    public void setDescription(String Description) throws ApplicationException {
        if (Description.length() <= 0) {
            throw new ApplicationException("You must give the stock item a Description");
        }
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
     * @param UnitPrice - Entry must be greater than 0 before UnitPrice is
     * assigned
     * @throws ApplicationException if UnitPrice is negative or Zero
     */
    public void setUnitPrice(double UnitPrice) throws ApplicationException {
        if (UnitPrice < 0.00) {
            throw new ApplicationException("Nothing in life is free, the price must be positive");
        }
        this.UnitPrice = UnitPrice;
    }

    @Override
    /**
     * To String Method to create a string representation of a StockItem
     *
     * @return -string representation of a StockItem
     */
    public String toString() {
        return "\nStock id " + StockItemId + ",\n"
                + "Part Number " + PartNumber + ",\n"
                + "Stock Name " + Name + ",\n"
                + "Stock Description" + Description + ",\n"
                + "Unit Price " + UnitPrice;

    }

}
