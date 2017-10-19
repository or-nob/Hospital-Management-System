/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Database.Database;
import Models.MedicineInfo;
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
public class Medicine_Control extends HttpServlet {

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
        String select = request.getParameter("Selected_Medicine");
        String index = request.getParameter("Select");
        Database db = new Database();
        if(select.equals("Allocate Medicine")){
            HttpSession session = request.getSession();
            session.setAttribute("Patient_Name", db.PatientList().get(Integer.valueOf(index)).getpname());
            session.setAttribute("A_ID", db.PatientList().get(Integer.valueOf(index)).getaid());
            RequestDispatcher rd = request.getRequestDispatcher("Create_New_Medicine.jsp");
            rd.forward(request, response);
        }
        else if(select.equals("Medicine List")){
            System.out.println(db.PatientList().get(Integer.valueOf(index)).getaid());
            ArrayList<MedicineInfo>test = new ArrayList<>();
            test = db.medicine_for_patient(db.PatientList().get(Integer.valueOf(index)).getaid());
            //System.out.println(test.size());
            HttpSession session = request.getSession();
            session.setAttribute("medicineList", test);
            if(test.size()>0){
                RequestDispatcher rd = request.getRequestDispatcher("Medicine_List.jsp");
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
