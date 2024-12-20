package hust.soict.dsai.aims.media;

public class DVDTungNM extends DiscTungNM implements PlayableTungNM{
    private static int nbDVDTungNM = 0;

    public DVDTungNM(String title) {
        super();
        setTitle(title);
        nbDVDTungNM++;
        setId(nbDVDTungNM);
    }

    public DVDTungNM(String title, float cost) {
        super(title, cost);
    }

    public DVDTungNM(String title, String category, float cost) {
        this(title);
        setCategory(category);
        setCost(cost);
	}

    public DVDTungNM(String director, String title, String category, float cost) {
        this(title, category, cost);
        setDirector(director);
	}

    public DVDTungNM(String title, String category, float cost, int length,  String director) {
       super(title, category, cost, length, director);
       //setLength(length);
    }

    public void play() {
        System.out.println("Plying DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }

    @Override
    public int compareTo(MediaTungNM o) {
        // So sánh tiêu đề trước
        int titleCompare = getTitle().compareTo(o.getTitle());
        if (titleCompare != 0) return titleCompare;

        // So sánh giá nếu tiêu đề bằng nhau
        int priceCompare = Double.compare(getCost(), o.getCost());
        if (priceCompare != 0) return priceCompare;

        // So sánh thể loại khi tiêu đề và giá bằng nhau
        return getCategory().compareTo(o.getCategory());
    }

}
