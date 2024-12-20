package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<MediaTungNM>{
    @Override
    public int compare(MediaTungNM o1, MediaTungNM o2) {
        return Comparator.comparingDouble(MediaTungNM::getCost)
                .reversed()
                .thenComparing(MediaTungNM::getTitle)
                .compare(o1, o2);
    }
}
