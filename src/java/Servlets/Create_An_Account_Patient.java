/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Database.Database;
import Models.DoctorInfo;
import Models.RoomInfo;
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
public class Create_An_Account_Patient extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        
        String Select = request.getParameter("Select");
        /*System.out.println(Select_Room);
        System.out.println(Select_Doctor);*/
        Database db = new Database();
        if(Select.equals("Select Doctor")){
            System.out.print("dffd");
            ArrayList<DoctorInfo> DocList = db.DoctorList();
            HttpSession session = request.getSession();
            session.setAttribute("DocList", DocList);
            
            RequestDispatcher rd = request.getRequestDispatcher("DocList.jsp");
            rd.forward(request, response);
        }
        /*else if(Select.equals("Select Room")){
            System.out.print("dffdr");
            /*ArrayList<DoctorInfo> DocList = db.DoctorList();
            HttpSession session = request.getSession();
            session.setAttribute("DocList", DocList);
            RequestDispatcher rd = request.getRequestDispatcher("DocList.jsp");
            rd.forward(request, response);*/
        //}
        else if(Select.equals("Select Room")){
            System.out.print("llll");
            ArrayList<RoomInfo> RoomList = db.RoomList();
            HttpSession session = request.getSession();
            session.setAttribute("RoomList", RoomList);
            
            RequestDispatcher rd = request.getRequestDispatcher("RoomList.jsp");
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
