import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.ResultSet;

import net.proteanit.sql.DbUtils;

public class MainPage extends JFrame {
    private JPanel panel2;
    private JTable table1;
    private JButton refreshButton;

    public MainPage() {
        add(panel2);
        setSize(800, 600);
        setTitle(Main.Host+":"+Main.PortN+"@"+Main.UserN+"|"+Main.TableN);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ResultSet rs = Main.QueryDB();
                table1.setModel(DbUtils.resultSetToTableModel(rs));
            }
        });

    }
}
