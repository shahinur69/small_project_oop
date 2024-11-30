
 import javax.swing.*;
 import java.awt.*;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;
 import javax.swing.table.DefaultTableModel;
 import java.io.*;
 import java.text.SimpleDateFormat;
 import java.util.ArrayList;
 
 public class AdmissionForm extends JFrame implements ActionListener {
     private JTextField nameField, presAddress, nationality, emailField, contactField;
     private JRadioButton maleRadio, femaleRadio, aRadioButton, bRadioButton, abRadioButton, oRadioButton, aMinusRadioButton, bMinusRadioButton, abMinusRadioButton, oMinusRadioButton;
     private JComboBox<String> programComboBox;
     private JSpinner dobSpinner;
     private JButton submitButton, resetButton, loadSerializedButton;
     private JTable table;
     private DefaultTableModel tableModel;
     private ButtonGroup genderGroup, bloodGroup;
 
     public AdmissionForm() {
         super("Admission Form");
 
         setLayout(new GridLayout(2, 1));
 
         JPanel formPanel = new JPanel(new GridLayout(0, 2, 5, 5));
         formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
 
         formPanel.add(new JLabel("Full Name:"));
         nameField = new JTextField(15);
         formPanel.add(nameField);
 
         formPanel.add(new JLabel("Present Address:"));
         presAddress = new JTextField(20);
         formPanel.add(presAddress);
 
         formPanel.add(new JLabel("Nationality:"));
         nationality = new JTextField(15);
         formPanel.add(nationality);
 
         formPanel.add(new JLabel("Email Address:"));
         emailField = new JTextField(20);
         formPanel.add(emailField);
 
         formPanel.add(new JLabel("Date of Birth:"));
         dobSpinner = new JSpinner(new SpinnerDateModel());
         JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dobSpinner, "yyyy-MM-dd");
         dobSpinner.setEditor(dateEditor);
         formPanel.add(dobSpinner);
 
         formPanel.add(new JLabel("Contact Number:"));
         contactField = new JTextField(15);
         formPanel.add(contactField);
 
         formPanel.add(new JLabel("Program Name:"));
         String[] programs = {"CSE", "EEE", "SWE", "LLB", "BBA", "English"};
         programComboBox = new JComboBox<>(programs);
         formPanel.add(programComboBox);
 
         formPanel.add(new JLabel("Gender:"));
         maleRadio = new JRadioButton("Male");
         femaleRadio = new JRadioButton("Female");
         genderGroup = new ButtonGroup();
         genderGroup.add(maleRadio);
         genderGroup.add(femaleRadio);
 
         JPanel genderPanel = new JPanel(new GridLayout(1, 2));
         genderPanel.add(maleRadio);
         genderPanel.add(femaleRadio);
         formPanel.add(genderPanel);
 
         formPanel.add(new JLabel("Blood Group:"));
         aRadioButton = new JRadioButton("A+");
         bRadioButton = new JRadioButton("B+");
         abRadioButton = new JRadioButton("AB+");
         oRadioButton = new JRadioButton("O+");
         aMinusRadioButton = new JRadioButton("A-");
         bMinusRadioButton = new JRadioButton("B-");
         abMinusRadioButton = new JRadioButton("AB-");
         oMinusRadioButton = new JRadioButton("O-");
 
         bloodGroup = new ButtonGroup();
         bloodGroup.add(aRadioButton);
         bloodGroup.add(bRadioButton);
         bloodGroup.add(abRadioButton);
         bloodGroup.add(oRadioButton);
         bloodGroup.add(aMinusRadioButton);
         bloodGroup.add(bMinusRadioButton);
         bloodGroup.add(abMinusRadioButton);
         bloodGroup.add(oMinusRadioButton);
 
         JPanel bloodGroupPanel = new JPanel(new GridLayout(2, 4));
         bloodGroupPanel.add(aRadioButton);
         bloodGroupPanel.add(bRadioButton);
         bloodGroupPanel.add(abRadioButton);
         bloodGroupPanel.add(oRadioButton);
         bloodGroupPanel.add(aMinusRadioButton);
         bloodGroupPanel.add(bMinusRadioButton);
         bloodGroupPanel.add(abMinusRadioButton);
         bloodGroupPanel.add(oMinusRadioButton);
         formPanel.add(bloodGroupPanel);
 
         submitButton = new JButton("Submit");
         submitButton.addActionListener(this);
         formPanel.add(submitButton);
 
         resetButton = new JButton("Reset");
         resetButton.addActionListener(this);
         formPanel.add(resetButton);
 
         loadSerializedButton = new JButton("Load Data");
         loadSerializedButton.addActionListener(this);
         formPanel.add(loadSerializedButton);
 
         add(formPanel);
 
         String[] columnNames = {
             "Full Name", "Present Address", "Nationality", "Email", "DateOfBirth", "Contact", "Program",
             "Gender", "Blood Group"
         };
         tableModel = new DefaultTableModel(columnNames, 0);
         table = new JTable(tableModel);
         JScrollPane scrollPane = new JScrollPane(table);
         scrollPane.setPreferredSize(new Dimension(500, 150));
         add(scrollPane);
 
         setSize(800, 600);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setVisible(true);
     }
 
     @Override
     public void actionPerformed(ActionEvent e) {
         if (e.getSource() == submitButton) {
             String email = emailField.getText();
             if (!email.contains("@")) {
                 JOptionPane.showMessageDialog(this, "Please enter a valid email with '@'.", "Invalid Email", JOptionPane.ERROR_MESSAGE);
                 return;
             }
 
             String name = nameField.getText();
             String address = presAddress.getText();
             String nation = nationality.getText();
             String dob = new SimpleDateFormat("yyyy-MM-dd").format(dobSpinner.getValue());
             String contact = contactField.getText();
             String program = (String) programComboBox.getSelectedItem();
             String gender = maleRadio.isSelected() ? "Male" : femaleRadio.isSelected() ? "Female" : "Other";
             String bloodGroupText = "";
 
             if (aRadioButton.isSelected()) bloodGroupText = "A+";
             else if (bRadioButton.isSelected()) bloodGroupText = "B+";
             else if (abRadioButton.isSelected()) bloodGroupText = "AB+";
             else if (oRadioButton.isSelected()) bloodGroupText = "O+";
             else if (aMinusRadioButton.isSelected()) bloodGroupText = "A-";
             else if (bMinusRadioButton.isSelected()) bloodGroupText = "B-";
             else if (abMinusRadioButton.isSelected()) bloodGroupText = "AB-";
             else if (oMinusRadioButton.isSelected()) bloodGroupText = "O-";
 
             // Create an AdmissionFormData object and add it to the table and serialize it
             AdmissionFormData data = new AdmissionFormData(name, address, nation, email, dob, contact, program, gender, bloodGroupText);
             tableModel.addRow(new Object[]{
                 data.getName(), data.getAddress(), data.getNationality(), data.getEmail(),
                 data.getDob(), data.getContact(), data.getProgram(), data.getGender(), data.getBloodGroup()
             });
             saveSerializedData(data);
         } else if (e.getSource() == resetButton) {
             nameField.setText("");
             presAddress.setText("");
             nationality.setText("");
             emailField.setText("");
             dobSpinner.setValue(new java.util.Date());
             contactField.setText("");
             programComboBox.setSelectedIndex(0);
             genderGroup.clearSelection();
             bloodGroup.clearSelection();
         } else if (e.getSource() == loadSerializedButton) {
             loadSerializedData();
         }
     }
 
     private void loadSerializedData() {
         try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("admission_data.ser"))) {
             ArrayList<AdmissionFormData> dataList = (ArrayList<AdmissionFormData>) ois.readObject();
             for (AdmissionFormData data : dataList) {
                 tableModel.addRow(new Object[]{
                     data.getName(), data.getAddress(), data.getNationality(), data.getEmail(),
                     data.getDob(), data.getContact(), data.getProgram(), data.getGender(), data.getBloodGroup()
                 });
             }
             JOptionPane.showMessageDialog(this, "Data loaded successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
         } catch (IOException | ClassNotFoundException ex) {
             JOptionPane.showMessageDialog(this, "Error loading serialized data.", "Error", JOptionPane.ERROR_MESSAGE);
         }
     }
 
     private void saveSerializedData(AdmissionFormData data) {
         try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("admission_data.ser"))) {
             ArrayList<AdmissionFormData> dataList = (ArrayList<AdmissionFormData>) ois.readObject();
             dataList.add(data);
             try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("admission_data.ser"))) {
                 oos.writeObject(dataList);
             }
         } catch (IOException | ClassNotFoundException ex) {
             ArrayList<AdmissionFormData> newDataList = new ArrayList<>();
             newDataList.add(data);
             try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("admission_data.ser"))) {
                 oos.writeObject(newDataList);
             } catch (IOException e) {
                 JOptionPane.showMessageDialog(this, "Error saving data.", "Error", JOptionPane.ERROR_MESSAGE);
             }
         }
     }
 
     public static void main(String[] args) {
         new AdmissionForm();
     }
 }
 
 // This class represents the data structure for admission records
 class AdmissionFormData implements Serializable {
     private String name, address, nationality, email, dob, contact, program, gender, bloodGroup;
 
     public AdmissionFormData(String name, String address, String nationality, String email, String dob,
                              String contact, String program, String gender, String bloodGroup) {
         this.name = name;
         this.address = address;
         this.nationality = nationality;
         this.email = email;
         this.dob = dob;
         this.contact = contact;
         this.program = program;
         this.gender = gender;
         this.bloodGroup = bloodGroup;
     }
 
     public String getName() { return name; }
     public String getAddress() { return address; }
     public String getNationality() { return nationality; }
     public String getEmail() { return email; }
     public String getDob() { return dob; }
     public String getContact() { return contact; }
     public String getProgram() { return program; }
     public String getGender() { return gender; }
     public String getBloodGroup() { return bloodGroup; }
 }
 