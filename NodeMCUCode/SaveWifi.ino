#include <ESP8266WiFi.h>
#include <WiFiClient.h>
#include <ESP8266WebServer.h>

const char *ssidNode = "NodeMCU";
const char *passNode = "";
String command;
ESP8266WebServer server(80);

void respond(){
  server.send(200,"text/html","<h1>Config</h1>");
}

void CreateWifi() {
  WiFi.setAutoConnect(false);
  // NodeMCU network init
  WiFi.softAP(ssidNode, passNode);
  IPAddress IPServer = WiFi.softAPIP();
  Serial.print("IP address server: ");
  Serial.println(IPServer);
  server.on("/", respond);
  server.begin();
  server.onNotFound([](){
     command = server.uri();
     server.send(200, "text/plain");
  });
  GetData();
}

String recib;
void GetData(){
  while (true){
    server.handleClient();
    recib = command;
    Serial.println("WIFI DATA");
    Serial.println(recib);
    recib.remove(0, 1);
    Serial.println("-----------------------");
    Serial.println(recib);
    delay(500);
  }  
}


