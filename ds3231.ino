#include <Wire.h> 
#include <LiquidCrystal_I2C.h>
#include "RTClib.h" // library yang kita add tadi
LiquidCrystal_I2C lcd(0x3f, 16, 2); // alamat i2c lcd dan type lcd 16x2

RTC_DS3231 rtc;
char hari[7][12] = {"Min", "Sen", "Sel", "Rab", "Kam", "Jum", "Sab"};

const byte buz = 6;


void setup() {
  pinMode(buz,OUTPUT);
  lcd.begin();
  lcd.backlight();
  //rtc.adjust(DateTime(2018, 3, 9, 27, 55, 0));
  if (rtc.lostPower()) {
    rtc.adjust(DateTime(F(__DATE__), F(__TIME__)));   
  }
  lcd.print("MIKROAVR.COM");
  delay(2000);
  lcd.clear();  
}
void loop() {
   DateTime now = rtc.now();
   //lcd.clear();
   lcd.setCursor(1,0);
   lcd.print(hari[now.dayOfTheWeek()]);
   lcd.print(":");
   printDT(now.day());
   lcd.print("-");
   printDT(now.month());
   lcd.print("-");
   printDT(now.year());
   
   lcd.setCursor(4,1);
   printDT(now.hour());
   lcd.print(":");
   printDT(now.minute());
   lcd.print(":");
   printDT(now.second());
   //digitalWrite(buz,HIGH);
   delay(100);
   //digitalWrite(buz,LOW);
   delay(900);
   
}
void printDT ( int DT ){
  if ( DT < 10 ){
    lcd.print('0');
    lcd.print(DT);
  }
  else{
    lcd.print(DT);
  }
}

