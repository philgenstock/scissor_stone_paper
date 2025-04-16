package de.philgenstock.ssp;

import java.util.Map;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Map<Result, Integer> result = new ScissorStonePaper(new Random()).play(100);
        System.out.println(result);
    }

}