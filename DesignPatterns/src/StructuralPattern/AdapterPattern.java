package StructuralPattern;

//Target interface
interface EuropeanPlug {
 void connectToEuropeanSocket();
}

class USPlug {
 public void connectToUSSocket() {
     System.out.println("Connecting to US socket.");
 }
}

//Adapter
class USPlugAdapter implements EuropeanPlug {
 private USPlug usPlug;

 public USPlugAdapter(USPlug usPlug) {
     this.usPlug = usPlug;
 }

 @Override
 public void connectToEuropeanSocket() {
     usPlug.connectToUSSocket();
     System.out.println("Adapted to European socket.");
 }
}

//Usage
public class AdapterPattern {
 public static void main(String[] args) {
     USPlug usPlug = new USPlug();
     EuropeanPlug adapter = new USPlugAdapter(usPlug);

     adapter.connectToEuropeanSocket();
 }
}
