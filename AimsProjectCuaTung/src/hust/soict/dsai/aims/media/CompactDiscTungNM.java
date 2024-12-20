package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDiscTungNM extends DiscTungNM implements PlayableTungNM{
    private String artist;
    private List<TrackTungNM> tracks = new ArrayList<>();

    // create 
    public CompactDiscTungNM(String title, float price) {
        super(title, price);
    }

    public CompactDiscTungNM(int id, String title, String category, float cost, int length, String director) {
        super(id, title, category, cost, length, director);
    }

    public CompactDiscTungNM(int id, String title, String category, float cost, int length, String director, String artist, List<TrackTungNM> tracks) {
        super(id, title, category, cost, length, director);
        this.artist = artist;
        this.tracks.addAll(tracks);
    }

    public boolean addTrack(TrackTungNM track) {
        if(tracks.contains(track)) {
            System.out.println("Already exits");
            return false;
        } else {
            tracks.add(track);
            System.out.println("Track: " + track + " have been added");
            return true;
        }
    }

    public boolean removeTrack(TrackTungNM track) {
        if(!tracks.contains(track)) {
            System.out.println("Not exits");
            return false;
        } else {
            tracks.add(track);
            System.out.println("Track: " + track + " have been removed");
            return true;
        }
    }

    public int getTotalLength() {
        int totalLength = 0;
        for(TrackTungNM track: tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    public void play() {
        for(TrackTungNM track : tracks) {
            System.out.println("Playing track: " + track.getTitle());
            track.play();
        }
    }
}
