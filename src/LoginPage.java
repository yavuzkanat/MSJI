import org.w3c.dom.html.HTMLIsIndexElement;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JFrame {
    private JButton logInButton;
    private JTextField DBNameField;
    private JTextField TableNameField;
    private JTextField HostField;
    private JTextField userName;
    private JPasswordField passwordField1;
    private JTextField PortField;
    private JPanel Panel1;

    public LoginPage() {
        add(Panel1);
        setTitle("Login Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(500, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //get user Creditinals
                String Host = HostField.getText().trim();
                String UserName = userName.getText().trim();
                String Password = String.valueOf(passwordField1.getPassword());
                String DBName = DBNameField.getText().trim();
                String TableName = TableNameField.getText().trim();
                Main.Host = Host;
                Main.UserN = UserName;
                Main.Password = Password;
                Main.databaseN = DBName;
                Main.TableN = TableName;
                Main.PortN = PortField.getText().trim();

                try{
                    Main.ConnectionDB();
                    JOptionPane.showMessageDialog(null, "Login Successful");
                    dispose();
                    MainPage mainPage = new MainPage();
                    mainPage.setVisible(true);
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }



            }
        });
    }
}
