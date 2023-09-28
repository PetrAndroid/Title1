package com.example.title1;

class Igrok {

   int health;
   int atak;
   int protection;
   int help;
   int uron_from;
   int uron_to;


   public Igrok(int health, int atak, int protection, int help, int uron_from, int uron_to) {
      this.health = health;
      this.atak = atak;
      this.protection = protection;
      this.help = help;
      this.uron_from = uron_from;
      this.uron_to = uron_to;
   }

   public int getHealth() {
      return health;
   }

   public void setHealth(int health) {
      this.health = health;
   }

   public int getAtak() {
      return atak;
   }

   public void setAtak(int atak) {
      this.atak = atak;
   }

   public int getProtection() {
      return protection;
   }

   public void setProtection(int protection) {
      this.protection = protection;
   }

   public int getHelp() {
      return help;
   }

   public void setHelp(int help) {
      this.help = help;
   }

   public void setUron(int uron_from,int uron_to) {
      this.uron_from = uron_from;
      this.uron_to   = uron_to;
   }
   public int getUron_from() {
      return uron_from;
   }

   public void setUron_from(int uron_from) {
      this.uron_from = uron_from;
   }

   public int getUron_to() {
      return uron_to;
   }

   public void setUron_to(int uron_to) {
      this.uron_to = uron_to;
   }
}
