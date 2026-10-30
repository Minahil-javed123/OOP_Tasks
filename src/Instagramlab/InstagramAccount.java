package Instagramlab;
public class InstagramAccount {
    private final String username;
    private String displayName;
    private String bio;
    private int[] recentPostLikes;
    private boolean isPrivate;
    private static int accountCount = 0;
    public InstagramAccount(String username,
                            String displayName,
                            String bio,
                            int[] recentPostLikes,
                            boolean isPrivate) {
        this.username = username;
        this.displayName = displayName;
        this.bio = bio;
        this.isPrivate = isPrivate;
        if (recentPostLikes == null ||
                recentPostLikes.length != 3) {
            throw new IllegalArgumentException(
                    "Exactly 3 post likes are required."
            );
        }
        this.recentPostLikes = recentPostLikes.clone();
        for (int likes : this.recentPostLikes) {
            if (likes < 0) {
                throw new IllegalArgumentException(
                        "Likes cannot be negative."
                );
            }
        }
        accountCount++;
    }
    public String getUsername() {
        return username;
    }
    public String getBio() {
        return bio;
    }
    public void setBio(String bio) {
        if (bio != null && !bio.trim().isEmpty()) {
            this.bio = bio;
        } else {
            System.out.println("Invalid bio.");
        }
    }
    public void setPrivate(boolean isPrivate) {
        this.isPrivate = isPrivate;
    }
    public boolean updatePostLikes(int index, int likes) {
        if (index < 0 ||
                index >= recentPostLikes.length ||
                likes < 0) {
            return false;
        }
        recentPostLikes[index] = likes;
        return true;
    }
    public double calculateAverageLikes() {
        int total = 0;
        for (int likes : recentPostLikes) {
            total += likes;
        }
        return (double) total / recentPostLikes.length;
    }
    public void displayProfile() {
        System.out.println(
                username + " | Bio: " + bio +
                        " | Avg likes: " + calculateAverageLikes()
        );
    }
    public static int getAccountCount() {
        return accountCount;
    }
}

