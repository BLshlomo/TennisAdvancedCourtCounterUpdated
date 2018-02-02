package com.example.android.tennisadvancedcourtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreGamePlayerA = 0;
    int scoreSetPlayerA = 0;
    int scoreMatchPlayerA = 0;
    int scoreGamePlayerB = 0;
    int scoreSetPlayerB = 0;
    int scoreMatchPlayerB = 0;
    String displayNoWinner = "";
    String displayPlayerAWins = "Player A wins !!!";
    String displayPlayerBWins = "Player B wins !!!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the reset button is clicked
     */
    public void reset(View view) {
        scoreGamePlayerA = 0;
        scoreSetPlayerA = 0;
        scoreMatchPlayerA = 0;
        scoreGamePlayerB = 0;
        scoreSetPlayerB = 0;
        scoreMatchPlayerB = 0;
        displayPlayerAGameScore(scoreGamePlayerA);
        displayPlayerASetScore(scoreSetPlayerA);
        displayPlayerAMatchScore(scoreMatchPlayerA);
        displayPlayerBGameScore(scoreGamePlayerB);
        displayPlayerBSetScore(scoreSetPlayerB);
        displayPlayerBMatchScore(scoreMatchPlayerB);
        TextView text = (TextView) findViewById(R.id.display_winner);
        text.setText(displayNoWinner);

    }

    /**
     * This method is called when the point button is clicked for player A
     */
    public void addPointForPlayerA(View view) {
        if (scoreGamePlayerA == 0) {
            TextView text = (TextView) findViewById(R.id.display_winner);
            text.setText(displayNoWinner);
            scoreGamePlayerA = 15;
        }
        else if (scoreGamePlayerA == 15) {
            scoreGamePlayerA = 30;
        }
        else if (scoreGamePlayerA == 30) {
            scoreGamePlayerA = 40;
        }
        else if (scoreGamePlayerA == 40) {
            scoreSetPlayerA = scoreSetPlayerA + 1;
            scoreGamePlayerA = 0;
            scoreGamePlayerB = 0;
            displayPlayerASetScore(scoreSetPlayerA);
            displayPlayerAGameScore(scoreGamePlayerA);
            displayPlayerBGameScore(scoreGamePlayerB);

            if (scoreSetPlayerA >= 3) {
                if (scoreSetPlayerA > scoreSetPlayerB) {
                    if (scoreSetPlayerA - scoreSetPlayerB >= 2) {
                        scoreMatchPlayerA = scoreMatchPlayerA + 1;
                        scoreGamePlayerA = 0;
                        scoreSetPlayerA = 0;
                        scoreGamePlayerB = 0;
                        scoreSetPlayerB = 0;
                        displayPlayerAMatchScore(scoreMatchPlayerA);
                        displayPlayerASetScore(scoreSetPlayerA);
                        displayPlayerAGameScore(scoreGamePlayerA);
                        displayPlayerBSetScore(scoreSetPlayerB);
                        displayPlayerBGameScore(scoreGamePlayerB);

                        if (scoreMatchPlayerA >= 3) {
                            if (scoreMatchPlayerA > scoreMatchPlayerB) {
                                if (scoreMatchPlayerA - scoreMatchPlayerB >= 2) {
                                    scoreMatchPlayerA = 0;
                                    scoreGamePlayerA = 0;
                                    scoreSetPlayerA = 0;
                                    scoreMatchPlayerB = 0;
                                    scoreGamePlayerB = 0;
                                    scoreSetPlayerB = 0;
                                    displayPlayerAMatchScore(scoreMatchPlayerA);
                                    displayPlayerASetScore(scoreSetPlayerA);
                                    displayPlayerAGameScore(scoreGamePlayerA);
                                    displayPlayerBMatchScore(scoreMatchPlayerB);
                                    displayPlayerBSetScore(scoreSetPlayerB);
                                    displayPlayerBGameScore(scoreGamePlayerB);

                                    TextView text = (TextView) findViewById(R.id.display_winner);
                                    text.setText(displayPlayerAWins);
                                }
                            }
                        }
                    }
                }
            }
        }
        displayPlayerAGameScore(scoreGamePlayerA);
    }

    /**
     * Displays the given games points for Player A.
     */
    public void displayPlayerAGameScore(int score) {
        TextView scoreView = (TextView) findViewById(R.id.player_a_game);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given set points for Player A.
     */
    public void displayPlayerASetScore(int score) {
        TextView scoreView = (TextView) findViewById(R.id.player_a_set);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given match points for Player A.
     */
    public void displayPlayerAMatchScore(int score) {
        TextView scoreView = (TextView) findViewById(R.id.player_a_match);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * This method is called when the point button is clicked for player B
     */
    public void addPointForPlayerB(View view) {
        if (scoreGamePlayerB == 0) {
            TextView text = (TextView) findViewById(R.id.display_winner);
            text.setText(displayNoWinner);
            scoreGamePlayerB = 15;
        }
        else if (scoreGamePlayerB == 15) {
            scoreGamePlayerB = 30;
        }
        else if (scoreGamePlayerB == 30) {
            scoreGamePlayerB = 40;
        }
        else if (scoreGamePlayerB == 40) {
            scoreSetPlayerB = scoreSetPlayerB + 1;
            scoreGamePlayerA = 0;
            scoreGamePlayerB = 0;
            displayPlayerBSetScore(scoreSetPlayerB);
            displayPlayerAGameScore(scoreGamePlayerA);
            displayPlayerBGameScore(scoreGamePlayerB);

            if (scoreSetPlayerB >= 3) {
                if (scoreSetPlayerB > scoreSetPlayerA) {
                    if (scoreSetPlayerB - scoreSetPlayerA >= 2) {
                        scoreMatchPlayerB = scoreMatchPlayerB + 1;
                        scoreGamePlayerA = 0;
                        scoreSetPlayerA = 0;
                        scoreGamePlayerB = 0;
                        scoreSetPlayerB = 0;
                        displayPlayerBMatchScore(scoreMatchPlayerB);
                        displayPlayerASetScore(scoreSetPlayerA);
                        displayPlayerAGameScore(scoreGamePlayerA);
                        displayPlayerBSetScore(scoreSetPlayerB);
                        displayPlayerBGameScore(scoreGamePlayerB);

                        if (scoreMatchPlayerB >= 3) {
                            if (scoreMatchPlayerB > scoreMatchPlayerA) {
                                if (scoreMatchPlayerB - scoreMatchPlayerA >= 2) {
                                    scoreMatchPlayerA = 0;
                                    scoreGamePlayerA = 0;
                                    scoreSetPlayerA = 0;
                                    scoreMatchPlayerB = 0;
                                    scoreGamePlayerB = 0;
                                    scoreSetPlayerB = 0;
                                    displayPlayerAMatchScore(scoreMatchPlayerA);
                                    displayPlayerASetScore(scoreSetPlayerA);
                                    displayPlayerAGameScore(scoreGamePlayerA);
                                    displayPlayerBMatchScore(scoreMatchPlayerB);
                                    displayPlayerBSetScore(scoreSetPlayerB);
                                    displayPlayerBGameScore(scoreGamePlayerB);

                                    TextView text = (TextView) findViewById(R.id.display_winner);
                                    text.setText(displayPlayerBWins);
                                }
                            }
                        }
                    }
                }
            }
        }
        displayPlayerBGameScore(scoreGamePlayerB);
    }
    /**
     * Displays the given games points for Player B.
     */
    public void displayPlayerBGameScore(int score) {
        TextView scoreView = (TextView) findViewById(R.id.player_b_game);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given set points for Player B.
     */
    public void displayPlayerBSetScore(int score) {
        TextView scoreView = (TextView) findViewById(R.id.player_b_set);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given match points for Player B.
     */
    public void displayPlayerBMatchScore(int score) {
        TextView scoreView = (TextView) findViewById(R.id.player_b_match);
        scoreView.setText(String.valueOf(score));
    }

}
