package com.example.bank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BankAct extends AppCompatActivity {

    TextView titlePage, subTitlePage, completeName, userName, bankOne, expired;

    Button btnEdit;

    // sets var datas
    String SHARED_PREFS = "sharedPrefs";
    String SHARED_PREFS2= "sharedPrefs2";
    String userCompleteName = "";
    String getUserCompleteName;
    String userUserName = "";
    String getUserUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank);

        // target element
        titlePage = findViewById(R.id.titlePage);
        subTitlePage = findViewById(R.id.subTitlePage);
        completeName = findViewById(R.id.completeName);
        userName = findViewById(R.id.userName);
        bankOne = findViewById(R.id.bankOne);
        expired = findViewById(R.id.expired);

        btnEdit = findViewById(R.id.btnEdit);

        // import fonts
        Typeface MLight = Typeface.createFromAsset(getAssets(), "fonts/MLight.ttf");
        Typeface MRegular = Typeface.createFromAsset(getAssets(), "fonts/MRegular.ttf");
        Typeface MMedium = Typeface.createFromAsset(getAssets(), "fonts/MMedium.ttf");

        // customize font
        titlePage.setTypeface(MRegular);
        subTitlePage.setTypeface(MLight);
        completeName.setTypeface(MRegular);
        userName.setTypeface(MRegular);

        bankOne.setTypeface(MMedium);
        expired.setTypeface(MLight);

        btnEdit.setTypeface(MMedium);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //bring user to another activity
                Intent a = new Intent(BankAct.this,MainActivity.class);
                startActivity(a);
            }
        });

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
