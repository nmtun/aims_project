package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<MediaTungNM> {
    @Override
    public int compare(MediaTungNM o1, MediaTungNM o2) {
        return Comparator.comparing(MediaTungNM::getTitle)
                .thenComparingDouble((o) -> -o.getCost())
                .compare(o1, o2);
    }
}
