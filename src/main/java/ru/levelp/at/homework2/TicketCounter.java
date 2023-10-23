package ru.levelp.at.homework2;

public class TicketCounter {

    /**
     * Программа happyTicket принимает номер билета и складывает первые 3 числа с последними 3я числами.
     * и если сумма одинаковая, то билет считается счастливым.
     */
    public boolean happyTicket(int ticketNumber) {
        var lengthTicketNumber = String.valueOf(ticketNumber).length();

        if (lengthTicketNumber == 6) {

            int ticketNumber1 = ticketNumber / 100000;
            int ticketNumber2 = (ticketNumber / 10000) % 10;
            int ticketNumber3 = (ticketNumber / 1000) % 10;
            int ticketNumber4 = (ticketNumber / 100) % 10;
            int ticketNumber5 = (ticketNumber / 10) % 10;
            int ticketNumber6 = ticketNumber % 10;

            return ticketNumber1 + ticketNumber2 + ticketNumber3 == ticketNumber4 + ticketNumber5 + ticketNumber6;
        } else {
            return false;
        }
    }
}
