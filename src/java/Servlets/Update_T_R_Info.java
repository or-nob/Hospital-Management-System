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
public class Update_T_R_Info extends HttpServlet {

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
        String select = request.getParameter("Selected_Test");
        String index = request.getParameter("Select");
        String aid = request.getParameter("aid");
        String pname = request.getParameter("pname");
        String Ok = request.getParameter("Selected_Test");
        Database db = new Database();
        ArrayList<TestInfo> TestList = db.test_for_patient(aid);
        TestInfo obj = TestList.get(Integer.valueOf(index));
        String tt_name = TestList.get(Integer.valueOf(index)).gettt_name();
        String dt_id = TestList.get(Integer.valueOf(index)).gettestid();
        if(select.equals("See Test Info & Update")){
             HttpSession session = request.getSession();
             session.setAttribute("pt_name", pname);
             session.setAttribute("a_id", aid);
             session.setAttribute("test_name", TestList.get(Integer.valueOf(index)).gettt_name());
             session.setAttribute("d_test_ID", TestList.get(Integer.valueOf(index)).gettestid());
             String s = Integer.toString(obj.gettestfee());
             session.setAttribute("d_test_fee",s);
             session.setAttribute("test_name", obj.gettt_name());
             session.setAttribute("test_day",obj.gettestday());
             String s1 = Integer.toString(db.getttprice(dt_id).geti());
             session.setAttribute("test_fee",s1);
             session.setAttribute("tt_id", db.getttprice(dt_id).gets());
             RequestDispatcher rd = request.getRequestDispatcher("Test_Info_Update.jsp");
             rd.forward(request, response);
        }
        else if(select.equals("See Report List & Update")){
            HttpSession session = request.getSession();
            session.setAttribute("pt_name", pname);
            session.setAttribute("a_id", aid);
            session.setAttribute("test_name", TestList.get(Integer.valueOf(index)).gettt_name());
            session.setAttribute("d_test_ID", TestList.get(Integer.valueOf(index)).gettestid());
            String r_desc = db.report_descrpition(TestList.get(Integer.valueOf(index)).gettestid());
            session.setAttribute("r_desc", r_desc);
            RequestDispatcher rd = request.getRequestDispatcher("Update_Report.jsp");
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
