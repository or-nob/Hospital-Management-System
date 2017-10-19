/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Database.Database;
import Models.MedicineInfo;
import Models.PatientInfo;
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
public class Patient_Update_Control extends HttpServlet {

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
        String click = request.getParameter("Update_Profile");
        int index = Integer.valueOf(request.getParameter("Select"));
        Database db = new Database();
        if(click.equals("See & Update Profile")){
            PatientInfo profile = db.PatientList().get(index);
            HttpSession session = request.getSession();
            session.setAttribute("patientInfo", profile);
            String aid = db.PatientList().get(index).getaid();
            session.setAttribute("SeatNo", db.seatno(aid));
            session.setAttribute("DocName", db.docName(aid));
            session.setAttribute("a_id", aid);
            System.out.println("doc eid");
            System.out.println(db.deid(aid));
            session.setAttribute("DocID", db.deid(aid));
            System.out.println(db.docName(aid));
            RequestDispatcher rd = request.getRequestDispatcher("Patient_Info_List.jsp");
            rd.forward(request, response);
        }
        else if(click.equals("Refresh")){
            ArrayList<PatientInfo> p = db.PatientList();
            HttpSession session = request.getSession();
            session.setAttribute("PatientList", p);
            RequestDispatcher rd = request.getRequestDispatcher("Patient_List_For_Update.jsp");
            rd.forward(request, response);
        }
        else if(click.equals("See & Update Test")){
            HttpSession session = request.getSession();
            session.setAttribute("aid",db.PatientList().get(index).getaid());
            session.setAttribute("pname",db.PatientList().get(index).getpname());
            
            ArrayList<TestInfo>test = new ArrayList<>();
            test = db.test_for_patient(db.PatientList().get(index).getaid());
            System.out.println(test.size());
            session.setAttribute("test", test);
            RequestDispatcher rd = request.getRequestDispatcher("Test_List_For_Update.jsp");
                rd.forward(request, response);
        }
        else if(click.equals("See & Update Medicine")){
            String aid = db.PatientList().get(index).getaid();
            String pname = db.PatientList().get(index).getpname();
            System.out.println("Med");
            HttpSession session = request.getSession();
            session.setAttribute("pt_name", pname);
            session.setAttribute("a_id", aid);
            int idx = Integer.valueOf(index);
            ArrayList<MedicineInfo> temp = new ArrayList<>();
            temp = db.medicine_for_patient(aid);
            session.setAttribute("medicineList", temp);
            RequestDispatcher rd = request.getRequestDispatcher("Medicine_List_Update.jsp");
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
