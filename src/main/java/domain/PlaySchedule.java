package domain;

import java.time.LocalDateTime;

import static utils.DateTimeUtils.format;

public class PlaySchedule {
    private static final int MINIMUM_CAPACITY = 1;
    private final LocalDateTime startDateTime;
    private int capacity;

    public PlaySchedule(LocalDateTime startDateTime, int capacity) {
        this.startDateTime = startDateTime;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "시작시간: " + format(startDateTime) + " 예약가능인원: " + capacity + "\n";
    }

    public void scheduleInformationOutput(){
        System.out.println("시작시간: " + format(startDateTime) + " 예약가능인원: " + capacity);
    }

    public PlaySchedule validateTime(LocalDateTime currentTime){
        if (this.startDateTime.isBefore(currentTime))
            throw new IllegalArgumentException("이미 상영 시간이 지난 영화입니다.");
        return this;
    }

    public void validateCapacity(int capacity){
        if(capacity < MINIMUM_CAPACITY)
            throw new IllegalArgumentException("최소 예약 인원은 1명보다 많아야합니다.");
        else if(this.capacity < capacity)
            throw new IllegalArgumentException("예약 인원이 현재 좌석보다 많습니다.");
    }

    public void minusCapacity(int capacity){
        this.capacity -= capacity;
    }

    public void addCapacity(int capacity){
        this.capacity += capacity;
    }
}
