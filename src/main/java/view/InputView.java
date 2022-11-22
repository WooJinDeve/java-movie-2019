package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_MOVIE_TEXT = "## 예약할 영화를 선택하세요.";

    public static int inputMovieId() {
        System.out.println(INPUT_MOVIE_TEXT);
        try {
            return scanner.nextInt();
        }catch (InputMismatchException exception){
            throw new IllegalArgumentException("숫자가 아닌 값이 입력되었습니다.");
        }
    }
}
