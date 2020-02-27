package com.sightsolutions.testcallback;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

public class NewTextWatcher implements TextWatcher {

    private static final String TAG = "NewTextWatcher";

    CallbackInterface ci;
    NewTextWatcher(CallbackInterface ci){
        this.ci = ci;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
            if(editable.toString().equals("1111")){
                Log.d(TAG, "afterTextChanged: chiamato");
                ci.reset();
            }
    }
}
