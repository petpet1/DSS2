package ejb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.ejb.Stateful;

/**
 *
 * @author petter
 */
@Stateful
public class SessionBean implements SessionBeanRemote {
    private static String username;
    private static String move;
    private static String oppMove;
    
    @Override
    public boolean login(String username, String password) {
        return true;
    }
    
    @Override
    public int getUserScore(String username) {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/CW", "dbuser", "dbuser");
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM APP.PLAYER WHERE USERNAME='"+ username+"'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getInt("SCORE");
            }
        } 
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return 10;
    }
    
    @Override
    public void makeMove(String username, String m) {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/CW", "dbuser", "dbuser");
            PreparedStatement pst = conn.prepareStatement("UPDATE APP.PLAYER SET MOVE = ? WHERE USERNAME = ?");
            
            pst.setString(1, m);
            pst.setString(2, username);
            int rs = pst.executeUpdate();  
        } 
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public String getMove(String username) {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/CW", "dbuser", "dbuser");
            PreparedStatement pst = conn.prepareStatement("Select * from APP.PLAYER where username=?");
            pst.setString(1, username);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getString("MOVE");
            }
        } 
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return "No move";
    }
}
