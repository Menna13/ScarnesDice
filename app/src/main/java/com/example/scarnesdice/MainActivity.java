package com.example.scarnesdice;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

/*
the user's overall score state
the user's turn score
the computer's overall score
the computer's turn score
 */


public class MainActivity extends AppCompatActivity {

    private static int userOverallScore = 0;
    private static int userTurnScore;
    private static int computerOverallScore = 0;
    private static int computerTurnScore;
    private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
        public void rollCreate (View view) {
            TextView userTurn = (TextView) findViewById(R.id.textView3);
            int num = random.nextInt(6);
            ImageView img = (ImageView)findViewById(R.id.imageView);
            if (num == 1) {
                userTurnScore = 0;
                Drawable res = getResources().getDrawable(R.drawable.dice1);
                img.setImageDrawable(res);
                userTurn.setText("turn score = 0");
                computerTurn(view);
            } else {
                userTurnScore = userTurnScore + num;
                userTurn.setText("turn score = " + Integer.toString(userTurnScore));
                if (num == 2) {
                Drawable res =  getResources().getDrawable(R.drawable.dice2);
                img.setImageDrawable(res);
                }
                if (num == 3) {
                    Drawable res = getResources().getDrawable(R.drawable.dice3);
                    img.setImageDrawable(res);
                }
                if (num == 4) {
                    Drawable res = getResources().getDrawable(R.drawable.dice4);
                    img.setImageDrawable(res);
                }
                if (num == 5) {
                    Drawable res = getResources().getDrawable(R.drawable.dice5);
                    img.setImageDrawable(res);
                }
                if (num == 6) {
                    Drawable res = getResources().getDrawable(R.drawable.dice6);
                    img.setImageDrawable(res);
                }
    //        getResources().getDrawable(R.drawable.dice1);
            }

            }
     */
    public void rollHelper(View view, int num) {
        ImageView img = (ImageView) findViewById(R.id.imageView);
        if (num == 1) {
            Drawable res = getResources().getDrawable(R.drawable.dice1);
            img.setImageDrawable(res);
        } else {
            if (num == 2) {
                Drawable res = getResources().getDrawable(R.drawable.dice2);
                img.setImageDrawable(res);
            }
            if (num == 3) {
                Drawable res = getResources().getDrawable(R.drawable.dice3);
                img.setImageDrawable(res);
            }
            if (num == 4) {
                Drawable res = getResources().getDrawable(R.drawable.dice4);
                img.setImageDrawable(res);
            }
            if (num == 5) {
                Drawable res = getResources().getDrawable(R.drawable.dice5);
                img.setImageDrawable(res);
            }
            if (num == 6) {
                Drawable res = getResources().getDrawable(R.drawable.dice6);
                img.setImageDrawable(res);
            }
        }
    }

    public void rollCreate(View view) {
        TextView userTurn = (TextView) findViewById(R.id.textView3);
        int num = random.nextInt(6);
        if (num == 1) {
            rollHelper(view, num);
            userTurnScore = 0;
            userTurn.setText("turn score = 0");
            computerTurn(view);
        } else {
            rollHelper(view, num);
            userTurnScore = userTurnScore + num;
            userTurn.setText("turn score = " + Integer.toString(userTurnScore));
        }
    }




     /*
    If the roll is not a 1, update the user's turn score by the value of the roll and update the label to
    "Your score: 0 computer score: 0 your turn score: X".
    If the roll is a 1, reset the turn score to 0 and update the label accordingly. TextView can be
    edited programmatically by calling findViewById to get the TextView object.

    Having written the basic "Roll" functionality, you can tackle the other two button handlers:

    When ResetButton is clicked, reset the 4 global variables to 0 and update the label text
    When HoldButton is clicked, updating the user's overall score, reset the user round score and update the label.

     */

    public void resetCreate(View view) {
        Button roll = (Button) findViewById(R.id.button);//is there more neat or less-code way for this?
        Button hold = (Button) findViewById(R.id.button2);
        roll.setEnabled(true); //how can i do that through attribute in the xml file "clickable"?
        hold.setEnabled(true);
        userOverallScore = 0;
        userTurnScore = 0;
        computerOverallScore = 0;
        computerTurnScore = 0;
        TextView resetUserTurn = (TextView) findViewById(R.id.textView3);
        resetUserTurn.setText("turn score = 0");
//         TextView resetComputerTurn = (TextView) findViewById(R.id.textView3);
        TextView resetOverallUserTurn = (TextView) findViewById(R.id.textView);
        resetOverallUserTurn.setText("Your score = 0");
        TextView resetOverallComputerTurn = (TextView) findViewById(R.id.textView2);
        resetOverallComputerTurn.setText("Computer score = 0");
    }

    public void holdCreate(View view) {
        userOverallScore = userOverallScore + userTurnScore;
        userTurnScore = 0;
        TextView userTurn = (TextView) findViewById(R.id.textView3);
        TextView overallUserTurn = (TextView) findViewById(R.id.textView);
        if (userOverallScore >= 100) {
            overallUserTurn.setText("Your score = " + Integer.toString(userOverallScore));
            userTurn.setText("YOU WIN!");
            helperClean(view, false);
        } else {
            overallUserTurn.setText("Your score = " + Integer.toString(userOverallScore));
            userTurn.setText("turn score = 0");
            computerTurn(view);
        }
    }

    public void helperClean(View view, boolean buttonVal) {
        Button roll = (Button) findViewById(R.id.button);
        Button hold = (Button) findViewById(R.id.button2);
        roll.setEnabled(buttonVal); //how can i do that through attribute in the xml file "clickable"?
        hold.setEnabled(buttonVal);
        TextView computerOverall = (TextView) findViewById(R.id.textView2);
        computerOverall.setText("Computer score = " + Integer.toString(computerOverallScore));
    }

    public void computerTurn(View view) {//how can I return to the user turn?
        boolean compTurn = true;
        ImageView img = (ImageView) findViewById(R.id.imageView);
        TextView computerTurn = (TextView) findViewById(R.id.textView3);
        helperClean(view, false);
//        while (compTurn) {
        int num = random.nextInt(6);
        if (num == 1) {
            rollHelper(view, num);
            computerTurnScore = 0;
            computerTurn.setText("Computer rolled a one");
            helperClean(view, true);
//            compTurn = false;
        } else {
            rollHelper(view, num);
            computerTurnScore = computerTurnScore + num;
            computerTurn.setText("turn score = " + Integer.toString(computerTurnScore));
            compTurn = random.nextBoolean(); //when the computer holds randomly

            if (compTurn) {
                Runnable timerRunnable = new Runnable() {
//                    @Override
//                    new Handler().postDelayed(this, 500);
                    public void run() {
                        Handler timeHandler = new Handler();
                        timeHandler.postDelayed(this, 500);
                    }
                };
                computerTurn(view); // recursion???
            } else {
                computerOverallScore = computerOverallScore + computerTurnScore;
                helperClean(view, true);
            }
        }
        if (computerOverallScore >= 100) {
            helperClean(view, false);
            computerTurn.setText("COMPUTER WINS!");
        }
        helperClean(view, true);
    }
}



