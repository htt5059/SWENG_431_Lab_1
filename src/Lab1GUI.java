/*
* Team: Huy Tran  and Mohamed Ibrahim
*
* */

import com.company.NameException;
import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Lab1GUI extends JFrame{
    private JPanel panel;
    private JLabel ageField;
    private JLabel nameField;
    private JTextField textField1;
    private JTextField textField2;
    private JButton doneButton;

    public Lab1GUI() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.setTitle("Lab 1 GUI");
        this.pack();
        doneButton.setEnabled(false);
        InputVerifier iv= new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                JTextField jtf= (JTextField) input;
                return Utility.checkAge(jtf.getText());
            }
        };

        textField1.setInputVerifier(iv);
        String age= textField1.getText();
        textField2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                String name = textField2.getText();
                doneButton.setEnabled(Utility.checkName(name));
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new Lab1GUI();
        frame.setSize(728, 215);
        frame.setVisible(true);

    }
}

class Utility{
    static public boolean checkName(String name) {
        if(name.length()==0||name.length()>15){
            try {
                throw new NameException("Length Exceed");
            } catch (NameException nameException) {
                nameException.printStackTrace();
                return false;
            }
        }else if(!name.matches("[A-Za-z\\s\\d,-]*")){
            try {
                throw new NameException("Special Characters Exist");
            } catch (NameException nameException) {
                nameException.printStackTrace();
                return false;
            }
        }else if(!isContainDigit(name)){
            try {
                throw new NameException("Digits Exist");
            } catch (NameException nameException) {
                nameException.printStackTrace();
                return false;
            }
        }else return true;
    }

    static public boolean checkAge(String age){
        if(age.matches("\\d{1,3}")){
            int val=Integer.parseInt(age);
            return val >= 0 && val <= 100;
        }
        return false;
    }
    public static boolean isContainDigit(String name){
        for(int i=0; i<name.length(); i++){
            if(Character.isDigit(name.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
