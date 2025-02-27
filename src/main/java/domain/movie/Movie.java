package domain.movie;

import domain.movie.PlaySchedule;

import java.util.ArrayList;
import java.util.List;

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

    public int getPrice() {
        return price;
    }

    public void addPlaySchedule(PlaySchedule playSchedule) {
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
