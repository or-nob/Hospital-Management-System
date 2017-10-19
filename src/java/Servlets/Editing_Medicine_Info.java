/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Database.Database;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.jboss.weld.context.http.Http;

/**
 *
 * @author user
 */
public class Editing_Medicine_Info extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String select = request.getParameter("Medicine");
        String idx = request.getParameter("Select");
        int index = Integer.valueOf(idx);
        String aid = request.getParameter("a_id");
        String pname = request.getParameter("pt_name");
        Database db = new Database();
        if(select.equals("Update")){
            HttpSession session = request.getSession();
            session.setAttribute("gname",db.medicine_for_patient(aid).get(index).getgname());
            session.setAttribute("gmid",db.medicine_for_patient(aid).get(index).getmid());
            session.setAttribute("mname",db.medicine_for_patient(aid).get(index).getmname());
            String mprice = Integer.toString(db.medicine_for_patient(aid).get(index).getmprice());
            session.setAttribute("mprice",mprice);
            String mquantity = Integer.toString(db.medicine_for_patient(aid).get(index).getquantity());
            session.setAttribute("quantity",mquantity);
            session.setAttribute("pname", pname);
            session.setAttribute("aid", aid);
            RequestDispatcher rd = request.getRequestDispatcher("Update_Medicine.jsp");
            rd.forward(request, response); 
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
