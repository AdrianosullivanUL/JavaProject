/*
Formal Specification
---------------------------------
1 Task Formulation
Implement a class that can store a collection of Stock Items and persist
these to a file on the computers disk. This will include methods to traverse the 
list, add, delete, update and sort entries along with a save method to persist
the data to a disk file.

2 Specification
Constructor which retrieves the list from a file store
   Input: N/A, Output: N/A
Method to allow user save changes made to the list
   Input: Updated Stock Item Identifier, Output: N/A
Method to allow user to delete a stock item
   Input: Stock Item Identifier to Delete, Output: N/A
Method to allow user get the next Stock Item ID available
   Input: N/A, Output Next available ID
Method to retrieve the current Stock Item as the user traverses the list
   Input: N/A, Output Current Stock Item
Method to traverse up and down through the list 
   Input: N/A, Output Move result (true/false)
Method to Sort the list using a bubble sort function 
(***NOTE: See method description for a detailed explanation of this method)

3 Problem Solving
Problem has been solved using a combination of techniques which include:
   a) A class to represent each Stock Item   
   b) An array list to store a collection of Stock Items
   c) Logic to stream the collection to a file store
   d) A bubble sort algorithm to sort the list

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
7 Testing


 */
package exercise05.pkg7;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Class for StockItemCollection array based container called stockStore for StockItems
 * @author Mary Cronin 0510661
 */
public class StockItemCollection {

    private List<StockItem> stockStore; //Array container
    private int currentEntryIndex = -1; //index initialised a position 1

    /**
     * Constructor for StockItemCollection which uses LoadStockCollection method or throws exception
     * @throws ApplicationException 
     */
    public StockItemCollection() throws ApplicationException {
        try {
            loadStockCollection();
        } catch (ApplicationException ex) {
            throw ex;
        }
    }

    /**
     * Load the Stock List from file 
     * @throws ApplicationException to handle unsuccessful loads
     */
    public void loadStockCollection()
            throws ApplicationException {
        try {
            FileInputStream fileInputStream = new FileInputStream("stockStore.dat"); // Create new file
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            stockStore = (List<StockItem>) objectInputStream.readObject();
            objectInputStream.close();
            currentEntryIndex = -1;

        } catch (FileNotFoundException ex1) {
            // First time run or file has been deleted, create a new empty collection
            stockStore = new ArrayList<StockItem>();
        } catch (IOException ex2) {
            throw new ApplicationException("I/O error loading the stockStore.dat file");

        } catch (ClassNotFoundException ex3) {
            throw new ApplicationException("Class Not Found loading the stockStore.dat file");
        } finally {

        }
    }

    /**
     * Method to save changes made to stockCollection by updating stockStore.dat
     * @param updatedStockItemId, stock Id is applied to all entries using validate method
     * @throws ApplicationException to handle file not found and I/O exceptions 
     */
    public void saveStockItem(int updatedStockItemId) throws ApplicationException {
        try {
            if (updatedStockItemId != 0) {
                validateUpdates(updatedStockItemId);
            }
            FileOutputStream fileOutputStream = new FileOutputStream("stockStore.dat");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(stockStore);
            objectOutputStream.close();
        } catch (FileNotFoundException ex1) {
            throw new ApplicationException("File stockStore.dat not found");
        } catch (IOException ex2) {
            throw new ApplicationException("I/O error loading the stockStore.dat file");

        } finally {

        }
    }

    /**
     * Validate changes made to each stock item with the stockStore
     * @param updateStockItemId
     * @throws ApplicationException 
     */
    private void validateUpdates(int updateStockItemId)
            throws ApplicationException {

        StockItem stockItem = null;
        for (StockItem findStockItem : stockStore) {
            if (findStockItem.getStockItemId() == updateStockItemId) {
                stockItem = findStockItem;
                break;
            }
        }
        if (stockItem == null) {
            throw new ApplicationException("Problem validating updates, cannot find Stock Item Id " + updateStockItemId);
        }

        for (StockItem existingStockItem : stockStore) {
            if (existingStockItem.getStockItemId() != stockItem.getStockItemId()
                    && checkForDuplicateStock(existingStockItem, stockItem)) {
                throw new ApplicationException("Cannot update this entry, Stock Item already exists");
            }
        }
        if (stockItem.getUnitPrice() < 0) {
            throw new ApplicationException("Nothing in this world is Free");
        }
    }

    /**
     * Method to delete stock items within the stockStore
     * @param stockItemId - selection identifier for stock item to be deleted
     * @throws ApplicationException if delete is unsuccessful
     */
    
    public void deleteStockItem(int stockItemId) throws ApplicationException {
        boolean deleted = true;
        for (int i = 0; i <= stockStore.size() - 1; i++) {
            if (Integer.compare(stockItemId, stockStore.get(i).getStockItemId()) == 0) {
                stockStore.remove(i);
                deleted = true;
            }
            if (deleted == false) {
                throw new ApplicationException("Entry not deleted");
            }
        }
    }

