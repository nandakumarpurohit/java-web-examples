package com.demo;

import javax.swing.JDialog;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Employees {

    public static void main(String[] args)
    {
        try
        {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        }
        catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            System.out.println(ex.getMessage());
        }
        EmployeesWindow sForm = new EmployeesWindow(null, false);
        sForm.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        sForm.pack();
        sForm.setLocationRelativeTo(null);

        sForm.setVisible(true);
    }

}