## APCS_PROJECT

This is my Final Project submission for APCSA final (January). 

This repo was not finished in time, with me having to scratch Passive.java and adding Magic.java as a useful characteristic for the character.

Should be done within a day tough.

Manual:
This project is a game.

When you run the game (from Main.java), you will be asked to input a name. In this event, if you input a number into the name, the name will be invalid and you will be asked to reinput a valid name (special characters are not yet filtered out).

Then you will be asked to allocate points towards attributes

The threshold for Easy, Medium, and Hard will be randomized with Medium always being 15 more than Easy (in terms of credits), and Hard being above Medium. This randomization will add RNG to ALL attributes you will be applying Credits to.

If you input a number greater than 50 (too much because that is when you are guaranteed (well technically 46) to get Max) you will be asked to reinput the value

If you input a negative number, you will also be asked to reinput a value.

This works with Strings too, I belive (not 100% sure) but it counts it as a negative number, so don't mind that. Had I worked longer on this project, this would be solved, and it is really quick.

If you input a value more than Credits (but not more than 50) you will also be asked to reinput your values. 

After acquiring all Attribute values you will be asked to play on Easy, Medium, or Hard. 1 corresponds to 20 credits to Opponent for every attribute (low chance for Max). 2 -> 35, and 3 -> 50.

Then the game will begin. 

Every round, and I highly suggest you make the terminal bigger, you will be told the attack values, defense values, HP values, Magic values (not finished), and luck values, BASED on applied magic and etc. 

Please note: If defense value is negative it compounds with Damage multiplier (which is basically the multiplier of your damage based on the attack you choose (HayMaker = 2, Scratch = 1, and Jab is 0.4 for damageMultiplier))

Then you will be told to input a number corresponding to a move. 

Attack showcases Scratch (damage, no magaic drain), Jab (low damage, magic gain), and HayMaker (high damage, magic drain)

(think of Magic value as how much energy you have left - I actually don't think I logged that in final submission but you will know when you are out of energy because if you use an attack/magic ability that uses magic and you have insufficient Magic Credits (energy), you will be told to input a new attack)

Magic showcases Poison, Nausea, Recharge, and Weaken. All of this documentation will be provided to you when you choose this move, so explore!

Things to note:
In the UTIL classes you will see me using dot notation to access public static values from Battle. This is intentional, as if those classes were children, the opponent would call applyCredits, changing up its entire configuration. 

In the Util Classes, you will note, most of them are similar. Yes, I would love to get the satisfaction of making an interface/abstract that I could apply to all to lower redundant lines but again, I am/was trying to get this in on time.

There are interfaces for Attack and Magic.java. These allow me to get values from them.
And then Points is an abstract class that I use in all of my ..Points.java classes. 

How to run: 
cd into src.
Then run javac *.java
Then run java Main.

Otherwise if using VSCODE, you may just do that there directly in the Main class, or obviously use the run button. 

Sorry for the late submission, I hope you could look past that !





