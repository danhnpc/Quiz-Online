/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package danhnpc.servlets;

import danhnpc.tblanswercontent.TblAnswerContentDAO;
import danhnpc.tblanswercontent.TblAnswerContentDTO;
import danhnpc.tblquiz.TblQuizDAO;
import danhnpc.tblquiz.TblQuizDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
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
@WebServlet(name = "SearchQuestionServlet", urlPatterns = {"/SearchQuestionServlet"})
public class SearchQuestionServlet extends HttpServlet {

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
        String url = SEARCH_PAGE;
        try {
            String searchValue = request.getParameter("txtSearchQuestion");
            String status = request.getParameter("txtStatus");
            boolean active = false;
            if (status.equalsIgnoreCase("true")) {
                active = true;
            }
            String subject = request.getParameter("txtSubject");
            TblQuizDAO dao = new TblQuizDAO();
            dao.searchQuestion(searchValue, active, subject);
            List<TblQuizDTO> list = dao.getListQuestion();
            if (list != null) {
                request.setAttribute("SEARCHQUESTION", list);
                TblAnswerContentDAO ac = new TblAnswerContentDAO();
                for (TblQuizDTO dto : list) {
                    ac.AnswerContent(dto.getAnswerContentID());
                }
                List<TblAnswerContentDTO> listAnswerContent = ac.getAnswer();
                request.setAttribute("ANSWERCONTENTSEARCH", listAnswerContent);
            }
            
        } catch (NamingException ex) {
            log("SearchQuestionServlet_NamingException: " + ex.getMessage());
        } catch (SQLException ex) {
            log("SearchQuestionServlet_SQLException: " + ex.getMessage());
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
