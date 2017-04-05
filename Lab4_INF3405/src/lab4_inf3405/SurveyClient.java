/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4_inf3405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Simel
 */
public class SurveyClient extends javax.swing.JFrame implements SurveyFormControlFormatter {

    private  Socket socket_;
    private  BufferedReader reader_;
    private  PrintWriter outWriter_;
    
    
    //private static boolean surveyIsOpen_ = false;
    private boolean ipAddressOk_ = false;    //Valid IP Address format is 0-255.0-255.0-255.0-255
    private boolean isConnected_ = false;
    
    private static int clientPortNumber_;
    private static String clientIPAddress_;
    
    private final List<javax.swing.JFormattedTextField> fieldList_;
    
    /**
     * Creates new form Client
     */
    public SurveyClient() {
        fieldList_ = new ArrayList<>();
        initComponents();
        
        fieldList_.add(portNumFTextField_);
        fieldList_.add(ipFTextField_);
        
        DocumentListener documentListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkFieldsFull();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkFieldsFull();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                 checkFieldsFull();
            }
        };
        
        // populate document listener for all fields
        for(javax.swing.JFormattedTextField field : fieldList_)
            field.getDocument().addDocumentListener(documentListener);
    }

    @Override
    public void validatePortNumber() {
        
        try {
                        
             Object[] options = { "OK", "CANCEL" };
                if ( Integer.parseInt(portNumFTextField_.getText().trim() ) < 10000 || Integer.parseInt(portNumFTextField_.getText().trim() ) > 10050) {
                    JOptionPane.showOptionDialog(clientPanel_, "Port Nnumber Must Be Between 10000 and 10050", "Error",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);                    
                    
                    portNumFTextField_.setValue("");
                    portNumFTextField_.requestFocus();
                }
            }catch (NumberFormatException ex) {
                
                JOptionPane.showMessageDialog(clientPanel_, "Port Number Should Be An Integer", "Error", JOptionPane.ERROR_MESSAGE);
                portNumFTextField_.setValue("");
                portNumFTextField_.requestFocus();
         
         }
        
    }

    @Override
    public void checkFieldsFull() {
        
        for(javax.swing.JFormattedTextField field : fieldList_) {
            
            if (field.getText().trim().isEmpty()) {
                connectButton_.setEnabled(false);
                sendButton_.setEnabled(false);
                disconnectButton_.setEnabled(false);
                
                return;
            }
        }
        
        connectButton_.setEnabled(true);
        sendButton_.setEnabled(true);
        disconnectButton_.setEnabled(true);
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        clientPanel_ = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        msgTextArea_ = new javax.swing.JTextArea();
        serverIpLabel_ = new javax.swing.JLabel();
        serverPortLabel_ = new javax.swing.JLabel();
        connectButton_ = new javax.swing.JButton();
        sendButton_ = new javax.swing.JButton();
        disconnectButton_ = new javax.swing.JButton();
        portNumFTextField_ = new javax.swing.JFormattedTextField();
        ipFTextField_ = new javax.swing.JFormattedTextField();
        msgTextField_ = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        clientPanel_.setBorder(javax.swing.BorderFactory.createTitledBorder("Client"));

        msgTextArea_.setEditable(false);
        msgTextArea_.setColumns(20);
        msgTextArea_.setRows(5);
        msgTextArea_.setFocusable(false);
        jScrollPane1.setViewportView(msgTextArea_);

        serverIpLabel_.setText("Server IP Addr:");

        serverPortLabel_.setText("Server Port # :");

        connectButton_.setText("CONNECT");
        connectButton_.setEnabled(false);
        connectButton_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectButton_ActionPerformed(evt);
            }
        });

        sendButton_.setText("SEND");
        sendButton_.setEnabled(false);
        sendButton_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButton_ActionPerformed(evt);
            }
        });

        disconnectButton_.setText("DISCONNECT");
        disconnectButton_.setEnabled(false);
        disconnectButton_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disconnectButton_ActionPerformed(evt);
            }
        });

        portNumFTextField_.setMinimumSize(new java.awt.Dimension(104, 24));
        portNumFTextField_.setPreferredSize(new java.awt.Dimension(104, 24));
        portNumFTextField_.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                portNumFTextField_FocusLost(evt);
            }
        });

        ipFTextField_.setMinimumSize(new java.awt.Dimension(104, 24));
        ipFTextField_.setPreferredSize(new java.awt.Dimension(104, 24));
        ipFTextField_.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ipFTextField_FocusLost(evt);
            }
        });

        msgTextField_.setEnabled(false);

        javax.swing.GroupLayout clientPanel_Layout = new javax.swing.GroupLayout(clientPanel_);
        clientPanel_.setLayout(clientPanel_Layout);
        clientPanel_Layout.setHorizontalGroup(
            clientPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clientPanel_Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(clientPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jScrollPane1)
                    .addComponent(msgTextField_, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sendButton_, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(9, Short.MAX_VALUE))
            .addGroup(clientPanel_Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(clientPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(serverIpLabel_)
                    .addComponent(serverPortLabel_))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(clientPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(clientPanel_Layout.createSequentialGroup()
                        .addComponent(ipFTextField_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(connectButton_, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(clientPanel_Layout.createSequentialGroup()
                        .addComponent(portNumFTextField_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(disconnectButton_, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        clientPanel_Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {connectButton_, disconnectButton_});

        clientPanel_Layout.setVerticalGroup(
            clientPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clientPanel_Layout.createSequentialGroup()
                .addGroup(clientPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(connectButton_)
                    .addComponent(ipFTextField_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(serverIpLabel_, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(clientPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(portNumFTextField_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(disconnectButton_)
                    .addComponent(serverPortLabel_))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(msgTextField_, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(sendButton_, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        clientPanel_Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {serverIpLabel_, serverPortLabel_});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(clientPanel_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(clientPanel_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ipFTextField_FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ipFTextField_FocusLost
        
        if (ipFTextField_.getText().equals(""))
            return;
             
        ipAddressOk_ = validateIP(ipFTextField_.getText().trim()); // Valid IP Address format is 0-255.0-255.0-255.0-255
        
        if (!ipAddressOk_) {
            
            JOptionPane.showMessageDialog(clientPanel_, "Wrong IP Format", "Error", JOptionPane.ERROR_MESSAGE);
            ipFTextField_.requestFocus();
            //ipFTextField_.setValue("");
           
        }
    }//GEN-LAST:event_ipFTextField_FocusLost

    private void portNumFTextField_FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_portNumFTextField_FocusLost
        
        if( portNumFTextField_.getText().equals("") )
            return;
        
        validatePortNumber();
    }//GEN-LAST:event_portNumFTextField_FocusLost

    private void connectButton_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectButton_ActionPerformed
        
        if (!isConnected_) {
            
            clientPortNumber_ = Integer.parseInt(portNumFTextField_.getText().trim());
            clientIPAddress_ = ipFTextField_.getText().trim();
            ipFTextField_.setEditable(false);
            portNumFTextField_.setEditable(false);
            msgTextField_.setEnabled(true);

           try {

               socket_ = new Socket(clientIPAddress_, clientPortNumber_);

                   InputStreamReader instream = new InputStreamReader(socket_.getInputStream());
                   reader_ = new BufferedReader(instream);
                   
                   outWriter_ = new PrintWriter(socket_.getOutputStream(), true); // with autoflush
                   outWriter_.println("ping");
                   
                   
                   isConnected_ = true;
                   connectButton_.setEnabled(false);                  
                  
                   //Create a new Thread so we can read
                   // server response and update the GUI without
                   // blocking it
                   Thread t = new Thread(new Runnable() {
                  
                       @Override                   
                       public void run() {
                       
                           try {
                
                                // read server response                  
                                 String response;
                                  while ( (response = reader_.readLine()) != null ) {                       

                                     msgTextArea_.append(response + " \n");
                                  }

                             } catch (Exception e) {}
                   
                       }
                    });
                   
                   t.start(); // start the newly created thread

           } catch (IOException ex) {

               msgTextArea_.append("Failed to connect! Try again.\n");
               Logger.getLogger(SurveyClient.class.getName()).log(Level.SEVERE, null, ex);
           }
           
        }
        
    }//GEN-LAST:event_connectButton_ActionPerformed

    private void sendButton_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButton_ActionPerformed
        
        // send answer
        String response = msgTextField_.getText().trim();
        
        if (response.equals("")) {
            
            msgTextField_.setText("");
            msgTextField_.requestFocus();
        } else {
            
            try {
                
                outWriter_.println(response);
                outWriter_.flush();
                
            } catch (Exception e) {
                
                msgTextArea_.append("Message was not sent. \n");
            }
            
             msgTextField_.setText("");
             msgTextField_.requestFocus();
        }
        
        msgTextField_.setText("");
        msgTextField_.requestFocus();
        
    }//GEN-LAST:event_sendButton_ActionPerformed

    private void disconnectButton_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disconnectButton_ActionPerformed
        
        String disconnect = ipFTextField_.getText() + " has disconnected";
        
        try {
            
            outWriter_.println(disconnect);
            outWriter_.flush();
            
            socket_.close();
            
        } catch (Exception e) {
        }
        
        isConnected_ = false;
    }//GEN-LAST:event_disconnectButton_ActionPerformed

    
    
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
            java.util.logging.Logger.getLogger(SurveyClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SurveyClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SurveyClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SurveyClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SurveyClient().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel clientPanel_;
    private javax.swing.JButton connectButton_;
    private javax.swing.JButton disconnectButton_;
    private static javax.swing.JFormattedTextField ipFTextField_;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea msgTextArea_;
    private javax.swing.JTextField msgTextField_;
    private static javax.swing.JFormattedTextField portNumFTextField_;
    private javax.swing.JButton sendButton_;
    private javax.swing.JLabel serverIpLabel_;
    private javax.swing.JLabel serverPortLabel_;
    // End of variables declaration//GEN-END:variables

}
