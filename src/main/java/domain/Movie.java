package domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Movie {
    private static final char NEW_LINE = '\n';

    private final int id;
    private final String name;
    private final int price;

    private List<PlaySchedule> playSchedules = new ArrayList<>();

    public Movie(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public boolean hasId(int id) {
        return this.id == id;
    }

    public List<PlaySchedule> getPlaySchedules() {
        return playSchedules;
    }

    public PlaySchedule getPaySchedule(int index){
        return Optional.ofNullable(playSchedules.get(index - 1))
                .orElseThrow(IllegalArgumentException::new)
                .validateTime(LocalDateTime.now());
    }

    void addPlaySchedule(PlaySchedule playSchedule) {
        playSchedules.add(playSchedule);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (PlaySchedule playSchedule : playSchedules) {
            sb.append(playSchedule);
        }
        return id + " - " + name + ", " + price + "원" + NEW_LINE
                + sb.toString();
    }

    public void movieInformationOutput(){
        System.out.println(id + " - " + name + ", " + price + "원");
    }
}
