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

/**
 *
 * @author user
 */
public class Update_Patient_Doctor extends HttpServlet {

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
        String p_doc_name = request.getParameter("Prev_Doctor");
        int index = Integer.valueOf(request.getParameter("Select"));
        Database db = new Database();
        String n_doc_name = db.DoctorList().get(index).getdname();
        String n_doc_id = db.DoctorList().get(index).getdeid();
        String p_doc_id = request.getParameter("Prev_Doctor_Id");
        System.out.println(p_doc_id);
        String Update = request.getParameter("Selected_Doctor");
        String dfee = db.dfee(p_doc_id);
        System.out.println(n_doc_name);
        System.out.println(p_doc_name);
        System.out.println(p_doc_id);
        System.out.println(n_doc_id);
        System.out.println(dfee);
        if(Update.equals("Update")){
            HttpSession session = request.getSession();
            session.setAttribute("p_doc_name", p_doc_name);
            session.setAttribute("n_doc_name", n_doc_name);
            session.setAttribute("p_doc_id", p_doc_id);
            session.setAttribute("n_doc_id", n_doc_id);
            session.setAttribute("p_doc_fee", dfee);
            session.setAttribute("Update", Update);
            RequestDispatcher rd = request.getRequestDispatcher("Update_Doc_Fee.jsp");
            rd.forward(request, response);
        }
        else if(Update.equals("Add")){
            HttpSession session = request.getSession();
            session.setAttribute("p_doc_name", p_doc_name);
            session.setAttribute("n_doc_name", n_doc_name);
            session.setAttribute("p_doc_id", p_doc_id);
            session.setAttribute("n_doc_id", n_doc_id);
            session.setAttribute("p_doc_fee", dfee);
            session.setAttribute("Update", Update);
            RequestDispatcher rd = request.getRequestDispatcher("Update_Doc_Fee.jsp");
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
