package de.philgenstock.ssp;

import javax.print.attribute.standard.PrinterMakeAndModel;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ScissorStonePaper {

    private final Random random;

    public ScissorStonePaper(Random random) {
        this.random = random;
    }

    public Map<Result, Integer> play(int times) {
        EnumMap<Result, Integer> resultMap = new EnumMap<>(Result.class);
        for (Result value : Result.values()) {
            resultMap.put(value, 0);
        }
        for (int i = 0; i < times; i++) {
            Shape attackingShape = Shape.PAPER;
            Shape defendingShape = Shape.values()[random.nextInt(Shape.values().length)];
            Result result = attackingShape.calculateResultAgainst(defendingShape);
            int totalResultCount = resultMap.get(result) + 1;
            resultMap.put(result, totalResultCount);
        }
        return resultMap;
    }
}
