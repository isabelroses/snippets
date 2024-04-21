/*
 * https://wiki-content.arduino.cc/en/Tutorial/LibraryExamples/TwoPortReceive
 * https://docs.arduino.cc/learn/built-in-libraries/software-serial#read
 */

#include <SoftwareSerial.h>

#define pin1 8
#define pin2 12

SoftwareSerial mySerial(pin1, pin2);

String username;

void setup() {
  // these should be inputs to recive
  pinMode(pin1, INPUT);
  pinMode(pin2, OUTPUT);
  
  // start the serial connection
  Serial.begin(9600);
  mySerial.begin(9600);

  // get the username
  Serial.println("Please enter your username: ");
  while (!Serial.available()) {};
  username = getInp();

  
  Serial.print("Welcome to the chatroom ");
  Serial.println(username);
}

void loop() {
  String message = getInp();
  if (message != "") {
    // send the message to the reciver
    mySerial.print(username);
    mySerial.print(": ");
    mySerial.println(message);

    // show me what i sent
    Serial.print("you: ");
    Serial.println(message);
  }
  
  getMessage();
}

String getInp() {
  return Serial.readString();
}

void getMessage() {
  mySerial.listen();
  
  while (mySerial.available() > 0){
    Serial.write(mySerial.read());
  } 
}
