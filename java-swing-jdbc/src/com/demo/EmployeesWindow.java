package com.demo;

import com.util.*;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableCellRenderer;

public class EmployeesWindow extends javax.swing.JDialog
{
    private javax.swing.JComboBox<String> cboGender;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtDepartment;
    private javax.swing.JTextField txtEmployeeId;
    private javax.swing.JTextField txtFullName;
    private javax.swing.JTextField txtPosition;
    private javax.swing.JTextField txtSalary;

    boolean addRecord = false;

    private void clearInputBoxes()
    {
        txtEmployeeId.setText("");
        txtFullName.setText("");
        cboGender.setSelectedItem("");
        txtDepartment.setText("");
        txtPosition.setText("");
        txtSalary.setText("");
    }

    private void addNew()
    {
    	try {
    		PreparedStatement ps = DBUtilities.getConnection().prepareStatement("INSERT INTO employees (full_name, gender, department, position, salary) values (?, ?, ?, ?, ?)");
    		ps.setString(1, txtFullName.getText());
            ps.setString(2, cboGender.getSelectedItem().toString());
            ps.setString(3, txtDepartment.getText());
            ps.setString(4, txtPosition.getText());
            ps.setDouble(5, Double.parseDouble(txtSalary.getText()));
            ps.executeUpdate();
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }

    private void updateRecord()
    {
    	try {
    	PreparedStatement ps = DBUtilities.getConnection().prepareStatement("update employees set full_name=?, gender=?, department=?, position=?, salary=? where employee_id=?");
        ps.setString(1, txtFullName.getText());
        ps.setString(2, cboGender.getSelectedItem().toString());
        ps.setString(3, txtDepartment.getText());
        ps.setString(4, txtPosition.getText());
        ps.setDouble(5, Double.parseDouble(txtSalary.getText()));
        ps.setInt(6, Integer.parseInt(txtEmployeeId.getText()));
        ps.executeUpdate();
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }

    private void deleteRecord()
    {
        String sql_stmt = "DELETE FROM employees WHERE employee_id = " + txtEmployeeId.getText();
        DBUtilities.ExecuteSQLStatement(sql_stmt);
    }

    private void loadRecords() throws SQLException
    {
        String sql_stmt = "SELECT * FROM employees;";
        ResultSetTableModel tableModel = new ResultSetTableModel(sql_stmt);
        jTable1.setModel(tableModel);
        jTable1.getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
            try {
                if (jTable1.getSelectedRow() >= 0) {
                    Object employee_id = jTable1.getValueAt(jTable1.getSelectedRow(), 0);
                    Object full_name = jTable1.getValueAt(jTable1.getSelectedRow(), 1);
                    Object gender = jTable1.getValueAt(jTable1.getSelectedRow(), 2);
                    Object department = jTable1.getValueAt(jTable1.getSelectedRow(), 3);
                    Object position = jTable1.getValueAt(jTable1.getSelectedRow(), 4);
                    Object salary = jTable1.getValueAt(jTable1.getSelectedRow(), 5);

                    txtEmployeeId.setText(employee_id.toString());
                    txtFullName.setText(full_name.toString());
                    cboGender.setSelectedItem(gender.toString());
                    txtDepartment.setText(department.toString());
                    txtPosition.setText(position.toString());
                    txtSalary.setText(salary.toString());
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        });

        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.LEFT);
        jTable1.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
    }

    public EmployeesWindow(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    private void initComponents() {

        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        txtEmployeeId = new javax.swing.JTextField();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        txtFullName = new javax.swing.JTextField();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        cboGender = new javax.swing.JComboBox<>();
        javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
        txtDepartment = new javax.swing.JTextField();
        javax.swing.JLabel jLabel6 = new javax.swing.JLabel();
        txtPosition = new javax.swing.JTextField();
        javax.swing.JLabel jLabel7 = new javax.swing.JLabel();
        txtSalary = new javax.swing.JTextField();
        javax.swing.JButton btnAddNew = new javax.swing.JButton();
        javax.swing.JButton btnUpdate = new javax.swing.JButton();
        javax.swing.JButton btnDelete = new javax.swing.JButton();
        javax.swing.JButton btnClose = new javax.swing.JButton();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Employee Records Editor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel2.setText("Employee ID:");
        txtEmployeeId.setEnabled(false);
        jLabel3.setText("Full Name:");
        jLabel4.setText("Gender:");
        cboGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Male", "Female"}));
        jLabel5.setText("Department:");
        jLabel6.setText("Position:");
        jLabel7.setText("Salary:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmployeeId, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDepartment)
                            .addComponent(txtSalary)))
                    .addComponent(txtFullName))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtEmployeeId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cboGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnAddNew.setText("Add New");
        btnAddNew.addActionListener(evt -> {
            addRecord = true;
            btnUpdateActionPerformed(evt);
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(evt -> {
            addRecord = false;
            btnUpdateActionPerformed(evt);
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(this::btnDeleteActionPerformed);

        btnClose.setText("Close");
        btnClose.addActionListener(this::btnCloseActionPerformed);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAddNew)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                        .addComponent(btnClose))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddNew)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnClose))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }

    private void formWindowOpened(java.awt.event.WindowEvent evt)
    {
        try
        {
            loadRecords();
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(1);
    }

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt)
    {
        int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this record?",
                "Confirm Delete Record?", JOptionPane.YES_NO_OPTION);

        if (dialogResult == JOptionPane.YES_OPTION) {
            try {
                deleteRecord();

                loadRecords();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt)
    {
        int dialogResult = JOptionPane.showConfirmDialog(null, addRecord ? "Confirm Add new record?" :"Are you sure you want to update this record?",
                addRecord ? "Confirm Add Record" : "Confirm Update Record?", JOptionPane.YES_NO_OPTION);

        if (dialogResult == JOptionPane.YES_OPTION) {
            try {
                if (addRecord)
                {
                    addNew();
                    clearInputBoxes();
                }
                else {
                    updateRecord();
                }

                loadRecords();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EmployeesWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeesWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeesWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeesWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EmployeesWindow dialog = new EmployeesWindow(new javax.swing.JFrame(), true);
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
}