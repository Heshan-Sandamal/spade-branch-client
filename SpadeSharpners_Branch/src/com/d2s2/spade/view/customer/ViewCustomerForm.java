/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.d2s2.spade.view.customer;

import com.d2s2.spade.controllers.CustomerController;
import com.d2s2.spade.controllers.CustomerTelephoneController;
import com.d2s2.spade.models.Customer;
import com.d2s2.spade.models.CustomerTelephone;
import java.awt.Frame;
import java.awt.ScrollPane;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.jdesktop.swingx.JXTable;

/**
 *
 * @author Tharindu Diluksha
 */
public class ViewCustomerForm extends javax.swing.JDialog {

    /**
     * Creates new form ViewCustomerForm
     */
    private DefaultTableModel defaulttablemodel;
    private DefaultTableModel phoneNoTableModel;
    private ArrayList<Customer> customerList;
    private EditSingleCustomer editSinglecustomer;
    private String[] tableHeaders;
    private String[] phoneNoTableHeders;
    private TableRowSorter<TableModel> sorter;
    private ArrayList<CustomerTelephone> telephoneList;
    private ArrayList<String> telephoneListString;

    public ViewCustomerForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        customerList = new ArrayList<>();
        
        
        phoneNoTableHeders = new String[]{"Phone Numbers"};
        phoneNoTableModel = new DefaultTableModel(0, 0);
        phoneNoTableModel.setColumnIdentifiers(phoneNoTableHeders);
        phoneNumberTable.setModel(phoneNoTableModel);
        phoneNoTableModel.addRow(new Object[]{""});
        //phoneNoTableModel.addRow(new Object[]{""});
        
        tableHeaders = new String[]{"CustomerID", "Name", "Balance"};
        defaulttablemodel = new DefaultTableModel(0, 0);
        defaulttablemodel.setColumnIdentifiers(tableHeaders);
        customerTable.setModel(defaulttablemodel);
      
