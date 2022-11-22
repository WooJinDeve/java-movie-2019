package domain;

public class BookedMovie {
    Movie bookedMovie;
    PlaySchedule bookedSchedule;
    int reservationNumber;

    public BookedMovie(Movie bookedMovie, PlaySchedule bookedSchedule, int reservationNumber) {
        this.bookedMovie = bookedMovie;
        this.bookedSchedule = bookedSchedule;
        this.reservationNumber = reservationNumber;
    }
}
