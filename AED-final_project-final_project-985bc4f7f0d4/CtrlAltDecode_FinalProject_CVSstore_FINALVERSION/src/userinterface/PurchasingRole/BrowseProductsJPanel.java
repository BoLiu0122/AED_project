/*
 * BrowseProducts.java
 *
 * Created on October 10, 2008, 9:10 AM
 */
package userinterface.PurchasingRole;

import Business.Enterprise.CVSEnterprise;
import Business.Enterprise.SupplierEnterprise;
import Business.Order.Order;
import Business.Order.OrderItem;
import Business.Order.Product;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.PurchaseWorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Kaushik
 */
public class BrowseProductsJPanel extends javax.swing.JPanel {
    private JPanel upc;
    private SupplierEnterprise supplier;
    private UserAccount userAccount;
    private Order order;
    private CVSEnterprise enterprise;
    private boolean isCheckout = false;
    private double totalPrice;
    
    /** Creates new form BrowseProducts */
    public BrowseProductsJPanel(JPanel upc, SupplierEnterprise supplier, UserAccount userAccount, CVSEnterprise enterprise) {
        initComponents();
        this.upc = upc;
        this.supplier = supplier;
        this.userAccount = userAccount;
        this.enterprise = enterprise;
        
        populateTable();
        if(!isCheckout){
            totalPrice = 0;
            order = new Order();
        }
            
        refreshOrderTable();
        
    }
    
    public void populateTable()
    {
        DefaultTableModel model = (DefaultTableModel)productTable.getModel();
        model.setRowCount(0);
        
        for(Product p : supplier.getProductCatalog().getProductList()) {
            Object row[] = new Object[5];
            row[0] = p;
            row[1] = p.getModelNumber();
            row[2] = p.getPrice();
            row[3] = p.getAvail();
            row[4] = p.getProductType();
            model.addRow(row);
        }
    }
    
    
    public void refreshOrderTable()
    {
        DefaultTableModel model = (DefaultTableModel)orderTable.getModel();
        model.setRowCount(0);
        totalPrice = 0;
        for(OrderItem oi: order.getOrderItemList())
        {
            Object row[] = new Object[5];
            row[0] = oi;
            row[2] = oi.getQuantity();
            row[1] = oi.getProduct().getPrice();
            row[3] = oi.getQuantity()*oi.getProduct().getPrice();
            row[4] = oi.getProduct().getProductType();
            model.addRow(row);
            totalPrice += oi.getQuantity()*oi.getProduct().getPrice();
            
        }
        txtTotalPrice.setText(String.valueOf(totalPrice));
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        productTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        viewProdjButton2 = new javax.swing.JButton();
        addtoCartButton6 = new javax.swing.JButton();
        quantitySpinner = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtSalesPrice = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        orderTable = new javax.swing.JTable();
        btnRemoveOrderItem = new javax.swing.JButton();
        btnCheckOut = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtTotalPrice = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(750, 511));

        productTable.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        productTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Name", "Product Id", "Price", "Avail", "Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        productTable.setRowHeight(24);
        jScrollPane1.setViewportView(productTable);

        jLabel2.setFont(new java.awt.Font("Marker Felt", 1, 36)); // NOI18N
        jLabel2.setText("Supplier Product Catalog");

