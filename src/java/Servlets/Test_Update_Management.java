/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Database.Database;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
public class Test_Update_Management extends HttpServlet {

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
        String Ok = request.getParameter("Updated_Info");
        Database db = new Database();
        if(Ok.equals("Update")){
            String name = request.getParameter("ttname");
            String date = request.getParameter("tday");
            String o_fee = request.getParameter("tfee");
            int ori_fee = Integer.valueOf(o_fee);
            String r_fee = request.getParameter("tredfee");
            int red_fee = Integer.valueOf(r_fee);
            String t_id = request.getParameter("tid");
            String tt_id = request.getParameter("ttid");
            String[] S = date.split("-");
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
            System.out.println(tt_id);
            System.out.println(name);
            System.out.println(ori_fee);
            System.out.println(newd);
            System.out.println(t_id);
            System.out.println(red_fee);
            db.updateTestInfo(tt_id, name, ori_fee, newd, t_id, red_fee);
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
