import javax.swing.JFrame;
public class AdmissionFormTest {

    public static void main(String[] args) {
        AdmissionForm admissionForm = new AdmissionForm();
        admissionForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        admissionForm.setSize(220, 350);
        admissionForm.setVisible(true);
    }
}
