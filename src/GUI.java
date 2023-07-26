import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {

        public void createGUI() {
                JFrame frame = new JFrame("Password Generator");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));
                frame.setResizable(false);

                ImageIcon image = new ImageIcon("password.png");
                frame.setIconImage(image.getImage());

                frame.getContentPane().setBackground(Color.BLACK);

                JPanel panel1 = new JPanel();
                panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
                panel1.setBackground(new Color(0, 0, 0, 0));
                JLabel title = new JLabel("PASSWORD GENERATOR");
                title.setFont(new Font("Courier New", Font.BOLD, 40));
                title.setForeground(Color.WHITE);
                title.setOpaque(true);
                title.setBackground(new Color(0, 0, 0));
                panel1.add(title);

                JPanel panel2 = new JPanel();
                panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
                panel2.setBackground(new Color(0, 0, 0, 0));
                JLabel label1 = new JLabel("Generate a safe password with just one click!");
                label1.setFont(new Font("Courier New", Font.PLAIN, 20));
                label1.setForeground(Color.WHITE);
                label1.setOpaque(true);
                label1.setBackground(new Color(0, 0, 0));
                panel2.add(label1);

                JPanel panel3 = new JPanel();
                panel3.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 30));
                panel3.setBackground(new Color(0, 0, 0, 0));
                JLabel label2 = new JLabel("Pick how long you want the password to be ");
                label2.setFont(new Font("Courier New", Font.PLAIN, 20));
                label2.setForeground(Color.WHITE);
                label2.setOpaque(true);
                label2.setBackground(new Color(0, 0, 0));

                SpinnerModel spinnerModel = new SpinnerNumberModel(8, 0, 100, 1);
                JSpinner spinner = new JSpinner(spinnerModel);
                Dimension spinnerSize = new Dimension(100, 30);
                spinner.setPreferredSize(spinnerSize);

                panel3.add(label2);
                panel3.add(spinner);

                JButton generateButton = new JButton("Generate");
                JTextField passwordField = new JTextField(20);
                passwordField.setEditable(false);
                passwordField.setBackground(Color.WHITE);

                generateButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                int selectedValue = (int) spinner.getValue();
                                PasswordGenerator pg = new PasswordGenerator();
                                String generatedPassword = pg.generatePassword(selectedValue);
                                passwordField.setText(generatedPassword);
                        }
                });

                frame.add(panel1);
                frame.add(panel2);
                frame.add(panel3);
                frame.add(generateButton);
                frame.add(passwordField);

                frame.setSize(640, 640);
                frame.setVisible(true);
        }

        public static void main(String[] args) {
                GUI gui = new GUI();
                gui.createGUI();
        }
}
