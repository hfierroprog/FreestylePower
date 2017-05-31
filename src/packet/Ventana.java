/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package packet;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/**
 *
 * @author bebee
 */
public final class Ventana extends javax.swing.JFrame {
    Conector con = new Conector();
    private String palabra;
    private Timer t;
    private int contador;
    private int tope = 0;
    private int intervalo;
    
    /** Creates new form Ventana */
    public Ventana() {
        initComponents();
        con.conectar();
        
        ImageIcon fondoxd = new ImageIcon("src/res/fondo.png");
        Icon icono3 = new ImageIcon(fondoxd.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_DEFAULT));
        fondo.setIcon(icono3);
        
        this.repaint();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        INICIAR = new javax.swing.JButton();
        PARAR = new javax.swing.JButton();
        CONTADOR_TXT = new javax.swing.JLabel();
        SEG_TXT = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        INTERVALO_TXT = new javax.swing.JTextField();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(747, 519));
        setMinimumSize(new java.awt.Dimension(747, 519));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe Print", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 100, 740, 62);

        INICIAR.setText("INICIAR");
        INICIAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                INICIARActionPerformed(evt);
            }
        });
        getContentPane().add(INICIAR);
        INICIAR.setBounds(170, 410, 200, 54);
        INICIAR.getAccessibleContext().setAccessibleParent(INICIAR);

        PARAR.setText("PARAR");
        PARAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PARARActionPerformed(evt);
            }
        });
        getContentPane().add(PARAR);
        PARAR.setBounds(430, 410, 200, 54);

        CONTADOR_TXT.setFont(new java.awt.Font("Segoe Print", 3, 24)); // NOI18N
        CONTADOR_TXT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(CONTADOR_TXT);
        CONTADOR_TXT.setBounds(0, 250, 740, 40);

        SEG_TXT.setText("120");
        SEG_TXT.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(SEG_TXT);
        SEG_TXT.setBounds(80, 400, 80, 30);

        jLabel2.setText("SEGUNDOS:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 410, 70, 14);

        jLabel3.setText("INTERVALO:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 450, 70, 14);

        INTERVALO_TXT.setText("10");
        INTERVALO_TXT.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(INTERVALO_TXT);
        INTERVALO_TXT.setBounds(80, 440, 80, 30);

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/fondo.png"))); // NOI18N
        getContentPane().add(fondo);
        fondo.setBounds(0, 0, 740, 510);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void INICIARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_INICIARActionPerformed
        INICIAR.setEnabled(false);
        contador = Integer.parseInt(SEG_TXT.getText());
        intervalo = Integer.parseInt(INTERVALO_TXT.getText());
        palabra();
        t = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                contador--;
                CONTADOR_TXT.setText(""+contador);
                if (contador % intervalo == 0){
                    palabra();
                }
                
                if(contador == tope){
                    parar();
                }
                
            }
        });
        t.start();
    }//GEN-LAST:event_INICIARActionPerformed

    
    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        con.cerrar();
    }//GEN-LAST:event_formWindowClosing

    private void PARARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PARARActionPerformed
        parar();
    }//GEN-LAST:event_PARARActionPerformed

   private void palabra(){
        palabra = con.getAleatorio();
        jLabel1.setText(palabra.toUpperCase());
   }
   
   private void parar(){
        t.stop();
        INICIAR.setEnabled(true);
        contador = 0;
   }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CONTADOR_TXT;
    private javax.swing.JButton INICIAR;
    private javax.swing.JTextField INTERVALO_TXT;
    private javax.swing.JButton PARAR;
    private javax.swing.JTextField SEG_TXT;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables

    void setIconImage(String srcresfondopng) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
