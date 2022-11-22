import domain.Movie;
import domain.MovieRepository;
import domain.PlaySchedule;
import junit.framework.TestCase;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static utils.DateTimeUtils.createDateTime;

public class MovieApplicationTest{

    private List<Movie> movies;

    @Before
    public void init(){
        movies = MovieRepository.getMovies();
    }

    @Test
    public void validateInputCapacity(){
        //given
        int initCapacity = 6;
        PlaySchedule playSchedule = new PlaySchedule(createDateTime("2022-11-22 12:00"), initCapacity);
        int requestCapacity = 3;

        //when
        MovieApplication.validateInputCapacity(playSchedule, requestCapacity);
        int expected = initCapacity - requestCapacity;

        //then
        assertThat(playSchedule.getCapacity()).isEqualTo(expected);
    }

    @Test
    public void getValidateExistByMovieId(){
        //given
        //exist movie Id = [ 1, 5, 7, 8]
        int movieId = 1;

        //when
        Movie actual = MovieApplication.getValidateExistByMovieId(movies, movieId);

        //then
        assertThat(actual.hasId(movieId)).isTrue();
    }

    @Test
    public void getValidateExistByMovieIdIsNoneId(){
        //given
        //exist movie Id = [ 1, 5, 7, 8]
        int noneId = 10;

        //when & then
        assertThatThrownBy(() -> MovieApplication.getValidateExistByMovieId(movies, noneId))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void getValidateExistByScheduleIndex(){
        //given
        Movie movie = new Movie(0, "Orc War", 8000);
        PlaySchedule playSchedule = new PlaySchedule(LocalDateTime.now().plusHours(2L), 6);
        movie.addPlaySchedule(playSchedule);

        //when
        PlaySchedule actual = MovieApplication.getValidateExistByScheduleIndex(movie, 1);

        //then
        assertThat(actual).isEqualTo(playSchedule);
    }
}