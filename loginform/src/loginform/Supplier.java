/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package loginform;

//import PlaceholderTextField.PlaceholderTextField;
import Modeling.supp_prod_rel_Model;
import Control.supplier_operations;
import Modeling.DBOperation;
import Modeling.Suppliers_Model;
import Modeling.Products_Model;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class Supplier extends javax.swing.JFrame {
    private ArrayList<Object> arr;
    private int row_number=0;
    /**
     * Creates new form Supplier
     */
    
    public Supplier() {
        initComponents();
        setLocationRelativeTo(null);
       tablesup.fixTable(jScrollPane2);
       tablesup.setColumnAlignment(0, JLabel.CENTER);
       tablesup.setCellAlignment(0, JLabel.CENTER);
       tablesup.setColumnAlignment(1, JLabel.CENTER);
       tablesup.setCellAlignment(1, JLabel.CENTER);
       
    }
    public void show_table() {
        DefaultTableModel pr = (DefaultTableModel) tablesup.getModel();
        try
        {
             arr = supplier_operations.get_PRodSuppData();
                Object[] row = new Object[4];
                int c=0;
                 for (int i = 0; i < arr.size(); i+=3) 
                    {
                       row[0] = ((Suppliers_Model)arr.get(i)).getSupplier_id();
                       row[1] = ((Suppliers_Model)arr.get(i)).getCompany_name();
                       row[2] = ((Products_Model)arr.get(i+1)).getMed_name();
                       row[3] = ((supp_prod_rel_Model)arr.get(i+2)).getDate();   
                       pr.insertRow(c, row);
                       c++;
                }
        }catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(null, "Error displaying data:", "Message", JOptionPane.WARNING_MESSAGE);
                }
        
         
        tablesup.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                row_number = tablesup.getSelectedRow();
            }
        }
        );
    }
    private void show_Supplier(String comName) 
    {
        DefaultTableModel pr = (DefaultTableModel) tablesup.getModel();
        Object[] row = new Object[4];
        
        arr=supplier_operations.Search_supplier(comName);
        row[0] = ((Suppliers_Model)arr.get(0)).getSupplier_id();
        row[1] = ((Suppliers_Model)arr.get(0)).getCompany_name();
        row[2] = ((Products_Model)arr.get(1)).getMed_name(); 
        row[3] = ((supp_prod_rel_Model)arr.get(2)).getDate(); 
        pr.insertRow(0, row);
        
            arr = supplier_operations.get_PRodSuppData();
            tablesup.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                row_number = tablesup.getSelectedRow();
            }
        }
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

        jPanel1 = new javax.swing.JPanel();
        label1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Add_supp = new button.mybutton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablesup = new tabledark.TableDark();
        search1 = new javax.swing.JTextField();
        sup_search = new button.mybutton();
        view_supp = new button.mybutton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        label1.setFont(new java.awt.Font("Tahoma", 1, 23)); // NOI18N
        label1.setForeground(new java.awt.Color(6, 107, 138));
        label1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label1.setText("Suppliers List");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/agreement.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/back-button.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        Add_supp.setBackground(new java.awt.Color(6, 107, 138));
        Add_supp.setForeground(new java.awt.Color(255, 255, 255));
        Add_supp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add-user.png"))); // NOI18N
        Add_supp.setText("Add");
        Add_supp.setBorderColor(new java.awt.Color(255, 255, 255));
        Add_supp.setColor(new java.awt.Color(6, 107, 138));
        Add_supp.setColorClick(new java.awt.Color(0, 153, 153));
        Add_supp.setColorText(new java.awt.Color(0, 102, 102));
        Add_supp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Add_supp.setRadius(10);
        Add_supp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Add_suppMouseClicked(evt);
            }
        });
        Add_supp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_suppActionPerformed(evt);
            }
        });

        tablesup.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Company ID", "Company name", "Product name", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablesup.setGridColor(new java.awt.Color(0, 102, 102));
        tablesup.getTableHeader().setReorderingAllowed(false);
        tablesup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablesupMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablesup);

        search1.setText("Enter Company Name");

        sup_search.setBackground(new java.awt.Color(6, 107, 138));
        sup_search.setForeground(new java.awt.Color(255, 255, 255));
        sup_search.setText("Search");
        sup_search.setBorderColor(new java.awt.Color(255, 255, 255));
        sup_search.setColor(new java.awt.Color(6, 107, 138));
        sup_search.setColorClick(new java.awt.Color(0, 153, 153));
        sup_search.setColorText(new java.awt.Color(0, 102, 102));
        sup_search.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sup_search.setRadius(10);
        sup_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sup_searchActionPerformed(evt);
            }
        });

        view_supp.setBackground(new java.awt.Color(6, 107, 138));
        view_supp.setForeground(new java.awt.Color(255, 255, 255));
        view_supp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/edit.png"))); // NOI18N
        view_supp.setText("View");
        view_supp.setBorderColor(new java.awt.Color(255, 255, 255));
        view_supp.setColor(new java.awt.Color(6, 107, 138));
        view_supp.setColorClick(new java.awt.Color(0, 153, 153));
        view_supp.setColorText(new java.awt.Color(0, 102, 102));
        view_supp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        view_supp.setRadius(10);
        view_supp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_suppActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(252, 252, 252)
                        .addComponent(Add_supp, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(161, 161, 161)
                        .addComponent(view_supp, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 854, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(176, 176, 176)
                                        .addComponent(search1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(sup_search, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(search1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sup_search, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Add_supp, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(view_supp, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        
        rond obj = new rond();
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void tablesupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablesupMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tablesupMouseClicked

    private void sup_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sup_searchActionPerformed
        // TODO add your handling code here:
        if (search1.getText().isEmpty()) {
        } else {
            if (supplier_operations.Search_supplier(search1.getText()) != null) {
                this.dispose();
                Supplier pr = new Supplier();
                pr.show_Supplier(search1.getText());
                pr.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "This product does not exist", "Message", JOptionPane.WARNING_MESSAGE);
            }
        }
       

    }//GEN-LAST:event_sup_searchActionPerformed

    private void Add_suppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_suppActionPerformed
        this.dispose();
        newproduct gg=new newproduct();
        gg.setVisible(true);
    }//GEN-LAST:event_Add_suppActionPerformed

    private void view_suppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view_suppActionPerformed
        // TODO add your handling code here:
         this.dispose();
        view_supp ss=new view_supp();
        ss.setVisible(true);
     

    }//GEN-LAST:event_view_suppActionPerformed

    private void Add_suppMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Add_suppMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_Add_suppMouseClicked

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
            java.util.logging.Logger.getLogger(Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Supplier().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private button.mybutton Add_supp;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label1;
    private javax.swing.JTextField search1;
    private button.mybutton sup_search;
    private tabledark.TableDark tablesup;
    private button.mybutton view_supp;
    // End of variables declaration//GEN-END:variables

}
