/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.CustomerRole;

import Business.Order.Order;
import java.awt.CardLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Tianyu
 */
public class ViewOrderJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewOrderJPanel
     */
    private Order order;
    private JPanel upc;
    
    public ViewOrderJPanel(Order order, JPanel upc) {
        initComponents();
        this.order = order;
        this.upc = upc;
        
        populatePurchaseBar();
        populateReturnBar();
        
        String path = "src/images/shipping.jpeg";
        ImageIcon icon = new ImageIcon(path);
        icon.setImage(icon.getImage().getScaledInstance(155,155,Image.SCALE_DEFAULT));
        picLabel.setIcon(icon);
    }
    
    public void populatePurchaseBar(){
        if(order.getStatus().equals("Placed")){
            populateBar.setValue(20);
        }
        else if(order.getStatus().equals("Grocery Store Confirmed")){
            populateBar.setValue(40);
        }
        else if(order.getStatus().equals("Collected the package")){
            populateBar.setValue(60);
        }
        else if(order.getStatus().equals("Package is on the way!")){
            populateBar.setValue(80);
        }
        else if(order.getStatus().equals("Package Shipped")){
            populateBar.setValue(100);
        }
        else{
            populateBar.setValue(100);
        }
    }
    
    public void populateReturnBar(){
        if(order.getStatus().equals("Returning")){
            returnBar.setValue(50);
        }
        else if(order.getStatus().equals("Returned")){
            returnBar.setValue(100);
        }
        else{
            returnBar.setValue(0);
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

        populateBar = new javax.swing.JProgressBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        returnBar = new javax.swing.JProgressBar();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        picLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        populateBar.setBackground(new java.awt.Color(255, 255, 255));
        populateBar.setFont(new java.awt.Font("Marker Felt", 1, 24)); // NOI18N
        populateBar.setStringPainted(true);
        add(populateBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 53, 663, 53));

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("Placed------------------------------20%\nGrocery Store Confirmed---------------40%\nCollected the package-----------------60%\nPackage is on the way-----------------80%\nPackage Shipped---------------------100%");
        jScrollPane1.setViewportView(jTextArea1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 132, 448, 131));

        returnBar.setBackground(new java.awt.Color(204, 204, 204));
        returnBar.setFont(new java.awt.Font("Marker Felt", 1, 24)); // NOI18N
        returnBar.setStringPainted(true);
        add(returnBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 320, 663, 52));

        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jTextArea2.setRows(5);
        jTextArea2.setText("Returning------------------------------50%\nReturned------------------------------100%");
        jScrollPane2.setViewportView(jTextArea2);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 400, 480, -1));

        jButton1.setBackground(new java.awt.Color(0, 153, 153));
        jButton1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jButton1.setText("<< Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 520, -1, 53));
        add(picLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        upc.remove(this);
        CardLayout layout = (CardLayout) upc.getLayout();
        layout.previous(upc);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JLabel picLabel;
    private javax.swing.JProgressBar populateBar;
    private javax.swing.JProgressBar returnBar;
    // End of variables declaration//GEN-END:variables
}
