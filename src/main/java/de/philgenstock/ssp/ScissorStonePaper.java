package de.philgenstock.ssp;

import java.util.EnumMap;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ScissorStonePaper {

    private final Random random;

    public ScissorStonePaper(Random random) {
        this.random = random;
    }

    public Map<Result, Integer> play(int times) {

        EnumMap<Result, Integer> resultMap = IntStream.range(0, times)
                .mapToObj(i -> {
                    Shape attackingShape = Shape.PAPER;
                    Shape defendingShape = Shape.values()[random.nextInt(Shape.values().length)];
                    return attackingShape.calculateResultAgainst(defendingShape);
                })
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        () -> new EnumMap<>(Result.class),
                        Collectors.collectingAndThen(Collectors.counting(), Long::intValue)
                ));

        for (Result result : Result.values()) {
            resultMap.putIfAbsent(result, 0);
        }

        return resultMap;
    }
}
