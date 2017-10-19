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
public class Patient_Account_Room extends HttpServlet {

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
        String done = request.getParameter("done_patient");
        Database db = new Database();
        if(done.equals("Done")){
            String username = request.getParameter("username");
            Random randomGenerator1 = new Random();
            String p_id = Integer.toString(randomGenerator1.nextInt(1000));
            

            String phone_number = request.getParameter("phone_number");
            String email = request.getParameter("email");

            String sex = request.getParameter("sex");
            String dob = request.getParameter("dob");

            String dot = request.getParameter("dot");
            String address = request.getParameter("address");

            String doctorName = request.getParameter("DocName");
            String e_id = db.EID_Doctor(doctorName);
            
            System.out.println(doctorName);
            
            Random randomGenerator = new Random();
            String a_id = Integer.toString(randomGenerator.nextInt(1000));
            
            String fee = request.getParameter("fee");
            int dfee = Integer.valueOf(fee);
            
            String fee1 = request.getParameter("sfee");
            int sfee = Integer.valueOf(fee1);
            
            String roomNo = request.getParameter("RoomName");
            
            System.out.println(roomNo);
            
            String seatNo = request.getParameter("SeatName");
            
            
            System.out.println(a_id);
            System.out.println(seatNo);
            System.out.println(sfee);
            
            db.createPatientAccount(username, p_id, phone_number, e_id, sex, email, dfee, dob, a_id, dot, address);
            db.createSeatAllocation(a_id, seatNo, dot, "SYSDATE", sfee);
            //
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
