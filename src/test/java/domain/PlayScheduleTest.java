package domain;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;
import static utils.DateTimeUtils.*;

public class PlayScheduleTest {

    @Test
    public void validateTimeIsOver(){
        //given
        PlaySchedule playSchedule = new PlaySchedule(createDateTime("2022-11-22 12:00"), 6);
        LocalDateTime request = createDateTime("2022-11-22 14:00");

        //when & then
        assertThatThrownBy(() -> playSchedule.validateTime(request))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이미 상영 시간이 지난 영화입니다.");
    }

    @Test
    public void validateTimeIsOneHour(){
        //given
        PlaySchedule playSchedule = new PlaySchedule(createDateTime("2022-11-22 12:00"), 6);
        LocalDateTime request = createDateTime("2022-11-22 11:30");

        //when & then
        assertThatThrownBy(() -> playSchedule.validateTime(request))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("상영 한시간 전에는 영화를 예매할 수 없습니다.");
    }


    @Test
    public void validateCapacityIsOver(){
        //given
        PlaySchedule playSchedule = new PlaySchedule(createDateTime("2022-11-22 12:00"), 6);
        int requestCapacity = 7;

        //when & then
        assertThatThrownBy(() -> playSchedule.validateCapacity(requestCapacity))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("예약 인원이 현재 좌석보다 많습니다.");
    }

    @Test
    public void validateCapacityIsZero(){
        //given
        PlaySchedule playSchedule = new PlaySchedule(createDateTime("2022-11-22 12:00"), 6);
        int requestCapacity = 0;

        //when & then
        assertThatThrownBy(() -> playSchedule.validateCapacity(requestCapacity))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("최소 예약 인원은 1명보다 많아야합니다.");
    }

    @Test
    public void minusCapacity(){
        //given
        int initCapacity = 5;
        PlaySchedule playSchedule = new PlaySchedule(createDateTime("2022-11-22 12:00"), initCapacity);
        int requestCapacity = 1;

        //when
        playSchedule.minusCapacity(requestCapacity);
        int expected = initCapacity - requestCapacity;

        //then
        assertThat(playSchedule.getCapacity()).isEqualTo(expected);
    }

    @Test
    public void plusCapacity(){
        //given
        int initCapacity = 5;
        PlaySchedule playSchedule = new PlaySchedule(createDateTime("2022-11-22 12:00"), initCapacity);
        int requestCapacity = 1;

        //when
        playSchedule.addCapacity(requestCapacity);
        int expected = initCapacity + requestCapacity;

        //then
        assertThat(playSchedule.getCapacity()).isEqualTo(expected);
    }
}
