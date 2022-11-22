import domain.movie.BookedMovie;
import domain.movie.Movie;
import domain.movie.MovieRepository;
import domain.movie.PlaySchedule;
import domain.payment.PayGroupAdvanced;
import domain.payment.ReserveState;
import domain.runner.BookedMovieRunner;
import domain.runner.PaymentRunner;
import view.InputView;
import view.OutputView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static domain.payment.PayGroupAdvanced.*;
import static domain.payment.PayGroupAdvanced.discountPrice;

public class MovieApplication {
    public static void main(String[] args) {
        startRunner();
        PaymentRunner.runPayment();
    }

    private static void startRunner() {
        boolean isReserveCheck = true;
        while (isReserveCheck) {
            BookedMovieRunner.runBookedMovie();
            int reserveNumber = InputView.inputCheckReserve();
            isReserveCheck = ReserveState.confirmReservation(reserveNumber);
        }
    }
}
