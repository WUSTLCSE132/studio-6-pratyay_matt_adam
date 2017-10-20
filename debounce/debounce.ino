const int buttonPin = 2;

volatile int buttonState = HIGH;             // the current reading from the input pin
volatile int lastButtonState = LOW;   // the previous reading from the input pin

// the following variables are unsigned longs because the time, measured in
// milliseconds, will quickly become a bigger number than can be stored in an int.
volatile unsigned long lastDebounceTime = 0;  // the last time the output pin was toggled
unsigned long debounceDelay = 50;   


void buttonPressed() {
  int reading = digitalRead(buttonPin);
  if((millis() - lastDebounceTime > debounceDelay) && (reading == HIGH)){
    Serial.println("Interrupt");
    lastDebounceTime = millis();
  }
  if(reading == LOW){
    lastDebounceTime = millis();
  }
}

void setup() {
  pinMode(buttonPin, INPUT_PULLUP);

  // Interrupts can happen on "edges" of signals.  
  // Three edge types are supported: CHANGE, RISING, and FALLING 
  attachInterrupt(digitalPinToInterrupt(buttonPin), buttonPressed, CHANGE);
  Serial.begin(9600);
}

void loop() {
  for(int i=0;i<100;i++) {
    Serial.println(i);
    delay(1000);
  }
}
