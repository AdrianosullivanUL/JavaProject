/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise05.pkg7;

import javax.swing.JOptionPane;

/**
 *
 * @author 501834813
 */
public class FrmStockItemEdit extends javax.swing.JInternalFrame {

    private int stockItemId;
    StockItemCollection stockItemCollection;
    /**
     * Creates new form FrmStockItemEdit
     */
    public FrmStockItemEdit(int stockItemId) {
        initComponents();
        
        try {
            stockItemCollection = new StockItemCollection();
        } catch (ApplicationException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Problem", JOptionPane.ERROR_MESSAGE);
        }

        // Store the location id
        this.stockItemId = stockItemId;

        // Decide on Add or Edit form presentation, 0 is add
        if (stockItemId == 0) {
            this.title = "Add new Inventory Location";
        } else {
            this.title = "Edit Inventory Location Id: " + stockItemId;
            PopulateFormFields();
        }
    }
    private void PopulateFormFields() {

        while (stockItemCollection.moveToNextStockItem()) {
            if (stockItemCollection.getCurrentStockItem().getStockItemId()== stockItemId) {
                this.txtPartNumber.setText(Integer.toString(stockItemCollection.getCurrentStockItem().getPartNumber()));
                this.txtStockName.setText(stockItemCollection.getCurrentStockItem().getName());
                this.txtDescription.setText(stockItemCollection.getCurrentStockItem().getDescription());
                this.txtUnitPrice.setText(Double.toString(stockItemCollection.getCurrentStockItem().getUnitPrice()));
                
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
        txtStockName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDescription = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtUnitPrice = new javax.swing.JTextField();
        BtnSave = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtPartNumber = new javax.swing.JTextField();

        jLabel1.setText("Stock Name");

        txtStockName.setText("jTextField1");
        txtStockName.setMinimumSize(new java.awt.Dimension(150, 25));
        txtStockName.setPreferredSize(new java.awt.Dimension(150, 25));

        jLabel2.setText("Description");

        txtDescription.setText("jTextField2");
        txtDescription.setMinimumSize(new java.awt.Dimension(150, 25));
        txtDescription.setPreferredSize(new java.awt.Dimension(150, 25));

        jLabel3.setText("Unit Price $");

        txtUnitPrice.setText("jTextField3");
        txtUnitPrice.setMinimumSize(new java.awt.Dimension(100, 25));
        txtUnitPrice.setPreferredSize(new java.awt.Dimension(100, 25));

        BtnSave.setBackground(new java.awt.Color(153, 255, 153));
        BtnSave.setText("SAVE");
        BtnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSaveActionPerformed(evt);
            }
        });

        jLabel4.setText("Part Number");

        txtPartNumber.setText("jTextField1");
        txtPartNumber.setMinimumSize(new java.awt.Dimension(150, 25));
        txtPartNumber.setPreferredSize(new java.awt.Dimension(150, 25));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BtnSave)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(96, 96, 96)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUnitPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtStockName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPartNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPartNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel2)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnSave)
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtStockName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(23, 23, 23)
                        .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtUnitPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(128, 128, 128))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSaveActionPerformed
        // TODO add your handling code here:
        stockItemCollection.moveToHeadLocation();
        while (stockItemCollection.moveToNextStockItem()) {
            StockItem stockItem = stockItemCollection.getCurrentStockItem();
            if (stockItem.getStockItemId() == stockItemId) {
                try {
                    int partNumber = Integer.parseInt(this.txtPartNumber.getText());
                    String stockName = this.txtStockName.getText();
                    String description = this.txtDescription.getText();
                    double unitPrice = Double.parseDouble(this.txtUnitPrice.getText());
                    
                    stockItem.setPartNumber(partNumber);
                    stockItem.setName(stockName);
                    stockItem.setDescription(description);
                    stockItem.setUnitPrice(unitPrice);
                    stockItemCollection.saveStockItem(stockItemId);
                    JOptionPane.showMessageDialog(null, "Change Saved", "Sucess", JOptionPane.INFORMATION_MESSAGE);
                    break;
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid entry: " + ex.getMessage(), "Problem", JOptionPane.ERROR_MESSAGE);
                } catch (ApplicationException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Problem", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_BtnSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtPartNumber;
    private javax.swing.JTextField txtStockName;
    private javax.swing.JTextField txtUnitPrice;
    // End of variables declaration//GEN-END:variables
}
