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
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
@WebServlet(name = "TakeQuizServlet", urlPatterns = {"/TakeQuizServlet"})
public class TakeQuizServlet extends HttpServlet {

    private final String TAKE_QUIZ = "quiz.jsp";
    private final String ERROR = "selectQuiz.jsp";

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
        try {
            String subject = request.getParameter("txtSubject");
            TblQuizDAO dao = new TblQuizDAO();
            dao.takeAllQuestionID(subject);
            List<String> listID = dao.getIdQuestion(); // lấy tất cả câu hỏi

            if (listID.size() < 10) {
                request.setAttribute("TAKEQUIZERROR", "Your subject must be greater than 10 question!!! ");
            } else {

                Random rand = new Random();
                List<String> listQuestion = new ArrayList<>();
                String remove = null;

                //random 10 id bất kỳ 
                while (listQuestion.size() < 10) {
                    String randomElement = listID.get(rand.nextInt(listID.size()));

                    listQuestion.add(randomElement);
                    remove = randomElement;
                    listID.remove(remove);
                }
                HttpSession session = request.getSession();

                //list 10 câu hỏi
                List<TblQuizDTO> quiz = new ArrayList<>();

                for (String id : listQuestion) {
                    dao.takeQuiz(id);
                }
                quiz = dao.getQuiz();
                session.setAttribute("ALLQUESTION", quiz);
                // câu đầu tiên
                int page = 0;
                session.setAttribute("QUESTION", quiz.get(0));
                session.setAttribute("PAGE", page);

                //list nội dung câu trả lời của 10 câu
                List<TblAnswerContentDTO> answer = new ArrayList<>();
                TblAnswerContentDAO acDao = new TblAnswerContentDAO();
                for (TblQuizDTO id : quiz) {
                    acDao.AnswerContent(id.getAnswerContentID());
                }
                answer = acDao.getAnswer();
                session.setAttribute("ANSWERCONTENT", answer);
                //set time
                LocalDateTime now = LocalDateTime.now();
                LocalDateTime end = now.plusSeconds(60);
                session.setAttribute("TIME", end);
                
                url = TAKE_QUIZ;
            }

        } catch (NamingException ex) {
            log("TakeQuizServlet_NamingException:" + ex.getMessage());
        } catch (SQLException ex) {
            log("TakeQuizServlet_SQLException:" + ex.getMessage());
        } catch( NullPointerException ex){
            request.setAttribute("TAKEQUIZERROR", "Your subject must be greater than 10 question!!! ");
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
