/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package danhnpc.tblquiz;

import danhnpc.utils.DBHelper;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author visug
 */
public class TblQuizDAO implements Serializable {

    private List<String> idQuestion;

    public List<String> getIdQuestion() {
        return idQuestion;
    }

    public void takeAllQuestionID(String subject)
            throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "Select ID, status From tblQuiz "
                        + "Where subjectID=? ";
                ps = con.prepareStatement(sql);
                ps.setString(1, subject);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String id = rs.getString("ID");
                    boolean status = rs.getBoolean("status");
                    if (this.idQuestion == null) {
                        this.idQuestion = new ArrayList<>();
                    }
                    if (status == true) {
                        this.idQuestion.add(id);
                    }
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    private List<TblQuizDTO> quiz;

    public List<TblQuizDTO> getQuiz() {
        return quiz;
    }

    public void takeQuiz(String id)
            throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "Select question, answerContentID, answerCorrect From tblQuiz "
                        + "Where ID=? ";
                ps = con.prepareStatement(sql);
                ps.setString(1, id);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String question = rs.getString("question");
                    String answerContentID = rs.getString("answerContentID");
                    String answerCorrect = rs.getString("answerCorrect");

                    if (this.quiz == null) {
                        this.quiz = new ArrayList<>();
                    }
                    TblQuizDTO dto = new TblQuizDTO(question, answerContentID, answerCorrect);
                    this.quiz.add(dto);

                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    private List<TblQuizDTO> listQuestion;

    public List<TblQuizDTO> getListQuestion() {
        return listQuestion;
    }

    public void searchQuestion(String searchValue, boolean status, String subject)
            throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "Select ID, question, answerContentID, answerCorrect, createDate, subjectID, status From tblQuiz "
                        + "Where question Like ? AND status = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, "%" + searchValue + "%");
                ps.setBoolean(2, status);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String id = rs.getString("ID");
                    String question = rs.getString("question");
                    String answerContentID = rs.getString("answerContentID");
                    String answerCorrect = rs.getString("answerCorrect");
                    Date createDate = rs.getDate("createDate");
                    String subjectID = rs.getString("subjectID");
                    boolean active = rs.getBoolean("status");
                    if (this.listQuestion == null) {
                        this.listQuestion = new ArrayList<>();
                    }
                    TblQuizDTO dto = new TblQuizDTO(id, question, answerContentID, answerCorrect, createDate, subjectID, status);
                    if (subject.equals("0") || subject.equals(subjectID)) {
                        this.listQuestion.add(dto);
                    }
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public boolean insertQuestion(String id, String question, String answerContent, String answerCorrect, Date createTime, String subject, boolean status)
            throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "INSERT INTO tblQuiz Values(?,?,?,?,?,?,?)";
                ps = con.prepareStatement(sql);
                ps.setString(1, id);
                ps.setString(2, question);
                ps.setString(3, answerContent);
                ps.setString(4, answerCorrect);
                ps.setDate(5, createTime);
                ps.setString(6, subject);
                ps.setBoolean(7, status);
                int row = ps.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public boolean deleteQuestion(String id, boolean isDelete)
            throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "Update tblQuiz Set status = ? Where ID = ?";
                ps = con.prepareStatement(sql);
                ps.setBoolean(1, isDelete);
                ps.setString(2, id);
                int row = ps.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public TblQuizDTO getQuestionByID(String id)
            throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "Select question, answerContentID, answerCorrect, subjectID From tblQuiz "
                        + "Where ID = ? ";
                ps = con.prepareStatement(sql);
                ps.setString(1, id);
                rs = ps.executeQuery();
                if (rs.next()) {
                    String question = rs.getString("question");
                    String answerContentID = rs.getString("answerContentID");
                    String answerCorrect = rs.getString("answerCorrect");
                    String subjectID = rs.getString("subjectID");
                    TblQuizDTO dto = new TblQuizDTO(id, question, answerContentID, answerCorrect, subjectID);
                    return dto;
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    }

    public boolean updateQuestion(String id, String question, String answerCorrect, String subject)
            throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "Update tblQuiz Set question=?, answerCorrect=?, subjectID=? Where ID=? ";
                ps = con.prepareStatement(sql);
                ps.setString(1, question);
                ps.setString(2, answerCorrect);
                ps.setString(3, subject);
                ps.setString(4, id);
                int row = ps.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    List<TblQuizDTO> home;

    public List<TblQuizDTO> getHome() {
        return home;
    }

    public void list20Question()
            throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "Select ID, question, answerContentID, answerCorrect, createDate, subjectID, status From tblQuiz "
                        + "ORDER BY question ASC";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String id = rs.getString("ID");
                    String question = rs.getString("question");
                    String answerContentID = rs.getString("answerContentID");
                    String answerCorrect = rs.getString("answerCorrect");
                    Date createDate = rs.getDate("createDate");
                    String subjectID = rs.getString("subjectID");
                    boolean active = rs.getBoolean("status");
                    if (this.home == null) {
                        this.home = new ArrayList<>();
                    }
                    TblQuizDTO dto = new TblQuizDTO(id, question, answerContentID, answerCorrect, createDate, subjectID, active);
                    if (active && (this.home.size() < 20)) {
                       
                            this.home.add(dto);
                        
                    }
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
}
