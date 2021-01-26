package com.company;
import java.util.Random;
//
//My own Randomizer class
//
public class RandomValues {

    Random random = new Random();
    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public RandomValues(){ }

    //
    //Call this method to get a random string
    //-limit is the set limit of how long a word can be if length = false
    //-limit is the set length of how long a word is if length = true
    //
    public String randomString (int limit, boolean length) {
        StringBuilder stringBuilder = new StringBuilder();

        if (!length) {
            limit = random.nextInt(limit) + 1;
        }

        for (int i = 0; i < limit; i++) {
            stringBuilder.append(alphabet.charAt(random.nextInt(alphabet.length())));
        }
        return stringBuilder.toString();
    }
    //
    //Call this method to get a random int
    //-limit is the set limit of how high a number can be
    //
    public int randomint (int limit) {
        int myInt = 0;
        myInt = random.nextInt(limit);
        return myInt;
    }
    //
    //Call this method to get a random boolean
    //
    public boolean randomBool () {
        return random.nextBoolean();
    }

    public int Dice () {
        int myInt = 1;
        myInt = random.nextInt(6);
        return myInt;
    }
}
