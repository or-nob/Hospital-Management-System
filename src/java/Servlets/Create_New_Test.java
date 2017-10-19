/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Database.Database;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
public class Create_New_Test extends HttpServlet {

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
        String Ok = request.getParameter("Create_Test");
        Database db = new Database();
        if(Ok.equals("Ok")){
            String testname = request.getParameter("testname");
            String test_type = request.getParameter("test_type");
            String test_p = request.getParameter("test_price");
            int test_price = Integer.valueOf(test_p);
            String reduced_c = request.getParameter("reduced_cost");
            int reduced_cost = Integer.valueOf(reduced_c);
            String date = request.getParameter("date");
            String aid = request.getParameter("aid");
            System.out.println(testname);
            System.out.println(test_type);
            System.out.println(test_price);
            System.out.println(reduced_cost);
            System.out.println(aid);
            Random r = new Random();
            String tt_id = Integer.toString(r.nextInt(1000));
            Random r1 = new Random();
            String d_tt_id = Integer.toString(r1.nextInt(1000));
            db.new_test(tt_id, testname, test_price, date, d_tt_id, reduced_cost, aid);
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
