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
import danhnpc.tblsubject.TblSubjectDAO;
import danhnpc.tblsubject.TblSubjectDTO;
import danhnpc.tblusers.TblUsersDAO;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author visug
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    
    private final String QUIZ_PAGE = "selectQuiz.jsp";
    private final String SEARCH_PAGE = "searchQuestion.jsp";
    private final String INVALID_PAGE = "invalid.html";

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
        String url = INVALID_PAGE;
        try {
            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");
            TblUsersDAO dao = new TblUsersDAO();
            boolean result = dao.checkLogin(username, password);
            if (result) {
                String fullName = dao.getFullName();
                boolean admin = dao.isRole();
                HttpSession session = request.getSession();
                session.setAttribute("FULLNAME", fullName);
                
                TblSubjectDAO sub = new TblSubjectDAO();
                sub.getAllSubject();
                List<TblSubjectDTO> subject = sub.getSubject();
                session.setAttribute("SUBJECT", subject);
                
                TblQuizDAO quiz = new TblQuizDAO();
                quiz.list20Question();
                List<TblQuizDTO> home = quiz.getHome();
                request.setAttribute("SEARCHQUESTION", home);
                
                
                TblAnswerContentDAO ac = new TblAnswerContentDAO();
                for(TblQuizDTO dto : home){
                    ac.AnswerContent(dto.getAnswerContentID());
                }
                List<TblAnswerContentDTO> listAc = ac.getAnswer();
                request.setAttribute("ANSWERCONTENTSEARCH", listAc);
                if(admin){
                    url = SEARCH_PAGE;
                }else{
                    url = QUIZ_PAGE;
                }
                
            }
        } catch (SQLException ex) {
            log("LoginServlet_SQLException: " + ex.getMessage());
        } catch (NamingException ex) {
            log("LoginServlet_NamingException: " + ex.getMessage());
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
