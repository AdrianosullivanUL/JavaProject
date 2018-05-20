/*
Formal Specification
---------------------------------
1 Task Formulation
Present useful information to the user on how to use & test this application 

2 Specification
   Input: N/A 
   Output: HTML formatted text giving instructions on how to use
           the application

3 Problem Solving
Present a swing form with instructions on how to use the application

4 Top Down Construction
Create HTML formatted text to present and then present it

5 Bottom-Up Verification
All text populated should be readable by the user with headings for the 
following sections: Introduction, How To Use, Sorting & Test Execution

6 Coding
Language is Java 

Variable Types
  Swing label with HTML formatted text

7 Testing
 - Following sections are visible:
      Introduction, How To Use, Sorting & Test Execution
   result = OK
 - All Text is present and readable, result = OK
 - No spelling mistakes, result = OK
 - Text Content makes sense and is easy to understand and follow, result = OK


 */
package exercise05.pkg7;

/**
* Present an form with an explanation on how to use the application on startup
* @author Adrian O'Sullivan Student ID 16230124 
*/
public class FrmReadMe extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmReadMe
     */
    public FrmReadMe() {
        initComponents();
        lblText.setText("<html><h1>Introduction</h1>" 
                + "This application is designed to support stock control for a small warehouse or shop." 
                + " <br>It is designed as a single user solution with data stored locally in files.<br>" 
                + "The system has two main modules, a Stock Item module to manage the items that are being" 
                + " controlled and an Inventory Location Module to manage the locations in a simple " 
                + "section/aisle/rack/shelf model where only one item can be stored in a location. <br>" 
                + "The location module is used to record what stock and how much is stored in each location. <br>" 
                + "<br><h2>How to use</h2>" 
                + "1) Select Help and then use the Create options to create new sample data<br>"
                + "2) Select Stock Item Find or Add module to maintain the list of stock items including price<br>" 
                + "3) Select the Inventory Location Find or Add module to maintain the locations and the stock contained in each<br>"
                + "<h2>Sorting</h2>"
                + "We have implemented two different Sort solutions:<br>"
                + "   1) The Stock Item Find screen implements a bubble sort to allow the user sort by Part number<br>"
                + "   2) The Location Inventory Find screen uses the collections.sort function with comparitors to offer<bv>"
                + "      the user an options for two different sort types.<br>"
                + "<h2>Executing Test Plans</h2>"
                + "You can execute the test plans for this application by running the following modules:<br>"
                + "   1) InventoryLocationTestHarness<br>"
                + "   2) StockItemTestHarness<br>"
                );
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblText = new javax.swing.JLabel();

        setTitle("Read Me");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblText, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(108, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblText, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblText;
    // End of variables declaration//GEN-END:variables
}
