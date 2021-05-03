package com.anurag.collegeassignmentconclusion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

import static android.view.View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR;
import static android.view.View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
import static android.view.WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS;

public class DisplayDetails extends AppCompatActivity {

    // Edit Fields
    TextView firstName, lastName, tenthMarks;
    TextView twelfthMarks, stream, fathersName, mothersName;
    TextView mobileNumber, city;

    // Check Fields
    RadioGroup criteriaGroup, genderGroup;
    RadioButton rbCGPA, rbPercentage, rbMale, rbFemale, rbOther; //Selected buttons for form validation
    CheckBox cbAndroid, cbWeb, cbGCP, cbAzure, cbNumpy; //Checkboxes for skills


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_details);

        //Changing the color of status bar to white
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.white));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS |
                    SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR | SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        //Edit Fields initialisation
        firstName = findViewById(R.id.tvValueFirstName);
        lastName = findViewById(R.id.tvValueLastName);
        tenthMarks = findViewById(R.id.tvValueTenthMarks);
        twelfthMarks = findViewById(R.id.tvValueTwelfthMarks);
        stream = findViewById(R.id.tvValueStream);
        fathersName = findViewById(R.id.tvValueFathersName);
        mothersName = findViewById(R.id.tvValueMothersName);
        mobileNumber = findViewById(R.id.tvValueMobileNumber);
        city = findViewById(R.id.tvValueCity);

        //Check fields initialisation
        criteriaGroup = findViewById(R.id.rgCriteria);
        genderGroup = findViewById(R.id.rgGender);
        rbCGPA = findViewById(R.id.rbCGPA);
        rbPercentage = findViewById(R.id.rbPercentage);
        rbMale = findViewById(R.id.rbMale);
        rbFemale = findViewById(R.id.rbFemale);
        rbOther = findViewById(R.id.rbOther);

        //Checkboxes
        cbAndroid = findViewById(R.id.cbAndroid);
        cbWeb = findViewById(R.id.cbWeb);
        cbGCP = findViewById(R.id.cbGCP);
        cbAzure = findViewById(R.id.cbAzure);
        cbNumpy = findViewById(R.id.cbNumpy);

        //Get data from intent
        Intent incomingIntent = getIntent();

        firstName.setText(incomingIntent.getStringExtra("firstName"));
        lastName.setText(incomingIntent.getStringExtra("lastName"));
        fathersName.setText(incomingIntent.getStringExtra("fathersName"));
        mothersName.setText(incomingIntent.getStringExtra("mothersName"));
        mobileNumber.setText(incomingIntent.getStringExtra("mobileNumber"));
        tenthMarks.setText(incomingIntent.getStringExtra("tenthMarks"));
        twelfthMarks.setText(incomingIntent.getStringExtra("twelfthMarks"));
        stream.setText(incomingIntent.getStringExtra("stream"));
        city.setText(incomingIntent.getStringExtra("city"));

        // Extract radio button ids and check the respective one
        int criteriaId = incomingIntent.getIntExtra("criteria", -1);
        int genderId = incomingIntent.getIntExtra("gender", -1);
        RadioButton criteria = findViewById(criteriaId);
        criteria.setChecked(true);
        RadioButton gender = findViewById(genderId);
        gender.setChecked(true);

        ArrayList<String> skills = incomingIntent.getStringArrayListExtra("skills");

        handleSkills(skills);

    }

    private void handleSkills(ArrayList<String> skills){
        for (String skill: skills){
            switch(skill){
                case "Android":
                    cbAndroid.setChecked(true);
                    break;
                case "Web":
                    cbWeb.setChecked(true);
                    break;
                case "GCP":
                    cbGCP.setChecked(true);
                    break;
                case "Azure":
                    cbAzure.setChecked(true);
                    break;
                case "Numpy":
                    cbNumpy.setChecked(true);
                    break;
            }
        }
    }
}