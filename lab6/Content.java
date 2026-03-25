public abstract class Content {
    private int id;
    private String title;
    private int baseDuration;

    public Content(int id, String title, int baseDuration) {
        this.id = id;
        this.title = title;
        this.baseDuration = baseDuration;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getBaseDuration() {
        return baseDuration;
    }

    public abstract int calculateTotalDuration();
    public abstract String getRecommendationCategory();
}

class Movie extends Content {
    private String postCreditsScene;

    public Movie(int id, String title, int baseDuration, String postCreditsScene) {
        super(id, title, baseDuration);
        this.postCreditsScene = postCreditsScene;
    }

    public String getPostCreditsScene() {
        return postCreditsScene;
    }

    @Override
    public int calculateTotalDuration() {
        if (postCreditsScene != null && !postCreditsScene.isBlank()) {
            return getBaseDuration() + 5;
        }
        return getBaseDuration();
    }

    @Override
    public String getRecommendationCategory() {
        if (getBaseDuration() < 90) {
            return "Short Movie";
        }
        return "Feature Length";
    }
}

class Series extends Content {
    private int numberOfEpisodes;

    public Series(int id, String title, int baseDuration, int numberOfEpisodes) {
        super(id, title, baseDuration);
        this.numberOfEpisodes = numberOfEpisodes;
    }

    public int getNumberOfEpisodes() {
        return numberOfEpisodes;
    }

    @Override
    public int calculateTotalDuration() {
        return getBaseDuration() * numberOfEpisodes;
    }

    @Override
    public String getRecommendationCategory() {
        if (numberOfEpisodes >= 10) {
            return "Bingr-worthy";
        }
        return "Mini series";
    }
}

class Documentary extends Content {
    private String subject;
    private int researchDepthLevel;
    private int numberOfScientistInterviews;

    public Documentary(int id, String title, int baseDuration, String subject, int researchDepthLevel, int numberOfScientistInterviews) {
        super(id, title, baseDuration);
        this.subject = subject;
        this.researchDepthLevel = researchDepthLevel;
        this.numberOfScientistInterviews = numberOfScientistInterviews;
    }

    @Override
    public int calculateTotalDuration() {
        return getBaseDuration() + numberOfScientistInterviews * 10;
    }

    @Override
    public String getRecommendationCategory() {
        if (researchDepthLevel >= 4) {
            return "In-depth";
        }
        return "Light Infprmative";
    }

    public String getSubject() {
        return subject;
    }

    public int getResearchDepthLevel() {
        return researchDepthLevel;
    }

    public int getNumberOfScientistInterviews() {
        return numberOfScientistInterviews;
    }
}
