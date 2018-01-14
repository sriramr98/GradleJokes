package com.sriram.jokes;

import java.util.Random;

public class Jokes {

    private static String[] jokes = {
            "A computer once beat me at chess, but it was no match for me at kick boxing",
            "As long as there are tests, there will be prayer in schools",
            "Wha did one ocean say to the other ocean? Nothing, they just waved",
            "A day without sunshine is like, night.",
            "Born free, taxed to death.",
            "A bank is the place that will lend you money, if you can prove that you don't need it"
    };

    public static String getJoke(){
        Random r = new Random();
        return jokes[r.nextInt(6)];
    }




}
