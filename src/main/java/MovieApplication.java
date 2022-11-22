import domain.*;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        List<BookedMovie> bookedMovies = new ArrayList<>();

        boolean isReserveCheck = true;

        while (isReserveCheck) {
            OutputView.printMovies(movies);
            Movie movie = getValidateExistByMovieId(movies);
            BookedMovie bookedMovie = getReserveMovie(movie);
            bookedMovies.add(bookedMovie);
            isReserveCheck = InputView.intCheckReserve() == 2;
        }
        OutputView.printBookedMovies(bookedMovies);
    }

    public static BookedMovie getReserveMovie(Movie movie){
        PlaySchedule playSchedule = getValidateExistByScheduleIndex(movie);
        int capacity = validateInputCapacity(playSchedule);
        return BookedMovie.of(movie, playSchedule, capacity);
    }

    private static int validateInputCapacity(PlaySchedule paySchedule) {
        paySchedule.scheduleInformationOutput();
        int capacity = InputView.inputCapacity();

        paySchedule.validateCapacity(capacity);
        paySchedule.minusCapacity(capacity);

        return capacity;
    }


    private static Movie getValidateExistByMovieId(List<Movie> movies) {
        int movieId = InputView.inputMovieId();
        return movies.stream()
                .filter(m -> m.hasId(movieId))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    private static PlaySchedule getValidateExistByScheduleIndex(Movie movie) {
        OutputView.printSchedule(movie);
        int scheduleId = InputView.inputSchedule();
        return movie.getPaySchedule(scheduleId);
    }
}
