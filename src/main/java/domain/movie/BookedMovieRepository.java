package domain.movie;

import java.util.ArrayList;
import java.util.List;

public class BookedMovieRepository {

    private static List<BookedMovie> bookedMovies = new ArrayList<>();
    private static BookedMovieRepository bookedMovieRepository = new BookedMovieRepository();
    private BookedMovieRepository(){}

    public static BookedMovieRepository getInstance(){
        return bookedMovieRepository;
    }

    public List<BookedMovie> getBookedMovies() {
        return bookedMovies;
    }

    public void save(BookedMovie bookedMovie){
        bookedMovies.add(bookedMovie);
    }

    public int getTotalPayment(){
        return bookedMovies.stream()
                .mapToInt(BookedMovie::getTotalPrice)
                .sum();
    }
}
