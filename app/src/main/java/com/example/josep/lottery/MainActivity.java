package com.example.josep.lottery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ToggleButton;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Locate the button in activity_main.xml
        Button button = (Button) findViewById(R.id.button);



        // Capture button clicks
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Radio button value variables
                int value1 = -1;
                int value2 = -1;
                int value3 = -1;
                int value4 = -1;
                int value5 = -1;

                RadioGroup rg1 = (RadioGroup) findViewById(R.id.toggleGroup1);
                String selectedRadioValue1 = ((RadioButton)findViewById(rg1.getCheckedRadioButtonId())).getText().toString();
                value1 = Integer.parseInt(selectedRadioValue1);
                RadioGroup rg2 = (RadioGroup) findViewById(R.id.toggleGroup2);
                String selectedRadioValue2 = ((RadioButton)findViewById(rg2.getCheckedRadioButtonId())).getText().toString();
                value2 = Integer.parseInt(selectedRadioValue2);
                RadioGroup rg3 = (RadioGroup) findViewById(R.id.toggleGroup3);
                String selectedRadioValue3 = ((RadioButton)findViewById(rg3.getCheckedRadioButtonId())).getText().toString();
                value3 = Integer.parseInt(selectedRadioValue3);
                RadioGroup rg4 = (RadioGroup) findViewById(R.id.toggleGroup4);
                String selectedRadioValue4 = ((RadioButton)findViewById(rg4.getCheckedRadioButtonId())).getText().toString();
                value4 = Integer.parseInt(selectedRadioValue4);
                RadioGroup rg5 = (RadioGroup) findViewById(R.id.toggleGroup5);
                String selectedRadioValue5 = ((RadioButton)findViewById(rg5.getCheckedRadioButtonId())).getText().toString();
                value5 = Integer.parseInt(selectedRadioValue5);

                // Start NewActivity.class
                Intent myIntent = new Intent(MainActivity.this,
                        Results.class);
                myIntent.putExtra("radioGroup1Selected", value1);
                myIntent.putExtra("radioGroup2Selected", value2);
                myIntent.putExtra("radioGroup3Selected", value3);
                myIntent.putExtra("radioGroup4Selected", value4);
                myIntent.putExtra("radioGroup5Selected", value5);
                startActivity(myIntent);
            }
        });
    }

    // Make the radio group a set of Toggle Buttons
    static final RadioGroup.OnCheckedChangeListener ToggleListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(final RadioGroup radioGroup, final int i) {
            for (int j = 0; j < radioGroup.getChildCount(); j++) {
                final ToggleButton view = (ToggleButton) radioGroup.getChildAt(j);
                view.setChecked(view.getId() == i);
            }
        }
    };

    public void onToggle(View view) {
        ((RadioGroup)view.getParent()).check(view.getId());

    }


}

/**
 *
 * The lottery class sets the lottery numbers randomly and compares them to the user's pick.
 *
 */

class Lottery
{
    private int[] lotteryNumbers;
    private int[] lotteryPicks;

    /**
     * Constructor
     */
    public Lottery()
    {
        lotteryNumbers = new int[5];
        lotteryPicks = new int[5];

        // Create Random Object
        Random randomNumbers = new Random();
        // Set random numbers into lotteryNumbers array
        for (int index = 0; index < lotteryNumbers.length; index++)
        {
            lotteryNumbers[index] = randomNumbers.nextInt(7);
        }
    }

    /**
     * The comparePicks method compares the users picks to the randomly generated lottery numbers
     * @param p User's lottery picks
     * @return The number of matching lottery numbers
     */
    public int comparePicks(int[] p)
    {
        int counter = 0;			// Matching lottery picks counter
        // Set lottery picks
        for (int index = 0; index < lotteryPicks.length; index++)
        {
            lotteryPicks[index] = p[index];
        }
        // Compare lottery picks and add up matching picks
        for (int index = 0; index < lotteryNumbers.length; index++)
        {
            if (lotteryNumbers[index] == lotteryPicks[index])
                counter++;
        }
        // Return number of correct matches
        return counter;
    }

    /**
     * The getLotteryNumbers method returns a copy of the lotteryNumbers array
     * @return Randomly generated lottery numbers
     */
    public int[] getLotteryNumbers()
    {
        return lotteryNumbers;
    }
}
