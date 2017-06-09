package com.droidapp.ivanelv.simplemathquiz;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    ViewPager viewPager;

    Button buttonBack, buttonNext;

    QuestionAdapter adapter;

    int page = 0;

    static boolean[] answer = new boolean[6];

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonBack = (Button) findViewById(R.id.buttonBack);
        buttonNext = (Button) findViewById(R.id.buttonNext);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        adapter = new QuestionAdapter(getSupportFragmentManager(), this);
        viewPager.setAdapter(adapter);


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
        {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
            {

            }

            @Override
            public void onPageSelected(int position)
            {
                page = position;

                switch (position)
                {
                    case 0:
                        buttonBack.setVisibility(View.INVISIBLE);
                        break;
                    case 4:
                        buttonNext.setText("FINISH");
                        break;
                    default:
                        buttonBack.setVisibility(View.VISIBLE);
                        buttonNext.setText("NEXT");
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state)
            {

            }
        });
    }

    public void ClickNext(View v)
    {
        Button b = (Button) v;

        if (b.getText().equals("NEXT"))
        {
            viewPager.setCurrentItem(page + 1, true);
        }
        else if (b.getText().equals("FINISH"))
        {
            StringBuilder string = new StringBuilder();
            int score = 0;
            boolean q4Half1 = false;
            boolean q4Half2 = false;
            for (int i = 0; i < answer.length; i++)
            {
                String bool = "False";
                if (answer[i])
                {
                    if (i != 3 && i != 4)
                    {
                        score += 20;
                        bool = "True";
                    }
                    else
                    {
                        if (i == 3)
                            q4Half1 = true;
                        else if (i == 4)
                            q4Half2 = true;

                        score += 10;
                    }
                }

                if (i != 3 && i != 4 && i != 5)
                    string.append("Question " + (i + 1) + " : " + bool + "\n");
                else if (q4Half1 && q4Half2 && i == 4)
                {
                    string.append("Question 4" + " : True" + "\n");
                }
                else if (((!q4Half1 && q4Half2) || (q4Half1 && !q4Half2)) && i == 4)
                {
                    string.append("Question 4" + " : Half" + "\n");
                }
                else if (!q4Half1 && !q4Half2 && i == 4)
                {
                    string.append("Question 4" + " : False" + "\n");
                }
                else if (i == 5)
                    string.append("Question " + i + " : " + bool + "\n");
            }

            Toast.makeText(this, "Score : " + score + "\n" + string.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    public void ClickBack(View v)
    {
        viewPager.setCurrentItem(page - 1);
    }
}
