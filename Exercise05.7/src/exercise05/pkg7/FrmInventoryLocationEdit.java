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

import java.util.HashSet;
import javax.swing.JOptionPane;

/**
 * Form to allow user to add/edit an Inventory Location
 *
 * @author Adrian O'Sullivan Student ID 16230124 
 */
public class FrmInventoryLocationEdit extends javax.swing.JInternalFrame {

    private int inventoryLocationId;
    InventoryLocationCollection inventoryCollection;
    StockItemCollection stockCollection;
    InventoryLocation editInventoryLocation;

    /**
     * Creates new form FrmInventoryLocationEdit
     */
    public FrmInventoryLocationEdit(int inventoryLocationId) {
        initComponents();

        // Load the Inventory Collection
        try {
            inventoryCollection = new InventoryLocationCollection();
            stockCollection = new StockItemCollection();
        } catch (ApplicationException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Problem", JOptionPane.ERROR_MESSAGE);
        }

        // Store the location id
        this.inventoryLocationId = inventoryLocationId;

        // Decide on Add or Edit form presentation, 0 is add
        if (inventoryLocationId == 0) {
            this.title = "Add new Inventory Location";
            editInventoryLocation = new InventoryLocation(0, 0, 0, 0, 0);
        } else {
            // Get the entry to edit
            while (inventoryCollection.moveToNextInventoryLocation()) {
                if (inventoryCollection.getCurrentInventoryLocation().getInventoryLocationId() == inventoryLocationId) {
                    editInventoryLocation = inventoryCollection.getCurrentInventoryLocation();
                }
            }
            this.title = "Edit Inventory Location Id: " + inventoryLocationId;

        }
        PopulateFormFields();
    }
/**
 * Populate the form fields with the Inventory Item being added/edited
 */
    private void PopulateFormFields() {
        PopulateStockItemDropdownList();
        PoplulateInventoryLocationFields();
    }
/**
 * Populate the stock item dropdown list
 */
    private void PopulateStockItemDropdownList() {
        cmbStockItem.addItem("");
        stockCollection.moveToHeadLocation();
        while (stockCollection.moveToNextStockItem()) {
            StockItem stockItem = stockCollection.getCurrentStockItem();
            cmbStockItem.addItem(stockItem.getPartNumber() + " - " + stockItem.getName());
        }
    }
/**
 * Populate the Inventory Location fields from the entry being edited
 */
    private void PoplulateInventoryLocationFields() {
        this.txtSection.setText(Integer.toString(editInventoryLocation.getSection()));
        this.txtAisle.setText(Integer.toString(editInventoryLocation.getAisle()));
        this.txtRack.setText(Integer.toString(editInventoryLocation.getRack()));
        this.txtShelf.setText(Integer.toString(editInventoryLocation.getShelf()));
        this.txtQuantity.setText(Integer.toString(editInventoryLocation.getQuantity()));

        // Popupate the dropdown list for stock item
        stockCollection.moveToHeadLocation();
        while (stockCollection.moveToNextStockItem()) {
            StockItem stockItem = stockCollection.getCurrentStockItem();
            if (stockItem.getStockItemId() == editInventoryLocation.getStockItemId()) {
                for (int i = 0; i < cmbStockItem.getItemCount() - 1; i++) {
                    if (cmbStockItem.getItemAt(i).equals(stockItem.getPartNumber() + " - " + stockItem.getName())) {
                        cmbStockItem.setSelectedIndex(i);
                        break;
                    }
                }
            }

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmbStockItem = new javax.swing.JComboBox<>();
        txtSection = new javax.swing.JTextField();
        txtAisle = new javax.swing.JTextField();
        txtRack = new javax.swing.JTextField();
        txtShelf = new javax.swing.JTextField();
        txtQuantity = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        jLabel1.setText("Section");

        jLabel2.setText("Aisle");

        jLabel3.setText("Rack");

        jLabel4.setText("Shelf");

        jLabel5.setText("Stock Item");

        jLabel6.setText("Quantity");

        cmbStockItem.setMinimumSize(new java.awt.Dimension(150, 20));
        cmbStockItem.setPreferredSize(new java.awt.Dimension(150, 25));

        txtSection.setText("jTextField1");
        txtSection.setMinimumSize(new java.awt.Dimension(100, 25));
        txtSection.setPreferredSize(new java.awt.Dimension(100, 25));
        txtSection.setRequestFocusEnabled(false);

        txtAisle.setText("jTextField2");
        txtAisle.setMinimumSize(new java.awt.Dimension(100, 25));
        txtAisle.setPreferredSize(new java.awt.Dimension(100, 25));

        txtRack.setText("jTextField3");
        txtRack.setMinimumSize(new java.awt.Dimension(100, 25));
        txtRack.setPreferredSize(new java.awt.Dimension(100, 25));

        txtShelf.setText("jTextField4");
        txtShelf.setMinimumSize(new java.awt.Dimension(100, 25));
        txtShelf.setPreferredSize(new java.awt.Dimension(100, 25));

        txtQuantity.setText("jTextField5");
        txtQuantity.setMinimumSize(new java.awt.Dimension(100, 25));
        txtQuantity.setPreferredSize(new java.awt.Dimension(100, 25));

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCancel)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbStockItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAisle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtShelf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(319, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSave)
                        .addGap(21, 21, 21))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtSection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtAisle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtRack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtShelf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbStockItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnCancel))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**
 * Handle the save request, if successful this stores the change and presents the find screen
 * @param evt event action
 */
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            int section = Integer.parseInt(this.txtSection.getText());
            int aisle = Integer.parseInt(this.txtAisle.getText());
            int rack = Integer.parseInt(this.txtRack.getText());
            int shelf = Integer.parseInt(this.txtShelf.getText());
            int quantity = Integer.parseInt(this.txtQuantity.getText());

            editInventoryLocation.setSection(section);
            editInventoryLocation.setAisle(aisle);
            editInventoryLocation.setRack(rack);
            editInventoryLocation.setShelf(shelf);
            int selectedStockItemId = getSelectedStockItem();
            editInventoryLocation.setStockItemId(selectedStockItemId);

            editInventoryLocation.setQuantity(quantity);

            // If adding a new entry, put it into the collection
            if (inventoryLocationId == 0) {
                editInventoryLocation.setInventoryLocationId(inventoryCollection.getNextID());
                inventoryCollection.addInventoryLocation(editInventoryLocation);
            }
            inventoryCollection.saveInventoryCollection(inventoryLocationId);

            JOptionPane.showMessageDialog(null, "Change Saved", "Sucess", JOptionPane.INFORMATION_MESSAGE);

            if (inventoryLocationId > 0) {
                // return to the Inventory Find screen
                FrmMain frmMain = (FrmMain) this.getTopLevelAncestor();
                frmMain.FindInventoryLocation();
                this.dispose();
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid entry: " + ex.getMessage(), "Problem", JOptionPane.ERROR_MESSAGE);
        } catch (ApplicationException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Problem", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveActionPerformed
/**
 * Handle cancel request,return to the find screen
 * @param evt event action
 */
    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // return to the Inventory Find screen
        FrmMain frmMain = (FrmMain) this.getTopLevelAncestor();
        frmMain.FindInventoryLocation();
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed
    /**
     * Get the selected stock item id
     * @return selected stock item id
     */
    private int getSelectedStockItem() {

        stockCollection.moveToHeadLocation();
        while (stockCollection.moveToNextStockItem()) {
            StockItem stockItem = stockCollection.getCurrentStockItem();
            String stockItemKey = stockItem.getPartNumber() + " - " + stockItem.getName();
            String comboKey = cmbStockItem.getSelectedItem().toString();
            if (stockItemKey.equals(comboKey)) {
                return stockItem.getStockItemId();
            }
        }
        return 0;

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cmbStockItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtAisle;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtRack;
    private javax.swing.JTextField txtSection;
    private javax.swing.JTextField txtShelf;
    // End of variables declaration//GEN-END:variables
}
