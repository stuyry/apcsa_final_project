package Code;

public class Main {
    //static ReadTheInputs x = new ReadTheInputs();
    public static void main(String[] args) {
        System.out.print("Hello World");  
        System.out.print(new Reader().getInputAsString()); 
        //REALLY happy this worked. Initally I was thinking about making a second constructor with a holder variable
        //and then calling that every time but then as I went to code it I was like WAIT, new makes a seperate object EVERY single time in Java's memory, so i did it.
    }
}
