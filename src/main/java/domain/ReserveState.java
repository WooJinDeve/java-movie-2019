package domain;

public enum ReserveState {
    DONE_BOOKED(1),
    ANOTHER_BOOKED(2);
    private int num;
    ReserveState(int num) {
        this.num = num;
    }

    public static boolean confirmReservation(int reserveNumber) {
        return ReserveState.ANOTHER_BOOKED.num == reserveNumber;
    }
}
