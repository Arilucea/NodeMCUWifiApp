#include <ESP8266WiFi.h>
#include <WiFiClientSecure.h>
#include <WiFiUdp.h>

#include "config.h"

#include <EEPROM.h>
void setup() {
  Serial.begin(115200);
  Serial.setDebugOutput(true);
  Serial.println("--------------");
  EEPROM.begin(512);


  
  // put your setup code here, to run once:

}

void loop() {
  // put your main code here, to run repeatedly:

}


void initWifi(){
  int sizeSSID = int(EEPROM.read(0));
  int sizePASS = int(EEPROM.read(1));

  if (sizeSSID == 0 && sizePASS == 0){
    Serial.println("Creando red wifi");
  }

  CreateWifi();
}

