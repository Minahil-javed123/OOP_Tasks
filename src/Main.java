
import Instagramlab.InstagramAccount;
import Instagramlab.HashtagTrend;
public class Main {
    public static void main(String[] args) {

        InstagramAccount[] accounts = new InstagramAccount[2];

        accounts[0] = new InstagramAccount(
                "@sara.cs",
                "Sara",
                "CS student",
                new int[]{40, 60, 80},
                false
        );
        accounts[1] = new InstagramAccount(
                "@areeba.tech",
                "Areeba",
                "Tech creator",
                new int[]{20, 30, 40},
                true
        );
        accounts[0].displayProfile();
        accounts[1].displayProfile();
        InstagramAccount alias = accounts[0];
        alias.setBio("Coding daily");
        System.out.println("After alias update:");
        accounts[0].displayProfile();
        System.out.println("Same object: " + (alias == accounts[0]));
        boolean success = accounts[0].updatePostLikes(0, 100);
        System.out.println("Valid likes update: " + success);

        boolean invalid = accounts[0].updatePostLikes(1, -50);
        boolean invalidIndex = accounts[0].updatePostLikes(5, 100);

        if (!invalid || !invalidIndex) {
            System.out.println("Invalid likes or index.");
        }
        accounts[1].setPrivate(false);
        System.out.println("Total Instagram accounts: "
                + InstagramAccount.getAccountCount());

        HashtagTrend trend = new HashtagTrend(
                "H-01",
                "#CampusLife",
                5
        );

        trend.recordUse();
        trend.displayTrend();
    }
}
