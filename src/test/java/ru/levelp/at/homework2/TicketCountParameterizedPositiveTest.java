package ru.levelp.at.homework2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


/**
 * TicketCountParameterized выполняет позитивные тесты.
 */
@DisplayName("Positive tests. Checking tests for different positive scenarios")
public class TicketCountParameterizedPositiveTest extends TicketCounter {

    @ParameterizedTest
    @DisplayName("Positive. Getting a lucky tickets")
    @ValueSource(ints = {111111, 202022})
    void testParameterizedCountLuckyTickets(Integer tickets) {
        var positiveTicket = new TicketCounter().happyTicket(tickets);
        assertThat(positiveTicket)
            .isTrue();
    }

    @ParameterizedTest
    @DisplayName("Positive. Getting a bad tickets")
    @ValueSource(ints = {111121, 212022})
    void testParameterizedCountBadTickets(Integer tickets) {
        var badTicket = new TicketCounter().happyTicket(tickets);
        assertThat(badTicket)
            .isFalse();
    }

}
