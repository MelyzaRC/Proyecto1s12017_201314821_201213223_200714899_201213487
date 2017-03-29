/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.logging.Level;
import javax.swing.ImageIcon;

/**
 *
 * @author MelyzaAlejandra
 */
public class PantallaReportes extends javax.swing.JFrame {

    public static OkHttpClient webClient = new OkHttpClient();

    public PantallaReportes() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public String metodoWS(String metodo, RequestBody formBody) {
        try {
            URL url = new URL("http://localhost:5000/" + metodo);
            Request request = new Request.Builder().url(url).post(formBody).build();
            Response response = webClient.newCall(request).execute();//Aqui obtiene la respuesta en dado caso si hayas pues un return en python
            String response_string = response.body().string();//y este seria el string de las respuesta
            return response_string;
        } catch (MalformedURLException ex) {
            java.util.logging.Logger.getLogger(reportes.Reportes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(reportes.Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        ArbolB_btn = new javax.swing.JButton();
        transactionID_txt = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Matriz Dispersa");

        jButton1.setText("Generar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Ver");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTabbedPane1.addTab("Imagen", jLabel2);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTabbedPane1.addTab("Detalles", jScrollPane1);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Activos de una empresa");

        jButton3.setText("Ver");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Generar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Activos de un departamento");

        jButton5.setText("Ver");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Generar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Opciones de usuario");

        jComboBox1.setToolTipText("");
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jLabel6.setText("Empresa");

        jLabel7.setText("Departamento");

        jLabel8.setText("Usuario");

        jButton7.setText("Generar AVL");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Ver");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Activos rentados");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Activos");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Transacciones");

        ArbolB_btn.setText("Generar");
        ArbolB_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ArbolB_btnActionPerformed(evt);
            }
        });

        jButton10.setText("Obtener Transación");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jLabel11.setText("Id de Transacción");

        jButton11.setText("Refrescar");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setText("Ver");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setText("Ver");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setText("ver");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setText("Ver Transaccion");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(jButton1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addComponent(jLabel3))
                                    .addComponent(jTextField2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(jButton4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel4)
                                    .addComponent(jTextField3)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(jLabel5))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(jButton6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButton7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton11)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel9)))))
                .addGap(18, 38, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(transactionID_txt)
                                .addComponent(jButton10)
                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ArbolB_btn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton14)))
                        .addGap(12, 12, 12))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton15)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jButton5))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton12))
                .addGap(7, 7, 7)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton13))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jButton8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton9)
                .addGap(33, 33, 33))
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel10)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ArbolB_btn)
                    .addComponent(jButton14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(transactionID_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            ImageIcon icono = new javax.swing.ImageIcon("C:\\graficas\\ActivosDepartamento.png");
            Image imagen = icono.getImage();
            ImageIcon iconoEscalado = new ImageIcon(imagen.getScaledInstance(450, 590, Image.SCALE_SMOOTH));
            jLabel2.setIcon(iconoEscalado);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed

    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        try {
            ImageIcon icono = new javax.swing.ImageIcon("C:\\graficas\\Avl.png");
            Image imagen = icono.getImage();
            ImageIcon iconoEscalado = new ImageIcon(imagen.getScaledInstance(450, 590, Image.SCALE_SMOOTH));
            jLabel2.setIcon(iconoEscalado);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        RequestBody formBody = new FormEncodingBuilder()
                .add("empresa", "none")
                .add("departamento", "none")
                .add("user", "none")
                .add("password", "none")
                .build();

        String r = metodoWS("graficarMatriz", formBody);
        try {
            String dotPath = "C:\\release\\bin\\dot.exe";
            String fileInputPath = "C:\\graficas\\MatrizDispersa.dot";
            String fileOutputPath = "C:\\graficas\\MatrizDispersa.png";
            String tParam = "-Tjpg";
            String tOParam = "-o";
            String[] cmd = new String[5];
            cmd[0] = dotPath;
            cmd[1] = tParam;
            cmd[2] = fileInputPath;
            cmd[3] = tOParam;
            cmd[4] = fileOutputPath;
            Runtime rt = Runtime.getRuntime();
            rt.exec(cmd);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
        }
        System.out.println(r);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            ImageIcon icono = new javax.swing.ImageIcon("C:\\graficas\\MatrizDispersa.png");
            Image imagen = icono.getImage();
            ImageIcon iconoEscalado = new ImageIcon(imagen.getScaledInstance(450, 590, Image.SCALE_SMOOTH));
            jLabel2.setIcon(iconoEscalado);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        RequestBody formBody = new FormEncodingBuilder()
                .add("empresa", "none")
                .add("departamento", "none")
                .add("user", "none")
                .add("password", "none")
                .build();

        String r = metodoWS("recorrerMatriz", formBody);
        jTextArea1.setText(r);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        RequestBody formBody = new FormEncodingBuilder()
                .add("empresa", jTextField2.getText())
                .build();

        String r = metodoWS("activosEmpresa", formBody);
        try {
            String dotPath = "C:\\release\\bin\\dot.exe";
            String fileInputPath = "C:\\graficas\\ActivosEmpresa.dot";
            String fileOutputPath = "C:\\graficas\\ActivosEmpresa.png";
            String tParam = "-Tjpg";
            String tOParam = "-o";
            String[] cmd = new String[5];
            cmd[0] = dotPath;
            cmd[1] = tParam;
            cmd[2] = fileInputPath;
            cmd[3] = tOParam;
            cmd[4] = fileOutputPath;
            Runtime rt = Runtime.getRuntime();
            rt.exec(cmd);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
        }
        jTextArea1.setText(r);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            ImageIcon icono = new javax.swing.ImageIcon("C:\\graficas\\ActivosEmpresa.png");
            Image imagen = icono.getImage();
            ImageIcon iconoEscalado = new ImageIcon(imagen.getScaledInstance(450, 590, Image.SCALE_SMOOTH));
            jLabel2.setIcon(iconoEscalado);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void ArbolB_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ArbolB_btnActionPerformed
        // TODO add your handling code here:

        try {
            String arbol = "";
            URL urlobtener = new URL("http://192.168.43.81/webapi/api/ArbolB/obtenerArbol");
            URLConnection conobtener = urlobtener.openConnection();

            BufferedReader inobtener = new BufferedReader(new InputStreamReader(conobtener.getInputStream()));
            String linea;
            while ((linea = inobtener.readLine()) != null) {
                arbol += linea;
            }
            jTextArea1.setText(arbol);

            URL url = new URL("http://192.168.43.81/webapi/api/ArbolB/graficarArbol");
            URLConnection con = url.openConnection();
            con.setReadTimeout(2000000000);
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String result = "";

            String archivoDotPath = "C:\\graficas\\ArbolB.dot";

            File archivoDot = new File(archivoDotPath);

            if (archivoDot.exists()) {
                archivoDot.delete();
            }

            FileWriter wr = new FileWriter(archivoDot, true);

            while ((result = in.readLine()) != null) {
                result = result.replace("\\", "");
                result = result.substring(1, result.length() - 2) + "}";
                wr.write(result);
            }
            in.close();
            wr.close();

            String dotPath = "C:\\release\\bin\\dot.exe";
            String fileInputPath = "C:\\graficas\\ArbolB.dot";
            String fileOutputPath = "C:\\graficas\\ArbolB.jpg";
            String tParam = "-Tjpg";
            String tOParam = "-o";
            String[] cmd = new String[5];
            cmd[0] = dotPath;
            cmd[1] = tParam;
            cmd[2] = fileInputPath;
            cmd[3] = tOParam;
            cmd[4] = fileOutputPath;
            Runtime rt = Runtime.getRuntime();
            rt.exec(cmd);

        } catch (Exception ex) {
            System.out.println(ex);
        }


    }//GEN-LAST:event_ArbolB_btnActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        try {

            String arbol = "";
            URL url = new URL("http://192.168.43.81/webapi/api/ArbolB/buscarNodo?transactionID=" + transactionID_txt.getText());
            URLConnection con = url.openConnection();
            con.setReadTimeout(2000000000);
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String result = "";

            String archivoDotPath = "C:\\graficas\\Transaccion.dot";

            File archivoDot = new File(archivoDotPath);

            if (archivoDot.exists()) {
                archivoDot.delete();
            }

            FileWriter wr = new FileWriter(archivoDot, true);

            while ((result = in.readLine()) != null) {
                arbol += result;
                result = result.replace("\\", "");
                result = result.substring(1, result.length() - 2) + "}";
                wr.write(result);
            }
            in.close();
            wr.close();

            String dotPath = "C:\\release\\bin\\dot.exe";
            String fileInputPath = "C:\\graficas\\Transaccion.dot";
            String fileOutputPath = "C:\\graficas\\Transaccion.jpg";
            String tParam = "-Tjpg";
            String tOParam = "-o";
            String[] cmd = new String[5];
            cmd[0] = dotPath;
            cmd[1] = tParam;
            cmd[2] = fileInputPath;
            cmd[3] = tOParam;
            cmd[4] = fileOutputPath;
            Runtime rt = Runtime.getRuntime();
            rt.exec(cmd);

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        RequestBody formBody = new FormEncodingBuilder()
                .add("empresa", "none")
                .add("departamento", jTextField3.getText())
                .add("user", "none")
                .add("password", "none")
                .build();

        String r = metodoWS("activosDepartamento", formBody);
        try {
            String dotPath = "C:\\release\\bin\\dot.exe";
            String fileInputPath = "C:\\graficas\\ActivosDepartamento.dot";
            String fileOutputPath = "C:\\graficas\\ActivosDepartamento.png";
            String tParam = "-Tjpg";
            String tOParam = "-o";
            String[] cmd = new String[5];
            cmd[0] = dotPath;
            cmd[1] = tParam;
            cmd[2] = fileInputPath;
            cmd[3] = tOParam;
            cmd[4] = fileOutputPath;
            Runtime rt = Runtime.getRuntime();
            rt.exec(cmd);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
        }
        jTextArea1.setText(r);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        jComboBox1.removeAllItems();
        jComboBox2.removeAllItems();
        jComboBox3.removeAllItems();
        RequestBody formBody = new FormEncodingBuilder()
                .add("empresa", "none")
                .build();

        String r = metodoWS("verEmpresas", formBody);
        System.out.println(r);

        char[] aa = r.toCharArray();
        String temp = "";
        for (int i = 0; i < r.length(); i++) {
            char b = aa[i];
            if (b == '$') {
                jComboBox1.addItem(temp);
                temp = "";
            } else {
                temp = temp + b;
            }
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        try {
            jComboBox2.removeAllItems();
            jComboBox3.removeAllItems();
            String empresa = (String) jComboBox1.getSelectedItem();
            RequestBody formBody = new FormEncodingBuilder()
                    .add("empresa", empresa)
                    .build();

            String r = metodoWS("verDepartamentos", formBody);
            jComboBox2.removeAllItems();
            char[] aa = r.toCharArray();
            String temp = "";
            for (int i = 0; i < r.length(); i++) {
                char b = aa[i];
                if (b == '$') {
                    jComboBox2.addItem(temp);
                    temp = "";
                } else {
                    temp = temp + b;
                }
            }
        } catch (Exception ex) {

        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        try {
            jComboBox3.removeAllItems();
            String empresa = (String) jComboBox1.getSelectedItem();
            String departamento = (String) jComboBox2.getSelectedItem();
            RequestBody formBody = new FormEncodingBuilder()
                    .add("empresa", empresa)
                    .add("departamento", departamento)
                    .build();

            String r = metodoWS("verUsuarios", formBody);
            jComboBox3.removeAllItems();
            char[] aa = r.toCharArray();
            String temp = "";
            for (int i = 0; i < r.length(); i++) {
                char b = aa[i];
                if (b == '$') {
                    jComboBox3.addItem(temp);
                    temp = "";
                } else {
                    temp = temp + b;
                }
            }
        } catch (Exception ex) {
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        try {
            String empresa = (String) jComboBox1.getSelectedItem();
            String departamento = (String) jComboBox2.getSelectedItem();
            String usuario = (String) jComboBox3.getSelectedItem();
            RequestBody formBody = new FormEncodingBuilder()
                    .add("empresa", empresa)
                    .add("departamento", departamento)
                    .add("usuario", usuario)
                    .build();

            String r = metodoWS("grafAvl", formBody);
        } catch (Exception ex) {

        }
        try {
            String dotPath = "C:\\release\\bin\\dot.exe";
            String fileInputPath = "C:\\graficas\\Avl.dot";
            String fileOutputPath = "C:\\graficas\\Avl.png";
            String tParam = "-Tjpg";
            String tOParam = "-o";
            String[] cmd = new String[5];
            cmd[0] = dotPath;
            cmd[1] = tParam;
            cmd[2] = fileInputPath;
            cmd[3] = tOParam;
            cmd[4] = fileOutputPath;
            Runtime rt = Runtime.getRuntime();
            rt.exec(cmd);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:

        ImageIcon icono = new javax.swing.ImageIcon("C:\\graficas\\ArbolB.jpg");
        Image imagen = icono.getImage();
        ImageIcon iconoEscalado = new ImageIcon(imagen.getScaledInstance(450, 590, Image.SCALE_SMOOTH));
        jLabel2.setIcon(iconoEscalado);
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        ImageIcon icono = new javax.swing.ImageIcon("C:\\graficas\\Transaccion.jpg");
        Image imagen = icono.getImage();
        ImageIcon iconoEscalado = new ImageIcon(imagen.getScaledInstance(450, 590, Image.SCALE_SMOOTH));
        jLabel2.setIcon(iconoEscalado);
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        try {
            String empresa = (String) jComboBox1.getSelectedItem();
            String departamento = (String) jComboBox2.getSelectedItem();
            String usuario = (String) jComboBox3.getSelectedItem();
            RequestBody formBody = new FormEncodingBuilder()
                    .add("empresa", empresa)
                    .add("departamento", departamento)
                    .add("usuario", usuario)
                    .build();

            String r = metodoWS("devRentasUsuario", formBody);
            jTextArea1.setText(r);
        } catch (Exception ex) {

        }          // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

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
            java.util.logging.Logger.getLogger(PantallaReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaReportes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ArbolB_btn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField transactionID_txt;
    // End of variables declaration//GEN-END:variables
}
