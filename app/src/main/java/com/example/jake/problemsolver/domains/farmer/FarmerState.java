package com.example.jake.problemsolver.domains.farmer;

/**
 * Created by Jake on 4/27/17.
 */
import com.example.jake.problemsolver.framework.problem.State;
/**
 *
 * @author Jake
 */
public class FarmerState implements State{

    public FarmerState(String Farmer, String Wolf,String Goat, String Cabbage) {
        this.Farmer = Farmer;
        this.Wolf = Wolf;
        this.Goat = Goat;
        this.Cabbage = Cabbage;
    }



    @Override
    public boolean equals(Object other){
        if (other instanceof FarmerState){
            FarmerState otherFarmer = (FarmerState) other;
            return this.Farmer.equals(otherFarmer.Farmer) &&
                    this.Wolf.equals(otherFarmer.Wolf) &&
                    this.Goat.equals(otherFarmer.Goat) &&
                    this.Cabbage.equals(otherFarmer.Cabbage);
        }
        return false;
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("   |  |   \n");
        if(Farmer != "East"){
            s.append(" F |  |   \n");
        }
        else{
            s.append("   |  | F \n");
        }
        if(Wolf != "East"){
            s.append(" W |  |   \n");
        }
        else {
            s.append("   |  | W \n");
        }
        if(Goat != "East"){
            s.append(" G |  |   \n");
        }
        else {
            s.append("   |  | G \n");
        }
        if(Cabbage != "East"){
            s.append(" C |  |   \n");
        }
        else{
            s.append("   |  | C \n");
        }
        s.append("   |  |   ");
        return s.toString();
    }

    public String getFarmer(){
        return this.Farmer;
    }
    public String getWolf(){
        return this.Wolf;
    }
    public String getGoat(){
        return this.Goat;
    }
    public String getCabbage(){
        return this.Cabbage;
    }


    private  String Farmer;
    private  String Wolf;
    private  String Goat;
    private  String Cabbage;
    private static final String NEW_LINE = "\n";
}
