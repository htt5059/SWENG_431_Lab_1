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

    public Lab1GUI() throws NameException {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.setTitle("Lab 1 GUI");
        this.pack();
        doneButton.setEnabled(false);
        InputVerifier iv= new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                JTextField jtf= (JTextField) input;
                int age=Integer.parseInt(jtf.getText());
                if(age<0||age>100) return false;
                return true;
            }
        };

        InputVerifier iv2 = new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                JTextField jtf= (JTextField) input;
                String s=jtf.getText();
                if(!s.matches("[A-Za-z\\s\\d,-]*")){
                    return false;
                }else if(!isContainDigit(s)){
                    return false;
                }else {
                    return true;
                }
            }
        };

        textField1.setInputVerifier(iv);
        String age= textField1.getText();
        textField2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                String name = textField2.getText();
                if(name.length()<0||name.length()>15){
                    try {
                        throw new NameException("Length Exceed");
                    } catch (NameException nameException) {
                        nameException.printStackTrace();
                        doneButton.setEnabled(false);
                    }
                }else if(!name.matches("[A-Za-z\\s\\d,-]*")){
                    try {
                        throw new NameException("Special Characters Exist");
                    } catch (NameException nameException) {
                        nameException.printStackTrace();
                        doneButton.setEnabled(false);
                    }
                }else if(!isContainDigit(name)){
                    try {
                        throw new NameException("Digits Exist");
                    } catch (NameException nameException) {
                        nameException.printStackTrace();
                        doneButton.setEnabled(false);
                    }
                }else {
                    doneButton.setEnabled(true);
                }
            }
        });
    }
    public static boolean isContainDigit(String name){
        for(int i=0; i<name.length(); i++){
            if(Character.isDigit(name.charAt(i))){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws NameException {
        JFrame frame = new Lab1GUI();
        frame.setSize(728, 215);
        frame.setVisible(true);

    }
}

class Utility{
    static public boolean checkName(String name) throws NameException {
        if(name.matches("[A-Za-z\\s\\D,-]{1,15}")){
            if(name.length()<0||name.length()>15){
                throw new NameException("Length Exceed");
            }else if(name.matches("[^A-Za-z\\s\\d,-]")){
                throw new NameException("Special Characters Exist");
            }else if(!Lab1GUI.isContainDigit(name)){
                throw new NameException("Digits Exist");
            }else {
                return true;
            }
        }
        else return false;
    }

    static public boolean checkAge(String age){
        if(age.matches("\\d{1,3}")){
            int val=Integer.parseInt(age);
            if(val>=0 && val<=100) return true;
            else return false;
        }
        return false;
    }
}
