/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Database.Database;
import Models.NurseInfo;
import Models.ShiftInfo;
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
public class NurseList extends HttpServlet {

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
        Database db = new Database();
        String Ok = request.getParameter("Selected_ Nurse");
        String index = request.getParameter("Select");
        if(Ok.equals("Ok")){
           ArrayList<ShiftInfo> ShiftList = new ArrayList<>();
           ShiftList = db.ShiftList();
           ArrayList<NurseInfo> NurseList = new ArrayList<>();
           NurseList = db.NurseList();
           HttpSession session = request.getSession();
           session.setAttribute("ShiftList", ShiftList);
           session.setAttribute("NurseName", NurseList.get(Integer.valueOf(index)).getnname());
           session.setAttribute("NurseID", NurseList.get(Integer.valueOf(index)).getnid());
           String roomNo = request.getParameter("RoomNo");
           String SeatNo = request.getParameter("SeatNo");
           session.setAttribute("room_No", roomNo);
           session.setAttribute("seat_No",SeatNo);
           System.out.println(NurseList.get(Integer.valueOf(index)).getnname());
           RequestDispatcher rd = request.getRequestDispatcher("ShiftList.jsp");
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
