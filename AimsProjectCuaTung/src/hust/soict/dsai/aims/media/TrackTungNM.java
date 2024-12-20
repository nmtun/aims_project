package hust.soict.dsai.aims.media;

public class TrackTungNM implements PlayableTungNM{
    private String title;
    private int length;
    private float price;

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public TrackTungNM() {
        super();
    }

    public TrackTungNM(String title) {
        super();
        this.title = title;
    }

    public TrackTungNM(String title, int length, float price) {
        super();
        this.title = title;
        this.length = length;
        this.price = price;
    }

    public void play() {
        System.out.println("Plying Track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof TrackTungNM)) return false;
        // 2 media items are considered as indentical if thay same title
        return (((TrackTungNM) o).getTitle().equals(title) && ((TrackTungNM) o).getLength() == length);
    }
}
