package com.example.spi_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class EePage extends AppCompatActivity {
    EditText eepsoc,eeedts,eetcme,eemp,eeci,eeres,eess,eeuv;
    Button eeget;
    TextView eespi;
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ee_page);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mInterstitialAd = new InterstitialAd(EePage.this);
        mInterstitialAd.setAdUnitId("ca-app-pub-7504258254981283/4514983679");

        eepsoc = findViewById(R.id.eepsoc);
        eeedts = findViewById(R.id.eeedts);
        eetcme = findViewById(R.id.eetcme);
        eemp = findViewById(R.id.eemp);
        eeci = findViewById(R.id.eeci);
        eeres = findViewById(R.id.eeres);
        eess = findViewById(R.id.eess);
        eeuv = findViewById(R.id.eeuv);
        eespi = findViewById(R.id.eespi);

        eeget = findViewById(R.id.eeget);

        eeget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mInterstitialAd.loadAd(new AdRequest.Builder().build());
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }

                String cdaa = eepsoc.getText().toString().trim();
                String cse = eeedts.getText().toString().trim();
                String cob = eetcme.getText().toString().trim();
                String cci = eemp.getText().toString().trim();
                String cmp = eeci.getText().toString().trim();
                String cjt = eeres.getText().toString().trim();
                String cnse = eess.getText().toString().trim();
                String cml = eeuv.getText().toString().trim();


                if(TextUtils.isEmpty(cdaa)){ eepsoc.setError("Required"); return;  }
                if(TextUtils.isEmpty(cse)){ eeedts.setError("Required"); return;  }
                if(TextUtils.isEmpty(cob)){ eetcme.setError("Required"); return;  }
                if(TextUtils.isEmpty(cci)){ eemp.setError("Required"); return;  }
                if(TextUtils.isEmpty(cmp)){ eeci.setError("Required"); return;  }
                if(TextUtils.isEmpty(cjt)){ eeres.setError("Required"); return;  }
                if(TextUtils.isEmpty(cnse)){ eess.setError("Required"); return;  }
                if(TextUtils.isEmpty(cml)){ eeuv.setError("Required"); return;  }


                int cc1=getvalue(cdaa)*5;
                int cc2=getvalue(cse)*4;
                int cc3=getvalue(cob)*3;
                int cc4=getvalue(cci)*1;
                int cc5=getvalue(cmp)*2;
                int cc6=getvalue(cjt)*3;
                int cc7=getvalue(cnse)*3;
                int cc8=getvalue(cml)*3;


                double pointer = cc1+cc2+cc3+cc4+cc5+cc6+cc7+cc8;
                pointer = pointer/24;
                Double ans=new Double(pointer);
                Double aans= BigDecimal.valueOf(ans).setScale(3, RoundingMode.HALF_UP).doubleValue();
                eespi.setText(Double.toString(aans));

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
