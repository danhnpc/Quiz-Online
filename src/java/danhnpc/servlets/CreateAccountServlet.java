/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package danhnpc.servlets;

import danhnpc.tblusers.CreateAccountError;
import danhnpc.tblusers.TblUsersDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "CreateAccountServlet", urlPatterns = {"/CreateAccountServlet"})
public class CreateAccountServlet extends HttpServlet {
    private final String ERROR = "createAccount.jsp";
    private final String LOGIN_PAGE = "login.html";
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
        CreateAccountError error = new CreateAccountError();
        String url = ERROR;
        try {
            String userId = request.getParameter("txtUserID");
            String password = request.getParameter("txtPassword");
            String confirm = request.getParameter("txtConfirm");
            String fullName = request.getParameter("txtFullName");
            boolean err = false;
            if(userId.trim().length() < 2 || userId.trim().length() > 20){
                error.setUserIdLengthErr("User ID must be 2 - 20 chars");
                err = true;
            }
            if(password.trim().length() < 2 || password.trim().length() > 30){
                error.setPasswordLengthErr("Password must be 2 - 30 chars");
                err = true;
            }else if(!confirm.trim().equals(password.trim())){
                error.setConfirmPasswordErr("Password is not matched");
                err = true;
            }
            if(fullName.trim().length() < 5 || fullName.trim().length() > 40){
                error.setFullNameLengthErr("Full name must be 5 - 40 chars");
                err = true;
            }
            if(err){
                request.setAttribute("CREATEERROR", error);
            }else{
                TblUsersDAO dao = new TblUsersDAO();
                boolean result = dao.createAccount(userId, password, fullName, false, true);
                if(result){
                    url = LOGIN_PAGE;
                }
            }
        } catch (SQLException ex) {
            String err = ex.getMessage();
            if(err.contains("duplicate")){
                error.setDuplicateUserIdErr("UserID is existed");
                request.setAttribute("CREATEERROR", error);
            }
        } catch (NamingException ex) {
            log("CreateAccountServlet_NamingException: " + ex.getMessage());
        }finally{
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
            out.close();
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
