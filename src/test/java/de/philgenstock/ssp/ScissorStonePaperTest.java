package de.philgenstock.ssp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ScissorStonePaperTest {

    @Mock
    private Random random;

    private ScissorStonePaper testee;

    @BeforeEach
    void setup() {
        testee = new ScissorStonePaper(random);
    }

    @Test
    void shouldPlay() {
        //given
        when(random.nextInt(Shape.values().length))
                .thenReturn(Shape.SCISSOR.ordinal())
                .thenReturn(Shape.PAPER.ordinal());

        //when
        Map<Result, Integer> result = testee.play(2);

        //then
        assertEquals(result.get(Result.LOOSE), 1);
        assertEquals(result.get(Result.TIE), 1);
        assertEquals(result.get(Result.WIN), 0);

    }

}