        //searchByCombobox.addActionListener(searchByCombobox);//
        /* creating customer table with specified properties*/
        /*customerTable = new JXTable() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };*/
        //customerTable.enableInputMethods(false);
        customerTable.setCellSelectionEnabled(false);
        customerTable.setSelectionMode(0);
        customerTable.setRowSelectionAllowed(true);
        customerTable.setDragEnabled(false);
        customerTable.getTableHeader().setReorderingAllowed(false);
        customerTable.getTableHeader().setResizingAllowed(false);
        //customerTable.addKeyListener(l);
        customerTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    customerTableMouseClicked(evt);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ViewCustomerForm.class.getName()).log(Level.SEVERE, null, ex);
                    
                } catch (SQLException ex) {
                    Logger.getLogger(ViewCustomerForm.class.getName()).log(Level.SEVERE, null, ex);
                    
                }
            }
        });

        try {
            telephoneList = CustomerTelephoneController.getCustomersTelephoneNo();
        } catch (SQLException ex) {
            Logger.getLogger(ViewCustomerForm.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Unable to view due to CLASS " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ViewCustomerForm.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Unable to view due to SQL " + ex.getMessage());
        }
        try {
            TableInit();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ViewCustomerForm.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Unable to view due to CLASS " + ex.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(ViewCustomerForm.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Unable to view due to SQL " + ex.getMessage());
        }
        
        
        setTableSorter();
        
        searchByCombobox.addItem("CustomerID");
        searchByCombobox.addItem("Name");
        searchByCombobox.addItem("Balance");

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
        updateButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        searchByCombobox = new javax.swing.JComboBox<String>();
        searchTextBox = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        addressLable = new javax.swing.JLabel();
        addressTextField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        customerTable = new JXTable() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        phoneNumberScroll = new javax.swing.JScrollPane();
        phoneNumberTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("  Customers");

        updateButton.setText("Update");

        editButton.setText("Edit");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete");

        searchByCombobox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                searchByComboboxItemStateChanged(evt);
            }
        });
        searchByCombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchByComboboxActionPerformed(evt);
            }
        });

        searchTextBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTextBoxKeyReleased(evt);
            }
        });

        jLabel2.setText("Search By");

        addressLable.setText("Address");

        customerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "CustomerID", "Name", "Debit"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(customerTable);
        if (customerTable.getColumnModel().getColumnCount() > 0) {
            customerTable.getColumnModel().getColumn(0).setResizable(false);
        }

        phoneNumberTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Phone Number"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        phoneNumberScroll.setViewportView(phoneNumberTable);
        if (phoneNumberTable.getColumnModel().getColumnCount() > 0) {
            phoneNumberTable.getColumnModel().getColumn(0).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(233, 233, 233)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchByCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(searchTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(updateButton)
                        .addGap(42, 42, 42)
                        .addComponent(deleteButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addressLable)
                        .addGap(18, 18, 18)
                        .addComponent(addressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(phoneNumberScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(93, 93, 93))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(searchByCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addressLable)
                            .addComponent(addressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addComponent(phoneNumberScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editButton)
                    .addComponent(updateButton)
                    .addComponent(deleteButton))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // TODO add your handling code here:
        try {
            editCustomer();
        } catch (ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(this, "Select a customer");
        } catch (IndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(this, "Select a customer");
        }


    }//GEN-LAST:event_editButtonActionPerformed

    private void searchByComboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchByComboboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchByComboboxActionPerformed

    private void searchTextBoxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextBoxKeyReleased
        filterTableInkeywordSearch();        // TODO add your handling code here:
    }//GEN-LAST:event_searchTextBoxKeyReleased

    private void searchByComboboxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_searchByComboboxItemStateChanged
        searchTextBox.setText(""); 
        sorter.setRowFilter(null);// TODO add your handling code here:
    }//GEN-LAST:event_searchByComboboxItemStateChanged

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
            java.util.logging.Logger.getLogger(ViewCustomerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewCustomerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewCustomerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewCustomerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ViewCustomerForm dialog = new ViewCustomerForm(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addressLable;
    private javax.swing.JTextField addressTextField;
    private javax.swing.JTable customerTable;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane phoneNumberScroll;
    private javax.swing.JTable phoneNumberTable;
    private javax.swing.JComboBox<String> searchByCombobox;
    private javax.swing.JTextField searchTextBox;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables

    /* Initializing table with data and headings */
    private void TableInit() throws ClassNotFoundException, SQLException {
        /*defaulttablemodel = new DefaultTableModel(0, 0);

        defaulttablemodel.setColumnIdentifiers(tableHeaders);
        customerTable.setModel(defaulttablemodel);*/

        customerList = CustomerController.viewCustomers();
        for (Customer cl : customerList) {
            defaulttablemodel.addRow(new Object[]{cl.getCustomerId(), cl.getName(), cl.getAddress()});
        }

        //scrollpane.setViewportView(customerTable);
        //add(scrollpane);
    }

    private void editCustomer() throws ArrayIndexOutOfBoundsException, IndexOutOfBoundsException {
        int selectedRow = customerTable.getSelectedRow();
        String selectedId = customerTable.getValueAt(selectedRow, 0).toString();
        System.out.println(selectedId);
        Customer selectedCustomer = null;
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getCustomerId() == selectedId) {
                selectedCustomer = customerList.get(i);
            } else {
                //selectedCustomer
            }

        }
        editSinglecustomer = new EditSingleCustomer(this, true, selectedCustomer);
        editSinglecustomer.setVisible(true);
        selectedRow = -1;
    }
    
    private void customerTableMouseClicked(java.awt.event.MouseEvent evt) throws ClassNotFoundException, SQLException{
        //phoneNoTableModel.removeRow(phoneNoTableModel.getRowCount());
        for (int i = phoneNoTableModel.getRowCount()-1; i>=0 ; i--) {
            phoneNoTableModel.removeRow(i);
        }
        
        
        
        
        String selectedId = customerTable.getValueAt(customerTable.getSelectedRow(), 0).toString();
        Customer selectedCustomer = null;        
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getCustomerId() == selectedId) {
                selectedCustomer = customerList.get(i);
            } else {
                //selectedCustomer
            }
        }
        //telephoneList = selectedCustomer.getTelNoList();
        telephoneListString = CustomerController.viewCustomerPhone("CustomerTelephone", selectedCustomer.getCustomerId());
        addressTextField.setText(selectedCustomer.getAddress());
        /*for (CustomerTelephone tp : telephoneList) {
            if (tp.getCustomerId()== selectedCustomer.getCustomerId()){
                phoneNoTableModel.addRow(new Object[]{tp.getTelNo()});
                System.out.println(tp.getTelNo());
                System.out.println("corretc tp");
            }
            else{
                System.out.println(tp.getTelNo());
            }
        }*/
        
        for (String tp: telephoneListString){
            phoneNoTableModel.addRow(new Object[]{tp});
        }
        
    }

    private void setTableSorter() {
        sorter = new TableRowSorter<>(customerTable.getModel());
        customerTable.setRowSorter(sorter);
    }

    private void filterTableInkeywordSearch() {
        String text = searchTextBox.getText();

        if (text.trim().length() == 0) {
            sorter.setRowFilter(null);
        } else {
            if (searchByCombobox.getSelectedItem().equals("CustomerID")) {
                sorter.setRowFilter(sorter.getRowFilter().regexFilter("^(?i)" + text, new int[]{0}));
            } else if (searchByCombobox.getSelectedItem().equals("Name")) {
                sorter.setRowFilter(sorter.getRowFilter().regexFilter("^(?i)" + text, new int[]{1}));
            }

        }
    }
}
