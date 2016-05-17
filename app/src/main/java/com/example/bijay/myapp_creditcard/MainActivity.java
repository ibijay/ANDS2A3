package com.example.bijay.myapp_creditcard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText cb, eyi, emp, fcb, mr, ip;

    double cardbal, yearlyint, minimumpay, finalcardbal, intpaid;
    int monthremain;
    double mon_cardbal, mon_intpaid, mon_principal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cb = (EditText) findViewById(R.id.editText_cb);
        eyi = (EditText) findViewById(R.id.editText_eyi);
        emp = (EditText) findViewById(R.id.editText_emp);

        fcb = (EditText) findViewById(R.id.editText_fcb);
        mr = (EditText) findViewById(R.id.editText_mr);
        ip = (EditText) findViewById(R.id.editText_ip);

    }

    public void Compute(View v) {

        cardbal = Double.parseDouble(cb.getText().toString());
        minimumpay = Double.parseDouble(emp.getText().toString());
        yearlyint = Double.parseDouble(eyi.getText().toString());

        mon_cardbal = cardbal;
        mon_intpaid = 0;
        intpaid = 0;
        monthremain=0;
        mon_principal = 0;
        while (mon_cardbal > 0) {
            monthremain++;
            mon_intpaid = Math.round((mon_cardbal * (yearlyint / (100 * 12))));
            if (mon_cardbal > minimumpay) {
                mon_principal = minimumpay - mon_intpaid;
            } else {
                mon_principal = mon_cardbal;
            }
            intpaid += mon_intpaid;
            mon_cardbal -= mon_principal;
        }
        finalcardbal = mon_principal;
        fcb.setText("" + finalcardbal);
        mr.setText("" + monthremain);
        ip.setText("" + intpaid);
    }

    public void Clear (View v){

        cb.setText("0");
        emp.setText("0");
        eyi.setText("0");
        fcb.setText("0");
        mr.setText("0");
        ip.setText("0");
    }
}