    /**
     * Method to check for duplicate stock
     * @param existing data holder for existing PN
     * @param updated data holder for new PN
     * @return 
     */
    private boolean checkForDuplicateStock(StockItem existing, StockItem updated) {
        boolean result = false;
        if (existing.getPartNumber() == updated.getPartNumber()) {
            result = true;
        }
        return result;
    }

    /**
     * Method to return ID of stockItem from stock store
     * @return StockID
     */
    public int getNextID() {
        int returnId = 0;
        if (stockStore != null && stockStore.size() > 0) {
            StockItem stockItem = stockStore.get(stockStore.size() - 1);
            returnId = stockItem.getStockItemId() + 1;
        } else {
            returnId = 1;
        }
        return returnId;

    }

    /**
     * Assign return value to stockItem for adding
     * @param stockItem StockItem 
     */
    public void addStockItem(StockItem stockItem) throws ApplicationException {
        stockStore.add(stockItem);
    }

    /**
     * Method to Return current StockItem info
     * @return current stock Item
     */
    public StockItem getCurrentStockItem() {
        if (currentEntryIndex > -1 && currentEntryIndex <= stockStore.size() - 1) {
            return stockStore.get(currentEntryIndex);
        } else {
            return null;
        }
    }

    /**
     * More to head of List where index =-1
     */
    public void moveToHeadLocation() {
        currentEntryIndex = -1;
    }

    /**
     * More to Tail of List where index size of StockStore ArrayList
     */
    public void moveToTailLocation() {
        currentEntryIndex = stockStore.size(); // force index beyond last entry
    }

    /**
     * Method to return size of arraylist
     * @return Size of stockStore ArrayList
     */
    public int size() {
        return stockStore.size();
    }

    /**
     * Method to indicate movement to next stock item was a success
     * @return ReturnValue true if it moves, false if not
     */
    public boolean moveToNextStockItem() {
        boolean returnValue = true;

        if (stockStore != null && currentEntryIndex < (stockStore.size() - 1)) {
            currentEntryIndex++;
        } else {
            returnValue = false;
        }
        return returnValue;
    }

    /**
     * Method to indicate movement to next stock item was a success
     * @return ReturnValue true if it moves, false if not
     */
    public boolean moveToPreviousStockItem() {
        boolean returnValue = true;

        if (stockStore != null && currentEntryIndex > 0) {
            currentEntryIndex--;
        } else {
            returnValue = false;
        }
        return returnValue;
    }

    /**
     * 1)Name Of Sorting Algorithm :Bubblesort, 
     * 2) Description of the operation of your selected algorithm-
     * Sorting algorithm that repeatedly steps through stockStore comparing each pair 
     * of adjacent stock PartNumbers and swapping them if they are in the wrong order.
     * 3)pseudocode for your sorting algorithm
     * BubbleSort()
     * Create temp variable
     *      exception try catch for valid list
     *      Outer loop for x= 1 to size of stockStore - 1 
     *         Inner Loop for i=0 to size of stockstore - 1
     *            check if the partnumber of stockstore (i)  is greater than  partnumber of stockstore(i+1)
     *                      swap by doing toe following(
     *                         make temp = stockstore (i)
     *                         make stockstore (i) = Stockstore(i+1)
     *                         make stockstore ((i+1) =  temp)
     *              End if 
     *          next i loop
     *      next x loop
     * 4) Efficiency of Sorting Algorithm in O notation
     * In Bubble Sort, n-1 comparisons will be done in the 1st pass, 
     * n-2 in 2nd pass, n-3 in 3rd pass and so on.
     * The total number of comparisons will be= (n-1) + (n-2) + (n-3) + ..... + 3 + 2 + 1
     * Sum = n(n-1)/2
     * =O(n^2)
     * 
     */
      public void BubbleSort() {
        StockItem temp;
        try {
            int storeSize = stockStore.size();
            if (stockStore.size() > 1) // check if the number of orders is larger than 1
            {
                for (int x = 0; x < storeSize; x++) // bubble sort outer loop
                {
                    System.out.println("x " + x);
                    for (int i = 0; i < (storeSize - 1); i++) {
                        //System.out.println("bubble check i " + i + " " + stockStore.get(i).getPartNumber() + " ? " + stockStore.get(i + 1).getPartNumber());
                        if (stockStore.get(i).getPartNumber() > stockStore.get(i + 1).getPartNumber()) {
                            temp = stockStore.get(i);
                            stockStore.set(i, stockStore.get(i + 1));
                            stockStore.set(i + 1, temp);
                        }
                        else
                            i = i;
                    }
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Problem", JOptionPane.ERROR_MESSAGE);
        }
    }
}
