package com.bongo.anagram;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import com.bongo.anagram.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TextWatcher {

    private ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mainBinding.matchingData.addTextChangedListener(this);
        mainBinding.srcData.addTextChangedListener(this);

    }

    /**
     * @param srcString source data to check
     * @param checkString matching data to check with source data
     * @return if anagram then true else false
     */
    public boolean checkAnagram(String srcString, String checkString){
        srcString = srcString.toLowerCase();
        checkString = checkString.toLowerCase();
        boolean isMatched = false;
        if(srcString.length() == checkString.length() && !srcString.equals(checkString)) {
            for (char srcChar : srcString.toCharArray()){
                boolean isExist = false;
                for (char dataChar : checkString.toCharArray()){
                    if(dataChar == srcChar) {
                        isExist = true;
                        checkString = checkString.replaceFirst(String.valueOf(srcChar),"");
                        break;
                    }
                }
                if(isExist){
                    isMatched = true;
                } else {
                    isMatched = false;
                    break;
                }
            }
        } else isMatched = false;
        return isMatched;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if(checkAnagram(mainBinding.srcData.getText().toString(), mainBinding.matchingData.getText().toString())){
            mainBinding.showMessage.setText("Data are anagram");
            mainBinding.showMessage.setTextColor(getResources().getColor(R.color.colorGreen));
        } else {
            mainBinding.showMessage.setText("Data are not anagram");
            mainBinding.showMessage.setTextColor(getResources().getColor(R.color.colorRed));
        }
    }

    @Override
    public void afterTextChanged(Editable s) { }
}
