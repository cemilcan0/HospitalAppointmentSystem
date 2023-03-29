package login_register_with_text_file;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.plaf.synth.Region;
import static login_register_with_text_file.AddAndRemove.departman;
import static login_register_with_text_file.AddAndRemove.location;
import static login_register_with_text_file.AddAndRemove.name;

public class AppointmentTimes extends javax.swing.JFrame {

    public void close() {
        WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }

    ArrayList<Checkbox> check;
    ArrayList<Doctor> doctors;
    ArrayList<confirmation> confirm;
    Message_Frame msgF = new Message_Frame();
    public static ArrayList<String> name2 = new ArrayList<String>();
    public static ArrayList<String> nm = new ArrayList<String>();
    public static ArrayList<String> nm2 = new ArrayList<String>();
    public static ArrayList<String> nm3 = new ArrayList<String>();
    public static ArrayList<String> m4 = new ArrayList<String>();

    public static ArrayList<String> docclinc = new ArrayList<String>();
    public String dep = null;
    public String dt = null;
    public String fname = null;
    public String cnfchck = null;
    public String isim = null;
    public int o = 0;
    String c, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12 = null;

    public AppointmentTimes() {
        initComponents();
        check = new ArrayList<Checkbox>();
        doctors = new ArrayList<Doctor>();
        confirm = new ArrayList<confirmation>();

        populateArrayList();
        for (int i = 0; i < check.size(); i++) {
            if (!name.contains(check.get(i).getName())) {
                name.add(check.get(i).getName());
            }
        }

        /*for(int i=0;i<name.size();i++){
                    cb_clander.addItem(name.get(i));
            } */
        populateArrayListdoc();
        for (int i = 0; i < doctors.size(); i++) {
            if (!location.contains(doctors.get(i).getlocation())) {
                location.add(doctors.get(i).getlocation());
            }
        }

        for (int i = 0; i < doctors.size(); i++) {
            if (!departman.contains(doctors.get(i).getDepartment())) {
                departman.add(doctors.get(i).getDepartment());

            }
        }

        for (int i = 0; i < doctors.size(); i++) {
            if (!name2.contains(doctors.get(i).getName())) {
                name2.add(doctors.get(i).getName());

            }
        }

        /*for(int i=0;i<check.size();i++){
            
                            m4.add(check.get(i).checkbox1);
                            m4.add(check.get(i).checkbox2);
                            m4.add(check.get(i).checkbox3);
                            m4.add(check.get(i).checkbox4);
                            m4.add(check.get(i).checkbox5);
                            m4.add(check.get(i).checkbox6);
                            m4.add(check.get(i).checkbox7);
                            m4.add(check.get(i).checkbox8);
                            m4.add(check.get(i).checkbox9);
                            m4.add(check.get(i).checkbox10);
                            m4.add(check.get(i).checkbox11);
                            m4.add(check.get(i).checkbox12);
            
        
        
        }
        System.out.println(m4);*/
    }

