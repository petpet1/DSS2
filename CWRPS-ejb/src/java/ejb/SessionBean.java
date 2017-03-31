package ejb;

import javax.ejb.Stateless;

/**
 *
 * @author petter
 */
@Stateless
public class SessionBean implements SessionBeanRemote {
    String move;
    String oppMove;
    int playersReady = 0;
    
    public boolean ready() {
        return true;
    }
    
    @Override
    public String sendName(String name) {
        return "Welcome " + name;
    }
    
    @Override
    public boolean login(String username, String password) {
        return true;
    }
    
    @Override
    public int getUserScore(String username) {
        return 2;
    }
    
    @Override
    public void makeMove(String username, String m) {
        if(username.equals("UserA")) {
            move = m;
        } else {
            oppMove = m;
        }
    }
    
    @Override
    public String getOppMove() {
        return oppMove;
    }
    
    @Override
    public String getMove() {
        return move;
    }
}
