package view;

import domain.BookedMovie;
import domain.Movie;
import domain.PlaySchedule;

import java.time.LocalDateTime;
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
}
