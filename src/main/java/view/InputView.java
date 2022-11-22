package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_MOVIE_TEXT = "## 예약할 영화를 선택하세요.";
    private static final String INPUT_SCHEDULE_TEXT = "## 예약할 시간를 선택하세요.";
    private static final String INPUT_CAPACITY_TEXT = "## 예인 인원을 입력하세요.";
    private static final String INPUT_RESERVE_TEXT = "## 예약 확인 입니다. [ 1: 예약, 2: 추가 예약 ]";

    private static final String INPUT_POINT_TEXT = "## 사용할 포인트를 입력하세요.";
    private static final String INPUT_PAYGROUP_TEXT = "## 결제 방법을 선택하세요. [ 1: 현금, 2: 카드 ]";

    public static int inputMovieId() {
        System.out.println(INPUT_MOVIE_TEXT);
        return getInputInt();
    }

    public static int inputSchedule(){
        System.out.println(INPUT_SCHEDULE_TEXT);
        return getInputInt();
    }

    public static int inputCapacity(){
        System.out.println(INPUT_CAPACITY_TEXT);
        return getInputInt();
    }

    public static int inputCheckReserve(){
        System.out.println(INPUT_RESERVE_TEXT);
        return getInputInt();
    }

    public static int inputPoint(){
        System.out.println(INPUT_POINT_TEXT);
        return getInputInt();
    }

    public static int inputPayGroup(){
        System.out.println(INPUT_PAYGROUP_TEXT);
        return getInputInt();
    }

    private static int getInputInt(){
        try {
            return scanner.nextInt();
        }catch (InputMismatchException exception){
            return getInputInt();
        }
    }
}
