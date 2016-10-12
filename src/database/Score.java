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
public class Score {
    private Connection connect = derbyDBConnection.dbconnect(); //Declare connection for derby
    private PreparedStatement ps= null; //Declare preparestatement
    private String nickname;
    private int highscore;
    private int numofKill;
    private int level;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getHighscore() {
        return highscore;
    }

    public void setHighscore(int highscore) {
        this.highscore = highscore;
    }

    public int getNumofKill() {
        return numofKill;
    }

    public void setNumofKill(int numofKill) {
        this.numofKill = numofKill;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    
    public Score() {//Default constructor
        this.nickname = "";
        this.highscore = 0;
        this.numofKill = 0;
        this.level = 0;
    }

    public Score(String nickname, int highscore, int numofKill, int level) {
        //Constructor with 4 parameters
        this.nickname = nickname;
        this.highscore = highscore;
        this.numofKill = numofKill;
        this.level = level;
    }

    public void insert() {//Method is used to insert name and email into database
        String sqlquery = "insert into SCORE (NICKNAME, LEVELS,HIGHSCORE, NUMBERKILL) values(?, ?, ?,?)";
        try {
            ps = connect.prepareStatement(sqlquery);
            ps.setString(1, this.nickname);
            ps.setInt(2, this.level);
            ps.setInt(3, this.highscore);
            ps.setInt(4, this.numofKill);
            ps.executeUpdate();
            //JOptionPane.showMessageDialog(null, "Saved", "Insert Successfully", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Insert Successfully!");
            ps.close();
            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
    
        public boolean maketable() {
            //The boolean method to check if the table is existed inside
            //the database
        String query = "";
        if (connect != null) {
            try {
                java.sql.DatabaseMetaData dbmd = connect.getMetaData();
                ResultSet rs = dbmd.getTables(null, null, "PLAYERNAME", null);
                if (rs.next()) {//If it is existed
                    System.out.println("table exists");
                } else {//otherwise, create the table
                    query = "create table score(\n"
                            + "nickname varchar(40) not null,\n"
                            + "levels integer not null,\n"
                            + "highscore integer,\n"
                            + "numberkill integer,\n"
                            + "constraint pk_nickname_score PRIMARY KEY (nickname)\n"
                            + ")";
                    ps = connect.prepareStatement(query);
                    ps.execute();//Execute the SQL statement
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
        
        public Score getHighScore(String name){//This method is to get the player's highscore
            Score playerscore = new Score();
            ResultSet rs = null;
            String sqlS = "";
            
            try{
                sqlS = "select max(HIGHSCORE) from TEAMGLEN.SCORE where NICKNAME = ?";
                ps = connect.prepareStatement(sqlS);
                ps.setString(1, name);
                rs = ps.executeQuery();
                rs.next();
                playerscore.setHighscore(rs.getInt(0));
            }catch(Exception ex){
                ex.printStackTrace();
            }
            return playerscore;
        }
}
