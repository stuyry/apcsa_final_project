package Code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reader { //decided against making this abstract because when I am extending I am not calling constructor again, so that would be stupid
    private final BufferedReader read;
    //Im not really accounting for nextLine in my code, but all of the inputs I am asking for are one liners, and I print something inbetween them if that makes sense
    private String input = "";

    // public ReadTheInputs() {
    //     read = new BufferedReader(null);
    // }
    public Reader() { //My take on Competitive coding (USACO) Kattio class except without looking at it
        read = new BufferedReader(new InputStreamReader(System.in));
        try {
            input = read.readLine(); //TODO: RESOLVED ensure that input is getting this value
        }   //TODO: RESOLVED ensure that this isn't reading lines that are useless, like ensure its getting use input
        catch (IOException e) {
            System.err.print("Issue in Reader!!");
        }
    }

    private String getInput() { 
        return this.input; 
        //value given automatically by constructor, so use this method then dot notation in etc
    }
    public int getInputAsInt() { 
        int toReturn = -1;
        boolean retryAgain = true;
        //TODO: (RESOLVED) Make abstract and put in methods where we need to deal with integers that they input
        //Could've given it name of points given but I need to see how this project develops
        //while(retryAgain) {
            try {
              //  retryAgain = false; //theoretically this should be skipped because the error would be given from the code above
                //System.out.print("CONFIRM INPUT: ");
                toReturn = Integer.parseInt(getInput());
            } 
            catch (Exception e) {
                System.err.print("Incorrect input format, please try again: ");
                while(retryAgain) {
                    try {
                        retryAgain = false;
                        toReturn = Integer.parseInt(new Reader().getInput());
                    } 
                    catch (Exception a) {
                        System.err.println("Incorrect input format, please try again: ");
                    }
                    finally {
                        if (toReturn == -1) {
                            retryAgain = true;
                        }
                     }
                    
                }
                //retryAgain = true; //creates infinite loop
            }
            
        //}

        return toReturn;
    }

    public String getInputAsString() {
        return getInput();
        //Mainly added for my ease so that when I am inplementing methods in other classes and I am going through the list of what I can use, I just don't get confused
    }

}
