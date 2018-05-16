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
            loadStockItemCollection();
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
 void saveStockCollection()
            throws ApplicationException {
        try {
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
            return null;
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
}

