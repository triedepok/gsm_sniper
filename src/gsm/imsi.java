/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gsm;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author ews
 */
public class imsi extends javax.swing.JFrame {

    private Query DBQ;
    int isiProgressBar;
    private DBAdmin db;
    private Connection conn;
    private ResultSet rs;
    private String query;
    Thread tFreq;
    ProcessBuilder cmd = new ProcessBuilder();
    float i = 0;

    /**
     * Creates new form imsi
     */
    public imsi() {
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

        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        label1 = new java.awt.Label();
        Message = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        CmbBoxChan = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        BtnRfScan = new javax.swing.JButton();
        BtnRfStop = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel4 = new javax.swing.JLabel();
        LblProgress = new javax.swing.JLabel();
        jJmlFreq = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        TxtImsi = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        BtnAddImsi = new javax.swing.JButton();
        BtnClearImsi = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        TblAddImsi = new javax.swing.JTable();
        BtnCariImsi = new javax.swing.JButton();
        BtlStopCariImsi = new javax.swing.JButton();
        jButtonExit = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem4 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("MOBILE IMSI SNIFFER");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel2.setPreferredSize(new java.awt.Dimension(789, 692));
        jPanel2.setLayout(null);

        jLabel7.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(245, 202, 202));
        jLabel7.setText("MOBILE IMSI SNIFFER");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(40, 30, 250, 17);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/header-graphic.png"))); // NOI18N
        jLabel6.setToolTipText("GSM IMSI Sniffer");
        jLabel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel2.add(jLabel6);
        jLabel6.setBounds(13, 13, 760, 56);
        jLabel6.getAccessibleContext().setAccessibleDescription("");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTable1PropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        label1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        label1.setText("Search result");

