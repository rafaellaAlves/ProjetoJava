/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoRosanTransports.view;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import projetoRosanTransports.model.administradorModel;
import projetoRosanTransports.model.empresaModel;
import projetoRosanTransports.model.motoristaModel;

/**
 *
 * @author Rafaella Alves Silva
 */
public class JFPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form JFPrincipal
     */
    administradorModel obj2;
    motoristaModel obj;
    empresaModel obj3;
    
    public void travaBotao(boolean n){
        jbAdm.setEnabled(n);
        jbCaminhoes.setEnabled(n);
        jbEmpresas.setEnabled(n);
        jbGerarRelat.setEnabled(n);
        jbMotoristas.setEnabled(n);
    }
    
    
    public JFPrincipal() {
        initComponents();
        
        this.getContentPane().setBackground(new Color(153,153,153));
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/projetoRosanTransports/imagens/caminhao3.jpg")));
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jbMotoristas = new javax.swing.JButton();
        jbEmpresas = new javax.swing.JButton();
        jbCaminhoes = new javax.swing.JButton();
        jbPedidos = new javax.swing.JButton();
        jbGerarRelat = new javax.swing.JButton();
        jbDiesel = new javax.swing.JButton();
        jbAdm = new javax.swing.JButton();
        jbCalcula = new javax.swing.JButton();
        jbLogout = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jlUser = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("R SILVA TRANSPORTES");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetoRosanTransports/imagens/Logo - Copia.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jbMotoristas.setFont(new java.awt.Font("Cinzel Black", 0, 12)); // NOI18N
        jbMotoristas.setText("Motoristas");
        jbMotoristas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jbMotoristas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbMotoristasMouseClicked(evt);
            }
        });
        jbMotoristas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMotoristasActionPerformed(evt);
            }
        });

        jbEmpresas.setFont(new java.awt.Font("Cinzel Black", 0, 12)); // NOI18N
        jbEmpresas.setText("Empresas");
        jbEmpresas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jbEmpresas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEmpresasActionPerformed(evt);
            }
        });

        jbCaminhoes.setFont(new java.awt.Font("Cinzel Black", 0, 12)); // NOI18N
        jbCaminhoes.setText("Caminhões");
        jbCaminhoes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jbCaminhoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCaminhoesActionPerformed(evt);
            }
        });

        jbPedidos.setFont(new java.awt.Font("Cinzel Black", 0, 12)); // NOI18N
        jbPedidos.setText("Pedidos");
        jbPedidos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jbPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPedidosActionPerformed(evt);
            }
        });

        jbGerarRelat.setFont(new java.awt.Font("Cinzel Black", 0, 12)); // NOI18N
        jbGerarRelat.setText("Relatórios");
        jbGerarRelat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jbGerarRelat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGerarRelatActionPerformed(evt);
            }
        });

        jbDiesel.setFont(new java.awt.Font("Cinzel Black", 0, 12)); // NOI18N
        jbDiesel.setText("NF-e Diesel");
        jbDiesel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jbDiesel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDieselActionPerformed(evt);
            }
        });

        jbAdm.setFont(new java.awt.Font("Cinzel Black", 0, 12)); // NOI18N
        jbAdm.setText("Administrador");
        jbAdm.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jbAdm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAdmActionPerformed(evt);
            }
        });

        jbCalcula.setFont(new java.awt.Font("Cinzel Black", 0, 12)); // NOI18N
        jbCalcula.setText("Calcular Frete");
        jbCalcula.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jbCalcula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCalculaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jbMotoristas, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbEmpresas, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbCaminhoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbDiesel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbAdm, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbGerarRelat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbPedidos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbCalcula, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbMotoristas, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbEmpresas, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCaminhoes, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbGerarRelat, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbDiesel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbAdm, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(jbCalcula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 360, 310));

        jbLogout.setBackground(new java.awt.Color(0, 0, 0));
        jbLogout.setFont(new java.awt.Font("Cinzel Black", 0, 12)); // NOI18N
        jbLogout.setForeground(new java.awt.Color(255, 255, 255));
        jbLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetoRosanTransports/imagens/logout.png"))); // NOI18N
        jbLogout.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jbLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLogoutActionPerformed(evt);
            }
        });
        getContentPane().add(jbLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 320, 50, 40));

        jLabel3.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel3.setText("Bem-Vindo");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, 20));

        jlUser.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        getContentPane().add(jlUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 330, 190, 20));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 640, 10));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 640, 10));

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(278, 0, -1, 310));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLogoutActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(this, "Deseja realmente sair?", "LogOff", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            this.dispose();
            new JFLogin().setVisible(true);
        }
    }//GEN-LAST:event_jbLogoutActionPerformed

    private void jbMotoristasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMotoristasActionPerformed
        // TODO add your handling code here:
        JFMotorista tela = new JFMotorista();
        tela.setVisible(true);       
    }//GEN-LAST:event_jbMotoristasActionPerformed

    private void jbEmpresasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEmpresasActionPerformed
        // TODO add your handling code here:
        setEnabled(false);
    }//GEN-LAST:event_jbEmpresasActionPerformed

    private void jbCaminhoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCaminhoesActionPerformed
        // TODO add your handling code here:
        setEnabled(false);
    }//GEN-LAST:event_jbCaminhoesActionPerformed

    private void jbPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPedidosActionPerformed
        // TODO add your handling code here:
        setEnabled(false);
    }//GEN-LAST:event_jbPedidosActionPerformed

    private void jbDieselActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDieselActionPerformed
        // TODO add your handling code here:
        setEnabled(false);
    }//GEN-LAST:event_jbDieselActionPerformed

    private void jbGerarRelatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGerarRelatActionPerformed
        // TODO add your handling code here:
        setEnabled(false);
    }//GEN-LAST:event_jbGerarRelatActionPerformed

    private void jbAdmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAdmActionPerformed
        // TODO add your handling code here:
        setEnabled(false);
    }//GEN-LAST:event_jbAdmActionPerformed

    private void jbCalculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCalculaActionPerformed
        // TODO add your handling code here:
        setEnabled(false);
    }//GEN-LAST:event_jbCalculaActionPerformed

    private void jbMotoristasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbMotoristasMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jbMotoristasMouseClicked

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
            java.util.logging.Logger.getLogger(JFPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFPrincipal().setVisible(true);
            }
        });
        
        
    }
    public void start1(motoristaModel obj){
        this.obj = obj;
        jlUser.setText(obj.getNomePessoa());
        if ((obj.getNivelPessoa()==0)) {
            travaBotao(false);
        }        
        //jlPrivilegio.setText("Motorista");
        
    }
    public void start2(administradorModel obj){
        this.obj2 = obj;
        jlUser.setText(obj.getNomePessoa());
        if ((obj.getNivelPessoa()==1)) {
            travaBotao(true);
        } 
        //jlPrivilegio.setText("Administrador");
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JButton jbAdm;
    private javax.swing.JButton jbCalcula;
    private javax.swing.JButton jbCaminhoes;
    private javax.swing.JButton jbDiesel;
    private javax.swing.JButton jbEmpresas;
    private javax.swing.JButton jbGerarRelat;
    private javax.swing.JButton jbLogout;
    private javax.swing.JButton jbMotoristas;
    private javax.swing.JButton jbPedidos;
    private javax.swing.JLabel jlUser;
    // End of variables declaration//GEN-END:variables
}