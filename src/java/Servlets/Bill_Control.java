/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Database.Database;
import Models.MedicineInfo;
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
public class Bill_Control extends HttpServlet {

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
        String select = request.getParameter("Selected_Bill");
        String index = request.getParameter("Select");
        Database db = new Database();
        if(select.equals("See Bill")){
            System.out.print(select);
            ArrayList<Integer> R_Bill = db.bill_room(db.PatientList().get(Integer.valueOf(index)).getaid());
            ArrayList<TestInfo> T_Bill = db.test_for_patient(db.PatientList().get(Integer.valueOf(index)).getaid());
            ArrayList<MedicineInfo> M_Bill = db.medicine_for_patient(db.PatientList().get(Integer.valueOf(index)).getaid());
            ArrayList<Integer> D_Bill = db.bill_doctor(db.PatientList().get(Integer.valueOf(index)).getaid());
            
            int total_bill = 0;
            for(int i = 0; i < R_Bill.size(); i++){
                total_bill+=R_Bill.get(i);
            }
            
            for(int i = 0; i < D_Bill.size(); i++){
                total_bill+=D_Bill.get(i);
            }
            
            for(int i = 0; i < M_Bill.size(); i++){
                total_bill+=(M_Bill.get(i).getmprice()*M_Bill.get(i).getquantity());
            }
            
            for(int i = 0; i < T_Bill.size(); i++){
                total_bill+=(T_Bill.get(i).gettestfee());
            }
            
            String t_bill = Integer.toString(total_bill);
            
            HttpSession session = request.getSession();
            session.setAttribute("R_Bill", R_Bill);
            session.setAttribute("T_Bill", T_Bill);
            session.setAttribute("M_Bill", M_Bill);
            session.setAttribute("D_Bill", D_Bill);
            session.setAttribute("TotalBill", t_bill);
            session.setAttribute("pname", db.PatientList().get(Integer.valueOf(index)).getpname());
            session.setAttribute("a_id", db.PatientList().get(Integer.valueOf(index)).getaid());
            RequestDispatcher rd = request.getRequestDispatcher("Total_Bill.jsp");
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
