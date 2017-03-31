package web;

import ejb.SessionBeanRemote;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author petter
 */
@WebServlet(name = "Main", urlPatterns = {"/main"})
public class Main extends HttpServlet {

    @EJB
    private SessionBeanRemote sessionBean;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username=request.getParameter("username");
        response.addHeader("username", username);

        String opponent;
        if(username.equals("playerA")){
            opponent = "playerB";
        } else {
            opponent = "playerA";
        }
            
        String move = sessionBean.getMove(username);
        String oppMove = sessionBean.getMove(opponent);
        
        if(oppMove.equals("NULL")) {
            response.addHeader("status", "Your opponent has not picked a move yet");
            request.getRequestDispatcher("game.jsp").forward(request, response);
            return;
        }
        
        String result = getResult(username, oppMove, move);
        
        response.addHeader("OppMove", oppMove);
        response.addHeader("Move", move);
        response.addHeader("Result", result);
        request.getRequestDispatcher("game.jsp").forward(request, response);
    }
    
     private String getResult(String username, String om, String m) { 
        int yourNum = -1;
        int opNum = -1;
        
        if(m.equals("Rock"))
            yourNum = 0;
        if(m.equals("Paper"))
            yourNum = 1;
        if(m.equals("Scissors"))
            yourNum = 2;
        
        if(om.equals("Rock"))
            opNum = 0;
        if(om.equals("Paper"))
            opNum = 1;
        if(om.equals("Scissors"))
            opNum = 2;
        if(yourNum == opNum)
            return "Tie";
        
        if((yourNum) == (opNum+1)%3){
            int currentScore = sessionBean.getUserScore(username);
            sessionBean.updateScore(username, currentScore);
            return "You won!";
        }
        return "You Lost!";
    }
     
   // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
