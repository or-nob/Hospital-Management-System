/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Database.Database;
import Models.Date_Change;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author user
 */
public class Doctor_Info_Update_Control extends HttpServlet {

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
        String Ok = request.getParameter("select");
        Database db = new Database();
        if(Ok.equals("Update")){
            String eid = request.getParameter("eid");
            String name = request.getParameter("dname");
            String phone = request.getParameter("dphone");
            String email = request.getParameter("demail");
            String dob = request.getParameter("dob");
            String dot = request.getParameter("dot");
            String degree = request.getParameter("degree");
            String institute = request.getParameter("dinstitute");
            String sex = request.getParameter("dsex");
            String address = request.getParameter("daddress");
            System.out.println(eid);
            System.out.println(name);
            System.out.println(phone);
            System.out.println(email);
            System.out.println(dob);
            System.out.println(dot);
            System.out.println(degree);
            System.out.println(institute);
            System.out.println(sex);
            System.out.println(address);
            Date_Change ndob = new Date_Change(dob);
            Date_Change ndot = new Date_Change(dot);
            String newdob = ndob.update_date();
            String newdot = ndot.update_date();
            db.update_doc_info(eid, name, phone, email, sex, newdob, newdot, address, degree, institute);
            HttpSession session = request.getSession();
            session.setAttribute("DocList", db.DoctorList());
            //make a success page
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
