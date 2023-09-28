package com.example.title1;

import java.util.Random;

class Action {

   Igrok igrok;
   Monster monster;
   public Action(Igrok igrok, Monster monster) {
   this.igrok=igrok;
   this.monster=monster;
   }

   public Igrok getIgrok() {
      return igrok;
   }

   public void setIgrok(Igrok igrok) {
      this.igrok = igrok;
   }

   public Monster getMonster() {
      return monster;
   }

   public void setMonster(Monster monster) {
      this.monster = monster;
   }

   public Monster igrok_atak(){
   int mod_atak=igrok.getAtak()- monster.getProtection()+1;
   if(mod_atak<=0)mod_atak=1;

   int kol_kubik=mod_atak;
   boolean bingo=false;
   for(int i=0;i<kol_kubik;i++)
   {
      int rez_broska = new Random().nextInt(6);
      if(rez_broska>4) {bingo=true; break;}
   }


   if(bingo){
      int min = igrok.getUron_from();
      int max = igrok.getUron_to();
      int strength_atak = new Random().nextInt((max - min) + 1) + min;

      int rez_health=monster.getHealth()-strength_atak;
      if(rez_health<0) rez_health=0;
      monster.setHealth(rez_health);
   }
   return monster;
   }

   public Igrok monster_atak(){

      int mod_atak=monster.getAtak()- igrok.getProtection()+1;
      if(mod_atak<=0)mod_atak=1;

      int kol_kubik=mod_atak;
      boolean bingo=false;
      for(int i=0;i<kol_kubik;i++)
      {
         int rez_broska = new Random().nextInt(6);
         if(rez_broska>4) {bingo=true; break;}
      }


      if(bingo){
         int min = monster.getUron_from();
         int max = monster.getUron_to();
         int strength_atak = new Random().nextInt((max - min) + 1) + min;

         int rez_health=igrok.getHealth()-strength_atak;
         if(rez_health<0) rez_health=0;
         igrok.setHealth(rez_health);
      }

      return igrok;
   }





}