    public void savedocEmployeesToFile() {
        try {
            FileOutputStream fileEmployee = new FileOutputStream("Doctor.dat");
            ObjectOutputStream outputFileEmployee = new ObjectOutputStream(fileEmployee);

            for (int i = 0; i < doctors.size(); i++) {
                outputFileEmployee.writeObject(doctors.get(i));
            }
            outputFileEmployee.close();
            msgF.jLabel_message.setText("Successfully saved!");
            msgF.setVisible(true);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void populateArrayListdoc() {

        try {
            FileInputStream fileEmployee = new FileInputStream("Doctor.dat");
            ObjectInputStream inputFileEmployee = new ObjectInputStream(fileEmployee);

            boolean endOfFile = false;
            while (!endOfFile) {
                try {
                    doctors.add((Doctor) inputFileEmployee.readObject());
                } catch (EOFException e) {
                    endOfFile = true;
                } catch (Exception f) {
                    JOptionPane.showMessageDialog(null, f.getMessage());
                }
            }
            inputFileEmployee.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void saveEmployeesToFile() {
        try {
            FileOutputStream fileEmployee = new FileOutputStream("kontrol.dat");
            ObjectOutputStream outputFileEmployee = new ObjectOutputStream(fileEmployee);

            for (int i = 0; i < check.size(); i++) {
                outputFileEmployee.writeObject(check.get(i));
            }
            outputFileEmployee.close();
            msgF.jLabel_message.setText("Successfully saved!");
            msgF.setVisible(true);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void populateArrayList() {

        try {
            FileInputStream fileEmployee = new FileInputStream("kontrol.dat");
            ObjectInputStream inputFileEmployee = new ObjectInputStream(fileEmployee);

            boolean endOfFile = false;
            while (!endOfFile) {
                try {
                    check.add((Checkbox) inputFileEmployee.readObject());
                } catch (EOFException e) {
                    endOfFile = true;
                } catch (Exception f) {
                    JOptionPane.showMessageDialog(null, f.getMessage());
                }
            }
            inputFileEmployee.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void savepatientEmployeesToFile() {
        try {
            FileOutputStream fileEmployee = new FileOutputStream("apptime.dat");
            ObjectOutputStream outputFileEmployee = new ObjectOutputStream(fileEmployee);

            for (int i = 0; i < confirm.size(); i++) {
                outputFileEmployee.writeObject(confirm.get(i));
            }
            outputFileEmployee.close();
            msgF.jLabel_message.setText("Successfully saved!");
            msgF.setVisible(true);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void populateArrayListpatient() {

        try {
            FileInputStream fileEmployee = new FileInputStream("apptime.dat");
            ObjectInputStream inputFileEmployee = new ObjectInputStream(fileEmployee);

            boolean endOfFile = false;
            while (!endOfFile) {
                try {
                    confirm.add((confirmation) inputFileEmployee.readObject());
                } catch (EOFException e) {
                    endOfFile = true;
                } catch (Exception f) {
                    JOptionPane.showMessageDialog(null, f.getMessage());
                }
            }
            inputFileEmployee.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cb_clander = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cb1 = new javax.swing.JCheckBox();
        cb2 = new javax.swing.JCheckBox();
        cb3 = new javax.swing.JCheckBox();
        cb4 = new javax.swing.JCheckBox();
        cb5 = new javax.swing.JCheckBox();
        cb6 = new javax.swing.JCheckBox();
        cb11 = new javax.swing.JCheckBox();
        cb12 = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cb7 = new javax.swing.JCheckBox();
        jLabel12 = new javax.swing.JLabel();
        cb8 = new javax.swing.JCheckBox();
        cb9 = new javax.swing.JCheckBox();
        cb10 = new javax.swing.JCheckBox();
        cb_patientlocation = new javax.swing.JComboBox<>();
        cb_clinic = new javax.swing.JComboBox<>();
        cb_docname = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        getname = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        cb_clander.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", " " }));
        cb_clander.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_clanderActionPerformed(evt);
            }
        });

        jLabel1.setText("10:00");

        jLabel2.setText("10:30");

        jLabel3.setText("11:00");

        jLabel4.setText("12:00");

        jLabel5.setText("12:30");

        jLabel6.setText("11:30");

        cb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb1ActionPerformed(evt);
            }
        });

        cb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb2ActionPerformed(evt);
            }
        });

        cb3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb3ActionPerformed(evt);
            }
        });

        cb4.setToolTipText("");

        jLabel7.setText("14:00");

        jLabel8.setText("14:30");

        jLabel9.setText("15:00");

        jLabel10.setText("16:00");

        jLabel11.setText("16:30");

        jLabel12.setText("15:30");

