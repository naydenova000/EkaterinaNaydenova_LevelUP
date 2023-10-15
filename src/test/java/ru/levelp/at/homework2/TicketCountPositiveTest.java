package ru.levelp.at.homework2;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TicketCountPositiveTest выполняет позитивные тесты
 */
@SuppressWarnings("checkstyle:WhitespaceAround")
public class TicketCountPositiveTest {
    @Test(description = "Getting a lucky ticket")
    public void testHappyTicket() {
        var ticket = 112202;

        var happyTicket = new TicketCounter().happyTicket(ticket);
        assertThat(happyTicket)
            .isTrue();
    }

    @Test(description = "Getting a bad ticket")
    public void testNormalTicket() {
        var ticket = 115202;

        var happyTicket = new TicketCounter().happyTicket(ticket);
        assertThat(happyTicket)
            .isFalse();
    }
}
