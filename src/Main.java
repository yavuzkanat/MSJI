import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static String Host;
    public static String UserN;
    public static String Password;
    public static String PortN ;
    public static String databaseN;
    public static String TableN;
    public static void main(String[] args) {
        LoginPage loginPage = new LoginPage();
        loginPage.setVisible(true);

    }
    // Connection DATABASE
    public static Connection ConnectionDB() throws  Exception{

        Connection conn = null;
        String url = "jdbc:mysql://"+Host+":"+PortN+"/"+databaseN;
        Connection tryCon = DriverManager.getConnection(url, UserN, Password);
        if(tryCon != null) {
            conn = tryCon;
        }else{
            throw new SQLException("Could not connect to database");
        }
        return conn;
    }public static ResultSet QueryDB() {
        ResultSet rs = null;
         try {
             Connection conn = ConnectionDB();
             PreparedStatement ps = conn.prepareStatement("select * from "+TableN);
             ResultSet rSet = ps.executeQuery();
             rs = rSet;

         } catch (Exception e) {
             throw new RuntimeException(e);
         }
         return rs;


    }

}