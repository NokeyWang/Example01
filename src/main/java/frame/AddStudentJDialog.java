/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frame;

import classes.Student;
import util.StudentGradeException;

import javax.swing.*;

/**
 *
 * @author CHester
 */
public class AddStudentJDialog extends javax.swing.JDialog {

    /**
     * Creates new form AddStudentJDialog
     */
    public AddStudentJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addStudentJPanel1 = new frame.AddStudentJPanel();
        addButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        addButton.setText("添加");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    addButtonActionPerformed(evt);
                } catch (StudentGradeException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(addStudentJPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addComponent(addButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(addStudentJPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addButton)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) throws StudentGradeException {//GEN-FIRST:event_addButtonActionPerformed
        String number, sex, birthday, id, studentNumber, discipline, grade;

        if (addStudentJPanel1.idTextField.getText().length() != 18) {
            JOptionPane.showMessageDialog(null, "身份证长度必须为18位!");
            return;
        }
        //TODO:此处请仿照上面添加输入的合法性检查!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        if (addStudentJPanel1.maleRadioButton.isSelected()) {
            sex = addStudentJPanel1.maleRadioButton.getText().trim();
        } else if (addStudentJPanel1.femaleRadioButton.isSelected()) {
            sex = addStudentJPanel1.femaleRadioButton.getText().trim();
        } else {
            JOptionPane.showMessageDialog(null, "请选择性别!");
            return;
        }

        if (((Integer.parseInt(addStudentJPanel1.gradeTextField.getText().trim())) < 2012) ||
                (Integer.parseInt(addStudentJPanel1.gradeTextField.getText().trim()) > 2015)) {
            throw new StudentGradeException("年级只能在2012~2015之间!");
        }
        number = this.addStudentJPanel1.numberTextField.getText().trim();
        birthday = this.addStudentJPanel1.birthdayTextField.getText().trim();
        id = this.addStudentJPanel1.idTextField.getText().trim();
        studentNumber = this.addStudentJPanel1.studentNumberTextField.getText().trim();
        discipline = this.addStudentJPanel1.disciplineTextField.getText().trim();
        grade = this.addStudentJPanel1.gradeTextField.getText().trim();
        student = new Student(number, sex, birthday, id, studentNumber, discipline, grade);
        this.dispose();
        return;    }//GEN-LAST:event_addButtonActionPerformed

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
            java.util.logging.Logger.getLogger(AddStudentJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddStudentJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddStudentJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddStudentJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddStudentJDialog dialog = new AddStudentJDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton addButton;
    private frame.AddStudentJPanel addStudentJPanel1;
    // End of variables declaration//GEN-END:variables
    private Student student;

    public Student getStudent() {
        return student;
    }
}
