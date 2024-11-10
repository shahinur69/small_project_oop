import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdmissionForm extends JFrame implements ActionListener {
    private JTextField nameField, presAddress, nationality;
    private JRadioButton maleRadio, femaleRadio, aRadioButton, bRadioButton, abRadioButton, oRadioButton;
    private JCheckBox mathCheckBox, physicsCheckBox, chemistryCheckBox;
    private JButton submitButton;
    private JButton resetButton;

    public AdmissionForm() {
        super("Admission Form");
        setLayout(new FlowLayout());
        add(new JLabel("Name:"));
        nameField = new JTextField(15);
        add(nameField);

        add(new JLabel("Present Address: "));
        presAddress = new JTextField(20);
        add(presAddress);

        add(new JLabel("Nationality: "));
        nationality = new JTextField(15);
        add(nationality);

        add(new JLabel("Gender:"));
        maleRadio = new JRadioButton("Male");
        femaleRadio = new JRadioButton("Female");
        ButtonGroup genderGroup1 = new ButtonGroup();
        genderGroup1.add(maleRadio);
        genderGroup1.add(femaleRadio);
        add(maleRadio);
        add(femaleRadio);

        add(new JLabel("Subjects:"));
        mathCheckBox = new JCheckBox("Math");
        physicsCheckBox = new JCheckBox("Physics");
        chemistryCheckBox = new JCheckBox("Chemistry");
        add(mathCheckBox);
        add(physicsCheckBox);
        add(chemistryCheckBox);

        add(new JLabel("Blood Group"));
        aRadioButton = new JRadioButton("A+");
        bRadioButton = new JRadioButton("B+");
        abRadioButton = new JRadioButton("AB+");
        oRadioButton = new JRadioButton("O+");
        ButtonGroup genderGroup2 = new ButtonGroup();
        genderGroup2.add(aRadioButton);
        genderGroup2.add(bRadioButton);
        genderGroup2.add(abRadioButton);
        genderGroup2.add(oRadioButton);
        add(aRadioButton);
        add(bRadioButton);
        add(abRadioButton);
        add(oRadioButton);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        add(submitButton);

        resetButton = new JButton("Reset");
        resetButton.addActionListener(this);
        add(resetButton);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String name = nameField.getText();
            String address = presAddress.getText();
            String nation = nationality.getText();
            String gender = maleRadio.isSelected() ? "Male" : femaleRadio.isSelected() ? "Female" : "Other";
            String subjects = "";
            String bloodGroup = "";

            if (mathCheckBox.isSelected())
                subjects += "Math ";
            if (physicsCheckBox.isSelected())
                subjects += "Physics ";
            if (chemistryCheckBox.isSelected())
                subjects += "Chemistry ";

            if (aRadioButton.isSelected())
                bloodGroup = "A+";
            else if (bRadioButton.isSelected())
                bloodGroup = "B+";
            else if (abRadioButton.isSelected())
                bloodGroup = "AB+";
            else if (oRadioButton.isSelected())
                bloodGroup = "O+";

            JOptionPane.showMessageDialog(this,
                    "Name: " + name + "\nPresent Address: " + address + "\nNationality: " + nation + "\nGender: "
                            + gender + "\nSubjects: "
                            + subjects + "\nBlood Group: " + bloodGroup);
        } else if (e.getSource() == resetButton) {
            nameField.setText("");
            presAddress.setText("");
            nationality.setText("");

            maleRadio.setSelected(false);
            femaleRadio.setSelected(false);
            aRadioButton.setSelected(false);
            bRadioButton.setSelected(false);
            abRadioButton.setSelected(false);
            oRadioButton.setSelected(false);

            mathCheckBox.setSelected(false);
            physicsCheckBox.setSelected(false);
            chemistryCheckBox.setSelected(false);
        }
    }

}