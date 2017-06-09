package com.droidapp.ivanelv.simplemathquiz;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by ivanelv on 08/06/2017.
 */

public class QuestionAdapter extends FragmentPagerAdapter
{
    private Context mContext;

    public QuestionAdapter(FragmentManager fm, Context context)
    {
        super(fm);
        this.mContext = context;
    }

    @Override
    public Fragment getItem(int position)
    {
        switch (position)
        {
            case 0:
                return new Question1();
            case 1:
                return new Question2();
            case 2:
                return new Question3();
            case 3:
                return new Question4();
            case 4:
                return new Question5();
        }

        return null;
    }

    @Override
    public int getCount()
    {
        return 5;
    }
}
