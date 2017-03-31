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

    String sendName(String name);

    boolean login(String username, String password);

    int getUserScore(String username);

    public String getOppMove();

    public String getMove();

    public void makeMove(String username, String m);
    
}
