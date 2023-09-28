package com.example.title1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Igrok igrok;
    Monster monster;
    Action action;

    Button btn_my_atak,start_game;
    ImageButton health_up;
    TextView igrok_data;
    TextView monster_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     btn_my_atak = findViewById(R.id.btn_my_atak);
     start_game = findViewById(R.id.start_game);
     igrok_data = findViewById(R.id.IgrokData);
     monster_data = findViewById(R.id.MonsterData);
     health_up=findViewById(R.id.health_up);

     start_game.setVisibility(View.VISIBLE);
     btn_my_atak.setVisibility(View.INVISIBLE);
     health_up.setVisibility(View.INVISIBLE);

        generate_game();

        btn_my_atak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                action = new Action(igrok, monster);
                monster=action.igrok_atak();
                update_data();
                monster_atak();

            }
        });

        start_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            start_game.setVisibility(View.INVISIBLE);
            btn_my_atak.setVisibility(View.VISIBLE);
            health_up.setVisibility(View.VISIBLE);
            monster_atak();
            }
        });

        health_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                igrok.health=igrok.health+30;
                igrok.help=igrok.help-1;
                if(igrok.getHelp()==0) {health_up.setVisibility(View.INVISIBLE);}
                update_data();
            }
        });


    }

    void monster_atak(){
        action = new Action(igrok, monster);
        igrok=action.monster_atak();
        update_data();
    }

   void generate_game(){
       igrok = new Igrok(100,10,10,4,3,5);
       monster = new Monster(70,10,8,4,2,4);
       update_data();
   }

   void update_data(){
        String igrok_str="Здоровье - "+igrok.getHealth()+"\n"+
                         "Атака - "+igrok.getAtak()+"\n"+
                         "Защита - "+igrok.getProtection()+"\n"+
                         "Урон - "+igrok.getUron_from()+"-"+igrok.getUron_to();
        igrok_data.setText(igrok_str);


       String monster_str="Здоровье - "+monster.getHealth()+"\n"+
               "Атака - "+monster.getAtak()+"\n"+
               "Защита - "+monster.getProtection()+"\n"+
               "Урон - "+monster.getUron_from()+"-"+monster.getUron_to();
       monster_data.setText(monster_str);



       if(monster.getHealth()==0) {
        Toast.makeText(MainActivity.this,"Монстр побежден",Toast.LENGTH_SHORT).show();start_game.setVisibility(View.VISIBLE); btn_my_atak.setVisibility(View.INVISIBLE);generate_game(); }

       if(monster.getHealth()==0) {
           Toast.makeText(MainActivity.this,"Вы побеждены",Toast.LENGTH_SHORT).show();start_game.setVisibility(View.VISIBLE);btn_my_atak.setVisibility(View.INVISIBLE); generate_game(); }

   }




}