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
import java.util.List;

/**
 * [Class Title Here]
 * @author Adrian O'Sullivan
 * Student ID 16230124
 * Last Modified [dd/mm/yyyy]
 */
public class InventoryLocationCollection {
    private List<InventoryLocation> iventoryStore;
    
    public void loadInventoryCollection()
        throws FileNotFoundException
    {
        try
        {
            FileInputStream fis = new FileInputStream("iventoryStore.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            List<InventoryLocation> inventoryStore = (List<InventoryLocation>)ois.readObject();
            ois.close();
            
        }
        catch (FileNotFoundException ex1)
        {
            
        }
        catch (IOException ex2)
        {
            
        }
        catch (ClassNotFoundException ex3)
        {
            
        }
        finally
        {

        }
    }
    public void saveInventoryCollection()
        throws FileNotFoundException
    {
        try
        {
            FileOutputStream fos = new FileOutputStream("iventoryStore.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(iventoryStore);
            oos.close();
        }
        catch (FileNotFoundException ex1)
        {
            
        }
        catch (IOException ex2)
        {
            
        }
        finally
        {

        }
    }
    
}
