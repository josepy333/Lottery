package com.example.josep.lottery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


/**
 * The Results class is a new activity that displays the results and handles the comparison of
 * user picks and lottery numbers.
 */
public class Results extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        Intent callingIntent = getIntent();

        // Values of user picks
        int value1 = callingIntent.getIntExtra("radioGroup1Selected", 0);
        int value2 = callingIntent.getIntExtra("radioGroup2Selected", 0);
        int value3 = callingIntent.getIntExtra("radioGroup3Selected", 0);
        int value4 = callingIntent.getIntExtra("radioGroup4Selected", 0);
        int value5 = callingIntent.getIntExtra("radioGroup5Selected", 0);

        int[] p = new int[5];		// Lottery picks
        int[] r;		            // Random lottery numbers
        int matching;				// Number of matching lottery numbers

        // Create Lottery object
        Lottery picks = new Lottery();

        // Get randomly generated lottery numbers
        r = picks.getLotteryNumbers();

        // Set user picks in array
        p[0] = value1;
        p[1] = value2;
        p[2] = value3;
        p[3] = value4;
        p[4] = value5;

        // Compare the lottery picks
        matching = picks.comparePicks(p);

        //Display the results
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setText("");
        if (matching == 5)
        {
            tv.append("CONGRATULATIONS!!! YOU WON THE GRAND PRIZE of $10,000!!!\n\n");
            tv.append("Your lottery numbers were:\n");
            for (int index = 0; index < p.length; index++)
            {
                tv.append(p[index] + " ");
            }
            tv.append("\nThe correct lottery numbers were:\n");
            for (int index = 0; index < r.length; index++)
            {
                tv.append(r[index] + " ");
            }
        }
        else if (matching == 4)
        {
            tv.append("You got " + matching + " matching lottery numbers.\n");
            tv.append("You won $1000!!\n\n");
            tv.append("Your lottery numbers were:\n");
            for (int index = 0; index < p.length; index++)
            {
                tv.append(p[index] + " ");
            }
            tv.append("\nThe correct lottery numbers were:\n");
            for (int index = 0; index < r.length; index++)
            {
                tv.append(r[index] + " ");
            }
        }
        else if (matching == 3)
        {
            tv.append("You got " + matching + " matching lottery numbers.\n");
            tv.append("You won $100!\n\n");
            tv.append("Your lottery numbers were:\n");
            for (int index = 0; index < p.length; index++)
            {
                tv.append(p[index] + " ");
            }
            tv.append("\nThe correct lottery numbers were:\n");
            for (int index = 0; index < r.length; index++)
            {
                tv.append(r[index] + " ");
            }
        }
        else if (matching == 2)
        {
            tv.append("You got " + matching + " matching lottery numbers.\n");
            tv.append("You won $10.\n\n");
            tv.append("Your lottery numbers were:\n");
            for (int index = 0; index < p.length; index++)
            {
                tv.append(p[index] + " ");
            }
            tv.append("\nThe correct lottery numbers were:\n");
            for (int index = 0; index < r.length; index++)
            {
                tv.append(r[index] + " ");
            }
        }
        else if (matching == 1)
        {
            tv.append("You lost with " + matching + " matching lottery number.\n\n");
            tv.append("Your lottery numbers were:\n");
            for (int index = 0; index < p.length; index++)
            {
                tv.append(p[index] + " ");
            }
            tv.append("\nThe correct lottery numbers were:\n");
            for (int index = 0; index < r.length; index++)
            {
                tv.append(r[index] + " ");
            }
        }
        else if (matching == 0)
        {
            tv.append("You lost with " + matching + " matching lottery numbers.\n\n");
            tv.append("Your lottery numbers were:\n");
            for (int index = 0; index < p.length; index++)
            {
                tv.append(p[index] + " ");
            }
            tv.append("\nThe correct lottery numbers were:\n");
            for (int index = 0; index < r.length; index++)
            {
                tv.append(r[index] + " ");
            }
        }

        Button button = (Button) findViewById(R.id.button2);

        // Capture button clicks
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent intent = new Intent(Results.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //this will always start your activity as a new task
                startActivity(intent);
            }
        });
    }
}
