/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Database.Database;
import Models.TestInfo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
public class Diagnostic_Control extends HttpServlet {

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
        String Ok = request.getParameter("Selected_Patient");
        String name = request.getParameter("Select");
        Database db = new Database();
        if(Ok.equals("Create Test")){
            HttpSession session = request.getSession();
            session.setAttribute("aid",db.PatientList().get(Integer.valueOf(name)).getaid());
            session.setAttribute("pname",db.PatientList().get(Integer.valueOf(name)).getpname());
            RequestDispatcher rd = request.getRequestDispatcher("Create_an_test.jsp");
            rd.forward(request, response);
        }
        else if(Ok.equals("Create Report")){
            HttpSession session = request.getSession();
            session.setAttribute("aid",db.PatientList().get(Integer.valueOf(name)).getaid());
            session.setAttribute("pname",db.PatientList().get(Integer.valueOf(name)).getpname());
            
            ArrayList<TestInfo>test = new ArrayList<>();
            test = db.test_for_patient(db.PatientList().get(Integer.valueOf(name)).getaid());
            System.out.println(test.size());
            session.setAttribute("test", test);
            if(test.size()>0){
                RequestDispatcher rd = request.getRequestDispatcher("Test_List.jsp");
                rd.forward(request, response);
            }
            else{
               RequestDispatcher rd = request.getRequestDispatcher("Error_Page.jsp");
                rd.forward(request, response); 
            }
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
