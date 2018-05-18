/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 * @author 501834813
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
    void saveStockItem(int updatedStockItemId) throws ApplicationException {
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
    
    void deleteStockItem(int stockItemId) throws ApplicationException {
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
    int getNextID() {
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
    void addStockItem(StockItem stockItem) {
        stockStore.add(stockItem);
    }

    /**
     * Method to Return current StockItem info
     * @return current ctock Item
     */
    StockItem getCurrentStockItem() {
        if (currentEntryIndex > -1 && currentEntryIndex <= stockStore.size() - 1) {
            return stockStore.get(currentEntryIndex);
        } else {
            return null;
        }
    }

    /**
     * More to head of List where index =-1
     */
    void moveToHeadLocation() {
        currentEntryIndex = -1;
    }

    /**
     * More to Tail of List where index size of StockStore ArrayList
     */
    void moveToTailLocation() {
        currentEntryIndex = stockStore.size(); // force index beyond last entry
    }

    /**
     * Method to return size of arraylist
     * @return Size of stockStore ArrayList
     */
    int size() {
        return stockStore.size();
    }

    /**
     * Method to indicate movement to next stock item was a success
     * @return ReturnValue true if it moves, false if not
     */
    boolean moveToNextStockItem() {
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
    boolean moveToPreviousStockItem() {
        boolean returnValue = true;

        if (stockStore != null && currentEntryIndex > 0) {
            currentEntryIndex--;
        } else {
            returnValue = false;
        }
        return returnValue;
    }

    /**
     * Method for Bubblesort, sorting algorithm that repeatedly steps through tockStore 
     * comparing each pair of adjacent stock PartNumbers and swaping them if they 
     * are in the wrong order.
     * 
     */
    void BubbleSort() {
        StockItem temp;
        try {
            int storeSize = stockStore.size();
            if (stockStore.size() > 1) // check if the number of orders is larger than 1
            {
                for (int x = 0; x < storeSize; x++) // bubble sort outer loop
                {
                    System.out.println("x " + x);
                    for (int i = 0; i < (storeSize - 1); i++) {
                        System.out.println("bubble check i " + i + " " + stockStore.get(i).getPartNumber() + " ? " + stockStore.get(i + 1).getPartNumber());
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
