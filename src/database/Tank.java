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
public class Tank {
    private Connection connect = derbyDBConnection.dbconnect(); //Declare connection for derby
    private String skin;
    private String type;
    private String nickname;
    private PreparedStatement ps= null;  //Declare preparestatement
    
    public String getSkin() {
        return skin;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Tank(String skin, String type, String nickname) {
        this.skin = skin;
        this.type = type;
        this.nickname = nickname;
    }

    public Tank() {
        this.skin = "";
        this.type = "";
        this.nickname = "";
    }
    
    public void insert(){//Method is used to insert name and email into database
        String sqlquery = "insert into TANK (SKIN, TANKTYPE,NICKNAME) values(?, ?, ?)";
        try{
            ps = connect.prepareStatement(sqlquery);
            ps.setString(1, this.skin);
            ps.setString(2, this.type);
            ps.setString(3, this.nickname);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Saved", "Insert Successfully", JOptionPane.INFORMATION_MESSAGE);
            ps.close();
            connect.close();
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
        public boolean maketable() {//The boolean method to check if the table is existed inside
                                    // the database
        String query = "";
        if (connect != null) {
            try {
                java.sql.DatabaseMetaData dbmd = connect.getMetaData();
                ResultSet rs = dbmd.getTables(null, null, "PLAYERNAME", null);
                if (rs.next()) {
                    System.out.println("table exists");
                } else {
                    query = "create table tank("
                            + "skin varchar(20) not null,"
                            + "tanktype varchar(20),"
                            + "nickname varchar(40) not null"
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
