/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.toedter.calendar.IDateEditor;   
import com.toedter.calendar.JTextFieldDateEditor;
import javax.swing.JOptionPane;

/**
 *
 * @author john
 */
public class JavaSwingCalendar extends JFrame {
    
    public JavaSwingCalendar(){
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    private void initComponents() {

    jDateChooser1 = new com.toedter.calendar.JDateChooser();
    jButton1 = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jButton1.setText("jButton1");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
    jButton1ActionPerformed(evt);
    }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    .addGroup(layout.createSequentialGroup()
    .addContainerGap()
    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
    .addContainerGap(149, Short.MAX_VALUE))
    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
    .addContainerGap(123, Short.MAX_VALUE)
    .addComponent(jButton1)
    .addGap(90, 90, 90))
    );
    layout.setVerticalGroup(
    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    .addGroup(layout.createSequentialGroup()
    .addContainerGap()
    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
    .addGap(39, 39, 39)
    .addComponent(jButton1)
    .addContainerGap(91, Short.MAX_VALUE))
    );

    pack();
    }//

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {

 String msg = "getCalendar = " + jDateChooser1.getCalendar();
 msg += "\ngetDate = " + jDateChooser1.getDate();
 JOptionPane.showMessageDialog(this, msg);

}

/**

    @param args the command line arguments
    */
    public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {
    public void run() {
    new JavaSwingCalendar().setVisible(true);
    }
    });
    }

// Variables declaration - do not modify
private javax.swing.JButton jButton1;
private com.toedter.calendar.JDateChooser jDateChooser1;
// End of variables declaration
    
}
