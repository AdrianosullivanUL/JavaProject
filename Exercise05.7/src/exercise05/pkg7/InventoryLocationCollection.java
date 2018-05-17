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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * [Class Title Here]
 *
 * @author Adrian O'Sullivan Student ID 16230124 Last Modified [dd/mm/yyyy]
 */
public class InventoryLocationCollection {

    private List<InventoryLocation> inventoryStore;
    private int currentEntryIndex = -1;

    public InventoryLocationCollection() throws ApplicationException {
        try {
            loadInventoryCollection();
        } catch (ApplicationException ex) {
            throw ex;
        }
    }

    public void loadInventoryCollection()
            throws ApplicationException {
        try {
            FileInputStream fileInputStream = new FileInputStream("inventoryStore.dat");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            inventoryStore = (List<InventoryLocation>) objectInputStream.readObject();
            objectInputStream.close();
            currentEntryIndex = -1;

        } catch (FileNotFoundException ex1) {
            // First time run or file has been deleted, create a new empty collection
            inventoryStore = new ArrayList<InventoryLocation>();
        } catch (IOException ex2) {
            throw new ApplicationException("I/O error loading the inventoryStore.dat file");

        } catch (ClassNotFoundException ex3) {
            throw new ApplicationException("Class Not Found loading the inventoryStore.dat file");
        } finally {

        }
    }

    void saveInventoryCollection()
            throws ApplicationException {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("inventoryStore.dat");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(inventoryStore);
            objectOutputStream.close();
        } catch (FileNotFoundException ex1) {
            throw new ApplicationException("File inventoryStore.dat not found");
        } catch (IOException ex2) {
            throw new ApplicationException("I/O error loading the inventoryStore.dat file");

        } finally {

        }
    }

    int getNextID() {
        int returnId = 0;
        if (inventoryStore != null && inventoryStore.size() > 0) {
            InventoryLocation inventoryLocation = inventoryStore.get(inventoryStore.size() - 1);
            returnId = inventoryLocation.getInventoryLocationId() + 1;
        } else {
            returnId = 1;
        }
        return returnId;
    }

    void addInventoryLocation(InventoryLocation inventoryLocation) {
        inventoryStore.add(inventoryLocation);
    }

    InventoryLocation getCurrentInventoryLocation() {
        if (currentEntryIndex > -1 && currentEntryIndex <= inventoryStore.size() - 1) {
            return inventoryStore.get(currentEntryIndex);
        } else {
            return null;
        }
    }

    void moveToHeadLocation() {
        currentEntryIndex = -1;
    }

    boolean moveToNextInventoryLocation() {
        boolean returnValue = true;

        if (inventoryStore != null && currentEntryIndex < (inventoryStore.size() - 1)) {
            currentEntryIndex++;
        } else {
            returnValue = false;
        }
        System.out.println("Current Inv loc " + currentEntryIndex);
        return returnValue;
    }

    boolean moveToPreviousInventortLocation() {
        boolean returnValue = true;

        if (inventoryStore != null && currentEntryIndex > 0) {
            currentEntryIndex--;
        } else {
            returnValue = false;
        }
        return returnValue;
    }

    void sortBy(String sortKey) {
        if (sortKey == "Section") {
            Collections.sort(inventoryStore, new InventoryLocationSectionComparator());
            moveToHeadLocation();
        }
        if (sortKey == "Entry Sequence (default)") {
            Collections.sort(inventoryStore, new InventoryLocationIdComparator());
            moveToHeadLocation();
        }
    }

    class InventoryLocationSectionComparator implements Comparator<InventoryLocation> {
        public int compare(InventoryLocation self, InventoryLocation other) {

            return Integer.valueOf(self.getSection()).compareTo(other.getSection());
        }
    }

    class InventoryLocationIdComparator implements Comparator<InventoryLocation> {
        public int compare(InventoryLocation self, InventoryLocation other) {
            return Integer.valueOf(self.getInventoryLocationId()).compareTo(other.getInventoryLocationId());
        }
    }
}
