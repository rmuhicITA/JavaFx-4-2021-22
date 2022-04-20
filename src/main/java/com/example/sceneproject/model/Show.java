package com.example.sceneproject.model;

public class Show {
    private int showId;
    private String showTitle;
    private int numOfSeasons;
    private int initialYear;

    public Show() {
        super();
    }

    public Show(int showId, String showTitle, int numberOfSeason, int year) {
        this.showId = showId;
        this.showTitle = showTitle;
        this.numOfSeasons = numberOfSeason;
        this.initialYear = year;
    }

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public String getShowTitle() {
        return showTitle;
    }

    public void setShowTitle(String showTitle) {
        this.showTitle = showTitle;
    }

    public int getNumOfSeasons() {
        return numOfSeasons;
    }

    public void setNumOfSeasons(int numOfSeasons) {
        this.numOfSeasons = numOfSeasons;
    }

    public int getInitialYear() {
        return initialYear;
    }

    public void setInitialYear(int initialYear) {
        this.initialYear = initialYear;
    }
}
