package de.philgenstock.ssp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ShapeTest {

    @ParameterizedTest
    @CsvSource({
            "STONE, SCISSOR",
            "SCISSOR, PAPER",
            "PAPER, STONE"
    })
    void shouldWin(Shape attackingShape, Shape defendingShape) {
        //given/when/then
        assertEquals(attackingShape.calculateResultAgainst(defendingShape), Result.WIN);
    }

    @ParameterizedTest
    @CsvSource({
            "STONE, STONE",
            "SCISSOR, SCISSOR",
            "PAPER, PAPER"
    })
    void shouldTie(Shape attackingShape, Shape defendingShape) {
        //given/when/then
        assertEquals(attackingShape.calculateResultAgainst(defendingShape), Result.TIE);
    }

    @ParameterizedTest
    @CsvSource({
            "SCISSOR,STONE",
            "PAPER,SCISSOR",
            "STONE,PAPER"
    })
    void shouldLoose(Shape attackingShape, Shape defendingShape) {
        //given/when/then
        assertEquals(attackingShape.calculateResultAgainst(defendingShape), Result.LOOSE);
    }

}