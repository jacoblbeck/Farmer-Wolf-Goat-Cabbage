package com.example.jake.problemsolver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jake.problemsolver.domains.farmer.FarmerState;
import com.example.jake.problemsolver.domains.farmer.FarmerProblem;
import com.example.jake.problemsolver.framework.problem.State;
import android.view.View;
import android.widget.TextView;


public class FWGC extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fwgc);
        current();
        textview = (TextView)(findViewById(R.id.current));
        messageview = (TextView)(findViewById(R.id.message));
    }

    public void goesAlone(View view) {
        textview = (TextView)(findViewById(R.id.current));
        if(farmer.getCabbage().equals(farmer.getGoat()) || farmer.getGoat().equals(farmer.getWolf())){
            illegalMove();}
        else if("West".equals(farmer.getFarmer())) {
            farmer = new FarmerState("East", farmer.getWolf(), farmer.getGoat(), farmer.getCabbage());
            textview.setText(farmer.toString());
            message(farmer);
        }
        else {
            farmer = new FarmerState("West", farmer.getWolf(), farmer.getGoat(), farmer.getCabbage());
            textview.setText(farmer.toString());
            message(farmer);

        }
    }

    public void takesWolf(View view) {
        textview = (TextView) (findViewById(R.id.current));
        if (farmer.getCabbage().equals(farmer.getGoat()) || !farmer.getFarmer().equals(farmer.getWolf())) {
            illegalMove();
        } else if ("West".equals(farmer.getWolf())) {
            farmer = new FarmerState("East", "East", farmer.getGoat(), farmer.getCabbage());
            textview.setText(farmer.toString());
            message(farmer);
        } else {
            farmer = new FarmerState("West", "West", farmer.getGoat(), farmer.getCabbage());
            textview.setText(farmer.toString());
            message(farmer);
        }
    }

    public void takesGoat(View view) {
        textview = (TextView) (findViewById(R.id.current));
        if (!farmer.getGoat().equals(farmer.getFarmer())) {
            illegalMove();
        } else if ("West".equals(farmer.getFarmer())) {
            farmer = new FarmerState("East", farmer.getWolf(), "East", farmer.getCabbage());
            textview.setText(farmer.toString());
            message(farmer);
        } else {
            farmer = new FarmerState("West", farmer.getWolf(), "West", farmer.getCabbage());
            textview.setText(farmer.toString());
            message(farmer);
        }
    }

    public void takesCabbage(View view) {
        textview = (TextView) (findViewById(R.id.current));
        if (farmer.getWolf().equals(farmer.getGoat()) || !farmer.getFarmer().equals(farmer.getCabbage())) {
            illegalMove();
        } else if ("West".equals(farmer.getFarmer())) {
            farmer = new FarmerState("East", farmer.getWolf(), farmer.getGoat(), "East");
            textview.setText(farmer.toString());
            message(farmer);
        } else {
            farmer = new FarmerState("West", farmer.getWolf(), farmer.getGoat(), "West");
            textview.setText(farmer.toString());
            message(farmer);
        }
    }

    public void reset(View view) {
        farmer = (FarmerState) prob.getInitialState();
        String message = farmer.toString();
        textview = (TextView) (findViewById(R.id.current));
        textview.setText(message);
        String reset = " ";
        messageview = (TextView)(findViewById(R.id.message));
        messageview.setTextSize(25);
        messageview.setText(reset);

    }


    public void current() {
        farmer = (FarmerState) prob.getCurrentState();
        String message = farmer.toString();
        textview = (TextView) (findViewById(R.id.current));
        textview.setTextSize(40);
        textview.setText(message);
    }

    public void message(FarmerState state){
     if(farmer.toString().equals(finalstate.toString())){
         String message = "You solved the problem. Congratulations.";
         messageview = (TextView)(findViewById(R.id.message));
         messageview.setTextSize(25);
         messageview.setText(message);
     }
     else {
         String blank = " ";
         messageview = (TextView) (findViewById(R.id.message));
         messageview.setTextSize(25);
         messageview.setText(blank);
     }

    }
    public void illegalMove(){
        String message = "Illegal Move Try again";
        messageview = (TextView)(findViewById(R.id.message));
        messageview.setTextSize(25);
        messageview.setText(message);
    }
    private TextView messageview;
    private TextView textview;
    private FarmerState farmer;
    private FarmerProblem prob = new FarmerProblem();
    private FarmerState finalstate = new FarmerState("East","East","East","East");
    }




