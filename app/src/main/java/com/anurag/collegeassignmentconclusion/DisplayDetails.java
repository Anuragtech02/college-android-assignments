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

import static android.view.View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR;
import static android.view.View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
import static android.view.WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS;

public class DisplayDetails extends AppCompatActivity {

    // Edit Fields
    EditText firstName, lastName, tenthMarks;
    EditText twelfthMarks, stream, fathersName, mothersName;
    EditText mobileNumber, city;

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
        firstName = findViewById(R.id.etFirstName);
        lastName = findViewById(R.id.etLastName);
        tenthMarks = findViewById(R.id.etTenthMarks);
        twelfthMarks = findViewById(R.id.etTwelfthMarks);
        stream = findViewById(R.id.etStream);
        fathersName = findViewById(R.id.etFathersName);
        mothersName = findViewById(R.id.etMothersName);
        mobileNumber = findViewById(R.id.etMobileNumber);
        city = findViewById(R.id.etCity);

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

        incomingIntent.getStringExtra("firstName");
        incomingIntent.getStringExtra("lastName");
        incomingIntent.getStringExtra("fathersName");
        incomingIntent.getStringExtra("mothersName");
        incomingIntent.getStringExtra("mobileNumber");
        incomingIntent.getStringExtra("tenthMarks");
        incomingIntent.getStringExtra("twelfthMarks");
        incomingIntent.getStringExtra("stream");
        incomingIntent.getStringExtra("city");

    }
}