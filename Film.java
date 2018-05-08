package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Film {

    private Scanner filmScanner = new Scanner(System.in);

    private String filmName;

    public String getFilmName() {
        return filmName;
    }

    private int durationInMins;

    public int getDurationInMins() {
        return durationInMins;
    }

    private int filmReleaseYear;

    public int getFilmReleaseYear() {
        return filmReleaseYear;
    }

    private int filmRatingOutOfFive;

    public int getFilmRatingOutOfFive() {
        return filmRatingOutOfFive;
    }

    public String film(String filmName, int durationInMins, int filmReleaseYear, int filmRatingOutOfFive) {
        this.filmName = filmName;
        this.durationInMins = durationInMins;
        this.filmReleaseYear = filmReleaseYear;
        this.filmRatingOutOfFive = filmRatingOutOfFive;
        return getFilm;
    }

    public String getFilm;

    public void promptFilmName() {
        filmName = filmScanner.nextLine();
    }

    public void promptFilmYear() {
        while (!filmScanner.hasNextInt()) {
            System.out.println("Please enter a number instead of text.");
            filmScanner.next();
        }
        filmReleaseYear = filmScanner.nextInt();
    }

    public void promptFilmDuration(){
        while (!filmScanner.hasNextInt()) {
            System.out.println("Please enter a number instead of text.");
            filmScanner.next();
        }
        durationInMins = filmScanner.nextInt();
    }

    public void promptFilmRating() {
        while (!filmScanner.hasNextInt()) {
            System.out.println("Please enter a number instead of text.");
            filmScanner.next();
        }
        do {
            filmRatingOutOfFive = filmScanner.nextInt();
            System.out.println("Please enter a number between 1 and 5.");
        } while (filmRatingOutOfFive > 5 || filmRatingOutOfFive < 1);


    }

}

