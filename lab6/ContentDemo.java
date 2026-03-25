import java.util.ArrayList;

public class ContentDemo {
    public static void main(String[] args) {
        ArrayList<Content> contents = new ArrayList<>();
    contents.add(new Movie(1, "mov", 100, "Yes"));
    contents.add(new Series(2, "ser", 20, 8));
    contents.add(new Documentary(3, "doc", 60, "Science", 5, 3));
    contents.add(new Movie(4, "mov2", 10, "No"));
    contents.add(new Series(5, "ser2", 20, 8));
    contents.add(new Documentary(6, "doc2", 60, "History", 2, 1));
    for (Content content : contents) {
        System.out.println("Title: " + content.getTitle());
        System.out.println("Total Duration: " + content.calculateTotalDuration() + " minutes");
        System.out.println("Category: " + content.getRecommendationCategory());
        System.out.println();
    }
}
}