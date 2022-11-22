package view;

import domain.movie.BookedMovie;
import domain.movie.Movie;
import domain.movie.PlaySchedule;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            movie.movieInformationOutput();
        }
    }

    public static void printSchedule(Movie movie){
        movie.movieInformationOutput();
        for (PlaySchedule playSchedule : movie.getPlaySchedules()) {
            playSchedule.scheduleInformationOutput();
        }
    }

    public static void printBookedMovies(List<BookedMovie> bookedMovies){
        for (BookedMovie bookedMovie : bookedMovies) {
            bookedMovie.bookedMovieInformationOutput();
        }
    }

    public static void printPaymentAmount(double finalPaymentAmount){
        System.out.println("최종 금액 : " + finalPaymentAmount);
    }
}
