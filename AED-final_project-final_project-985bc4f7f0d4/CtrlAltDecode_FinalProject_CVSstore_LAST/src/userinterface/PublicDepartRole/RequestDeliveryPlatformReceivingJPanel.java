/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.PublicDepartRole;

import Business.Enterprise.Enterprise;
import Business.Enterprise.EnterpriseDirectory;
import Business.Enterprise.DeliveryPlatformEnterprise;
import Business.Enterprise.SupplierEnterprise;
import Business.Order.Order;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.ReceiveWorkRequest;
import Business.WorkQueue.PublicDepartWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
/**
 *
 * @author raunak
 */
public class RequestDeliveryPlatformReceivingJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private SupplierEnterprise enterprise;
    private UserAccount userAccount;
    private EnterpriseDirectory enterpriseDirectory;
    /**
     * Creates new form ProcessWorkRequestJPanel
     */
    public RequestDeliveryPlatformReceivingJPanel(JPanel userProcessContainer, UserAccount account, SupplierEnterprise enterprise, EnterpriseDirectory enterpriseDirectory) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.userAccount = account;
        this.enterpriseDirectory = enterpriseDirectory;
        valueLabel.setText(enterprise.getName());
        
        populateOrderCombo();
        populateSupplierCombo();
        
        String path = "src/images/supplier.jpeg";
        ImageIcon icon = new ImageIcon(path);
        icon.setImage(icon.getImage().getScaledInstance(145,155,Image.SCALE_DEFAULT));
        picLabel.setIcon(icon);
    }
    
    public void populateOrderCombo(){
        orderComboBox.removeAllItems();
        
        for(WorkRequest workRequest : userAccount.getReceiveWorkQueue().getWorkRequestList()) {
            if(((PublicDepartWorkRequest)workRequest).getPublicDepartResult().equals("Prepare"))
            {
                orderComboBox.addItem(workRequest);
            }
        }
    }

    public void populateSupplierCombo()
    {
        shippingComboBox.removeAllItems();
        
        for(Enterprise e: enterpriseDirectory.getEnterpriseList())
        {
            if(e instanceof DeliveryPlatformEnterprise){
                shippingComboBox.addItem(e);
            }
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

        submitJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        backJButton = new javax.swing.JButton();
        orderComboBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        shippingComboBox = new javax.swing.JComboBox();
        enterpriseLabel = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();
        picLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        submitJButton.setBackground(new java.awt.Color(0, 153, 153));
        submitJButton.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        submitJButton.setText("Request Order");
        submitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitJButtonActionPerformed(evt);
            }
        });
        add(submitJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 330, -1, 46));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("My Order :");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 272, 237, -1));

        backJButton.setBackground(new java.awt.Color(0, 153, 153));
        backJButton.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 400, -1, 46));

        orderComboBox.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        orderComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(orderComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(401, 271, 225, -1));

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Destination Enterprise :");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 227, -1, -1));

        shippingComboBox.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        shippingComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(shippingComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(401, 226, 225, -1));

        enterpriseLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        enterpriseLabel.setText("Enterprise");
        add(enterpriseLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 53, -1, -1));

        valueLabel.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        valueLabel.setForeground(new java.awt.Color(153, 0, 51));
        valueLabel.setText("<value>");
        add(valueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 52, -1, -1));
        add(picLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        jLabel3.setFont(new java.awt.Font("Marker Felt", 1, 36)); // NOI18N
        jLabel3.setText("Request  Delivery  Platform  Enterprise");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        PublicDepartWorkAreaJPanel dwjp = (PublicDepartWorkAreaJPanel) component;
        dwjp.populateTable();
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void submitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitJButtonActionPerformed
        Order order = ((WorkRequest)orderComboBox.getSelectedItem()).getOrder();
        ((PublicDepartWorkRequest)orderComboBox.getSelectedItem()).setPublicDepartResult("Sent");
        
        DeliveryPlatformEnterprise shipping = (DeliveryPlatformEnterprise)shippingComboBox.getSelectedItem();
        
        ReceiveWorkRequest request = new ReceiveWorkRequest();
        request.setOrder(order);
        request.setSender(userAccount);
        request.setStatus("Pending");
        userAccount.getSendWorkQueue().getWorkRequestList().add(request);
        shipping.getReceivingWorkQueue().getWorkRequestList().add(request);
        order.setStatus("Packing up");
        populateOrderCombo();
        
    }//GEN-LAST:event_submitJButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JComboBox orderComboBox;
    private javax.swing.JLabel picLabel;
    private javax.swing.JComboBox shippingComboBox;
    private javax.swing.JButton submitJButton;
    private javax.swing.JLabel valueLabel;
    // End of variables declaration//GEN-END:variables
}
