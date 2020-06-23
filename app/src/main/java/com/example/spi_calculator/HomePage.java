package com.example.spi_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class HomePage extends AppCompatActivity {

    RadioGroup rg;
    RadioButton rb;
    Button sel;
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mInterstitialAd = new InterstitialAd(HomePage.this);
        mInterstitialAd.setAdUnitId("ca-app-pub-7504258254981283/4514983679");




        rg = findViewById(R.id.radioGroup2);
        sel = findViewById(R.id.select);
        openDialog();

        sel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mInterstitialAd.loadAd(new AdRequest.Builder().build());
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }


                int idd=rg.getCheckedRadioButtonId();
                rb = (RadioButton) findViewById(idd);
                String str=rb.getText().toString().trim();
                if(str.equals("CSE/IT")){
                    Toast.makeText(HomePage.this, "Moved To CSE/IT Page", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(HomePage.this,CsePage.class));
                }
                if(str.equals("ME")){
                    Toast.makeText(HomePage.this, "Moved To ME", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(HomePage.this,MePage.class));
                }
                if(str.equals("EE")){
                    Toast.makeText(HomePage.this, "Moved To EE", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(HomePage.this,EePage.class));
                }
                if(str.equals("CL")){
                    Toast.makeText(HomePage.this, "Moved To CL", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(HomePage.this,ClPage.class));
                }
            }
        });
    }

    private void openDialog() {
        NoticeDialog dia=new NoticeDialog();
        dia.show(getSupportFragmentManager(),"Notice Dialog");
    }
}
