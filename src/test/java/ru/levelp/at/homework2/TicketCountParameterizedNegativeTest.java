package ru.levelp.at.homework2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * TicketCountParameterized выполняет негативные тесты.
 */
@DisplayName("Negative tests. Checking tests for different negative scenarios")
public class TicketCountParameterizedNegativeTest extends TicketCounter {

    @ParameterizedTest
    @DisplayName("Negative. Entering ticket numbers with different combinations")
    @ValueSource(ints = {0, 155, 1112222})
    void testParameterizedCountLuckyTickets(Integer tickets) {
        var positiveTicket = new TicketCounter().happyTicket(tickets);
        assertThat(positiveTicket)
            .isFalse();
    }
}
