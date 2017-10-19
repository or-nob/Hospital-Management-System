/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Database.Database;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
public class Update_Doctor_Control extends HttpServlet {

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
        String p_id = request.getParameter("pid");
        String a_id = request.getParameter("aid");
        String p_doc_name = request.getParameter("p_doc_name");
        String n_doc_name = request.getParameter("n_doc_name");
        String p_doc_id = request.getParameter("p_doc_id");
        String n_doc_id = request.getParameter("n_doc_id");
        String p_doc_fee = request.getParameter("p_doc_fee");
        int fee = Integer.valueOf(p_doc_fee);
        String select = request.getParameter("Update");
        String select1 = request.getParameter("Update1");
        Database db = new Database();
        System.out.print("naf");
        System.out.print(n_doc_id);
        System.out.print(a_id);
        System.out.print(fee);
        if(select.equals("Update")&&select1.equals("Update")){
            System.out.print(n_doc_id);
            System.out.print(a_id);
            System.out.print(fee);
            db.update_doc_all(n_doc_id, a_id, fee);
        }
        else if(select.equals("Update")&&select1.equals("Add")){
            db.insert_new_doc(n_doc_id, a_id, fee);
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
