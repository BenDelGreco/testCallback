package com.sightsolutions.testcallback;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CallbackInterface {


    TextView show_tv;
    EditText write_et, nuovo_write_et;
    Button press_btn, reset_btn;

    double count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        show_tv = findViewById(R.id.show_tv);
        write_et = findViewById(R.id.write_et);
        nuovo_write_et = findViewById(R.id.nuovo_write_et);

        press_btn = findViewById(R.id.press_btn);
        reset_btn = findViewById(R.id.reset_btn);

        //primo esempio
        reset_btn.setEnabled(false);
        write_et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                reset_btn.setEnabled(callBoolean(charSequence.toString()));
                count = callCambiaValoreAggiunto(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        //secondo esempio
        count = 0.0;
        press_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callVoid(count++);
            }
        });

        //terzo esempio
        reset_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset();
            }
        });

        //quarto esempio
        nuovo_write_et.addTextChangedListener(new NewTextWatcher(this));


    }




    @Override
    public void callVoid(double val) {
        show_tv.setText(String.valueOf(val));
    }

    @Override
    public void reset() {
        count = 0;
        show_tv.setText("");
        write_et.setText("");
    }

    @Override
    public int callCambiaValoreAggiunto(String val) {
        if(!TextUtils.isEmpty(val))
            return Integer.parseInt(val);
        return 0;
    }

    @Override
    public boolean callBoolean(String txt) {
        return txt.equals("0000");
    }
}

interface CallbackInterface {
    void callVoid(double val);
    void reset();
    int callCambiaValoreAggiunto(String val);
    boolean callBoolean(String txt);
}
