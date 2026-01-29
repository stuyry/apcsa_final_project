package Code;

public class Name {
    private String name;
    private boolean toRetry = true;
    public Name() { //DEFINITELY a better way to do this, but I am NOT writing out all special characters :/
        while (toRetry) { //TODO: IMPORTANT? Went to the Java API maybe I should use StringBuffer or StringBuilder, because I doubt the getInput can support that, creating an error. But I don't really know where to go from this -> ima go eat dinner now.

            name = new Reader().getInput();
            toRetry = false;

            if (name.contains("0") || 
            name.contains("1") || 
            name.contains("2") || 
            name.contains("3") || 
            name.contains("4") || 
            name.contains("5") || 
            name.contains("6") || 
            name.contains("7") || 
            name.contains("8") || 
            name.contains("9")) {
                toRetry = true;
                System.out.print("Incorrect input format, please try again: ");
            }
        }
    }


    public String getName() {
       return name;
    }

}   
