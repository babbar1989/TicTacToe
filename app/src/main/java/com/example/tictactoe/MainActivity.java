package com.example.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int activeplayer=0;//rcb=0, csk=1;
    Boolean gameisActive= true;
    int gamestate[]={2,2,2,2,2,2,2,2,2};
    int winningpos[][]={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};


    public void dropin(View view)
    {
        ImageView counter= (ImageView) view;
       // counter.setImageResource(R.drawable.csk1);
       // System.out.println(counter.getTag().toString());
        int tappedcounter= Integer.parseInt(counter.getTag().toString());
        if(gamestate[tappedcounter]==2&&gameisActive==true) {

            gamestate[tappedcounter]=activeplayer;

            counter.setTranslationY(-1000f);
            if (activeplayer == 0) {
                counter.setImageResource(R.drawable.rcb);
                activeplayer = 1;
            } else {
                counter.setImageResource(R.drawable.csk1);
                activeplayer = 0;
            }

            counter.animate().rotation(3600).translationYBy(1000f).setDuration(400);
            for(int i=0;i<8;i++)
            {
               if(gamestate[winningpos[i][0]]==gamestate[winningpos[i][1]]
                       &&gamestate[winningpos[i][1]]==gamestate[winningpos[i][2]]&&gamestate[winningpos[i][0]]!=2)
               {
                  //won
                   gameisActive=false;
                   String winner="RCB";
                   if(gamestate[winningpos[i][0]]==1)
                       winner="CSK";
                   TextView tvvar1= findViewById(R.id.tvvar1);
                   tvvar1.setText(winner+" has won!");

                   LinearLayout llvar1= findViewById(R.id.llvar1);
                   llvar1.setVisibility(View.VISIBLE);
                   break;
                  // System.out.println("won");

                  // GridLayout grvar1= findViewById(R.id.grvar1);
                 //  grvar1.setVisibility(View.INVISIBLE);


               }

               else
               {
                   int count=0;
                   for(int j=0;j<9;j++)
                   {
                       if(gamestate[j]!=2)
                           count++;
                   }

                   System.out.println("i="+i+"count="+count);
                   if(count==9&&i==7)
                   {
                       gameisActive=false;


                       TextView tvvar1= findViewById(R.id.tvvar1);
                       tvvar1.setText("Match Drawn");

                       LinearLayout llvar1= findViewById(R.id.llvar1);
                       llvar1.setVisibility(View.VISIBLE);
                   }
               }

            }


        }

    }

    public void playagain(View view)
    {
        LinearLayout llvar1= findViewById(R.id.llvar1);
        llvar1.setVisibility(View.INVISIBLE);
        gameisActive=true;
        activeplayer=0;
        for(int i=0;i<9;i++)
        {
            gamestate[i]=2;
        }

        android.support.v7.widget.GridLayout grvar1= (android.support.v7.widget.GridLayout) findViewById(R.id.grvar1);

        for(int i=0;i<grvar1.getChildCount();i++)
        {
            ((ImageView)grvar1.getChildAt(i)).setImageResource(0);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
