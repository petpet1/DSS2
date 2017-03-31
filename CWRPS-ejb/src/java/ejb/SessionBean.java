package ejb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 *
 * @author petter
 */
@Stateless
public class SessionBean implements SessionBeanRemote {
    Connection conn;
    PreparedStatement pst;
        
    @Override
    public boolean isOpponentReady() {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/CW", "dbuser", "dbuser");
            pst = conn.prepareStatement("Select * from APP.PLAYER");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                if(!rs.getBoolean("READY"))
                    return false;
            }
            return true;
        } 
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    @Override
    public boolean login(String username, String password) {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/CW", "dbuser", "dbuser");
            pst = conn.prepareStatement("Select * from APP.PLAYER where username=? and password=?");
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                // Mark user as ready
                pst = conn.prepareStatement("UPDATE APP.PLAYER SET READY = ? WHERE USERNAME = ?");
                pst.setString(1, "true");
                pst.setString(2, username);
                pst.executeUpdate();
                return true;
            }
        } 
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
        
    }
    
    @Override
    public void updateScore(String username, int currentScore) {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/CW", "dbuser", "dbuser");
            pst = conn.prepareStatement("UPDATE APP.PLAYER SET SCORE = ? WHERE USERNAME = ?");
            
            currentScore += 1;
            pst.setInt(1, currentScore);
            pst.setString(2, username);
            int rs = pst.executeUpdate();
        } 
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public int getUserScore(String username) {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/CW", "dbuser", "dbuser");
            pst = conn.prepareStatement("SELECT * FROM APP.PLAYER WHERE USERNAME='"+ username+"'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getInt("SCORE");
            }
        } 
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    @Override
    public void makeMove(String username, String m) {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/CW", "dbuser", "dbuser");
            pst = conn.prepareStatement("UPDATE APP.PLAYER SET MOVE = ? WHERE USERNAME = ?");
            
            pst.setString(1, m);
            pst.setString(2, username);
            int rs = pst.executeUpdate();  
        } 
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public String getMove(String username) {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/CW", "dbuser", "dbuser");
            pst = conn.prepareStatement("Select * from APP.PLAYER where username=?");
            pst.setString(1, username);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getString("MOVE");
            }
        } 
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return "No move";
    }
}
