import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import net.proteanit.sql.DbUtils;

public class MainPage extends JFrame {
    private JPanel panel2;
    private JTable table1;
    private JButton refreshButton;
    private JButton deleteButton;

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

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table1.getSelectedRow();
                int column = 0;
                String id = table1.getValueAt(row, column).toString();
                int Sid = Integer.parseInt(id);
                String PkName = null;
                try {
                    ResultSet rs = Main.QueryDB();
                    ResultSetMetaData rsmd = rs.getMetaData();
                    PkName = rsmd.getColumnName(1);
                    Main.DeleteDB(Sid,PkName);
                    JOptionPane.showMessageDialog(MainPage.this, "Deleted row selected");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }

            }
        });
    }
}
