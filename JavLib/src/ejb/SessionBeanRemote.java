/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Remote;

/**
 *
 * @author petter
 */
@Remote
public interface SessionBeanRemote {

    boolean login(String username, String password);

    int getUserScore(String username);
    
    public void makeMove(String username, String m);

    public String getMove(String username);

    public void updateScore(String username, int currentScore);

    public boolean isOpponentReady();
    
}