        btnBack.setBackground(new java.awt.Color(0, 153, 153));
        btnBack.setFont(new java.awt.Font("Lucida Grande", 3, 18)); // NOI18N
        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        viewProdjButton2.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        viewProdjButton2.setText("View Product Detail>>");
        viewProdjButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewProdjButton2ActionPerformed(evt);
            }
        });

        addtoCartButton6.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        addtoCartButton6.setText("Add To Cart");
        addtoCartButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addtoCartButton6ActionPerformed(evt);
            }
        });

        quantitySpinner.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        quantitySpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel5.setText("Quantity:");

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel6.setText("Sales Price :");

        txtSalesPrice.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Marker Felt", 1, 36)); // NOI18N
        jLabel7.setText("Cart  Items");

        orderTable.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        orderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Item Name", "Price", "Quantity", "Total Amount", "Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        orderTable.setRowHeight(24);
        jScrollPane2.setViewportView(orderTable);

        btnRemoveOrderItem.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        btnRemoveOrderItem.setText("Remove from Cart");
        btnRemoveOrderItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveOrderItemActionPerformed(evt);
            }
        });

        btnCheckOut.setBackground(new java.awt.Color(255, 102, 0));
        btnCheckOut.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        btnCheckOut.setText("Check out>>");
        btnCheckOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckOutActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel3.setText("$");

        txtTotalPrice.setEditable(false);
        txtTotalPrice.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel1.setText("Total Cost :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(12, 12, 12)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(25, 25, 25))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(quantitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addComponent(txtSalesPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(17, 17, 17)
                            .addComponent(addtoCartButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(12, 12, 12)
                            .addComponent(jScrollPane2))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(viewProdjButton2))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(472, 472, 472)
                            .addComponent(btnCheckOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(282, 282, 282)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(btnBack)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRemoveOrderItem, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2)
                .addGap(31, 31, 31)
                .addComponent(viewProdjButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSalesPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(addtoCartButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quantitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(46, 46, 46)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemoveOrderItem, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        if(!order.getOrderItemList().isEmpty()){
            for(OrderItem oi : order.getOrderItemList())
            {
                
                int oldAvail = oi.getProduct().getAvail();
                int newAvail = oldAvail + oi.getQuantity();
                oi.getProduct().setAvail(newAvail);
            }
        }
        upc.remove(this);
        CardLayout layout = (CardLayout) upc.getLayout();
        layout.previous(upc);
        
    }//GEN-LAST:event_btnBackActionPerformed

    private void viewProdjButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewProdjButton2ActionPerformed
        // TODO add your handling code here:
        int row = productTable.getSelectedRow();
        if(row<0){
            JOptionPane.showMessageDialog(null, "Pls select a row!!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        Product p = (Product)productTable.getValueAt(row, 0);
        ViewProductDetailJPanel vpdjp = new ViewProductDetailJPanel(upc, p);
        upc.add("ViewProductDetailJPanelCust", vpdjp);
        CardLayout layout = (CardLayout) upc.getLayout();
        layout.next(upc);
        
    }//GEN-LAST:event_viewProdjButton2ActionPerformed

    private void addtoCartButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addtoCartButton6ActionPerformed
        // TODO add your handling code here:
        int selectedRow = productTable.getSelectedRow();
        if(selectedRow<0){
            JOptionPane.showMessageDialog(null, "Pls select a row!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Product p = (Product)productTable.getValueAt(selectedRow, 0);
        int fetchQty = (Integer)quantitySpinner.getValue();
        if(fetchQty <= 0)
        {
            JOptionPane.showMessageDialog(null, "Quantity cannot be less than or equal to 0!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try{
            double salesPrice = Double.parseDouble(txtSalesPrice.getText());
            if(salesPrice <= p.getPrice())
            {
                JOptionPane.showMessageDialog(null, "Quantity cannot be less than or equal to 0!", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if(fetchQty <= p.getAvail())
            {
                boolean alreadyPresent = false;
                for(OrderItem oi : order.getOrderItemList())
                {
                    if(oi.getProduct() == p)
                    {
                        int oldAvail = p.getAvail();
                        int newAvail = oldAvail - fetchQty;
                        p.setAvail(newAvail);
                        oi.setQuantity(fetchQty + oi.getQuantity());
                        alreadyPresent = true;
                        populateTable();
                        refreshOrderTable();
                    }
                }
                if(!alreadyPresent)
                {
                    int oldAvail = p.getAvail();
                    int newAvail = oldAvail - fetchQty;
                    p.setAvail(newAvail);
                    order.addOrderItem(p, fetchQty, salesPrice);
                    populateTable();
                    refreshOrderTable();
                }
                
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Quantity is greater than availability", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "invalid price!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
       
    }//GEN-LAST:event_addtoCartButton6ActionPerformed

    private void btnCheckOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckOutActionPerformed
        // TODO add your handling code here:
        if(!order.getOrderItemList().isEmpty())
        {
            PurchaseWorkRequest request = new PurchaseWorkRequest();
            enterprise.getOrderDirectory().addOrder(order);
            order.setStatus("Placed");
            request.setOrder(order); 
            request.setSender(userAccount);
            //request.setStatus("Order placed");
            request.getOrder().setEnterprise(enterprise);
            request.setStatus("Pending");
            userAccount.getSendWorkQueue().getWorkRequestList().add(request);
            supplier.getPurchasingWorkQueue().getWorkRequestList().add(request);
            
            JOptionPane.showMessageDialog(null, "Order placed successfully!");
            order = new Order();
            populateTable();
            refreshOrderTable();
            isCheckout = true;
        }
        else
        {
            JOptionPane.showMessageDialog(null, "No order placed!", "Warning", JOptionPane.WARNING_MESSAGE);
            
        }
       
    }//GEN-LAST:event_btnCheckOutActionPerformed

    private void btnRemoveOrderItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveOrderItemActionPerformed
        int row = orderTable.getSelectedRow();
        if(row<0){
            JOptionPane.showMessageDialog(null, "Pls select a row!!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        OrderItem p = (OrderItem)orderTable.getValueAt(row, 0);
        int oldAvail = p.getProduct().getAvail();
        int oldQty = p.getQuantity();
        int newQty = oldAvail + oldQty;
        p.getProduct().setAvail(newQty);
        order.removeOrderItem(p);
        JOptionPane.showMessageDialog(null, "Order item removed from cart!");
        
        populateTable();
        refreshOrderTable();   
        
    }//GEN-LAST:event_btnRemoveOrderItemActionPerformed

                                           

//    private void btnRemoveOrderItemActionPerformed(java.awt.event.ActionEvent evt) {                                                   
//        int row = productTable.getSelectedRow();
//        if(row<0){
//            JOptionPane.showMessageDialog(null, "Pls select a row!!", "Warning", JOptionPane.WARNING_MESSAGE);
//        }
//        OrderItem p = (OrderItem)orderTable.getValueAt(row, 0);
//        int oldAvail = p.getProduct().getAvail();
//        int oldQty = p.getQuantity();
//        int newQty = oldAvail + oldQty;
//        p.getProduct().setAvail(newQty);
//        order.removeOrderItem(p);
//        JOptionPane.showMessageDialog(null, "Order item removed from cart!");
//        
//        populateTable();
//        refreshOrderTable();   
//        
//    }                                                  

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addtoCartButton6;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCheckOut;
    private javax.swing.JButton btnRemoveOrderItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable orderTable;
    private javax.swing.JTable productTable;
    private javax.swing.JSpinner quantitySpinner;
    private javax.swing.JTextField txtSalesPrice;
    private javax.swing.JTextField txtTotalPrice;
    private javax.swing.JButton viewProdjButton2;
    // End of variables declaration//GEN-END:variables
}
