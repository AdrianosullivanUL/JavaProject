/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise05.pkg7;

/**
 *
 * @author 501958452
 */
public class FrmMain extends javax.swing.JFrame {
    FrmFindInventoryLocation frmFindInventoryLocation;
    FrmInventoryLocationEdit frmInventoryLocationEdit;
    /**
     * Creates new form FrmMain
     */
    public FrmMain() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem5 = new javax.swing.JMenuItem();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuStockItem = new javax.swing.JMenu();
        mnuStockItemFind = new javax.swing.JMenuItem();
        mnuStockItemAdd = new javax.swing.JMenuItem();
        mnuInventoryLocation = new javax.swing.JMenu();
        mnuInventoryLocationFind = new javax.swing.JMenuItem();
        mnuInventoryLocationAdd = new javax.swing.JMenuItem();

        jMenuItem5.setText("jMenuItem5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1024, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 747, Short.MAX_VALUE)
        );

        getContentPane().add(jDesktopPane1, java.awt.BorderLayout.CENTER);

        mnuStockItem.setText("Stock Item");

        mnuStockItemFind.setText("Find");
        mnuStockItem.add(mnuStockItemFind);

        mnuStockItemAdd.setText("Add");
        mnuStockItem.add(mnuStockItemAdd);

        jMenuBar1.add(mnuStockItem);

        mnuInventoryLocation.setText("Inventory Location");

        mnuInventoryLocationFind.setText("Find");
        mnuInventoryLocationFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuInventoryLocationFindActionPerformed(evt);
            }
        });
        mnuInventoryLocation.add(mnuInventoryLocationFind);

        mnuInventoryLocationAdd.setText("Add");
        mnuInventoryLocationAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuInventoryLocationAddActionPerformed(evt);
            }
        });
        mnuInventoryLocation.add(mnuInventoryLocationAdd);

        jMenuBar1.add(mnuInventoryLocation);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuInventoryLocationFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuInventoryLocationFindActionPerformed
        if (frmFindInventoryLocation == null || frmFindInventoryLocation.isClosed())
        {
            frmFindInventoryLocation = new FrmFindInventoryLocation();
            jDesktopPane1.add(frmFindInventoryLocation);
          
        }
        frmFindInventoryLocation.setVisible(true);
        frmFindInventoryLocation.setClosable(true);
        System.out.println(frmFindInventoryLocation.getMaximumSize());
   //     frmFindInventoryLocation.setSize(frmFindInventoryLocation.getMaximumSize());
    }//GEN-LAST:event_mnuInventoryLocationFindActionPerformed

    private void mnuInventoryLocationAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuInventoryLocationAddActionPerformed
       if (frmInventoryLocationEdit == null || frmInventoryLocationEdit.isClosed())
        {
            frmInventoryLocationEdit = new FrmInventoryLocationEdit(0);
            jDesktopPane1.add(frmInventoryLocationEdit);
        }
        frmInventoryLocationEdit.setVisible(true);
        frmInventoryLocationEdit.setClosable(true);

    }//GEN-LAST:event_mnuInventoryLocationAddActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenu mnuInventoryLocation;
    private javax.swing.JMenuItem mnuInventoryLocationAdd;
    private javax.swing.JMenuItem mnuInventoryLocationFind;
    private javax.swing.JMenu mnuStockItem;
    private javax.swing.JMenuItem mnuStockItemAdd;
    private javax.swing.JMenuItem mnuStockItemFind;
    // End of variables declaration//GEN-END:variables
}
