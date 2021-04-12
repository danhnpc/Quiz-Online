/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package danhnpc.tblsubject;

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
public class TblSubjectDAO implements Serializable{
    private List<TblSubjectDTO> subject;

    public List<TblSubjectDTO> getSubject() {
        return subject;
    }
    
    public void getAllSubject() throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = DBHelper.makeConnection();
            if(con != null){
                String sql = "Select subjectID, subjectName From tblSubject";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while(rs.next()){
                    String id = rs.getString("subjectID");
                    String name = rs.getString("subjectName");
                    TblSubjectDTO dto = new TblSubjectDTO(id, name);
                    if(this.subject == null){
                        this.subject = new ArrayList<>();
                    }
                    this.subject.add(dto);
                }
            }
        }finally{
            if(rs != null){
                rs.close();
            }
            if(ps != null){
                ps.close();
            }
            if(con != null){
                con.close();
            }
        }
    }
    public boolean insert(String subjectID, String subjectName)
            throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement ps = null;
        try{
            con = DBHelper.makeConnection();
            if(con != null){
                String sql = "INSERT INTO tblSubject Values(?,?)";
                ps = con.prepareStatement(sql);
                ps.setString(1, subjectID);
                ps.setString(2, subjectName);
                int row = ps.executeUpdate();
                if(row > 0){
                    return true;
                }
            }
        }finally{
            if(ps != null){
                ps.close();
            }
            if(con != null){
                con.close();
            }
        }
        return false;
    }
}
