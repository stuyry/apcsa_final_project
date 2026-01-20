package Code;
//Class made to generate everything for the opponent
public class RandomNumber {
    private long randomNumber;

    public RandomNumber(long multiplier) { //not equal distribution -> now their should be ?
        // 0 -> 0.5 = 0, ::: 0.5 -> 1.5 = 1 ::: 1.5 -> 2 = 2
        //what if:  0 -> 0.9 = 0 ::: 1 -> 1.9 = 1, 2 -> 2.9 = 2 
        randomNumber = (long)(Math.random() * (multiplier));//no minus 1 because this guarantees no one, so when 3, it will only be 0.0 -> 2.98 which is all rounded down
         //Math.random removes 1.0 //0.33 -> 0.99, 0.66 -> 1 0.99 -> 2
        randomNumber += 1; //3, 0 -> 2 max but its rounded. Then you add 1 on top of it. This gives you 1 - 3
    }

    public long getRandomNumber() {
        return randomNumber;
    }
    
}
