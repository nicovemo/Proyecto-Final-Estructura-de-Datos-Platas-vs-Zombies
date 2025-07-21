/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyectoed;


import javax.swing.*;
/**
 *
 * @author cheve
 */
public class frmUsuario extends javax.swing.JFrame {
 
    private String nom = "";
    
    public frmUsuario() {
        
        initComponents();
        llenarComboUsuarios();

}
    
    private void llenarComboUsuarios() {
        comUsuario.removeAllItems();
        for (int i = 0; i < CompartirUsuario.listaUsuarios.getCantidad(); i++) {
            String nombre = CompartirUsuario.listaUsuarios.get(i);
            if (nombre != null) {
                comUsuario.addItem(nombre);
            }
        }

}

    public void iniciar() {
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    public JComboBox<String> getComUsuario() {
        return comUsuario;
    }

    public String getNom() {
        return nom;
    }
    
 


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        btnCrearUsuario = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        comUsuario = new javax.swing.JComboBox<>();
        btnIngresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLayeredPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCrearUsuario.setBackground(new java.awt.Color(51, 51, 51));
        btnCrearUsuario.setFont(new java.awt.Font("Sigmar One", 0, 18)); // NOI18N
        btnCrearUsuario.setForeground(new java.awt.Color(255, 255, 255));
        btnCrearUsuario.setText("Create user");
        btnCrearUsuario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCrearUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearUsuarioActionPerformed(evt);
            }
        });
        jLayeredPane1.add(btnCrearUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 510, 210, 50));

        btnSalir.setBackground(new java.awt.Color(51, 51, 51));
        btnSalir.setFont(new java.awt.Font("Sigmar One", 0, 18)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("Exit");
        btnSalir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jLayeredPane1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 580, 210, 50));

        comUsuario.setBackground(new java.awt.Color(51, 51, 51));
        comUsuario.setFont(new java.awt.Font("Sigmar One", 0, 18)); // NOI18N
        comUsuario.setForeground(new java.awt.Color(255, 255, 255));
        comUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select an user", "Nicole", "Jerson" }));
        comUsuario.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 2, true));
        comUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comUsuarioActionPerformed(evt);
            }
        });
        jLayeredPane1.add(comUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 370, 250, 40));

        btnIngresar.setBackground(new java.awt.Color(51, 51, 51));
        btnIngresar.setFont(new java.awt.Font("Sigmar One", 0, 18)); // NOI18N
        btnIngresar.setForeground(new java.awt.Color(255, 255, 255));
        btnIngresar.setText("Start");
        btnIngresar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        jLayeredPane1.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 440, 210, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectoed/img/Pick-an-User-7-1-2025 (3).png"))); // NOI18N
        jLayeredPane1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectoed/img/Lapida.png"))); // NOI18N
        jLayeredPane1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 440, 550));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectoed/img/Fondo1.png"))); // NOI18N
        jLayeredPane1.add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 780));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);        
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
         String usuarioSeleccionado = (String) comUsuario.getSelectedItem();
    if (usuarioSeleccionado != null && !usuarioSeleccionado.equals("")) {
        frmMenu menu = new frmMenu(usuarioSeleccionado);
        menu.setVisible(true);
        this.dispose(); // Cierra la ventana actual
    } else {
       
    }
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void comUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comUsuarioActionPerformed
      
            
    }//GEN-LAST:event_comUsuarioActionPerformed

    private void btnCrearUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearUsuarioActionPerformed
        frmRegistroUsuario registro = new frmRegistroUsuario();
        registro.setLocationRelativeTo(null);
        registro.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCrearUsuarioActionPerformed

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
            java.util.logging.Logger.getLogger(frmUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    private javax.swing.JButton btnCrearUsuario;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> comUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLayeredPane jLayeredPane1;
    // End of variables declaration//GEN-END:variables
}
