/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package danhnpc.servlets;

import danhnpc.tblanswercontent.TblAnswerContentDAO;
import danhnpc.tblquiz.TblQuizCreateError;
import danhnpc.tblquiz.TblQuizDAO;
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
@WebServlet(name = "ConfirmUpdateServlet", urlPatterns = {"/ConfirmUpdateServlet"})
public class ConfirmUpdateServlet extends HttpServlet {
    private final String ERROR = "updateQuestion.jsp";
    private final String SEARCH_PAGE = "searchQuestion.jsp";
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
        TblQuizCreateError error = new TblQuizCreateError();
        try {
            String id = request.getParameter("txtID");
            String question = request.getParameter("txtQuestion");
            String answerA = request.getParameter("txtA");
            String answerB = request.getParameter("txtB");
            String answerC = request.getParameter("txtC");
            String answerD = request.getParameter("txtD");
            String answerCorrect = request.getParameter("txtAnswerCorrect");
            String subject = request.getParameter("txtSubject");
            boolean errFound = false;

            if (question.trim().length() == 0) {
                error.setNameLengthErr("Question is not empty");
                errFound = true;
            }
            if (answerA.trim().length() == 0) {
                error.setAnswerALengthErr("Answer is not empty");
                errFound = true;
            }
            if (answerB.trim().length() == 0) {
                error.setAnswerBLengthErr("Answer is not empty");
                errFound = true;
            }
            if (answerC.trim().length() == 0) {
                error.setAnswerCLengthErr("Answer is not empty");
                errFound = true;
            }
            if (answerD.trim().length() == 0) {
                error.setAnswerDLengthErr("Answer is not empty");
                errFound = true;
            }
            if (answerCorrect.trim().length() == 0) {
                error.setAnswerCorrectLengthErr("Answer correct is not empty");
                errFound = true;
            }
            if (errFound) {
                request.setAttribute("UPDATEERROR", error);
            } else {
                TblQuizDAO dao = new TblQuizDAO();
                boolean result = dao.updateQuestion(id, question, answerCorrect, subject);
                if (result) {
                    TblAnswerContentDAO ac = new TblAnswerContentDAO();
                    boolean result2 = ac.updateAnswerContent("Q" + id, answerA, answerB, answerC, answerD);
                    url = SEARCH_PAGE;
                }
            }

        } catch (NamingException ex) {
            log("ConfirmUpdateServlet_NamingException: " + ex.getMessage());
        } catch (SQLException ex) {
            log("ConfirmUpdateServlet_SQLException: " + ex.getMessage());
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
