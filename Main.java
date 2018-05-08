package com.company;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Main implements Serializable{

    public static void main(String[] args) throws IOException {
        ArrayList<String> filmArray = new ArrayList<String>();
        Boolean interfaceAskAgain = true;
        while (interfaceAskAgain) {
            if (filmInterface(filmArray)) break;
        }
    }

    private static boolean filmInterface(ArrayList<String> filmArray) throws IOException {
        System.out.println("Welcome to your DVD collection. Type; \n \"View\" to see your current collection. \n \"Add\" to add a new film to your collection. \n \"Delete\" to choose a film to be removed from your collection. \n \"Sort\" to sort the display of your collection by film title, film duration, film release year or film rating out of 5. \n \"Edit\" to edit an already existing film in your collection, regarding the film name, duration, year and/or rating. \n \"Exit\" to exit your collection.");
        Scanner inputScanner = new Scanner(System.in);
        String input = inputScanner.nextLine();
        if (input.trim().equals("View".toLowerCase())) {
            viewFilmsInCollection();
        } else if (input.trim().equals("Add".toLowerCase())) {
            addFilm(filmArray);
        } else if (input.trim().equals("Delete".toLowerCase())) {
            removeFilm();
        } else if (input.trim().equals("Exit".toLowerCase())) {
            System.out.println("See you again soon!");
            return true;
        } else if (input.trim().equals("Sort".toLowerCase())) {
            sortFilms(input);
        } else if (input.trim().equals("Edit".toLowerCase())){
            editFilm();
        } else {
            System.out.println("Your input is unrecognisable, try again.");
        }
        System.out.println("\n");
        return false;
    }

    private static void editFilm() throws FileNotFoundException {
        Film film = new Film();
        Scanner fileScanner = new Scanner(new File("src/FilmInfo.dat"));
        BufferedReader fileReader = new BufferedReader(new FileReader("src/FilmInfo.dat"));
        ArrayList<String> editList = new ArrayList<String>();
        Boolean editInterface = true;
        String oldText;
        String replaceText = null;
        int index = -1;
        while (fileScanner.hasNextLine()) {
            editList.add(fileScanner.nextLine());
        }
        System.out.println("Which film would you like to edit?");
        try {
            while (editInterface) {
                Boolean editFilmPrompt = true;
                Scanner editScanner = new Scanner(System.in);
                String edit = editScanner.nextLine();
                for (int i = 0; i < editList.size(); i++) {
                    while (editFilmPrompt)
                        if (editList.get(i).contains(edit)) {
                            index = i;
                            System.out.println(index);
                            editFilmPrompt = false;
                        } else if (!editList.contains(edit)) {
                            System.out.println("Your input does not match any film name in the collection, please enter an film that is in the collection.");
                        }
                    System.out.println("Which film attribute would you like to edit?");
                    Scanner editScanner2 = new Scanner(System.in);
                    edit = editScanner2.nextLine();
                    if (edit.equals("Name".toLowerCase())) {
                        System.out.println("Please enter the new name of the film.");
                        film.promptFilmName();
                        replaceText = film.getFilmName();
                    } else if (edit.equals("Rating".toLowerCase())) {
                        System.out.println("Please enter the new rating of the film.");
                        film.promptFilmRating();
                        int filmRating = Integer.parseInt(replaceText);
                        filmRating = film.getFilmRatingOutOfFive();
                    } else if (edit.equals("Year".toLowerCase())) {
                        System.out.println("Please enter the new release year of the film.");
                        film.promptFilmYear();
                        int filmYear = Integer.parseInt(replaceText);
                        filmYear = film.getFilmReleaseYear();
                    } else if (edit.equals("Duration".toLowerCase())) {
                        System.out.println("Please enter the new duration of the film.");
                        film.promptFilmDuration();
                        int filmDuration = Integer.parseInt(replaceText);
                        filmDuration = film.getDurationInMins();
                    } else {
                        System.out.println("You have entered an invalid attribute. Please enter a valid attribute.");
                    }
                }
                System.out.println("Changes have been saved.");
            }
        } catch (Exception error) {
            System.out.println("Problem reading from file");
        }
    }




    private static void sortFilms(String input) {
        System.out.println("What would you like to sort your collection by? Type \"Name\" to sort by alphabetical film name. \"Duration\" to sort by film length. \"Rating\" to sort by your given rating or \"Year\" to sort by the film's release year.");
        if (input.trim().equals("Name".toLowerCase())) {
            System.out.println("Film Collection is now sorted by Name.");
        } else if (input.trim().equals("Duration".toLowerCase())) {
            System.out.println("Film Collection is now sorted by Duration.");
        } else if (input.trim().equals("Rating".toLowerCase())) {
            System.out.println("Film Collection is now sorted by Rating.");
        } else if (input.trim().equals("Year".toLowerCase())) {
            System.out.println("Film Collection is now sorted by Year.");
        } else {
            System.out.println("Your input is unrecognisable, enter a valid attribute.");
        }
    }

    private static void removeFilm() throws IOException {
        Film film = new Film();
        System.out.println("Which film would you like to remove from your collection? (Enter a film name to remove the film) :- ");
        film.promptFilmName();
        String removeFilm = film.getFilmName();
        String currentLine = null;
        try {
            File inputFile = new File("src/FilmInfo.dat");
            File removeFilmFile = new File("src/FilmRemoval.dat");
        try (BufferedReader deleteReader = new BufferedReader(new FileReader(inputFile));
              BufferedWriter deleteWriter = new BufferedWriter(new FileWriter(removeFilmFile))){
            while ((currentLine = deleteReader.readLine()) != null) {
                String trim = currentLine.trim();
                if (!trim.equals(removeFilm)) {
                    deleteWriter.write(currentLine);
                    deleteWriter.newLine();
                }
            }
        }
        } catch (Exception error) {
            System.out.println(film.getFilmName() + "could not be deleted.");
        }
        System.out.println(film.getFilmName() + " has been deleted from your collection.");
    }

    private static void addFilm(ArrayList<String> filmArray) {
        Film film = new Film();
        try {
            FileWriter writer = new FileWriter("src/FilmInfo.dat", true);
            System.out.println("What is the name of the Film?");
            film.promptFilmName();
            System.out.println("How long is the film in minutes? (Input a number)");
            film.promptFilmDuration();
            System.out.println("What year was the film released?");
            film.promptFilmYear();
            System.out.println("What would you rate the film? (Enter any number between 1 - 5)");
            film.promptFilmRating();
            String filmFromAdd = ("\nFilm Name:- " + film.getFilmName() + ", Film Duration in Minutes:- " + film.getDurationInMins() + ", Film Release Year:- " + film.getFilmReleaseYear() + ", Film Rating Out of 5:- " + film.getFilmRatingOutOfFive()) + " ";
            filmArray.add(filmFromAdd);
            String filmArrayDisplay = filmArray.toString();
            writer.write(filmArrayDisplay.substring(1, filmArrayDisplay.length() - 1));
            writer.close();
        } catch (Exception error) {
            System.out.println("Unable to write to film collection file.");
        }
    }

    private static void viewFilmsInCollection() {
        try {
            FileReader filmReader = new FileReader("src/FilmInfo.dat");
            int character;
            while ((character = filmReader.read()) != -1) {
                System.out.print((char) character);
            }
            filmReader.close();
        } catch (Exception error) {
            System.out.println("Unable to read from film info file.");
        }
    }
}
