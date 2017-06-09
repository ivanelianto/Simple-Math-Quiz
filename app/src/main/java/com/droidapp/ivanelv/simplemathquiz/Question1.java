package com.droidapp.ivanelv.simplemathquiz;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * Created by ivanelv on 09/06/2017.
 */

public class Question1 extends Fragment
{
    RadioButton answer;

    public Question1()
    {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.question1, container, false);
        answer = (RadioButton) rootView.findViewById(R.id.answer3);
        answer.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if (isChecked)
                    MainActivity.answer[0] = true;
                else
                    MainActivity.answer[0] = false;
            }
        });
        return rootView;
    }
}
