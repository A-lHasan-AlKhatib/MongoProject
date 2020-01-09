package View;

import Controller.XtraController;
import java.util.InputMismatchException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author Handy
 */
public class StdFrame extends javax.swing.JFrame {

    /**
     * Creates new form StdFrame
     */
    public StdFrame() {
        try {
            initComponents();
            this.setLocationRelativeTo(null);

            Object[][] data = XtraController.displayExams();
            Object[] cols = new Object[5];
            cols[0] = "Teatcher name";
            cols[1] = "Course name";
            cols[2] = "Room";
            cols[3] = "Date";
            cols[4] = "Time";
            DefaultTableModel model = new DefaultTableModel(data, cols);
            allTable.setModel(model);
            MainFrame.writeLog("StdFrame opend and all exams has been retrived from the data base . Number of fetched row = " + data.length);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Something went Wrong!", "ERROR!!", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ButtonGroup group = new ButtonGroup();
        JTabbedPane jTabbedPane1 = new JTabbedPane();
        JPanel jPanel1 = new JPanel();
        // Variables declaration - do not modify//GEN-BEGIN:variables
        JButton allRef = new JButton();
        JScrollPane jScrollPane1 = new JScrollPane();
        allTable = new javax.swing.JTable();
        JPanel jPanel2 = new JPanel();
        JButton specRef = new JButton();
        JLabel jLabel1 = new JLabel();
        radioCourse = new javax.swing.JRadioButton();
        JRadioButton radioTeacher = new JRadioButton();
        specField = new javax.swing.JTextField();
        JScrollPane jScrollPane2 = new JScrollPane();
        specTable = new javax.swing.JTable();
        JButton stdBack = new JButton();

        group.add(radioCourse);
        group.add(radioTeacher);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        allRef.setText("refresh");
        allRef.addActionListener(this::allRefActionPerformed);

        allTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null}
                },
                new String[]{
                        "Teacher name", "Course name", "Room", "Date", "Time"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(allTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(allRef)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(allRef)
                                .addContainerGap())
        );

        jTabbedPane1.addTab("View all tests", jPanel1);

        specRef.setText("search");
        specRef.addActionListener(this::specRefActionPerformed);

        jLabel1.setText("by :");

        radioCourse.setSelected(true);
        radioCourse.setText("Course name");
        radioCourse.setToolTipText("");

        radioTeacher.setText("Teacher Name");

        specTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null}
                },
                new String[]{
                        "Teacher name", "Course name", "Room", "Date", "Time"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane2.setViewportView(specTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(20, 20, 20)
                                                .addComponent(specRef)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(radioCourse)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(radioTeacher)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(specField, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane2)))
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                                .addGap(11, 11, 11)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(radioCourse)
                                                        .addComponent(radioTeacher)
                                                        .addComponent(jLabel1)
                                                        .addComponent(specField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(6, 6, 6))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(specRef)
                                                .addContainerGap())))
        );

        jTabbedPane1.addTab("View specific tests", jPanel2);

        stdBack.setText("Back");
        stdBack.addActionListener(this::stdBackActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jTabbedPane1)
                                .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(stdBack, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(191, 191, 191))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                                .addComponent(stdBack, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("View all tests");

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void stdBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stdBackActionPerformed
        MainFrame f = new MainFrame();
        f.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_stdBackActionPerformed

    private void specRefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_specRefActionPerformed
        if (specField.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Fill the blank!!","ERROR!!",JOptionPane.WARNING_MESSAGE);
            return;
        }
        Object[][] data;
        if (radioCourse.isSelected()) {
            data = XtraController.displayExamsCourse(specField.getText());
        } else {
            data = XtraController.displayExamsTeacher(specField.getText());
        }

        Object[] cols = new Object[5];
        cols[0] = "Teatcher name";
        cols[1] = "Course name";
        cols[2] = "Room";
        cols[3] = "Date";
        cols[4] = "Time";
        DefaultTableModel model = new DefaultTableModel(data, cols);
        specTable.setModel(model);
        specField.setText("");
        MainFrame.writeLog("Search for exam by " + specField.getText() + " in the database and the results has been retrived . Number of fetched rows = " + data.length);
    }//GEN-LAST:event_specRefActionPerformed

    private void allRefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allRefActionPerformed
        try {
            Object[][] data = XtraController.displayExams();
            Object[] cols = new Object[5];
            cols[0] = "Teatcher name";
            cols[1] = "Course name";
            cols[2] = "Room";
            cols[3] = "Date";
            cols[4] = "Time";
            DefaultTableModel model = new DefaultTableModel(data, cols);
            allTable.setModel(model);
            specField.setText("");
            MainFrame.writeLog("Refresh and all exams has been retrived from the data base . Number of fetched rows = " + data.length);
        } catch (InputMismatchException i) {
            JOptionPane.showMessageDialog(null, "Wrong input type !!", "Error!", JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_allRefActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* Set the Nimbus look and feel */
        /* <editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) "> */
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
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Something Went wrong","ERROR!!",JOptionPane.ERROR_MESSAGE);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new StdFrame().setVisible(true));
    }

    private javax.swing.JTable allTable;
    private javax.swing.JRadioButton radioCourse;
    private javax.swing.JTextField specField;
    private javax.swing.JTable specTable;
    // End of variables declaration//GEN-END:variables
}