package edu.oakland;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    //Declare checkboxes
    CheckBox backgroundCB;
    CheckBox textColorCB;

    //Declare Textview to show the hex value of color
    TextView bgColorTV;
    TextView txColorTV;

    //Declare the frame
    TextView myClr;

    //Declare the Textview  which is inside the frame
    TextView textColor;

    //Declare the Radio Group and two Radio Buttons
    RadioGroup rgb;
    RadioButton bgColorRB;
    RadioButton textColorRB;

    //Declare all the Seekbars and its Textview which the show the intensity of colors
    SeekBar redSB;
    SeekBar greenSB;
    SeekBar blueSB;
    TextView redTV;
    TextView greenTV;
    TextView blueTV;

    //Initializing variables
    int red = 100;
    int green = 100;
    int blue = 100;
    int bg_red =100;
    int bg_green =100;
    int bg_blue = 100;
    int tx_red = 255;
    int tx_green = 255;
    int tx_blue = 255;




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        backgroundCB = findViewById(R.id.backgroundCB);
        textColorCB = findViewById(R.id.textColorCB);
        bgColorTV = findViewById(R.id.bgColorTV);
        txColorTV = findViewById(R.id.txColorTV);
        myClr = findViewById(R.id.myClr);
        textColor = findViewById(R.id.textColor);
        rgb = findViewById(R.id.rgb);
        bgColorRB = findViewById(R.id.bgColorRB);
        textColorRB = findViewById(R.id.textColorRB);
        redSB = findViewById(R.id.redSB);
        greenSB = findViewById(R.id.greenSB);
        blueSB = findViewById(R.id.blueSB);
        redTV = findViewById(R.id.redTV);
        greenTV = findViewById(R.id.greenTV);
        blueTV = findViewById(R.id.blueTV);

        //Initially Radio Button is checked when the app runs. The frame rgb color is set to 100 and text rgb color is set to 255.
        bgColorRB.setChecked(true);
        myClr.setBackgroundColor(Color.rgb(100, 100, 100));
        textColor.setTextColor(Color.rgb(255, 255, 255));

        //This method will invoke when background color checkbox is checked
        backgroundCB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    bgColorTV.setText(String.format("#%02X%02X%02X", bg_red, bg_green, bg_blue));

                }else{
                    bgColorTV.setText(null);
                }
            }
        });

        //This method will invoke when text color checkbox is checked
        textColorCB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    txColorTV.setText(String.format("#%02X%02X%02X", tx_red, tx_green, tx_blue));
                }else{
                    txColorTV.setText(null);
                }
            }
        });

        //This method will invoke when user plays with Red seekbar
        redSB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                red = redSB.getProgress();
                redTV.setText(String.valueOf(red));
                setColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        //This method will invoke when play with Green seekbar
        greenSB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                green = greenSB.getProgress();
                greenTV.setText(String.valueOf(green));
                setColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //This method will invoke when play with Blue seekbar
        blueSB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                blue = blueSB.getProgress();
                blueTV.setText(String.valueOf(blue));
                setColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    //This method is use to set the colors
    public void setColor()
    {

        if(bgColorRB.isChecked()){
            myClr.setBackgroundColor(Color.rgb(red, green, blue));
            bg_red = red;
            bg_green = green;
            bg_blue = blue;
        } else{
            textColor.setTextColor(Color.rgb(red, green, blue));
            tx_red = red;
            tx_green = green;
            tx_blue = blue;
        }

        if(backgroundCB.isChecked())
        {
            bgColorTV.setText(String.format("#%02X%02X%02X", bg_red, bg_green, bg_blue));

        }else{
            bgColorTV.setText(null);
        }

        if(textColorCB.isChecked())
        {
            txColorTV.setText(String.format("#%02X%02X%02X", tx_red, tx_green, tx_blue));
        }else{
            txColorTV.setText(null);
        }

    }
}