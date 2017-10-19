/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Database.Database;
import java.io.IOException;
import java.io.PrintWriter;
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
public class Update_Patient_Seat extends HttpServlet {

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
        String Select = request.getParameter("Selected_Room");
        int index = Integer.valueOf(request.getParameter("Select"));
        String seat_no = request.getParameter("seat_no");
        String aid = request.getParameter("a_id");
        System.out.println(seat_no);
        System.out.println("index:");
        System.out.println(index);
        Database db = new Database();
        String updated_seat_no = db.RoomList().get(index).getseatNo();
        String updated_room_no = db.RoomList().get(index).getroomNo();
        System.out.println(updated_seat_no);
        System.out.println(updated_room_no);
        if(Select.equals("Update")){
            //String aid = db.getallseat(seat_no).getaid();
            String eday = db.getallseat(seat_no).geteday();
            String sday = db.getallseat(seat_no).getsday();
            System.out.println(aid);
            System.out.println(eday);
            System.out.println(sday);
            int co = db.getallseat(seat_no).getcost();
            String cost = Integer.toString(co);
            HttpSession session = request.getSession();
            session.setAttribute("a_id", aid);
            session.setAttribute("sday", sday);
            session.setAttribute("eday", eday);
            session.setAttribute("cost", cost);
            session.setAttribute("u_s_no", updated_seat_no);
            session.setAttribute("u_r_no", updated_room_no);
            System.out.println();
            System.out.println();
            RequestDispatcher rd = request.getRequestDispatcher("Update_Seat_Allocation.jsp");
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
