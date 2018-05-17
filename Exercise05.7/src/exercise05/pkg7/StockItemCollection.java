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

/**
 *
 * @author 501834813
 */
public class StockItemCollection {
    private List<StockItem> stockStore;
    private int currentEntryIndex = -1;
    
 public StockItemCollection() throws ApplicationException {
        try {
            loadStockCollection();
        } catch (ApplicationException ex) {
            throw ex;
        }
    }
 public void loadStockCollection()
            throws ApplicationException {
        try {
            FileInputStream fileInputStream = new FileInputStream("stockStore.dat");
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
 
 
   void saveStockItem(int updatedStockItemId)throws ApplicationException {
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
   private void validateUpdates(int updateStockItemId)
            throws ApplicationException {
        
        StockItem stockItem = null;
        for (StockItem findStockItem : stockStore)
        {
            if (findStockItem.getStockItemId() == updateStockItemId)
            {
                stockItem = findStockItem;
                break;
            }
        }
        if (stockItem == null)
            throw new ApplicationException("Problem validating updates, cannot find Stock Item Id " + updateStockItemId);

        for (StockItem existingStockItem : stockStore) {
            if (existingStockItem.getStockItemId() != stockItem.getStockItemId()
                    && checkForDuplicateStock(existingStockItem, stockItem)) {
                throw new ApplicationException("Cannot update this entry, Stock Item already exists");
            }
        }
        if (stockItem.getUnitPrice()< 0) {
            throw new ApplicationException("Nothing in this world is Free");
        }
        stockStore.add(stockItem);
    }

    private boolean checkForDuplicateStock(StockItem existing, StockItem updated) {
        boolean result = false;
        if (existing.getPartNumber() == updated.getPartNumber()) {
            result = true;
        }
        return result;
    }
    
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
 void addStockItem(StockItem stockItem) {
        stockStore.add(stockItem);
    }
 StockItem getCurrentStockItem() {
        if (currentEntryIndex > -1 && currentEntryIndex <= stockStore.size() -1)
            return stockStore.get(currentEntryIndex);
        else
        {
            return null;
        }
    }
 
 void moveToHeadLocation() {
        currentEntryIndex = -1;
 }
 
 boolean moveToNextStockItem() {
        boolean returnValue = true;

        if (stockStore != null && currentEntryIndex < (stockStore.size() - 1)) {
            currentEntryIndex++;
        } else {
            returnValue = false;
        }
        return returnValue;
    }

    boolean moveToPreviousStockItem() {
        boolean returnValue = true;

        if (stockStore != null && currentEntryIndex > 0) {
            currentEntryIndex--;
        } else {
            returnValue = false;
        }
        return returnValue;
    }
  
    
    void BubbleSort(){
        StockItem temp;
        if (stockStore.size()>1) // check if the number of orders is larger than 1
        {
            for (int x=0; x<stockStore.size(); x++) // bubble sort outer loop
            {
                for (int i=0; i < stockStore.size()-i; i++) {
                    if (stockStore.get(i).getPartNumber() > stockStore.get(i+1).getPartNumber())
                      {
                        temp = stockStore.get(i);
                        stockStore.set(i,stockStore.get(i+1) );
                        stockStore.set(i+1, temp);
                    }
                }
            }
        }

    }
}


