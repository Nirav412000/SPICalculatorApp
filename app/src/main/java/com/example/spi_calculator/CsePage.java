package com.example.spi_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CsePage extends AppCompatActivity {
    EditText csedaa,csese,cseob,cseci,csejt,csense,cseml,csemp,cseuv;
    Button cseget;
    TextView csespi;
    ProgressBar pbr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cse_page);

        csedaa = findViewById(R.id.csedaa);
        csese = findViewById(R.id.csese);
        cseob = findViewById(R.id.cseob);
        cseci = findViewById(R.id.cseci);
        csemp = findViewById(R.id.csemp);
        csejt = findViewById(R.id.csejt);
        csense = findViewById(R.id.csense);
        cseml = findViewById(R.id.cseml);
        cseuv = findViewById(R.id.cseuv);
        csespi = findViewById(R.id.csespi);
        pbr = findViewById(R.id.progressBar2);
        cseget = findViewById(R.id.cseget);

        cseget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cdaa = csedaa.getText().toString().trim();
                String cse = csese.getText().toString().trim();
                String cob = cseob.getText().toString().trim();
                String cci = cseci.getText().toString().trim();
                String cmp = csemp.getText().toString().trim();
                String cjt = csejt.getText().toString().trim();
                String cnse = csense.getText().toString().trim();
                String cml = cseml.getText().toString().trim();
                String cuv = cseuv.getText().toString().trim();

                if(TextUtils.isEmpty(cdaa)){  csedaa.setError("Required"); return;  }
                if(TextUtils.isEmpty(cse)){ csese.setError("Required"); return;  }
                if(TextUtils.isEmpty(cob)){ cseob.setError("Required"); return;  }
                if(TextUtils.isEmpty(cci)){ cseci.setError("Required"); return;  }
                if(TextUtils.isEmpty(cmp)){ csemp.setError("Required"); return;  }
                if(TextUtils.isEmpty(cjt)){ csejt.setError("Required"); return;  }
                if(TextUtils.isEmpty(cnse)){ csense.setError("Required"); return;    }
                if(TextUtils.isEmpty(cml)){ cseml.setError("Required"); return;  }
                if(TextUtils.isEmpty(cuv)){ cseuv.setError("Required");return;   }

                int cc1=getvalue(cdaa)*4;
                int cc2=getvalue(cse)*4;
                int cc3=getvalue(cob)*2;
                int cc4=getvalue(cci)*2;
                int cc5=getvalue(cmp)*1;
                int cc6=getvalue(cjt)*4;
                int cc7=getvalue(cnse)*4;
                int cc8=getvalue(cml)*4;
                int cc9=getvalue(cuv)*3;

                double pointer = cc1+cc2+cc3+cc4+cc5+cc6+cc7+cc8+cc9;
                pointer = pointer/28;
                Double ans=new Double(pointer);
                Double aans= BigDecimal.valueOf(ans).setScale(3, RoundingMode.HALF_UP).doubleValue();
                csespi.setText(Double.toString(aans));

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
