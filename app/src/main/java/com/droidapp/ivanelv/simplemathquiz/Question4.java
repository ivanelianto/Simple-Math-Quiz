package com.droidapp.ivanelv.simplemathquiz;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

/**
 * Created by ivanelv on 09/06/2017.
 */

public class Question4 extends Fragment
{
    CheckBox answer1, answer2, answer3, answer4;

    int checkCount = 0;

    public Question4()
    {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.question4, container, false);
        answer1 = (CheckBox) rootView.findViewById(R.id.answer1);
        answer2 = (CheckBox) rootView.findViewById(R.id.answer4);
        answer3 = (CheckBox) rootView.findViewById(R.id.answer2);
        answer4 = (CheckBox) rootView.findViewById(R.id.answer3);

        answer1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if (isChecked)
                {
                    MainActivity.answer[3] = true;
                    checkCount++;
                }
                else
                {
                    MainActivity.answer[3] = false;
                    checkCount--;
                }
                checkCount();
            }
        });

        answer2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if (isChecked)
                {
                    MainActivity.answer[4] = true;
                    checkCount++;
                }
                else
                {
                    MainActivity.answer[4] = false;
                    checkCount--;
                }
                checkCount();
            }
        });

        answer3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if (isChecked)
                    checkCount++;
                else
                    checkCount--;
                checkCount();
            }
        });

        answer4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if (isChecked)
                    checkCount++;
                else
                    checkCount--;
                checkCount();
            }
        });

        return rootView;
    }

    private void checkCount()
    {
        if (checkCount == 2)
        {
            if (!answer1.isChecked())
                answer1.setEnabled(false);

            if (!answer2.isChecked())
                answer2.setEnabled(false);

            if (!answer3.isChecked())
                answer3.setEnabled(false);

            if (!answer4.isChecked())
                answer4.setEnabled(false);
        }
        else if (checkCount <= 1)
        {
            if (!answer1.isChecked())
                answer1.setEnabled(true);

            if (!answer2.isChecked())
                answer2.setEnabled(true);

            if (!answer3.isChecked())
                answer3.setEnabled(true);

            if (!answer4.isChecked())
                answer4.setEnabled(true);
        }
    }
}
