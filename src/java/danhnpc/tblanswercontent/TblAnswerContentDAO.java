/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package danhnpc.tblanswercontent;

import danhnpc.utils.DBHelper;
import java.io.Serializable;
import java.sql.Connection;
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
public class TblAnswerContentDAO implements Serializable {

    private List<TblAnswerContentDTO> answer;

    public List<TblAnswerContentDTO> getAnswer() {
        return answer;
    }

    public void AnswerContent(String answerContentID)
            throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "Select A, B, C, D From tblAnswerContent "
                        + "Where answerContentID=? ";
                ps = con.prepareStatement(sql);
                ps.setString(1, answerContentID);
                rs = ps.executeQuery();
                if (rs.next()) {

                    String a = rs.getString("A");
                    String b = rs.getString("B");
                    String c = rs.getString("C");
                    String d = rs.getString("D");
                    if (this.answer == null) {
                        this.answer = new ArrayList<>();
                    }
                    TblAnswerContentDTO dto = new TblAnswerContentDTO(answerContentID, a, b, c, d);
                    this.answer.add(dto);
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

    public boolean insertAnswerContent(String id, String A, String B, String C, String D)
            throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "INSERT INTO tblAnswerContent Values(?,?,?,?,?)";
                ps = con.prepareStatement(sql);
                ps.setString(1, id);
                ps.setString(2, A);
                ps.setString(3, B);
                ps.setString(4, C);
                ps.setString(5, D);
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

    public boolean updateAnswerContent(String id, String a, String b, String c, String d)
            throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "Update tblAnswerContent Set A=?, B=?, C=?, D=? Where answerContentID=?";
                ps = con.prepareStatement(sql);
                ps.setString(1, a);
                ps.setString(2, b);
                ps.setString(3, c);
                ps.setString(4, d);
                ps.setString(5, id);
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
}
