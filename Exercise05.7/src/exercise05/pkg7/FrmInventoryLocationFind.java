/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise05.pkg7;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 501958452
 */
public class FrmInventoryLocationFind extends javax.swing.JInternalFrame {

    InventoryLocationCollection inventoryCollection;
    StockItemCollection stockCollection;

    /**
     * Creates new form FrmFindInventoryLocation
     */
    public FrmInventoryLocationFind() {
        initComponents();
        try {
            inventoryCollection = new InventoryLocationCollection();
            stockCollection = new StockItemCollection();

            PopulateTable();
        } catch (ApplicationException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Problem", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void PopulateTable() {
        DefaultTableModel model = (DefaultTableModel) tblInventoryLocation.getModel();
        for (int i = model.getRowCount() - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        inventoryCollection.moveToHeadLocation();
        while (inventoryCollection.moveToNextInventoryLocation()) {
            InventoryLocation inventoryLocation = inventoryCollection.getCurrentInventoryLocation();
            String stockItemKey = "";
            if (inventoryLocation.getStockItemId() != 0) {
                stockCollection.moveToHeadLocation();
                while (stockCollection.moveToNextStockItem()) {
                    StockItem stockItem = stockCollection.getCurrentStockItem();
                    if (stockItem.getStockItemId() == inventoryCollection.getCurrentInventoryLocation().getStockItemId()) {
                        stockItemKey = stockItem.getPartNumber() + " - " + stockItem.getName();
                        break;
                    }
                }
            }

            model.addRow(new Object[]{inventoryLocation.getSection(),
                inventoryLocation.getAisle(),
                inventoryLocation.getRack(),
                inventoryLocation.getShelf(),
                stockItemKey,
                0,
                inventoryLocation.getInventoryLocationId()});
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblInventoryLocation = new javax.swing.JTable();
        txtSection = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtStockItem = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtAisle = new javax.swing.JTextField();
        txtRack = new javax.swing.JTextField();
        btnApplyFilter = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnEditSelectedLocation = new javax.swing.JButton();
        btnDeleteSelectedLocation = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cmbSort = new javax.swing.JComboBox<>();

        tblInventoryLocation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Section", "Aisle", "Rack", "Shelf", "StockItem", "Quantity", "Id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblInventoryLocation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblInventoryLocationMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblInventoryLocation);

        jLabel1.setText("Section");

        jLabel2.setText("Aisle");

        jLabel3.setText("Rack");

        txtStockItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStockItemActionPerformed(evt);
            }
        });

        jLabel4.setText("Stock Item");

        txtRack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRackActionPerformed(evt);
            }
        });

        btnApplyFilter.setText("ApplyFilter");

        jLabel5.setText("Filter");

        btnEditSelectedLocation.setText("Edit Selected Location");
        btnEditSelectedLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditSelectedLocationActionPerformed(evt);
            }
        });

        btnDeleteSelectedLocation.setText("Delete Selected Item");
        btnDeleteSelectedLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteSelectedLocationActionPerformed(evt);
            }
        });

        jLabel6.setText("Sort By");

        cmbSort.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Entry Sequence (default)", "Section", " " }));
        cmbSort.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbSortItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(56, 56, 56))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel5))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtAisle, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                    .addComponent(txtSection))
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtRack, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtStockItem, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnApplyFilter)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDeleteSelectedLocation)
                                .addGap(71, 71, 71)))
                        .addComponent(btnEditSelectedLocation))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbSort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmbSort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(txtRack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtAisle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtStockItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnApplyFilter)
                    .addComponent(btnEditSelectedLocation)
                    .addComponent(btnDeleteSelectedLocation))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtRackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRackActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRackActionPerformed

    private void txtStockItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStockItemActionPerformed

    private void btnEditSelectedLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditSelectedLocationActionPerformed
        // TODO add your handling code here:
        int column = 0;
        int row = tblInventoryLocation.getSelectedRow();
        String selectedId = tblInventoryLocation.getModel().getValueAt(row, 6).toString();
        int selectedInventoryLocationId = Integer.parseInt(selectedId);

        FrmMain frmMain = (FrmMain) this.getTopLevelAncestor();
        frmMain.EditInventoryLocation(selectedInventoryLocationId);


    }//GEN-LAST:event_btnEditSelectedLocationActionPerformed

    private void cmbSortItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbSortItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            String sortColumn = cmbSort.getSelectedItem().toString();
            inventoryCollection.sortBy(sortColumn);
            PopulateTable();
        }
    }//GEN-LAST:event_cmbSortItemStateChanged

    private void tblInventoryLocationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblInventoryLocationMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblInventoryLocationMouseClicked

    private void btnDeleteSelectedLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteSelectedLocationActionPerformed
        // TODO add your handling code here:
        int response = JOptionPane.showConfirmDialog(null, "Are you sure you wish to delete this location?", "Confirm",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
            int column = 0;
            int row = tblInventoryLocation.getSelectedRow();
            String selectedId = tblInventoryLocation.getModel().getValueAt(row, 6).toString();
            int selectedInventoryLocationId = Integer.parseInt(selectedId);
            try {
                inventoryCollection.deleteInventoryLocation(selectedInventoryLocationId);
                inventoryCollection.saveInventoryCollection(0);
                PopulateTable();
                JOptionPane.showMessageDialog(null, "Entry Deleted", "Sucess", JOptionPane.INFORMATION_MESSAGE);
            } catch (ApplicationException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Problem", JOptionPane.ERROR_MESSAGE);
            }

        }
    }//GEN-LAST:event_btnDeleteSelectedLocationActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApplyFilter;
    private javax.swing.JButton btnDeleteSelectedLocation;
    private javax.swing.JButton btnEditSelectedLocation;
    private javax.swing.JComboBox<String> cmbSort;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblInventoryLocation;
    private javax.swing.JTextField txtAisle;
    private javax.swing.JTextField txtRack;
    private javax.swing.JTextField txtSection;
    private javax.swing.JTextField txtStockItem;
    // End of variables declaration//GEN-END:variables
}
