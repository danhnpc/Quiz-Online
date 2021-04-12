/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package danhnpc.servlets;

import danhnpc.tblquiz.Result;
import danhnpc.tblquiz.TblQuizDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "PagingServlet", urlPatterns = {"/PagingServlet"})
public class PagingServlet extends HttpServlet {

    private final String TAKE_QUIZ = "quiz.jsp";

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
        String url = TAKE_QUIZ;

        String button = request.getParameter("btAction");
        try {
            HttpSession session = request.getSession();
            //take all question
            List<TblQuizDTO> question = (List<TblQuizDTO>) session.getAttribute("ALLQUESTION");
            int page = (int) session.getAttribute("PAGE");
            // take result
            List<Result> result = (List<Result>) session.getAttribute("ALLANSWER");
            if (result == null) {
                result = new ArrayList<>();
            }

            String answer = request.getParameter("cbAnswer_" + (page));
            String answerCorrect = request.getParameter("txtAnswerCorrect");
            // if press Next => next question => save an old answer into Array
            if (button.equals("Next")) {
                page = page + 1;
                session.setAttribute("QUESTION", question.get(page));
                boolean duplicate = false;
                for (Result i : result) {
                    if (i.getPage() == (page - 1)) {
                        if (answer != null) {
                            i.setAnswerChosen(answer);
                        }
                        duplicate = true;
                    }
                }
                if (!duplicate) {
                    result.add(new Result(page - 1, answer, answerCorrect));
                }
                // if press Previous => => save an old answer into Array
            } else if (button.equals("Previous")) {
                page = page - 1;
                session.setAttribute("QUESTION", question.get(page));
                boolean duplicate = false;
                 for (Result i : result) {
                    if (i.getPage() == (page + 1)) {
                        if (answer != null) {
                            i.setAnswerChosen(answer);
                        }
                        duplicate = true;
                    }
                }
                if (!duplicate) {
                    result.add(new Result(page + 1, answer, answerCorrect));
                }
            }
            
            session.setAttribute("ALLANSWER", result);
            session.setAttribute("PAGE", page);

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
