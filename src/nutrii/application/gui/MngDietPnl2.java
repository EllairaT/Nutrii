/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nutrii.application.gui;

/**
 *
 * @author Blakey
 */
public class MngDietPnl2 extends javax.swing.JPanel {

/**
 * Creates new form MngDietPnl2
 */
public MngDietPnl2() {
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

        MDP2ViewDaysTitleLbl = new javax.swing.JLabel();
        MDP2 = new javax.swing.JPanel();
        MDP2SelectDayLbl = new javax.swing.JLabel();
        MDP2DayLbl = new javax.swing.JLabel();
        MDP2DayTxtField = new javax.swing.JTextField();
        MDP2MonthLbl = new javax.swing.JLabel();
        MDP2MonthTxtField = new javax.swing.JTextField();
        MDP2YearLbl = new javax.swing.JLabel();
        MDP2YearTxtField = new javax.swing.JTextField();
        MDP2EnterDateBtn = new javax.swing.JButton();
        MDP2ListOfConsumedLbl = new javax.swing.JLabel();
        MDP2Output = new javax.swing.JPanel();

        MDP2ViewDaysTitleLbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        MDP2ViewDaysTitleLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MDP2ViewDaysTitleLbl.setText("View Days");

        MDP2.setBackground(new java.awt.Color(102, 102, 102));

        MDP2SelectDayLbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        MDP2SelectDayLbl.setText("Select Day:");

        MDP2DayLbl.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        MDP2DayLbl.setForeground(new java.awt.Color(204, 204, 204));
        MDP2DayLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MDP2DayLbl.setText("DD");

        MDP2DayTxtField.setText("01");
        MDP2DayTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MDP2DayTxtFieldActionPerformed(evt);
            }
        });

        MDP2MonthLbl.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        MDP2MonthLbl.setForeground(new java.awt.Color(204, 204, 204));
        MDP2MonthLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MDP2MonthLbl.setText("MM");

        MDP2MonthTxtField.setText("01");
        MDP2MonthTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MDP2MonthTxtFieldActionPerformed(evt);
            }
        });

        MDP2YearLbl.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        MDP2YearLbl.setForeground(new java.awt.Color(204, 204, 204));
        MDP2YearLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MDP2YearLbl.setText("YYYY");

        MDP2YearTxtField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        MDP2YearTxtField.setText("2020");
        MDP2YearTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MDP2YearTxtFieldActionPerformed(evt);
            }
        });

        MDP2EnterDateBtn.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        MDP2EnterDateBtn.setText("Enter Date");

        MDP2ListOfConsumedLbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        MDP2ListOfConsumedLbl.setText("List of Consumed");

        javax.swing.GroupLayout MDP2OutputLayout = new javax.swing.GroupLayout(MDP2Output);
        MDP2Output.setLayout(MDP2OutputLayout);
        MDP2OutputLayout.setHorizontalGroup(
            MDP2OutputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        MDP2OutputLayout.setVerticalGroup(
            MDP2OutputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout MDP2Layout = new javax.swing.GroupLayout(MDP2);
        MDP2.setLayout(MDP2Layout);
        MDP2Layout.setHorizontalGroup(
            MDP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MDP2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MDP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(MDP2Output, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MDP2SelectDayLbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, MDP2Layout.createSequentialGroup()
                        .addGroup(MDP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(MDP2EnterDateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(MDP2Layout.createSequentialGroup()
                                .addGroup(MDP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(MDP2DayTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(MDP2DayLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(MDP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(MDP2Layout.createSequentialGroup()
                                        .addComponent(MDP2MonthTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(MDP2YearTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                                    .addGroup(MDP2Layout.createSequentialGroup()
                                        .addComponent(MDP2MonthLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(MDP2YearLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 459, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(MDP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(MDP2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(MDP2ListOfConsumedLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        MDP2Layout.setVerticalGroup(
            MDP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MDP2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MDP2SelectDayLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MDP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MDP2DayLbl)
                    .addComponent(MDP2MonthLbl)
                    .addComponent(MDP2YearLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MDP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MDP2DayTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MDP2MonthTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MDP2YearTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(MDP2EnterDateBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(MDP2Output, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
            .addGroup(MDP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(MDP2Layout.createSequentialGroup()
                    .addGap(141, 141, 141)
                    .addComponent(MDP2ListOfConsumedLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(425, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(MDP2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MDP2ViewDaysTitleLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MDP2ViewDaysTitleLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(MDP2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void MDP2DayTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MDP2DayTxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MDP2DayTxtFieldActionPerformed

    private void MDP2MonthTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MDP2MonthTxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MDP2MonthTxtFieldActionPerformed

    private void MDP2YearTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MDP2YearTxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MDP2YearTxtFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MDP2;
    private javax.swing.JLabel MDP2DayLbl;
    private javax.swing.JTextField MDP2DayTxtField;
    private javax.swing.JButton MDP2EnterDateBtn;
    private javax.swing.JLabel MDP2ListOfConsumedLbl;
    private javax.swing.JLabel MDP2MonthLbl;
    private javax.swing.JTextField MDP2MonthTxtField;
    private javax.swing.JPanel MDP2Output;
    private javax.swing.JLabel MDP2SelectDayLbl;
    private javax.swing.JLabel MDP2ViewDaysTitleLbl;
    private javax.swing.JLabel MDP2YearLbl;
    private javax.swing.JTextField MDP2YearTxtField;
    // End of variables declaration//GEN-END:variables
}