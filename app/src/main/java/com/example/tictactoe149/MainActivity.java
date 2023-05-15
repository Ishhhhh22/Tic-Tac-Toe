package com.example.tictactoe149;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean isWinner=false;
    int imageclicked=-1;
    int player=1; //player1 is cross
    int [][]winningstates={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int []gamestate={-1,-1,-1,-1,-1,-1,-1,-1,-1};
    public void load(View view) {

        ImageView v = (ImageView) view;
        int tag = Integer.parseInt(v.getTag().toString());
        imageclicked=gamestate[tag];
        if(isWinner==false && imageclicked==-1) {
            if (player == 1) {
                v.setImageResource(R.drawable.x);
                gamestate[tag] = player;
                Toast.makeText(this, tag + "" + " x", Toast.LENGTH_SHORT).show();
                player = 0;
            } else {
                v.setImageResource(R.drawable.o);
                gamestate[tag] = player;
                Toast.makeText(this, tag + "" + " o", Toast.LENGTH_SHORT).show();
                player = 1;
            }
            for (int i = 0; i < winningstates.length; i++) {
                if (gamestate[winningstates[i][0]] == gamestate[winningstates[i][1]] && gamestate[winningstates[i][1]] == gamestate[winningstates[i][2]] && gamestate[winningstates[i][0]] > -1) {
                    Toast.makeText(this, "Winner is " + (player == 0 ? 1 : 0), Toast.LENGTH_SHORT).show();
                    isWinner=true;
                }
            }
        }
    }
    public void reset(View view){
        GridLayout gridlayout=findViewById(R.id.gridlayout);
        int totalimage= gridlayout.getChildCount();
        for(int i=0;i<totalimage;i++){
            ImageView v=(ImageView) gridlayout.getChildAt(i);
            v.setImageDrawable(null);
        }
        isWinner=false;
        imageclicked=-1;
        player=1;
        for(int i=0;i< gamestate.length;i++)
            gamestate[i]=-1;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}