        cb_patientlocation.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Location", "Ataşehir", "Mecidiyeköy", "Pendik" }));
        cb_patientlocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_patientlocationActionPerformed(evt);
            }
        });

        cb_clinic.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose outpatient Clinic" }));
        cb_clinic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_clinicActionPerformed(evt);
            }
        });

        cb_docname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_docnameActionPerformed(evt);
            }
        });

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel13.setText("jLabel13");

        getname.setText("Patient Name");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setText("Patient İnformation");

        jLabel15.setText("Patient Name:");

        jLabel16.setText("Patient Id:");

        jLabel17.setText("Patient Email:");

        jLabel18.setText("jLabel18");

        jLabel19.setText("Patient age:");

        jLabel20.setText("jLabel20");

        jLabel21.setText("jLabel21");

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton2.setText("Find the nearest hospital");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel17)
                            .addComponent(jLabel19))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel21)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(getname, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cb_patientlocation, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cb_clinic, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cb_docname, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cb_clander, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(cb2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cb3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cb4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cb5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cb6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cb1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2))
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cb7, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cb8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cb9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cb10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cb11, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cb12, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jButton1)))
                .addContainerGap(126, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton3)
                        .addGap(42, 42, 42)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(getname)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel21)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cb_patientlocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cb_clinic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cb_docname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(cb_clander, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jButton1)
                        .addGap(65, 65, 65))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(cb7))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(cb2)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8)
                                        .addComponent(cb8)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cb9)
                                    .addComponent(jLabel9)
                                    .addComponent(cb3)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cb10)
                                    .addComponent(jLabel12)
                                    .addComponent(cb4)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cb11)
                                    .addComponent(jLabel10))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cb12)
                                    .addComponent(jLabel11)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(cb1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cb5)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cb6)
                                    .addComponent(jLabel5))))
                        .addGap(92, 92, 92))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cb_clanderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_clanderActionPerformed
        populateArrayList();

        cb1.setForeground(Color.black);
        cb2.setForeground(Color.black);
        cb3.setForeground(Color.black);
        cb4.setForeground(Color.black);
        cb5.setForeground(Color.black);
        cb6.setForeground(Color.black);
        cb7.setForeground(Color.black);
        cb8.setForeground(Color.black);
        cb9.setForeground(Color.black);
        cb10.setForeground(Color.black);
        cb11.setForeground(Color.black);
        cb12.setForeground(Color.black);

        for (int i = 0; i < check.size(); i++) {

            if (cb_clander.getSelectedItem().equals(check.get(i).getDays()) && cb_docname.getSelectedItem().equals(check.get(i).getName())) {
                dt = check.get(i).getDays();

                if (check.get(i).getCheckbox1().equals("1")) {
                    cb1.setForeground(Color.green);
                    cb1.setText("Appointments can be made");

                } else {
                    cb1.setForeground(Color.red);
                    cb1.setText("Appointments can not be made");
                }
                if (check.get(i).getCheckbox2().equals("1")) {
                    cb2.setForeground(Color.green);
                    cb2.setText("Appointments can be made");
                } else {
                    cb2.setForeground(Color.red);
                    cb2.setText("Appointments can not be made");
                }
                if (check.get(i).getCheckbox3().equals("1")) {
                    cb3.setForeground(Color.green);
                    cb3.setText("Appointments can be made");
                } else {
                    cb3.setForeground(Color.red);
                    cb3.setText("Appointments can not be made");
                }
                if (check.get(i).getCheckbox4().equals("1")) {
                    cb4.setForeground(Color.green);
                    cb4.setText("Appointments can be made");
                } else {
                    cb4.setForeground(Color.red);
                    cb4.setText("Appointments can not be made");
                }
                if (check.get(i).getCheckbox5().equals("1")) {
                    cb5.setForeground(Color.green);
                    cb5.setText("Appointments can be made");
                } else {
                    cb5.setForeground(Color.red);
                    cb5.setText("Appointments can not be made");
                }
                if (check.get(i).getCheckbox6().equals("1")) {
                    cb6.setForeground(Color.green);
                    cb6.setText("Appointments can be made");
                } else {
                    cb6.setForeground(Color.red);
                    cb6.setText("Appointments can not be made");
                }
                if (check.get(i).getCheckbox7().equals("1")) {
                    cb7.setForeground(Color.green);
                    cb7.setText("Appointments can be made");
                } else {
                    cb7.setForeground(Color.red);
                    cb7.setText("Appointments can not be made");
                }
                if (check.get(i).getCheckbox8().equals("1")) {
                    cb8.setForeground(Color.green);
                    cb8.setText("Appointments can be made");
                } else {
                    cb8.setForeground(Color.red);
                    cb8.setText("Appointments can not be made");
                }
                if (check.get(i).getCheckbox9().equals("1")) {
                    cb9.setForeground(Color.green);
                    cb9.setText("Appointments can be made");
                } else {
                    cb9.setForeground(Color.red);
                    cb9.setText("Appointments can not be made");
                }
                if (check.get(i).getCheckbox10().equals("1")) {
                    cb10.setForeground(Color.green);
                    cb10.setText("Appointments can be made");
                } else {
                    cb10.setForeground(Color.red);
                    cb10.setText("Appointments can not be made");
                }
                if (check.get(i).getCheckbox11().equals("1")) {
                    cb11.setForeground(Color.green);
                    cb11.setText("Appointments can be made");
                } else {
                    cb11.setForeground(Color.red);
                    cb11.setText("Appointments can not be made");
                }
                if (check.get(i).getCheckbox12().equals("1")) {
                    cb12.setForeground(Color.green);
                    cb12.setText("Appointments can be made");
                } else {
                    cb12.setForeground(Color.red);
                    cb12.setText("Appointments can not be made");
                }
            }
        }

    }//GEN-LAST:event_cb_clanderActionPerformed

    private void cb3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb3ActionPerformed

    private void cb_patientlocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_patientlocationActionPerformed
        cb1.setForeground(Color.black);
        cb2.setForeground(Color.black);
        cb3.setForeground(Color.black);
        cb4.setForeground(Color.black);
        cb5.setForeground(Color.black);
        cb6.setForeground(Color.black);
        cb7.setForeground(Color.black);
        cb8.setForeground(Color.black);
        cb9.setForeground(Color.black);
        cb10.setForeground(Color.black);
        cb11.setForeground(Color.black);
        cb12.setForeground(Color.black);

        if (cb_patientlocation.getSelectedItem().equals("Ataşehir")) {
            docclinc.removeAll(docclinc);
            cb_clinic.removeAllItems();

            for (int i = 0; i < doctors.size(); i++) {
                if (doctors.get(i).getlocation().contains("Ataşehir")) {
                    if (!docclinc.contains(doctors.get(i).getDepartment())) {
                        docclinc.add(doctors.get(i).getDepartment());
                    }
                }
            }
            for (int k = 0; k < docclinc.size(); k++) {
                cb_clinic.addItem(docclinc.get(k));
            }

        } else if (cb_patientlocation.getSelectedItem().equals("Mecidiyeköy")) {
            docclinc.removeAll(docclinc);
            cb_clinic.removeAllItems();

            for (int i = 0; i < doctors.size(); i++) {
                if (doctors.get(i).getlocation().contains("Mecidiyeköy")) {
                    if (!docclinc.contains(doctors.get(i).getDepartment())) {
                        docclinc.add(doctors.get(i).getDepartment());
                    }
                }
            }
            for (int k = 0; k < docclinc.size(); k++) {
                cb_clinic.addItem(docclinc.get(k));
            }

        } else if (cb_patientlocation.getSelectedItem().equals("Pendik")) {
            docclinc.removeAll(docclinc);
            cb_clinic.removeAllItems();

            for (int i = 0; i < doctors.size(); i++) {
                if (doctors.get(i).getlocation().contains("Pendik")) {
                    if (!docclinc.contains(doctors.get(i).getDepartment())) {
                        docclinc.add(doctors.get(i).getDepartment());
                    }
                }
            }
            for (int k = 0; k < docclinc.size(); k++) {
                cb_clinic.addItem(docclinc.get(k));
            }

        }

    }//GEN-LAST:event_cb_patientlocationActionPerformed

    private void cb_clinicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_clinicActionPerformed
        cb1.setForeground(Color.black);
        cb2.setForeground(Color.black);
        cb3.setForeground(Color.black);
        cb4.setForeground(Color.black);
        cb5.setForeground(Color.black);
        cb6.setForeground(Color.black);
        cb7.setForeground(Color.black);
        cb8.setForeground(Color.black);
        cb9.setForeground(Color.black);
        cb10.setForeground(Color.black);
        cb11.setForeground(Color.black);
        cb12.setForeground(Color.black);

        for (int p = 0; p < docclinc.size(); p++) {
            cb1.setForeground(Color.black);
            nm.removeAll(nm);
            nm2.removeAll(nm2);
            nm3.removeAll(nm3);
            cb_docname.removeAllItems();

            if (cb_clinic.getSelectedItem().equals(docclinc.get(p))) {

                dep = docclinc.get(p);

                if (cb_clinic.getSelectedItem().equals(dep)) {

                    for (int c = 0; c < doctors.size(); c++) {

                        if (doctors.get(c).getDepartment().contains(dep)) {
                            if (doctors.get(c).getlocation().contains("Ataşehir")) {

                                if (!nm.contains(doctors.get(c).getName())) {
                                    nm.add(doctors.get(c).getName());

                                }

                            } else if (doctors.get(c).getlocation().contains("Mecidiyeköy")) {

                                if (!nm2.contains(doctors.get(c).getName())) {
                                    nm2.add(doctors.get(c).getName());
                                }

                            } else if (doctors.get(c).getlocation().contains("Pendik")) {

                                if (!nm3.contains(doctors.get(c).getName())) {
                                    nm3.add(doctors.get(c).getName());
                                }

                            }

                        }
                    }
                    if (cb_patientlocation.getSelectedItem().equals("Mecidiyeköy")) {
                        for (int t = 0; t < nm2.size(); t++) {
                            cb_docname.addItem(nm2.get(t));
                        }
                        break;

                    } else if (cb_patientlocation.getSelectedItem().equals("Ataşehir")) {
                        for (int n = 0; n < nm.size(); n++) {
                            cb_docname.addItem(nm.get(n));
                        }
                        break;
                    } else if (cb_patientlocation.getSelectedItem().equals("Pendik")) {
                        for (int n = 0; n < nm3.size(); n++) {
                            cb_docname.addItem(nm3.get(n));
                        }
                        break;
                    }

                }
            }

        }

    }//GEN-LAST:event_cb_clinicActionPerformed

    private void cb_docnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_docnameActionPerformed

        cb1.setForeground(Color.black);
        cb2.setForeground(Color.black);
        cb3.setForeground(Color.black);
        cb4.setForeground(Color.black);
        cb5.setForeground(Color.black);
        cb6.setForeground(Color.black);
        cb7.setForeground(Color.black);
        cb8.setForeground(Color.black);
        cb9.setForeground(Color.black);
        cb10.setForeground(Color.black);
        cb11.setForeground(Color.black);
        cb12.setForeground(Color.black);
    }//GEN-LAST:event_cb_docnameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            //you can make an appointmen by selecting the hospital departmen from here
            //If there are no green, red or black text at the appointments times,that doctors has not uplooaded the appointment time.
        populateArrayListpatient();
        populateArrayList();
        if (cb1.isSelected() && cb1.getForeground().equals(Color.red) || cb1.getForeground().equals(Color.black) || cb2.isSelected() && cb2.getForeground().equals(Color.red) || cb2.getForeground().equals(Color.black) || cb3.isSelected() && cb3.getForeground().equals(Color.red) || cb3.getForeground().equals(Color.black) || cb4.isSelected() && cb4.getForeground().equals(Color.red) || cb4.getForeground().equals(Color.black) || cb5.isSelected() && cb5.getForeground().equals(Color.red) || cb5.getForeground().equals(Color.black)
                || cb6.isSelected() && cb6.getForeground().equals(Color.red) || cb6.getForeground().equals(Color.black) || cb7.isSelected() && cb7.getForeground().equals(Color.red) || cb7.getForeground().equals(Color.black)
                || cb8.isSelected() && cb8.getForeground().equals(Color.red) || cb8.getForeground().equals(Color.black) || cb9.isSelected() && cb9.getForeground().equals(Color.red) || cb9.getForeground().equals(Color.black)
                || cb10.isSelected() && cb10.getForeground().equals(Color.red) || cb10.getForeground().equals(Color.black) || cb11.isSelected() && cb11.getForeground().equals(Color.red) || cb11.getForeground().equals(Color.black)
                || cb12.isSelected() && cb12.getForeground().equals(Color.red) || cb12.getForeground().equals(Color.black)) {
            msgF.jLabel_message.setText("You cannot make an appointment from the red and black checkboxes.");
            msgF.setVisible(true);
        } else {
            if (cb1.isSelected()) {
                o += 1;
            }
            if (cb2.isSelected()) {
                o += 1;
            }
            if (cb3.isSelected()) {
                o += 1;
            }
            if (cb4.isSelected()) {
                o += 1;
            }

            if (cb5.isSelected()) {
                o += 1;
            }
            if (cb6.isSelected()) {
                o += 1;
            }
            if (cb7.isSelected()) {
                o += 1;
            }
            if (cb8.isSelected()) {
                o += 1;
            }
            if (cb9.isSelected()) {
                o += 1;
            }
            if (cb10.isSelected()) {
                o += 1;
            }
            if (cb11.isSelected()) {
                o += 1;
            }
            if (cb12.isSelected()) {
                o += 1;
            }
            if (o < 2) {
                if (cb1.isSelected()) {
                cb1.setForeground(Color.red);
            }
            if (cb2.isSelected()) {
                cb2.setForeground(Color.red);
            }
            if (cb3.isSelected()) {
                cb3.setForeground(Color.red);
            }
            if (cb4.isSelected()) {
                cb4.setForeground(Color.red);
            }

            if (cb5.isSelected()) {
                cb5.setForeground(Color.red);
            }
            if (cb6.isSelected()) {
                cb6.setForeground(Color.red);
            }
            if (cb7.isSelected()) {
                cb7.setForeground(Color.red);
            }
            if (cb8.isSelected()) {
                cb8.setForeground(Color.red);
            }
            if (cb9.isSelected()) {
                cb9.setForeground(Color.red);
            }
            if (cb10.isSelected()) {
                cb10.setForeground(Color.red);
                
            }
            if (cb11.isSelected()) {
                cb11.setForeground(Color.red);
                
            }
            if (cb12.isSelected()) {
                cb12.setForeground(Color.red);
                
            }

                String Id = jLabel13.getText().trim();
                String Fullname = getname.getText().trim();
                String Age = jLabel20.getText().trim();
                String Email = jLabel18.getText().trim();
                String dateday = dt;
                String sifre = jLabel21.getText().trim();
                saveEmployeesToFile();

                confirmation cnfrm = new confirmation(dateday, dep, Id, Fullname, Age, Email, sifre);
                confirm.add(cnfrm);
                System.out.println(dateday);

                savepatientEmployeesToFile();
                System.out.println("randevu alındı");

            } else {
                msgF.jLabel_message.setText("You cannot make 2 appointments from the same department.");
                msgF.setVisible(true);
                o = 0;
            }
        }

       

    }//GEN-LAST:event_jButton1ActionPerformed

    private void cb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb1ActionPerformed

    }//GEN-LAST:event_cb1ActionPerformed

    private void cb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            Desktop.getDesktop().browse(new URL("https://cemilcan0.github.io/NearestHospital/").toURI());
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Login_And_Register login= new Login_And_Register();
        login.setVisible(true);
        close();
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(AppointmentTimes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AppointmentTimes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AppointmentTimes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppointmentTimes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AppointmentTimes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox cb1;
    private javax.swing.JCheckBox cb10;
    private javax.swing.JCheckBox cb11;
    private javax.swing.JCheckBox cb12;
    private javax.swing.JCheckBox cb2;
    private javax.swing.JCheckBox cb3;
    private javax.swing.JCheckBox cb4;
    private javax.swing.JCheckBox cb5;
    private javax.swing.JCheckBox cb6;
    private javax.swing.JCheckBox cb7;
    private javax.swing.JCheckBox cb8;
    private javax.swing.JCheckBox cb9;
    private javax.swing.JComboBox<String> cb_clander;
    private javax.swing.JComboBox<String> cb_clinic;
    private javax.swing.JComboBox<String> cb_docname;
    private javax.swing.JComboBox<String> cb_patientlocation;
    public javax.swing.JLabel getname;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    public javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    public javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel20;
    public javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
