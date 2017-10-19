/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Database.Database;
import Models.NurseInfo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author user
 */
@WebServlet(name = "LoginPageN", urlPatterns = {"/LoginPageN"})
public class LoginPageN extends HttpServlet {

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
        String create_an_account = request.getParameter("Create_an_Account");
        String username = request.getParameter("username");
        String e_id = request.getParameter("e_ID");
        Database db = new Database();
        boolean exist = db.existNurse(e_id,username);
        System.out.println(create_an_account);
        if(create_an_account!=null && create_an_account.equals("Create an Account")){
            RequestDispatcher rd = request.getRequestDispatcher("Create_Account_Nurse.jsp");
            rd.forward(request, response);
        }
        if(exist){
            ArrayList<NurseInfo> dataN = new ArrayList<>();
             dataN = db.dataretrieveN(e_id,username);
             
             HttpSession session = request.getSession();
             session.setAttribute("nurseInfo", dataN.get(0));
             
             RequestDispatcher rd = request.getRequestDispatcher("Nurse_Info.jsp");
             rd.forward(request, response);
             
        }
        else { 
            RequestDispatcher rd = request.getRequestDispatcher("Login_Nurse.jsp");
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