        Message.setText("Status:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Message))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Message)
                .addGap(30, 30, 30))
        );

        label1.getAccessibleContext().setAccessibleName("List IMSI yang didapatkan:");

        jPanel2.add(jPanel1);
        jPanel1.setBounds(13, 409, 760, 226);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Scanning Channels");

        CmbBoxChan.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        CmbBoxChan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "GSM900", "GSM1900" }));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel3.setText("Channels");

        BtnRfScan.setText("Scan");
        BtnRfScan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRfScanActionPerformed(evt);
            }
        });

        BtnRfStop.setText("Stop");
        BtnRfStop.setEnabled(false);
        BtnRfStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRfStopActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel4.setText("Progress");

        LblProgress.setText("0%");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(CmbBoxChan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnRfScan, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnRfStop, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jJmlFreq)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LblProgress)))))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CmbBoxChan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(BtnRfScan)
                    .addComponent(BtnRfStop))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblProgress))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jJmlFreq)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3);
        jPanel3.setBounds(13, 75, 760, 125);

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("IMSI Search List");

        TxtImsi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtImsiKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel5.setText("IMSI");

        BtnAddImsi.setText("Add");
        BtnAddImsi.setEnabled(false);
        BtnAddImsi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAddImsiActionPerformed(evt);
            }
        });

        BtnClearImsi.setText("Clear");
        BtnClearImsi.setEnabled(false);
        BtnClearImsi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnClearImsiActionPerformed(evt);
            }
        });

        jScrollPane3.setViewportView(TblAddImsi);

        BtnCariImsi.setText("Search");
        BtnCariImsi.setEnabled(false);
        BtnCariImsi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCariImsiActionPerformed(evt);
            }
        });

        BtlStopCariImsi.setText("Stop");
        BtlStopCariImsi.setEnabled(false);
        BtlStopCariImsi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtlStopCariImsiActionPerformed(evt);
            }
        });

        jButtonExit.setText("Exit");
        jButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(BtnCariImsi, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                                    .addComponent(BtlStopCariImsi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(TxtImsi, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnAddImsi, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnClearImsi, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtImsi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(BtnAddImsi)
                    .addComponent(BtnClearImsi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(BtnCariImsi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtlStopCariImsi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel5);
        jPanel5.setBounds(13, 204, 760, 201);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 780, 648);

        jMenu1.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Open");
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Close");
        jMenu1.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Save");
        jMenu1.add(jMenuItem3);
        jMenu1.add(jSeparator1);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("SaveAs");
        jMenu1.add(jMenuItem4);
        jMenu1.add(jSeparator2);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setText("Exit");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Help");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(789, 694));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTable1PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1PropertyChange

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        listTable();

        cmd.command("bash", "-c", "uhd_find_devices;uhd_usrp_probe;");
        try {
            Process nunggu = cmd.start();
            nunggu.waitFor();
        } catch (IOException ex) {
            //Logger.getLogger(imsi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(imsi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowOpened

    private void listTable() {
        Runnable runner = new Runnable() {
            public void run() {
                while (true) {
                    try {
                        DBQ = new Query();
                        ResultSet rs1 = DBQ.selectImsi();
                        jTable1.setModel(tableModel1(new String[]{"NO", "IMSI", "DATE", "CID", "MCC", "MNC", "LAC"}, rs1));
                        jTable1.getColumnModel().getColumn(0).setPreferredWidth(10);
                        jTable1.getColumnModel().getColumn(1).setPreferredWidth(105);
                        jTable1.getColumnModel().getColumn(2).setPreferredWidth(125);

                        ResultSet rs2 = DBQ.selectAddImsi();
                        TblAddImsi.setModel(tableModel2(new String[]{"NO", "IMSI"}, rs2));
                        TblAddImsi.getColumnModel().getColumn(0).setPreferredWidth(10);
                        TblAddImsi.getColumnModel().getColumn(1).setPreferredWidth(305);

                        ResultSet rs3 = DBQ.selectTable("freq_active");
                        rs3.last();
                        int rowCount = rs3.getRow();
                        rs3.beforeFirst();
                        jJmlFreq.setText(Integer.toString(rowCount) + " channel detected");
                    } catch (SQLException ex) {
                        Logger.getLogger(imsi.class.getName()).log(Level.SEVERE, null, ex);
                        Message.setText("Status: Database not conect...");
                        BtnRfScan.setEnabled(false);
                    }

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(imsi.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Message.setText("Status: Running");
                }
            }
        };
        Thread row = new Thread(runner, "Code Executer");
        row.start();
    }

    void filterhuruf(KeyEvent a) {
        if (Character.isAlphabetic(a.getKeyChar())) {
            a.consume();
            JOptionPane.showMessageDialog(null, "Hanya Bisa Memasukan Karakter Angka");
        }
    }

    void filterangka(KeyEvent b) {
        if (Character.isDigit(b.getKeyChar())) {
            b.consume();
            JOptionPane.showMessageDialog(null, "Hanya Bisa Memasukan Karakter Huruf");
        }
    }

    void filterHanyaAngka(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!((Character.isDigit(c)
                || (c == KeyEvent.VK_BACK_SPACE)
                || (c == KeyEvent.VK_DELETE)))) {
            evt.consume();
        }
    }

    private void BtnClearImsiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnClearImsiActionPerformed
        // TODO add your handling code here:
        DBQ = new Query();
        DBQ.deleteImsi("addimsi");
        //DBQ.deleteImsi("imsi");
        TxtImsi.setText("");
    }//GEN-LAST:event_BtnClearImsiActionPerformed

    private void BtnAddImsiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAddImsiActionPerformed
        // TODO add your handling code here:
        DBQ = new Query();
        if (TxtImsi.getText() != null) {
            if ((TxtImsi.getText().length()) == 15) {
                try {
                    rs = DBQ.selectDataSama(TxtImsi.getText());
                    rs.next();
                    int row = rs.getRow();
                    if (row > 0) {
                        JOptionPane.showMessageDialog(null, "Duplikasi data...");
                    } else {
                        DBQ.insertImsi(TxtImsi.getText());
                        Message.setText("Data tersimpan...");
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(imsi.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Format data tidak sesuai...\n");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Data belum di isi...");
        }
        //listTable();
        //TxtImsi.setText("");
        BtnCariImsi.setEnabled(true);
    }//GEN-LAST:event_BtnAddImsiActionPerformed

    private void BtnCariImsiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCariImsiActionPerformed
        // TODO add your handling code here:
        BtlStopCariImsi.setEnabled(true);
        BtnCariImsi.setEnabled(false);
        BtnAddImsi.setEnabled(false);
        BtnRfScan.setEnabled(false);
        BtnClearImsi.setEnabled(false);

        ///System.err.println("Proses scan IMSI \n");        
        Runnable runner = new Runnable() {
            public void run() {
                cmd.command("bash", "-c", "gsmsniffer.py;");
                try {
                    Process aki = cmd.start();
                    aki.waitFor();
                    System.err.println("Proses scan IMSI \n");
                    BtlStopCariImsi.setEnabled(false);
                    BtnCariImsi.setEnabled(true);
                } catch (IOException ex) {
                    //Logger.getLogger(imsi.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                    Logger.getLogger(imsi.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        };
        Thread imsi = new Thread(runner, "Jalankan program scan IMSI");
        imsi.start();


    }//GEN-LAST:event_BtnCariImsiActionPerformed

    private void BtlStopCariImsiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtlStopCariImsiActionPerformed
        // TODO add your handling code here:
        BtlStopCariImsi.setEnabled(false);
        BtnCariImsi.setEnabled(true);
        BtnAddImsi.setEnabled(true);
        BtnRfScan.setEnabled(true);
        BtnClearImsi.setEnabled(true);

        System.err.println("Stop scan IMSI \n");
        cmd.command("sh", "-c", "killall -TERM python2;killall -TERM sh;");
        try {
            cmd.start();
        } catch (IOException ex) {
            //Logger.getLogger(imsi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtlStopCariImsiActionPerformed

    private void BtnRfScanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRfScanActionPerformed
        // TODO add your handling code here:        
        BtnCariImsi.setEnabled(false);
        BtnAddImsi.setEnabled(false);
        BtnRfStop.setEnabled(true);
        BtnRfScan.setEnabled(false);

        Runnable runner = new Runnable() {
            public void run() {
                while (true) {
                    try {
                        //Your original code with the loop here.
                        rs = DBQ.selectTable("player");
                        rs.next();
                        int row = rs.getRow();
                        i = rs.getFloat(4);
                    } catch (SQLException ex) {
                        Logger.getLogger(imsi.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    try {
                        jProgressBar1.setValue((int) i);
                        LblProgress.setText(String.valueOf(i) + "%");

                        if (i >= 47.4) {
                            System.err.println("Proses scan selesai \n");
                            jProgressBar1.setValue(100);
                            LblProgress.setText("100%");
                            cmd.command("bash", "-c", "killall -TERM kal;killall -TERM sh;");
                            try {
                                cmd.start();
                                BtnRfScan.setEnabled(true);
                                BtnRfStop.setEnabled(false);
                                BtnAddImsi.setEnabled(true);
                                BtnClearImsi.setEnabled(true);
                                BtnCariImsi.setEnabled(true);
                                //Resert data progress
                                DBQ = new Query();
                                DBQ.updateProgress();
                            } catch (IOException ex) {
                                //Logger.getLogger(imsi.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }

                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        };
        Thread freq = new Thread(runner, "Prosess pada progress bar");
        freq.start();

        Runnable runner1 = new Runnable() {
            public void run() {
                String Pband = null;
                String channel = CmbBoxChan.getSelectedItem().toString();
                switch (channel) {
                    case "GSM900":
                        Pband = "900";
                        break;
                    case "GSM1900":
                        Pband = "1900";
                        break;
                }
                cmd.command("bash", "-c", "kal -s " + Pband + ";");
                //cmd.command("bash", "-c", "wireshark;");
                try {
                    Process aki = cmd.start();
                    aki.waitFor();
                    System.err.println("Proses scan frequency \n");
                    BtnRfScan.setEnabled(true);
                    BtnRfStop.setEnabled(false);
                    BtnAddImsi.setEnabled(true);
                    BtnClearImsi.setEnabled(true);
                    BtnCariImsi.setEnabled(true);
                } catch (IOException ex) {
                    //Logger.getLogger(imsi.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                    Logger.getLogger(imsi.class.getName()).log(Level.SEVERE, null, ex);
                }
                BtnAddImsi.setEnabled(true);
                BtnClearImsi.setEnabled(true);
                BtnCariImsi.setEnabled(true);
            }
        };
        Thread rf = new Thread(runner1, "Jalankan program scan rf");
        rf.start();

    }//GEN-LAST:event_BtnRfScanActionPerformed

    private void BtnRfStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRfStopActionPerformed
        // TODO add your handling code here:
        //tFreq.interrupt();
        BtnRfScan.setEnabled(true);
        BtnRfStop.setEnabled(false);

        cmd.command("sh", "-c", "killall -TERM kal;killall -TERM sh;");
        try {
            cmd.start();
            BtnAddImsi.setEnabled(true);
            BtnClearImsi.setEnabled(true);
            BtnCariImsi.setEnabled(true);
            System.err.println("Proses scan dihentikan \n");
        } catch (IOException ex) {
            //Logger.getLogger(imsi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtnRfStopActionPerformed

    private void TxtImsiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtImsiKeyTyped
        // TODO add your handling code here:
        filterHanyaAngka(evt);
    }//GEN-LAST:event_TxtImsiKeyTyped

    private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExitActionPerformed
        // TODO add your handling code here:

        cmd.command("sh", "-c", "killall -TERM kal;killall -TERM sh;");
        try {
            cmd.start();
        } catch (IOException ex) {
            //Logger.getLogger(imsi.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Keluar aplikasi
        System.exit(0);
    }//GEN-LAST:event_jButtonExitActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        cmd.command("sh", "-c", "killall -TERM kal;killall -TERM sh;");
        try {
            cmd.start();
        } catch (IOException ex) {
            //Logger.getLogger(imsi.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Keluar aplikasi
        System.exit(0);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        // TODO add your handling code here:
        help hai = new help();
        hai.setVisible(true);
    }//GEN-LAST:event_jMenu2MouseClicked

    private DefaultTableModel tableModel1(String[] colNames, ResultSet rs) throws SQLException {
        int row = 0;
        while (rs.next()) {
            row = rs.getRow();
        }
        rs.beforeFirst();
        String[][] data = new String[row][colNames.length];
        for (int i = 0; i < row; i++) {
            rs.next();
            data[i][0] = String.valueOf(i + 1);
            for (int j = 1; j < colNames.length; j++) {
                if (j == 2) {
                    String kata = rs.getString(j);
                    data[i][j] = kata.substring(4, 6) + "/" + kata.substring(2, 4) + "/20" + kata.substring(0, 2) + " " + kata.substring(6, 8) + ":" + kata.substring(8, 10) + ":" + kata.substring(10, 12);
                } else {
                    data[i][j] = rs.getString(j);
                }
            }
        }
        return new DefaultTableModel(data, colNames);
    }

    private DefaultTableModel tableModel2(String[] colNames, ResultSet rs) throws SQLException {
        int row = 0;
        while (rs.next()) {
            row = rs.getRow();
        }
        rs.beforeFirst();
        String[][] data = new String[row][colNames.length];
        for (int i = 0; i < row; i++) {
            rs.next();
            data[i][0] = String.valueOf(i + 1);
            for (int j = 1; j < colNames.length; j++) {
                data[i][j] = rs.getString(j + 1);
            }
        }
        return new DefaultTableModel(data, colNames);
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
            java.util.logging.Logger.getLogger(imsi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(imsi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(imsi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(imsi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new imsi().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtlStopCariImsi;
    private javax.swing.JButton BtnAddImsi;
    private javax.swing.JButton BtnCariImsi;
    private javax.swing.JButton BtnClearImsi;
    private javax.swing.JButton BtnRfScan;
    private javax.swing.JButton BtnRfStop;
    private javax.swing.JComboBox CmbBoxChan;
    private javax.swing.JLabel LblProgress;
    private javax.swing.JLabel Message;
    private javax.swing.JTable TblAddImsi;
    private javax.swing.JTextField TxtImsi;
    private javax.swing.JButton jButtonExit;
    private javax.swing.JLabel jJmlFreq;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JTable jTable1;
    private java.awt.Label label1;
    // End of variables declaration//GEN-END:variables
}
