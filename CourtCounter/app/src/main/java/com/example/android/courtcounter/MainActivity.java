package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

     int scoreTeamA = 0;
    int scoreTeamB = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**
     * This method is called when +3 points  button for TEAM A is clicked
     */
    public void addThreeForTeamA(View view){
        scoreTeamA += 3;
        displayForTeamA(scoreTeamA);

    }
    /**
     * This method is called when +2 points button for TEAM A is clicked
     */
    public void addTwoForTeamA(View view){
        scoreTeamA += 2;
        displayForTeamA(scoreTeamA);

    }
    /**
     * This method is called when free throw button for TEAM A is clicked
     */
    public void addOneForTeamA(View view){
        scoreTeamA += 1;
        displayForTeamA(scoreTeamA);

    }
    /**
     * This method is called when +3 points  button for TEAM B is clicked
     */
    public void addThreeForTeamB(View view){
        scoreTeamB+= 3;
        displayForTeamB(scoreTeamB);

    }
    /**
     * This method is called when +2 points button for TEAM B is clicked
     */
    public void addTwoForTeamB(View view){
        scoreTeamB += 2;
        displayForTeamB(scoreTeamB);

    }
    /**
     * This method is called when free throw button for TEAM B is clicked
     */
    public void addOneForTeamB(View view){
        scoreTeamB+= 1;
        displayForTeamB(scoreTeamB);

    }
    /**
     * This method is called when RESET button is clicked
     */
    public void resetScore(View view){
        scoreTeamA=0;
        scoreTeamB=0;
        displayForTeamA(0);
        displayForTeamB(0);
    }
    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }
    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }
}
