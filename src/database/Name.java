/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Thi
 */
public class Name {
    private Connection connect = derbyDBConnection.dbconnect(); //Declare connection for derby
    private String nickname;
    private String email;
    private ResultSet rs = null;
    private PreparedStatement ps= null; //Declare preparestatement
    

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Name() {
        this.nickname = "Anon";
        this.email = "Anon@anon.com";
    }

    public Name(String nickname, String email) {
        this.nickname = nickname;
        this.email = email;
    }
    
    public void insert(){//Method is used to insert name and email into database
        String sqlquery = "insert into PLAYERNAME (NICKNAME, EMAILADD) values(?, ?)";
        String sqlquery1 = "select NICKNAME, EMAILADD from TEAMGLEN.PLAYERNAME where " +
                "NICKNAME = ? AND EMAILADD = ?";
        try{
            ps = connect.prepareStatement(sqlquery1);
            ps.setString(1, this.nickname);
            ps.setString(2, this.email);
            rs = ps.executeQuery();
            if(rs.next()){//If it is existed, it will display the message
                JOptionPane.showMessageDialog(null, "The nickname: " + this.nickname
                        + "and email: " + this.email + "\n" +
                        " are already existed.", "Existed", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Existed");
            }else {//Otherwise, add into the database
                ps = connect.prepareStatement(sqlquery);
                ps.setString(1, this.nickname);
                ps.setString(2, this.email);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Saved", "Insert Successfully", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Insert Successfully");
            }
            rs.close();//Close resultset
            ps.close();//Close Statement
            connect.close();//Close connection
        }catch(Exception e){//Capture the exception
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public boolean maketable() {//The boolean method to check if the table is existed inside
                                //the database
        String query = "";
        if (connect != null) {
            try {
                java.sql.DatabaseMetaData dbmd = connect.getMetaData();
                ResultSet rs = dbmd.getTables(null, null, "PLAYERNAME", null);
                if (rs.next()) {
                    System.out.println("table exists");
                } else {
                    query = "create table playername("
                            + "nickname varchar(40) not null,"
                            + "emailadd varchar(50),"
                            + "constraint pk_nickname PRIMARY KEY (nickname)"
                            + ")";
                    ps = connect.prepareStatement(query);
                    ps.execute();
                    System.out.println("new table created");
                }
            } catch (SQLException ex) {
                System.out.println("table create failed");
                ex.printStackTrace();
            }
        } else {
            System.out.println("Connect failed.");
        }
        return true;
    }
    
}
