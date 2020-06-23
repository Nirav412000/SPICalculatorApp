package com.example.spi_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MePage extends AppCompatActivity {
    EditText clds,clee,clte,clle,clasm,clhs,clie,clmp;
    Button clget;
    TextView clspi;
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me_page);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mInterstitialAd = new InterstitialAd(MePage.this);
        mInterstitialAd.setAdUnitId("ca-app-pub-7504258254981283/4514983679");

        clds = findViewById(R.id.memd);
        clee = findViewById(R.id.mept);
        clte = findViewById(R.id.mele);
        clle = findViewById(R.id.memm);
        clasm = findViewById(R.id.memp);
        clhs = findViewById(R.id.merg);
        clie = findViewById(R.id.mews);
        clmp = findViewById(R.id.mete);
        clspi = findViewById(R.id.mespi);
        clget = findViewById(R.id.meget);

        clget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mInterstitialAd.loadAd(new AdRequest.Builder().build());
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }

                String cdaa = clds.getText().toString().trim();
                String cse = clee.getText().toString().trim();
                String cob = clte.getText().toString().trim();
                String cci = clle.getText().toString().trim();
                String cmp = clasm.getText().toString().trim();
                String cjt = clhs.getText().toString().trim();
                String cnse = clie.getText().toString().trim();
                String cml = clmp.getText().toString().trim();

                if(TextUtils.isEmpty(cdaa)){ clds.setError("Required"); return; }
                if(TextUtils.isEmpty(cse)){ clee.setError("Required"); return;  }
                if(TextUtils.isEmpty(cob)){ clte.setError("Required"); return;  }
                if(TextUtils.isEmpty(cci)){ clle.setError("Required"); return;  }
                if(TextUtils.isEmpty(cmp)){ clasm.setError("Required"); return; }
                if(TextUtils.isEmpty(cjt)){ clhs.setError("Required"); return;  }
                if(TextUtils.isEmpty(cnse)){ clie.setError("Required"); return; }
                if(TextUtils.isEmpty(cml)){ clmp.setError("Required"); return;  }

                int cc1=getvalue(cdaa)*4;
                int cc2=getvalue(cse)*4;
                int cc3=getvalue(cob)*2;
                int cc4=getvalue(cci)*3;
                int cc5=getvalue(cmp)*1;
                int cc6=getvalue(cjt)*3;
                int cc7=getvalue(cnse)*3;
                int cc8=getvalue(cml)*4;


                double pointer = cc1+cc2+cc3+cc4+cc5+cc6+cc7+cc8;
                pointer = pointer/24;
                Double ans=new Double(pointer);
                Double aans= BigDecimal.valueOf(ans).setScale(3, RoundingMode.HALF_UP).doubleValue();
                clspi.setText(Double.toString(aans));


            }
        });
    }
    public static int getvalue(String s){
        if(s.length()==2){
            if(s.charAt(0)=='A' || s.charAt(0)=='a')
                return 10;
            else if(s.charAt(0)=='B'  || s.charAt(0)=='b')
                return 8;
            else if(s.charAt(0)=='C'  || s.charAt(0)=='c')
                return 6;
        }
        else{
            if(s.charAt(0)=='A' || s.charAt(0)=='a')
                return 9;
            else if(s.charAt(0)=='B' || s.charAt(0)=='b')
                return 7;
            else if(s.charAt(0)=='C'  || s.charAt(0)=='c')
                return 5;
            else
                return 4;
        }
        return 0;
    }


}
