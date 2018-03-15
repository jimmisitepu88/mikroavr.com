/*******************************************************************
 *  this is a basic example how to program a Telegram Bot          *
 *  using TelegramBOT library on ESP8266                           *
 *                                                                 *
 *  Open a conversation with the bot, you can command via Telegram *
 *  a led from ESP8266 GPIO                                        *
 *  https://web.telegram.org/#/im?p=@FlashledBot_bot               *
 *                                                                 *
 *  written by Giancarlo Bacchio                                   *
 *******************************************************************/

#include <ESP8266WiFi.h>
#include <WiFiClientSecure.h>
#include <ESP8266TelegramBOT.h>


// Initialize Wifi connection to the router
//char ssid[] = "mikroavr.com";              // your network SSID (name)
//char pass[] = "jimmiKS@888";                              // your network key

const char* ssid = "PMT MEDAN";
const char* password = "nocmedan3000";
WiFiServer server(80);


// Initialize Telegram BOT

#define BOTtoken "467568694:AAECg13q9MAdD6SvliprsuL_csqyNoD9B5c"  //token of FlashledBOT
#define BOTname "mikroavr"
#define BOTusername "mikroavr_bot"

TelegramBOT bot(BOTtoken, BOTname, BOTusername);
  

int Bot_mtbs = 1000; //mean time between scan messages
long Bot_lasttime;   //last time messages' scan has been done
bool Start = false;

/********************************************
 * EchoMessages - function to Echo messages *
 ********************************************/
void Bot_ExecMessages() {
  for (int i = 1; i < bot.message[0][0].toInt() + 1; i++)      {
    bot.message[i][5]=bot.message[i][5].substring(1,bot.message[i][5].length());
    if (bot.message[i][5] == "me") {
          bot.sendMessage(bot.message[i][4], bot.message[i][0], ""); 
          bot.sendMessage(bot.message[i][4], bot.message[i][1], "");  
          bot.sendMessage(bot.message[i][4], bot.message[i][2], ""); 
          bot.sendMessage(bot.message[i][4], bot.message[i][3], "");    
          bot.sendMessage(bot.message[i][4], bot.message[i][4], ""); 
          bot.sendMessage(bot.message[i][4], bot.message[i][5], "");                  
    } 
  }
  bot.message[0][0] = "";   // All messages have been replied - reset new messages
}


void setup() {
  Serial.begin(115200);
  delay(3000);

  // attempt to connect to Wifi network:
  Serial.print("Connecting Wifi: ");
  Serial.println(ssid);
  WiFi.begin(ssid,password);
  
  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }
  Serial.println("");
  Serial.println("WiFi connected");
  Serial.print("http://");
  Serial.print(WiFi.localIP());
  bot.begin();      // launch Bot functionalities
}

void loop() {
   
  if (millis() > Bot_lasttime + Bot_mtbs)  {
    bot.getUpdates(bot.message[0][1]);   // launch API GetUpdates up to xxx message
    Bot_ExecMessages();   // reply to message with Echo
    Bot_lasttime = millis();
  }
}



