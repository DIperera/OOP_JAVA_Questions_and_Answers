package beforefinal;

//Command Interface
interface Command {
 void execute();
}

//Receiver
class Light {
 public void turnOn() { 
     System.out.println("The light is ON");
 }

 public void turnOff() {
     System.out.println("The light is OFF");
 }
}

//Concrete Commands
class LightOnCommand implements Command { 
 private Light light;  

 public LightOnCommand(Light light) {
     this.light = light;
 }

 public void execute() {
     light.turnOn();
 }
}

class LightOffCommand implements Command {
 private Light light;

 public LightOffCommand(Light light) {
     this.light = light;
 }

 public void execute() {
     light.turnOff();
 }
}

//Invoker
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command; 
    }

    public void pressButton() {
        command.execute(); 
    }
}


//Client
class CommandPatternExample {
 public static void main(String[] args) {
     Light light = new Light();  // Receiver

     Command lightOn = new LightOnCommand(light);
     //Command lightOff = new LightOffCommand(light);

     RemoteControl remote = new RemoteControl();

     // Turn the light ON
     remote.setCommand(lightOn);
     remote.pressButton();

     // Turn the light OFF
     //remote.setCommand(lightOff);
     //remote.pressButton();
 }
}

