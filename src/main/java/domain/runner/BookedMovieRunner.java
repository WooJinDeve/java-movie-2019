package domain.runner;

import domain.movie.*;
import view.InputView;
import view.OutputView;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static domain.movie.BookedMovieRepository.*;
import static domain.movie.MovieRepository.getValidateExistByMovieId;

public class BookedMovieRunner {
    private static List<Movie> movies = MovieRepository.getMovies();
    private static BookedMovieRepository bookedMovieRepository = BookedMovieRepository.getInstance();

    public static void runBookedMovie(){
        OutputView.printMovies(movies);
        Movie movie = getValidateExistByMovieId(InputView.inputMovieId());
        BookedMovie bookedMovie = getReserveMovie(movie);
        bookedMovieRepository.save(bookedMovie);
    }


    private static BookedMovie getReserveMovie(Movie movie){
        OutputView.printSchedule(movie);
        PlaySchedule playSchedule = getValidateExistByScheduleIndex(movie, InputView.inputSchedule());

        playSchedule.scheduleInformationOutput();
        int capacity = validateInputCapacity(playSchedule, InputView.inputCapacity());

        return BookedMovie.of(movie, playSchedule, capacity);
    }

    private static int validateInputCapacity(PlaySchedule paySchedule, int capacity) {
        paySchedule.validateCapacity(capacity);
        paySchedule.minusCapacity(capacity);
        return capacity;
    }


    private static PlaySchedule getValidateExistByScheduleIndex(Movie movie, int scheduleId) {
        return Optional.ofNullable(movie.getPlaySchedules().get(scheduleId - 1))
                .orElseThrow(IllegalArgumentException::new)
                .validateTime(LocalDateTime.now());
    }
}
