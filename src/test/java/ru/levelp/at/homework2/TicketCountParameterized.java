package ru.levelp.at.homework2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * TicketCountParameterized
 */
@DisplayName("Sample parameterized")
public class TicketCountParameterized extends TicketCounter {

    @ParameterizedTest
    @DisplayName("lflflf")
    @ValueSource(ints = {111111, 202022})
    void testParameterizedCountPositive(Integer number) {
        //TODO: не понимаю как сделать проверку на boolean

    }


}
