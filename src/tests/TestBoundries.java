package tests;

import javafx.geometry.Point3D;
import operations.WorldCoOrdinates;

import java.util.ArrayList;

/**
 * Created by Liandri on 25/09/2016.
 */
public class TestBoundries {
    WorldCoOrdinates wc = new WorldCoOrdinates();
    ArrayList<Integer> masterERRORlist = new ArrayList<>();
    ArrayList<Point3D> Xhits = new ArrayList<>();
    ArrayList<Point3D> Yhits = new ArrayList<>();
    ArrayList<Point3D> Zhits = new ArrayList<>();

    public String boundryTests(){
        String results ="";
        for(int i =0;i<Xhits.size();i++){

            if((Xhits.get(i).getX()<=wc.getCase0().getX())||(Xhits.get(i).getX()>=wc.getCase3().getX())){

            }else{
                results += " Number of Xfaults INVADERS "+i+" X: "+Xhits.get(i).getX()+" Xmin:0 Xmax:1000 \n";
            }
        }
        for(int i =0;i<Zhits.size();i++){
            if((Zhits.get(i).getY()<=wc.getCase1().getZ())||(Zhits.get(i).getY()>=wc.getCase5().getZ())){

            }else{
                results += "Number of Zfaults INVADERS "+i+" Z: "+Xhits.get(i).getZ()+" Zmin:800 Zmax:1300\n";
            }
        }
        for(int i =0;i<Yhits.size();i++){
            if(Yhits.get(i).getY()>=wc.getCase1().getY()-15){

            }else{
                results += "Number of Zfaults INVADERS "+i+" Y: "+Xhits.get(i).getY()+" Ymin:0 Ymax:500 \n";
            }
        }
        return results;
    }
    public void setXhit(Point3D hit){
        Xhits.add(hit);
    }
    public void setYhit(Point3D hit){
        Xhits.add(hit);
    }
    public void setZhit(Point3D hit){
        Xhits.add(hit);
    }
    public void setMasterERRORlist(Integer errorType){masterERRORlist.add(errorType);}
    public ArrayList<Integer> getMasterERRORlist(){return masterERRORlist;}

}
