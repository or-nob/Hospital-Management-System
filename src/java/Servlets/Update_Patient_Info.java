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
public class Update_Patient_Info extends HttpServlet {

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
        String update = request.getParameter("Select");
        Database db = new Database();
        String doc_name = request.getParameter("doc_name");
        String seat_no = request.getParameter("seat_no");
        String d_id = request.getParameter("doc_eid");
        String aid = request.getParameter("aid");
        if(update.equals("Ok")){
            System.out.println("dhukse");
            String pid = request.getParameter("pid");
            String name = request.getParameter("name");
            String p_no = request.getParameter("phone_no");
            String mail = request.getParameter("mail");
            String sex = request.getParameter("sex");
            String dob = request.getParameter("dob");
            System.out.println(pid);
            System.out.println(name);
            System.out.println(p_no);
            System.out.println(mail);
            System.out.println(sex);
            System.out.println(dob);
            String[] S = dob.split("-");
            String newd = new String();
            if(S[1].equals("01")){
                newd = S[2]+"-"+"jan"+"-"+S[0];
            }
            else if(S[1].equals("02")){
                newd = S[2]+"-"+"feb"+"-"+S[0];
            }
            else if(S[1].equals("03")){
                newd = S[2]+"-"+"mar"+"-"+S[0];
            }
            else if(S[1].equals("04")){
                newd = S[2]+"-"+"apr"+"-"+S[0];
            }
            else if(S[1].equals("05")){
                newd = S[2]+"-"+"may"+"-"+S[0];
            }
            else if(S[1].equals("06")){
                newd = S[2]+"-"+"jun"+"-"+S[0];
            }
            else if(S[1].equals("07")){
                newd = S[2]+"-"+"jul"+"-"+S[0];
            }
            else if(S[1].equals("08")){
                newd = S[2]+"-"+"aug"+"-"+S[0];
            }
            else if(S[1].equals("09")){
                newd = S[2]+"-"+"sep"+"-"+S[0];
            }
            else if(S[1].equals("10")){
                newd = S[2]+"-"+"oct"+"-"+S[0];
            }
            else if(S[1].equals("11")){
                newd = S[2]+"-"+"nov"+"-"+S[0];
            }
            else{
                newd = S[2]+"-"+"dec"+"-"+S[0];
            }
            System.out.println(newd);
            db.updatePatientInfo(pid,name,p_no,mail,sex,newd);
            HttpSession session = request.getSession();
            session.setAttribute("PatientList",db.PatientList());
            RequestDispatcher rd = request.getRequestDispatcher("Patient_List_For_Update.jsp");
            rd.forward(request, response);
        }
        else if(update.equals("Change Seat")){
            ArrayList<RoomInfo> RoomList = db.RoomList();
            HttpSession session = request.getSession();
            session.setAttribute("RoomList", RoomList);
            session.setAttribute("doc_name", doc_name);
            session.setAttribute("seat_no", seat_no);
            session.setAttribute("docid", d_id);
            System.out.print(doc_name);
            System.out.println(seat_no);
            RequestDispatcher rd = request.getRequestDispatcher("RoomList_Update.jsp");
            rd.forward(request, response);
        }
        else if(update.equals("Change Doc")){
            String pid = request.getParameter("pid");
            ArrayList<DoctorInfo> DocList = db.DoctorList();
            HttpSession session = request.getSession();
            session.setAttribute("DocList", DocList);
            session.setAttribute("doc_name", doc_name);
            session.setAttribute("seat_no", seat_no);
            session.setAttribute("docid", d_id);
            session.setAttribute("aid", aid);
            session.setAttribute("pid",pid);
            RequestDispatcher rd = request.getRequestDispatcher("DocList_Update.jsp");
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
