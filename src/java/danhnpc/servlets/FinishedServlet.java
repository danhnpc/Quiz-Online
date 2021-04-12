/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package danhnpc.servlets;

import danhnpc.tblquiz.Result;
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
@WebServlet(name = "FinishedServlet", urlPatterns = {"/FinishedServlet"})
public class FinishedServlet extends HttpServlet {

    private final String RESULT_PAGE = "result.jsp";

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
        String url = RESULT_PAGE;
        try {
            HttpSession session = request.getSession();
            // take all answer
            List<Result> result = (List<Result>) session.getAttribute("ALLANSWER");
            if (result == null) {
                result = new ArrayList<>();
            }
            // take number of page, answer, answerCorrect
            int page = (int) session.getAttribute("PAGE");
            String answer = request.getParameter("cbAnswer_" + page);
            String answerCorrect = request.getParameter("txtAnswerCorrect");
            boolean duplicate = false;
            for (Result i : result) {
                // if duplicate question => set new answer
                if (i.getPage() == (page)) {
                    if (answer != null) {
                        i.setAnswerChosen(answer);
                    }
                    duplicate = true;
                }
            }
            //if do not duplicate => add new answer
            if (!duplicate) {
                result.add(new Result(page, answer, answerCorrect));
            }
            int mark = 0;
            // get mark
            for (Result i : result) {
                if (i.getAnswerChosen() == null) {
                    i.setAnswerChosen("");
                }
                if (i.getAnswerChosen().equals(i.getAnswerCorrect())) {
                    mark = mark + 1;
                }
            }
            float finalMark = ((mark) * 10) / 10;
            session.setAttribute("MARK", finalMark);
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
