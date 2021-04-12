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
import java.sql.Date;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author visug
 */
@WebServlet(name = "CreateQuestionServlet", urlPatterns = {"/CreateQuestionServlet"})
public class CreateQuestionServlet extends HttpServlet {
    private final String ERROR = "createQuestion.jsp";
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
            String id = request.getParameter("txtQuestionID");
            String question = request.getParameter("txtQuestion");
            String answerA = request.getParameter("txtAnswerA");
            String answerB = request.getParameter("txtAnswerB");
            String answerC = request.getParameter("txtAnswerC");
            String answerD = request.getParameter("txtAnswerD");
            String answerContent = "Q" + id;
            String answerCorrect = request.getParameter("txtAnswerCorrect");
            long date = System.currentTimeMillis();
            Date createTime = new Date(date);
            String subject = request.getParameter("txtSubject");
            boolean errFound = false;
            try{
                int idQuestion = Integer.parseInt(id);
            }catch(NumberFormatException ex){
                error.setIdNumberErr("ID must be a integer number");
                errFound = true;
            }
            if(id.trim().length() == 0){
                error.setIdLengthErr("ID is not empty");
                errFound = true;
            }
            if(question.trim().length() == 0){
                error.setNameLengthErr("Question is not empty");
                errFound = true;
            }
            if(answerA.trim().length() == 0){
                error.setAnswerALengthErr("Answer is not empty");
                errFound = true;
            }
            if(answerB.trim().length() == 0){
                error.setAnswerBLengthErr("Answer is not empty");
                errFound = true;
            }
            if(answerC.trim().length() == 0){
                error.setAnswerCLengthErr("Answer is not empty");
                errFound = true;
            }
            if(answerD.trim().length() == 0){
                error.setAnswerDLengthErr("Answer is not empty");
                errFound = true;
            }
            if(answerCorrect.trim().length() == 0){
                error.setAnswerCorrectLengthErr("Answer correct is not empty");
                errFound = true;
            }
            if(errFound){
                request.setAttribute("QUESTIONERROR", error);
            }else{
                TblAnswerContentDAO ac = new TblAnswerContentDAO();
                ac.insertAnswerContent(answerContent, answerA, answerB, answerC, answerD);
                TblQuizDAO dao = new TblQuizDAO();
                boolean result = dao.insertQuestion(id, question, answerContent, answerCorrect, createTime, subject, true);
                if(result){
                    url = SEARCH_PAGE;
                }
            }
        } catch (NamingException ex) {
            log("CreateQuestionServlet_NamingException: " + ex.getMessage());
        } catch (SQLException ex) {
            String err = ex.getMessage();
            if(err.contains("duplicate")){
                error.setIdDuplicateErr("ID is existed!");
                request.setAttribute("QUESTIONERROR", error);
            }
        }finally{
            RequestDispatcher rd= request.getRequestDispatcher(url);
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
