/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyectoed;

import javax.swing.*;

/**
 *
 * @author PC-JPS01
 */
public class frmMenu extends javax.swing.JFrame {
    
    private String usuarioActual;

    /**
     * Creates new form Menu
     */
    public frmMenu(String usuario) {
        this.usuarioActual = usuario;
        initComponents();
         setLocationRelativeTo(null);
        txtnomUsuario.setText("Bienvenido, " + usuarioActual);
    }
  
    public void iniciar() {
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    public JTextField getTxtnomUsuario() {
        return txtnomUsuario;
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        txtnomUsuario = new javax.swing.JTextField();
        btnChangeUser = new javax.swing.JButton();
        jbQuit = new javax.swing.JButton();
        jbAdventure = new javax.swing.JButton();
        jbOptions = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jLayeredPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtnomUsuario.setEditable(false);
        txtnomUsuario.setBackground(new java.awt.Color(82, 69, 50));
        txtnomUsuario.setFont(new java.awt.Font("Russo One", 1, 16)); // NOI18N
        txtnomUsuario.setForeground(new java.awt.Color(255, 255, 255));
        txtnomUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtnomUsuario.setActionCommand("<Not Set>");
        txtnomUsuario.setBorder(null);
        txtnomUsuario.setFocusable(false);
        txtnomUsuario.setOpaque(true);
        txtnomUsuario.setRequestFocusEnabled(false);
        txtnomUsuario.setSelectionColor(new java.awt.Color(102, 51, 0));
        txtnomUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnomUsuarioActionPerformed(evt);
            }
        });
        jLayeredPane1.add(txtnomUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 107, 290, 20));

        btnChangeUser.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        btnChangeUser.setForeground(new java.awt.Color(255, 255, 255));
        btnChangeUser.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnChangeUser.setBorderPainted(false);
        btnChangeUser.setContentAreaFilled(false);
        btnChangeUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeUserActionPerformed(evt);
            }
        });
        jLayeredPane1.add(btnChangeUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 320, 40));

        jbQuit.setBorder(null);
        jbQuit.setContentAreaFilled(false);
        jbQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbQuitActionPerformed(evt);
            }
        });
        jLayeredPane1.add(jbQuit, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 660, 80, 50));

        jbAdventure.setBorderPainted(false);
        jbAdventure.setContentAreaFilled(false);
        jbAdventure.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAdventureActionPerformed(evt);
            }
        });
        jLayeredPane1.add(jbAdventure, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 110, 410, 110));

        jbOptions.setBorder(null);
        jbOptions.setContentAreaFilled(false);
        jLayeredPane1.add(jbOptions, new org.netbeans.lib.awtextra.AbsoluteConstraints(712, 630, 100, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectoed/img/Menu.png"))); // NOI18N
        jLayeredPane1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbAdventureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAdventureActionPerformed
        frmJuego m = new frmJuego();
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbAdventureActionPerformed

    private void btnChangeUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeUserActionPerformed
        frmUsuario u = new frmUsuario();
        u.iniciar();
        this.dispose();

    }//GEN-LAST:event_btnChangeUserActionPerformed

    private void txtnomUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnomUsuarioActionPerformed

    }//GEN-LAST:event_txtnomUsuarioActionPerformed

    private void jbQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbQuitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jbQuitActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                String usuario = null;
                new frmMenu(usuario).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChangeUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JButton jbAdventure;
    private javax.swing.JButton jbOptions;
    private javax.swing.JButton jbQuit;
    private javax.swing.JTextField txtnomUsuario;
    // End of variables declaration//GEN-END:variables
}
