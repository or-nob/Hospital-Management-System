/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Database.Database;
import Models.ShiftInfo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
public class Allocating_Nurse extends HttpServlet {

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
        String Ok = request.getParameter("Selected_Shift");
        String index = request.getParameter("Select");
        String al_date = request.getParameter("All_date");
        String rel_date = request.getParameter("Rel_date");
        Database db = new Database();
        if(Ok.equals("Ok")){
            ArrayList<ShiftInfo> ShiftList = new ArrayList<>();
            ShiftList = db.ShiftList();
            String Shift_ID = ShiftList.get(Integer.valueOf(index)).getShiftId();
            String roomNo = request.getParameter("RoomNo");
            String N_ID = request.getParameter("NurseID");
            System.out.println(roomNo);
            System.out.println(Shift_ID);
            System.out.println(al_date);
            System.out.println(rel_date);
            System.out.println(N_ID);
            Random r = new Random();
            int a_id = r.nextInt(1000);
            String all_id = Integer.toString(a_id);
            db.nurse_allocation(all_id, al_date, rel_date, Shift_ID, roomNo, N_ID);
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
