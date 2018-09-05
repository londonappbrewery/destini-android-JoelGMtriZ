package com.londonappbrewery.destini;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    Button buttonTop;
    Button buttonBottom;
    TextView storyTextView;
    int mStoryIndex = 0;
    String gameOver = "Game Over. LoL!!!";

    private int[] mStoryBank = {
            R.string.T1_Story,
            R.string.T2_Story,
            R.string.T3_Story,
            R.string.T4_End,
            R.string.T5_End,
            R.string.T6_End
    };

    private int[] mButtonTop = {
            R.string.T1_Ans1,
            R.string.T2_Ans1,
            R.string.T3_Ans1
    };

    private int[] mButtonBottom = {
            R.string.T1_Ans2,
            R.string.T2_Ans2,
            R.string.T3_Ans2
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        buttonTop = findViewById(R.id.buttonTop);
        buttonBottom = findViewById(R.id.buttonBottom);
        storyTextView = findViewById(R.id.storyTextView);

        storyTextView.setText(mStoryBank[mStoryIndex]);


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        buttonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mStoryIndex == 0 || mStoryIndex == 1) {
                    updateStory(2);
                    updateButtons(2);
                }

                else {
                    updateStory(5);
                    updateButtons(5);
                }

            }
        });




        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        buttonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mStoryIndex > 2){
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
                    AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                    alert.setTitle(gameOver);
                    alert.setCancelable(false);
                    alert.setMessage("You Have Completed The Game!!!");
                    alert.setPositiveButton("Close Application", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    });
                    alert.show();
                }

                else if (mStoryIndex == 0) {
                    updateStory(1);
                    updateButtons(1);
                }

                else if (mStoryIndex == 1) {
                    updateStory(3);
                    updateButtons(3);
                }

                else if (mStoryIndex == 2) {
                    updateStory(4);
                    updateButtons(4);
                }
            }
        });


    }

    private void updateStory(int storyIndex) {
        mStoryIndex = storyIndex;
        storyTextView.setText(mStoryBank[storyIndex]);
    }

    private void updateButtons(int storyIndex) {

        if (storyIndex < 3) {
            buttonTop.setText(mButtonTop[storyIndex]);
            buttonBottom.setText(mButtonBottom[storyIndex]);
        }

        else {
            buttonTop.setVisibility(View.GONE);
            buttonBottom.setText(R.string.EndGame);
        }
    }

}
