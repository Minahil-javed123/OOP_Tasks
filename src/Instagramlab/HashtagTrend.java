package Instagramlab;

public class HashtagTrend {
    private final String trendCode;
    private String hashtag;
    private int useCount;
    public HashtagTrend(String trendCode,
                        String hashtag,
                        int useCount) {
        if (useCount < 0) {
            throw new IllegalArgumentException(
                    "Use count cannot be negative."
            );
        }
        this.trendCode = trendCode;
        this.hashtag = hashtag;
        this.useCount = useCount;
    }
    public void recordUse() {
        useCount++;
    }
    public void displayTrend() {
        System.out.println(
                trendCode + " | " + hashtag +
                        " | Uses: " + useCount
        );
    }
}
