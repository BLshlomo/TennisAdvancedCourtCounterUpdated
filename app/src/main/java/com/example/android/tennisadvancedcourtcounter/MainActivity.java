package com.example.android.tennisadvancedcourtcounter;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean winA;
    boolean winB;
    int scoreGamePlayerA = 0;
    int scoreSetPlayerA = 0;
    int scoreMatchPlayerA = 0;
    int scoreGamePlayerB = 0;
    int scoreSetPlayerB = 0;
    int scoreMatchPlayerB = 0;
    String displayNoWinner = "";
    String displayPlayerAWins;
    String displayPlayerBWins;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Use onSaveInstanceState(Bundle) and onRestoreInstanceState

    //onSaveInstanceState
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        // Save UI state changes to the savedInstanceState.
        // This bundle will be passed to onCreate if the process is
        // killed and restarted.

        savedInstanceState.putBoolean("booleanWinA", winA);
        savedInstanceState.putBoolean("booleanWinB", winB);
        savedInstanceState.putInt("gamePlayerA", scoreGamePlayerA);
        savedInstanceState.putInt("setPlayerA", scoreSetPlayerA);
        savedInstanceState.putInt("matchPlayerA", scoreMatchPlayerA);
        savedInstanceState.putInt("gamePlayerB", scoreGamePlayerB);
        savedInstanceState.putInt("setPlayerB", scoreSetPlayerB);
        savedInstanceState.putInt("matchPlayerB", scoreMatchPlayerB);


        // etc.

        super.onSaveInstanceState(savedInstanceState);
    }

    //onRestoreInstanceState
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {

        super.onRestoreInstanceState(savedInstanceState);

        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.

        winA = savedInstanceState.getBoolean("booleanWinA");
        winB = savedInstanceState.getBoolean("booleanWinB");
        scoreGamePlayerA = savedInstanceState.getInt("gamePlayerA");
        scoreSetPlayerA = savedInstanceState.getInt("setPlayerA");
        scoreMatchPlayerA = savedInstanceState.getInt("matchPlayerA");
        scoreGamePlayerB = savedInstanceState.getInt("gamePlayerB");
        scoreSetPlayerB = savedInstanceState.getInt("setPlayerB");
        scoreMatchPlayerB = savedInstanceState.getInt("matchPlayerB");
        // Display all scores from before the kill activity
        displayAllScores();
        // Display winner from before the kill activity
        if (winA) {
            displayWinner(displayPlayerAWins = getResources().getString(R.string.playerAWins));
        } else if (winB) {
            displayWinner(displayPlayerBWins = getResources().getString(R.string.playerBWins));
        }
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
        winA = false;
        winB = false;
        displayWinner(displayNoWinner);
        displayAllScores();
    }

    /**
     * This method is called when the point button is clicked for player A
     */
    public void addPointForPlayerA(View view) {
        // Check to see if there is a winner so the button wont work until
        // the reset button is clicked.
        if (winA || winB) {
            return;
        }
        // Add a point to player A but check to see the value to show and display
        // according to the point system rules of tennis.
        else if (scoreGamePlayerA == 0) {
            scoreGamePlayerA = 15;
        }
        // Add a point to player A but check to see the value to show and display
        // according to the point system rules of tennis.
        else if (scoreGamePlayerA == 15) {
            scoreGamePlayerA = 30;
        }
        // Add a point to player A but check to see the value to show and display
        // according to the point system rules of tennis.
        else if (scoreGamePlayerA == 30) {
            scoreGamePlayerA = 40;
        }
        // Add a set point to player A and resetting the game points for both players.
        else if (scoreGamePlayerA == 40) {
            scoreSetPlayerA += +1;
            scoreGamePlayerA = 0;
            scoreGamePlayerB = 0;

            // Add a match point to player A after check if the rules conditions are met
            // and reset the game and set points for both players.
            if (scoreSetPlayerA >= 3) {
                if (scoreSetPlayerA > scoreSetPlayerB) {
                    if (scoreSetPlayerA - scoreSetPlayerB >= 2) {
                        scoreMatchPlayerA += +1;
                        scoreGamePlayerA = 0;
                        scoreSetPlayerA = 0;
                        scoreGamePlayerB = 0;
                        scoreSetPlayerB = 0;

                        // Determine the game winner according to the set conditions.
                        if (scoreMatchPlayerA >= 3) {
                            if (scoreMatchPlayerA > scoreMatchPlayerB) {
                                if (scoreMatchPlayerA - scoreMatchPlayerB >= 2) {
                                    // Display winner player A on screen.
                                    displayWinner(displayPlayerAWins = getResources().getString(R.string.playerAWins));
                                    // Set a boolean value for winner player A future reference.
                                    winA = true;
                                    // End the method.
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
        // Call the display all scores method to display all scores on screen.
        displayAllScores();
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
     * This method is called when the point button is clicked for player B.
     */
    public void addPointForPlayerB(View view) {
        // Check to see if there is a winner so the button wont work until
        // the reset button is clicked.
        if (winA || winB) {
            return;
        }
        // Add a point to player B but check to see the value to show and display
        // according to the point system rules of tennis.
        else if (scoreGamePlayerB == 0) {
            scoreGamePlayerB = 15;
        }
        // Add a point to player B but check to see the value to show and display
        // according to the point system rules of tennis.
        else if (scoreGamePlayerB == 15) {
            scoreGamePlayerB = 30;
        }
        // Add a point to player B but check to see the value to show and display
        // according to the point system rules of tennis.
        else if (scoreGamePlayerB == 30) {
            scoreGamePlayerB = 40;
        }
        // Add a set point to player B and resetting the game points for both players.
        else if (scoreGamePlayerB == 40) {
            scoreSetPlayerB += +1;
            scoreGamePlayerA = 0;
            scoreGamePlayerB = 0;

            // Add a match point to player B after check if the rules conditions are met
            // and reset the game and set points for both players.
            if (scoreSetPlayerB >= 3) {
                if (scoreSetPlayerB > scoreSetPlayerA) {
                    if (scoreSetPlayerB - scoreSetPlayerA >= 2) {
                        scoreMatchPlayerB += +1;
                        scoreGamePlayerA = 0;
                        scoreSetPlayerA = 0;
                        scoreGamePlayerB = 0;
                        scoreSetPlayerB = 0;

                        // Determine the game winner according to the set conditions.
                        if (scoreMatchPlayerB >= 3) {
                            if (scoreMatchPlayerB > scoreMatchPlayerA) {
                                if (scoreMatchPlayerB - scoreMatchPlayerA >= 2) {
                                    // Display winner player B on screen.
                                    displayWinner(displayPlayerBWins = getResources().getString(R.string.playerBWins));
                                    // Set a boolean value for winner player B for future reference.
                                    winB = true;
                                    // End the method.
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
        // Call the display all scores method to display all scores on screen.
        displayAllScores();
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

    /**
     * Display the name of the winner.
     *
     * @param gameWinner the winner of the game.
     */
    public void displayWinner(String gameWinner) {
        TextView winner = (TextView) findViewById(R.id.display_winner);
        winner.setText(gameWinner);
        winner.setTextColor(Color.parseColor("#FFFF8D"));
    }

    /**
     * A method to display all the scores of the app.
     */
    public void displayAllScores() {
        displayPlayerAMatchScore(scoreMatchPlayerA);
        displayPlayerASetScore(scoreSetPlayerA);
        displayPlayerAGameScore(scoreGamePlayerA);
        displayPlayerBMatchScore(scoreMatchPlayerB);
        displayPlayerBSetScore(scoreSetPlayerB);
        displayPlayerBGameScore(scoreGamePlayerB);
    }
}
