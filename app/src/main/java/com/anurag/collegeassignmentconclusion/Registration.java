package com.anurag.collegeassignmentconclusion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.view.View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR;
import static android.view.View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
import static android.view.WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS;

public class Registration extends AppCompatActivity {

    // Edit Fields
    EditText firstName, lastName, tenthMarks;
    EditText twelfthMarks, stream, fathersName, mothersName;
    EditText mobileNumber, city;

    // Check Fields
    RadioGroup criteriaGroup, genderGroup;
    RadioButton rbCGPA, rbPercentage, rbMale, rbFemale, rbOther; //Selected buttons for form validation
    CheckBox cbAndroid, cbWeb, cbGCP, cbAzure, cbNumpy; //Checkboxes for skills

    //Buttons
    Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

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

        //Buttons Initialisation
        submitBtn = findViewById(R.id.submitBtn);

        //List for skills selected
        ArrayList<String> skills = new ArrayList<>();

        cbAndroid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cbAndroid.isChecked()){  //If checkbox is checked then add to list
                    skills.add("Android");
                }else{
                    skills.remove("Android"); //If not checked remove from the list.
                }
            }
        });

        cbWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cbWeb.isChecked()){
                    skills.add("Web");
                }else{
                    skills.remove("Web");
                }
            }
        });

        cbGCP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cbGCP.isChecked()){
                    skills.add("GCP");
                }else{
                    skills.remove("GCP");
                }
            }
        });

        cbAzure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cbAzure.isChecked()){
                    skills.add("Azure");
                }else{
                    skills.remove("Azure");
                }
            }
        });

        cbNumpy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cbNumpy.isChecked()){
                    skills.add("Numpy");
                }else{
                    skills.remove("Numpy");
                }
            }
        });

        //onClick listener for submit btn,
        // This function checks if all the fields are filled and then passes the values to the next activity
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Check if any of the fields is not filled
                if(!checkInputFields() || !checkRadioAndCheckBoxes())
                    //If any field is empty, immediately return
                    return;

                Intent intent = new Intent(Registration.this, DisplayDetails.class);

                //Pass edit text values
                intent.putExtra("firstName", firstName.getText().toString());
                intent.putExtra("lastName", lastName.getText().toString());
                intent.putExtra("fathersName", fathersName.getText().toString());
                intent.putExtra("mothersName", mothersName.getText().toString());
                intent.putExtra("mobileNumber", mobileNumber.getText().toString());
                intent.putExtra("tenthMarks", tenthMarks.getText().toString());
                intent.putExtra("twelfthMarks", twelfthMarks.getText().toString());
                intent.putExtra("stream", stream.getText().toString());
                intent.putExtra("city", city.getText().toString());

                //Parse and pass radio group values
                RadioButton criteria = findViewById(criteriaGroup.getCheckedRadioButtonId());
                RadioButton gender = findViewById(genderGroup.getCheckedRadioButtonId());
                intent.putExtra("criteria", criteria.getText().toString());
                intent.putExtra("gender", gender.getText().toString());

                //Pass skills
                intent.putExtra("skills", skills);

                //Display Success Toast before starting new activity
                Toast.makeText(Registration.this, "Successfully Submitted Form", Toast.LENGTH_SHORT).show();

                startActivity(intent);

            }
        });

    }

    private boolean checkInputFields(){
        if (firstName.length() == 0) {
            firstName.setError("This field is required");
            return false;
        }

        if (lastName.length() == 0) {
            lastName.setError("This field is required");
            return false;
        }

        if (fathersName.length() == 0) {
            fathersName.setError("This field is required");
            return false;
        }

        if (mothersName.length() == 0) {
            mothersName.setError("This field is required");
            return false;
        }

        if (tenthMarks.length() == 0) {
            tenthMarks.setError("This field is required");
            return false;
        }

        if (twelfthMarks.length() == 0) {
            twelfthMarks.setError("This field is required");
            return false;
        }

        if (stream.length() == 0) {
            stream.setError("This field is required");
            return false;
        }
        if (mobileNumber.length() == 0) {
            mobileNumber.setError("This field is required");
            return false;
        }
        if (city.length() == 0) {
            city.setError("This field is required");
            return false;
        }
        if (mothersName.length() == 0) {
            mothersName.setError("This field is required");
            return false;
        }

        // if no errors found ; return true
        return true;
    }

    private boolean checkRadioAndCheckBoxes(){

        if (criteriaGroup.getCheckedRadioButtonId() == -1 ) {
            rbCGPA.setError("This field is required");
            rbPercentage.setError("This field is required");
            return false;
        }

        if(genderGroup.getCheckedRadioButtonId() == -1){
            rbMale.setError("This field is required");
            rbFemale.setError("This field is required");
            rbOther.setError("This field is required");
        }

        // if no errors found ; return true
        return true;
    }
}
