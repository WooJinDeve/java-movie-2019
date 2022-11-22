import domain.*;
import view.InputView;
import view.OutputView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        List<BookedMovie> bookedMovies = new ArrayList<>();

        boolean isReserveCheck = true;

        while (isReserveCheck) {
            OutputView.printMovies(movies);
            int movieId = InputView.inputMovieId();
            Movie movie = getValidateExistByMovieId(movies, movieId);
            BookedMovie bookedMovie = getReserveMovie(movie);
            bookedMovies.add(bookedMovie);
            isReserveCheck = InputView.intCheckReserve() == 2;
        }
        OutputView.printBookedMovies(bookedMovies);
    }

    public static BookedMovie getReserveMovie(Movie movie){
        OutputView.printSchedule(movie);
        int scheduleId = InputView.inputSchedule();
        PlaySchedule playSchedule = getValidateExistByScheduleIndex(movie, scheduleId);

        playSchedule.scheduleInformationOutput();
        int capacity = InputView.inputCapacity();
        validateInputCapacity(playSchedule, capacity);

        return BookedMovie.of(movie, playSchedule, capacity);
    }

    public static void validateInputCapacity(PlaySchedule paySchedule, int capacity) {
        paySchedule.validateCapacity(capacity);
        paySchedule.minusCapacity(capacity);
    }


    public static Movie getValidateExistByMovieId(List<Movie> movies, int movieId) {
        return movies.stream()
                .filter(m -> m.hasId(movieId))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static PlaySchedule getValidateExistByScheduleIndex(Movie movie, int scheduleId) {
        return Optional.ofNullable(movie.getPlaySchedules().get(scheduleId - 1))
                .orElseThrow(IllegalArgumentException::new)
                .validateTime(LocalDateTime.now());
    }
}
