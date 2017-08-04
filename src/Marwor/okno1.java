package Marwor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class okno1 {
    private JPanel MainWindow;
    private JTextField textFieldHeight;
    private JTextField textFieldLength;
    private JTextField textFieldAngle;
    private JButton buttonCounting;
    private JPanel Workspace;
    private JLabel heightLabel;
    private JLabel lengthLabel;
    private JLabel angleLabel;
    private JLabel percentLabel;
    private JTextField textFieldPercent;
    private JLabel heightUnit;
    private JLabel lengthUnit;
    private JLabel angleUnit;
    private JLabel percentUnit;
    private JButton buttonReset;
    private JLabel welcomeLabel;

    public okno1() {
        buttonCounting.addActionListener(new ActionListener() {
            String height;
            String length;
            String angle;
            String percent;
            double convert;//zmienna sluzaca do konnwersjki wewnatrz if z double na string
            CoutingClass count;
            @Override
            public void actionPerformed(ActionEvent e) {
                height = textFieldHeight.getText();
                length = textFieldLength.getText();
                angle = textFieldAngle.getText();
                percent = textFieldPercent.getText();
                count=new CoutingClass(height, length, angle, percent);
                if(count.EnoughData()==false){
                    JOptionPane.showMessageDialog(null, "We need more data to count something");
                }
                else{
                        convert=count.CountingHeight();
                        textFieldHeight.setText(Double.toString(convert));
                        convert=count.CountingLength();
                        textFieldLength.setText(Double.toString(convert));
                        convert=count.CountingAngle();
                        textFieldAngle.setText(Double.toString(convert));
                        convert=count.CountingPercent();
                        textFieldPercent.setText(Double.toString(convert));

                }
            }
        });
        buttonReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldAngle.setText("");
                textFieldHeight.setText("");
                textFieldLength.setText("");
                textFieldPercent.setText("");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("okno1");
        frame.setContentPane(new okno1().MainWindow);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);




    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
