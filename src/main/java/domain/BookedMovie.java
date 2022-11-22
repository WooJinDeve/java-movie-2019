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

    public static BookedMovie of(Movie bookedMovie, PlaySchedule bookedSchedule, int reservationNumber) {
        return new BookedMovie(bookedMovie, bookedSchedule, reservationNumber);
    }

    public void bookedMovieInformationOutput(){
        System.out.println("예약 번호 : " + reservationNumber);
        this.bookedMovie.movieInformationOutput();
        this.bookedSchedule.scheduleInformationOutput();
    }
}
