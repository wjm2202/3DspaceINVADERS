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
public class Level {
    private Connection connect = derbyDBConnection.dbconnect(); //Declare connection for derby
    private String nickname;
    private int level;
    private PreparedStatement ps= null; //Declare preparestatement
    
    
    public Level(String nickname, int level) {
        this.nickname = nickname;
        this.level = level;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Level() {
        this.nickname = "";
        this.level = 0;
    }

    public void insert(){//Method is used to insert name and email into database
        String sqlquery = "insert into LEVELDIFFICULT (NICKNAME, LEVELS) values(?, ?)";
        try{
            ps = connect.prepareStatement(sqlquery);
            ps.setString(1, this.nickname);//
            ps.setInt(2, this.level);
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Saved", "Insert Successfully", JOptionPane.INFORMATION_MESSAGE);
            ps.close();
            connect.close();
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public boolean maketable() {
        String query = "";
        if (connect != null) {
            try {
                java.sql.DatabaseMetaData dbmd = connect.getMetaData();
                ResultSet rs = dbmd.getTables(null, null, "PLAYERNAME", null);
                if (rs.next()) {
                    System.out.println("table exists");
                } else {
                    query = "create table leveldifficult(\n"
                            + "nickname varchar(40) not null,\n"
                            + "levels integer not null,\n"
                            + "constraint pk_name_level PRIMARY KEY (nickname)\n"
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
