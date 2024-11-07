/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.learning.arbolesdebusqueda;

import com.learning.arbolesdebusqueda.Arboles.*;
import com.learning.arbolesdebusqueda.Arboles.Excepciones.ExcepcionOrdenInvalido;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Santiago
 */
public class Interfaz extends javax.swing.JFrame {

    private IArbolBusqueda<Integer,String> arbolBusqueda;
    private IArbolBusqueda<Integer,String> arbolCompra;
    private IArbolBusqueda<Integer,Integer> arbolDataBase;

    /**
     * Creates new form Interfaz
     */
    public Interfaz() {
        initComponents();
        this.CodeLabel.setVisible(false);
        this.NameLabel.setVisible(false);
        this.CodeText.setVisible(false);
        this.NameText.setVisible(false);
        this.ExecuteButton.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CodeText = new javax.swing.JTextField();
        NameText = new javax.swing.JTextField();
        ExecuteButton = new javax.swing.JToggleButton();
        CodeLabel = new javax.swing.JLabel();
        NameLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ShopArea = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        TreeArea = new javax.swing.JTextArea();
        MenuArbol = new javax.swing.JMenuBar();
        TreeTypeMenu = new javax.swing.JMenu();
        ABBCheckBox = new javax.swing.JCheckBoxMenuItem();
        AVLCheckBox = new javax.swing.JCheckBoxMenuItem();
        AMVCheckBox = new javax.swing.JCheckBoxMenuItem();
        ABCheckBox = new javax.swing.JCheckBoxMenuItem();
        OperationMenu = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        EliminarButton = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        CodeText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CodeTextActionPerformed(evt);
            }
        });

        ExecuteButton.setText("Ejecutar");
        ExecuteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExecuteButtonActionPerformed(evt);
            }
        });

        CodeLabel.setText("<Defualt Text>");

        NameLabel.setText("<Default Text>");

        ShopArea.setColumns(20);
        ShopArea.setRows(5);
        jScrollPane2.setViewportView(ShopArea);

        TreeArea.setColumns(20);
        TreeArea.setRows(5);
        jScrollPane1.setViewportView(TreeArea);

        TreeTypeMenu.setText("TipoDeArbol");

        ABBCheckBox.setSelected(true);
        ABBCheckBox.setText("ABB");
        ABBCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ABBCheckBoxActionPerformed(evt);
            }
        });
        TreeTypeMenu.add(ABBCheckBox);

        AVLCheckBox.setText("AVL");
        AVLCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AVLCheckBoxActionPerformed(evt);
            }
        });
        TreeTypeMenu.add(AVLCheckBox);

        AMVCheckBox.setText("AMV");
        AMVCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AMVCheckBoxActionPerformed(evt);
            }
        });
        TreeTypeMenu.add(AMVCheckBox);

        ABCheckBox.setText("AB");
        ABCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ABCheckBoxActionPerformed(evt);
            }
        });
        TreeTypeMenu.add(ABCheckBox);

        MenuArbol.add(TreeTypeMenu);

        OperationMenu.setText("Operacion");

        jMenuItem1.setText("Insertar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertarButton(evt);
            }
        });
        OperationMenu.add(jMenuItem1);

        EliminarButton.setText("Eliminar");
        EliminarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarButtonActionPerformed(evt);
            }
        });
        OperationMenu.add(EliminarButton);

        MenuArbol.add(OperationMenu);

        setJMenuBar(MenuArbol);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(239, 239, 239)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(NameLabel)
                    .addComponent(CodeLabel))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NameText, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CodeText, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(ExecuteButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 703, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CodeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ExecuteButton)
                    .addComponent(CodeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NameLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(219, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void AMVCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AMVCheckBoxActionPerformed
        // TODO add your handling code here:
        boolean state=this.AMVCheckBox.getState();
        if(!state){
            
            this.AVLCheckBox.setState(false);
            this.ABBCheckBox.setState(true);
            this.ABCheckBox.setState(false);
        }else{
            this.ABCheckBox.setState(false);
            this.ABBCheckBox.setState(false);
            this.AVLCheckBox.setState(false);
            try {
                arbolBusqueda=new AMV<>(4);
            } catch (ExcepcionOrdenInvalido ex) {
                Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                arbolCompra=new AMV<>(4);
            } catch (ExcepcionOrdenInvalido ex) {
                Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                arbolDataBase=new AMV<>(4);
            } catch (ExcepcionOrdenInvalido ex) {
                Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
            }
            setArbol();
            ShopArea.setText("");
            TreeArea.setText(arbolBusqueda.toString());
            System.out.println(arbolBusqueda.toString());
        }
    }//GEN-LAST:event_AMVCheckBoxActionPerformed

    private void AVLCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AVLCheckBoxActionPerformed
        // TODO add your handling code here:
        boolean state=this.AVLCheckBox.getState();
        if(!state){
            
            this.ABBCheckBox.setState(true);
            this.AMVCheckBox.setState(false);
            this.ABCheckBox.setState(false);
        }else{
            this.ABCheckBox.setState(false);
            this.ABBCheckBox.setState(false);
            this.AMVCheckBox.setState(false);
            arbolBusqueda=new AVL<>();
            arbolCompra=new AVL<>();
            arbolDataBase=new AVL<>();
            setArbol();
            ShopArea.setText("");
            TreeArea.setText(arbolBusqueda.toString());
            System.out.println(arbolBusqueda.toString());
        }
    }//GEN-LAST:event_AVLCheckBoxActionPerformed

    private void ABCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ABCheckBoxActionPerformed
        // TODO add your handling code here:
        boolean state=this.ABCheckBox.getState();
        if(!state){
            this.AVLCheckBox.setState(false);
            this.AMVCheckBox.setState(true);
            this.ABBCheckBox.setState(false);
            
        }else{
            this.AVLCheckBox.setState(false);
            this.ABBCheckBox.setState(false);
            this.AMVCheckBox.setState(false);
            arbolBusqueda=new AB<>(4);
            arbolCompra=new AB<>(4);
            arbolDataBase=new AB<>(4);
            setArbol();
            ShopArea.setText("");
            TreeArea.setText(arbolBusqueda.toString());
            System.out.println(arbolBusqueda.toString());
        }
    }//GEN-LAST:event_ABCheckBoxActionPerformed

    private void ABBCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ABBCheckBoxActionPerformed
        boolean state=this.ABBCheckBox.getState();
        if(!state){
            this.AMVCheckBox.setState(true);
            this.AVLCheckBox.setState(false);
            this.ABCheckBox.setState(false);
        }else{
            this.AMVCheckBox.setState(false);
            this.AVLCheckBox.setState(false);
            this.ABCheckBox.setState(false);
        }
    }//GEN-LAST:event_ABBCheckBoxActionPerformed

    private void InsertarButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertarButton
        // TODO add your handling code here:
        this.CodeLabel.setText("Codigo A Insertar");
        this.CodeLabel.setVisible(true);
        this.NameLabel.setText("Producto A Insertar");
        this.NameLabel.setVisible(true);
    }//GEN-LAST:event_InsertarButton

    private void CodeTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CodeTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CodeTextActionPerformed

    private void ExecuteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExecuteButtonActionPerformed
        // TODO add your handling code here:
        if(this.CodeLabel.getText()=="Codigo A Insertar"){
            int prod= Integer.parseInt(codigoProd.getText());
                String nombre=arbolBusqueda.buscar(prod);
                if(arbolCompra.buscar(prod)==null) {
                    arbolCompra.insertar(prod, nombre);
                    arbolDataBase.insertar(prod,1);
                }else {
                    int cantidad=arbolDataBase.buscar(prod);
                    arbolDataBase.insertar(prod,cantidad+1);
                }
                String deploy=listaDeCompra();
                ShopArea.setText(deploy);
        }else if(this.CodeLabel.getText()=="Codigo A Eliminar"){
            int prod= Integer.parseInt(codigoProd.getText());
                arbolCompra.eliminar(prod);
                arbolDataBase.eliminar(prod);
                String deploy=listaDeCompra();
            this.ShopArea.setText(deploy);
        }
                
    }//GEN-LAST:event_ExecuteButtonActionPerformed

    private void EliminarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarButtonActionPerformed
        // TODO add your handling code here:
        this.CodeLabel.setText("Codigo A Eliminar");
        this.CodeLabel.setVisible(true);
    }//GEN-LAST:event_EliminarButtonActionPerformed

    public String listaDeCompra(){
        List<Integer> compras=arbolCompra.recorridoEnInOrden();
        String lista="";
        for(int i=0;i<compras.size();i++){
            lista+=compras.get(i)+"("+arbolDataBase.buscar(compras.get(i))+")"+arbolCompra.buscar(compras.get(i))+"\n";
        }
        return lista;
    }
    
    public void setArbol(){
        arbolBusqueda.insertar(313,"Coca Cola 2Lts");
        arbolBusqueda.insertar(314,"Coca Cola 3Lts");
        arbolBusqueda.insertar(321,"Mendocina Manzana 2Lts");
        arbolBusqueda.insertar(322,"Mendocina Naranja 2Lts");
        arbolBusqueda.insertar(304,"Leche Blanca Deslactosada 1 Lts");
        arbolBusqueda.insertar(300,"Leche Blanca 1Lts");
        arbolBusqueda.insertar(301,"Leche Blanca Deslactosada 1 Lts");
        arbolBusqueda.insertar(302,"Leche Chocolatada 1 Lts");
        arbolBusqueda.insertar(303,"Leche Chocolatada Deslactosada 1 Lts");
        arbolBusqueda.insertar(305,"Yogurt Botella 2Lts");
        arbolBusqueda.insertar(306,"Yogurt Coco 1Lts");
        arbolBusqueda.insertar(307,"Yogurt Coco Botella 2Lts");
        arbolBusqueda.insertar(308,"Yogurt Frutilla 1Lts");
        arbolBusqueda.insertar(309,"Yogurt Frutilla Botella 2Lts");
        arbolBusqueda.insertar(310,"Pilfrut Manzana 1Lts");

        arbolBusqueda.insertar(318,"Pepsi 3Lts");
        arbolBusqueda.insertar(319,"Pepsi Black 2Lts");
        arbolBusqueda.insertar(320,"Pepsi Black 3Lts");
        arbolBusqueda.insertar(323,"Mendocina Mandarina 2Lts");

        arbolBusqueda.insertar(400,"Mantequilla");
        arbolBusqueda.insertar(401,"Margarina");
        arbolBusqueda.insertar(402,"Queso 1Kg");
        arbolBusqueda.insertar(311,"Pilfrut Durazno 1Lts");
        arbolBusqueda.insertar(312,"Pilfrut Piña 1Lts");

        arbolBusqueda.insertar(315,"Coca Cola Zero 2Lts");
        arbolBusqueda.insertar(316,"Coca Cola Zero 3Lts");
        arbolBusqueda.insertar(317,"Pepsi 2Lts");
        arbolBusqueda.insertar(403,"Queso 2Kg");
        arbolBusqueda.insertar(324,"Mendocina Piña 2Lts");
        arbolBusqueda.insertar(325,"Maltin");
        arbolBusqueda.insertar(326,"Malta");
        arbolBusqueda.insertar(327,"Maltita");
        arbolBusqueda.insertar(328,"Powerade Red 1Lts");

        arbolBusqueda.insertar(404,"Salchicha Viena");
    }

    
    
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
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Interfaz().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBoxMenuItem ABBCheckBox;
    private javax.swing.JCheckBoxMenuItem ABCheckBox;
    private javax.swing.JCheckBoxMenuItem AMVCheckBox;
    private javax.swing.JCheckBoxMenuItem AVLCheckBox;
    private javax.swing.JLabel CodeLabel;
    private javax.swing.JTextField CodeText;
    private javax.swing.JMenuItem EliminarButton;
    private javax.swing.JToggleButton ExecuteButton;
    private javax.swing.JMenuBar MenuArbol;
    private javax.swing.JLabel NameLabel;
    private javax.swing.JTextField NameText;
    private javax.swing.JMenu OperationMenu;
    private javax.swing.JTextArea ShopArea;
    private javax.swing.JTextArea TreeArea;
    private javax.swing.JMenu TreeTypeMenu;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}