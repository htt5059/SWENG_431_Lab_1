import com.company.Utility;

import javax.swing.*;

public class Lab1GUI extends JFrame{
    private JPanel panel;
    private JLabel ageField;
    private JLabel nameField;
    private JTextField textField1;
    private JTextField textField2;
    private JButton doneButton;

    public Lab1GUI(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.setTitle("Lab 1 GUI");
        this.pack();

        doneButton.setEnabled(false);

        InputVerifier iv= new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                JTextField jtf= (JTextField) input;
                String name=jtf.getText();
                if(!Utility.checkName(name)){
                    throw new NameException("")
                }

            }
        };
        textField2.setInputVerifier(iv);
        String age= textField1.getText();
        String name=textField2.getText();
        doneButton.setEnabled(Utility.checkAge(age) && Utility.checkName(name));
    }

    public static void main(String[] args){
        JFrame frame = new Lab1GUI();
        frame.setSize(728, 215);
        frame.setVisible(true);
    }
}

class NameException extends Exception{
    public NameException(String err){
        super(err);
    }
}
