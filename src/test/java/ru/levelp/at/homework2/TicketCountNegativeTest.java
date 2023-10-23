package ru.levelp.at.homework2;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

/**
 * TicketCountNegativeTest выполняет негативные тесты.
 */
public class TicketCountNegativeTest {
    @Test(description = "Negative. Entering a ticket number with one digit")
    public void testNegativeTicketWithOneNumber() {
        var ticket = 0;

        var negativeTicket = new TicketCounter().happyTicket(ticket);
        assertThat(negativeTicket)
            .isFalse();
    }

    @Test(description = "Negative. Entering a ticket number with five digits")
    public void testNegativeTicketWithFiveNumber() {
        var ticket = 11111;

        var negativeTicket = new TicketCounter().happyTicket(ticket);
        assertThat(negativeTicket)
            .isFalse();
    }

    @Test(description = "Negative. Entering a ticket number with seven digits")
    public void testNegativeTicketWithSevenNumber() {
        var ticket = 1111111;

        var negativeTicket = new TicketCounter().happyTicket(ticket);
        assertThat(negativeTicket)
            .isFalse();
    }
}
