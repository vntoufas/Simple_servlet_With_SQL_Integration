import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Billy
 */
//@WebServlet("/ServletNewTest")
public class ServletNewTest extends HttpServlet {

	
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws SQLException 
     */
    
        
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        //String first, second;
        String name, surname ,age;
        
        response.setContentType("text/html;charset=UTF-8");
        
        name = request.getParameter("name");
        surname = request.getParameter("surname");
        age = request.getParameter("age");
        //am=Integer.parseInt(first);
        //name=Integer.parseInt(second);
        //fir=5;
        //sec=2;
        
        
        try (PrintWriter out = response.getWriter()) {
        
        	DatabaseActions dbActions = new DatabaseActions();
        	dbActions.InsertToDB(name,surname,age);
            String results = dbActions.SelectAllFromDB();
            
            
            //System.out.println("Printing results from servlet "+results );
          
            // / TODO output your page here. You may use following sample code. /
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Html, Servlet, SQL & back Sample</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h5>Simple Servlet example with Database Coonection and queries</h5>");
            //out.println("<p>Result of addition is: "+r + "<p>");
            out.println("<p>Results are: \n"+results+"</p>");
            out.println("</body>");
            out.println("</html>");
      
        }
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
        //out.println(res);
        try {
			processRequest(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
        try {
			processRequest(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        
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
