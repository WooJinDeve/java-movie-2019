package domain.runner;

import domain.movie.BookedMovie;
import domain.movie.BookedMovieRepository;
import domain.movie.Movie;
import domain.payment.PayGroupAdvanced;
import view.InputView;
import view.OutputView;

import static domain.movie.BookedMovieRepository.*;
import static domain.movie.MovieRepository.getValidateExistByMovieId;
import static domain.payment.PayGroupAdvanced.discountPrice;
import static domain.payment.PayGroupAdvanced.findByPayType;

public class PaymentRunner {

    private static BookedMovieRepository bookedMovieRepository = BookedMovieRepository.getInstance();

    public static void runPayment(){
        OutputView.printBookedMovies(bookedMovieRepository.getBookedMovies());
        int discountPointPayment = validateDiscountPoint(InputView.inputPoint());
        double finalPaymentAmount = getFinalPaymentAmount(discountPointPayment, InputView.inputPayGroup());
        OutputView.printPaymentAmount(finalPaymentAmount);
    }

    private static int validateDiscountPoint(int point){
        int totalPayment = bookedMovieRepository.getTotalPayment();

        int discountPointPayment = totalPayment - point;
        if (discountPointPayment < 0)
            throw new IllegalArgumentException();

        return discountPointPayment;
    }

    private static double getFinalPaymentAmount(int totalPrice, int payGroupTypeNum) {
        PayGroupAdvanced payGroupAdvanced = findByPayType(payGroupTypeNum);
        return discountPrice(payGroupAdvanced, totalPrice);
    }
}
