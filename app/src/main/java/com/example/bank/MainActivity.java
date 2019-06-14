package com.example.bank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView titlePage, subTitlePage, completeName, userName;
    Button btnSave, btnCancel;

    // sets var datas
    String SHARED_PREFS = "sharedPrefs";
    String SHARED_PREFS2 = "sharedPrefs2";
    String userCompleteName = "";
    String getUserCompleteName;
    String userUserName = "";
    String getUserUserName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // target element
        titlePage = findViewById(R.id.titlePage);
        subTitlePage = findViewById(R.id.subTitlePage);
        completeName = findViewById(R.id.completeName);
        userName = findViewById(R.id.userName);

        btnSave = findViewById(R.id.btnSave);
        btnCancel = findViewById(R.id.btnCancel);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // save data
                SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(userCompleteName, completeName.getText().toString());
                editor.apply();

                // save data2
                SharedPreferences sharedPreferencesII = getSharedPreferences(SHARED_PREFS2, MODE_PRIVATE);
                SharedPreferences.Editor editorII = sharedPreferencesII.edit();
                editorII.putString(userCompleteName, userName.getText().toString());
                editorII.apply();

                // bring  user to anothe screen
                Intent a = new Intent (MainActivity.this,BankAct.class);
                startActivity(a);
            }
        });

        // import fonts
        Typeface MLight = Typeface.createFromAsset(getAssets(), "fonts/MLight.ttf");
        Typeface MRegular = Typeface.createFromAsset(getAssets(), "fonts/MRegular.ttf");
        Typeface MMedium = Typeface.createFromAsset(getAssets(), "fonts/MMedium.ttf");

        // customize font
        titlePage.setTypeface(MRegular);
        subTitlePage.setTypeface(MLight);
        completeName.setTypeface(MRegular);
        userName.setTypeface(MRegular);

        btnSave.setTypeface(MMedium);
        btnCancel.setTypeface(MLight);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(MainActivity.this,BankAct.class);
                startActivity(a);
            }
        });

        //load function
        loadData();
        updateData();
    }

    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences sharedPreferencesII = getSharedPreferences(SHARED_PREFS2, MODE_PRIVATE);
        getUserCompleteName = sharedPreferences.getString(userCompleteName, "");
        getUserUserName = sharedPreferencesII.getString(userUserName, "");
    }

    public void updateData() {
        completeName.setText(getUserCompleteName);
        userName.setText(getUserUserName);
    }
}
