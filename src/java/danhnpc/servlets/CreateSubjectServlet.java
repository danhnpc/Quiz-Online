/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package danhnpc.servlets;

import danhnpc.tblsubject.TblSubjectCreateError;
import danhnpc.tblsubject.TblSubjectDAO;
import danhnpc.tblsubject.TblSubjectDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author visug
 */
@WebServlet(name = "CreateSubjectServlet", urlPatterns = {"/CreateSubjectServlet"})
public class CreateSubjectServlet extends HttpServlet {

    private final String ERROR = "createSubject.jsp";
    private final String CREATE_QUESTION_PAGE = "createQuestion.jsp";

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
        String url = ERROR;
        TblSubjectCreateError error = new TblSubjectCreateError();
        try {
            String id = request.getParameter("txtSubjectID");
            String name = request.getParameter("txtSubjectName");
            boolean errFound = false;
            if (id.trim().length() == 0) {
                error.setIdLengthErr("SubjectID is not empty");
                errFound = true;
            }
            if (name.trim().length() == 0) {
                error.setNameLengthErr("Subject name is not empty");
                errFound = true;
            }
            if (errFound) {
                request.setAttribute("SUBJECTERROR", error);
            } else {
                TblSubjectDAO dao = new TblSubjectDAO();
                boolean result = dao.insert(id, name);
                dao.getAllSubject();
                List<TblSubjectDTO> subject = dao.getSubject();
                if (result) {
                    HttpSession session = request.getSession();
                    session.setAttribute("SUBJECT", subject);
                    url = CREATE_QUESTION_PAGE;
                }
            }
        } catch (SQLException ex) {
            String err = ex.getMessage();
            if(err.contains("duplicate")){
                error.setIdDuplicateErr("This subjectID is existed!");
                request.setAttribute("SUBJECTERROR", error);
            }
        } catch (NamingException ex) {
            log("CreateSubjectServlet_NamingException: " + ex.getMessage());
        } finally {
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
