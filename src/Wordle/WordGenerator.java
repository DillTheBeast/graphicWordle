package Wordle;

import java.io.File;
import java.util.Scanner;

public class WordGenerator {

    Scanner reader;
    int WORD_FILE_SIZE = 15_900;

    public WordGenerator(){


    }

    String getRandomWord() {

        try{
            int count = 0;
            int randIdx = (int)(Math.random() * WORD_FILE_SIZE);

            reader = new Scanner(new File("words5.txt"));
            String currentWord = "";

            while(reader.hasNext()){
                currentWord = reader.nextLine();
                System.out.println("Testing: " + currentWord);

                if (count == randIdx)
                    return currentWord;

                count++;
            }

        }catch(Exception e){
            System.out.println("Could not word find File.");
            e.printStackTrace();
            System.exit(1);
        }


        return ""; //Will not happen


    }

    boolean isWord(String word){
        try{
            reader = new Scanner(new File("words5.txt"));
            String currentWord = "";

            while(reader.hasNext()){
                currentWord = reader.nextLine();
                System.out.println("Testing: " + currentWord);
                if (currentWord.equals(word))
                    return true;
            }

        }catch(Exception e){
            System.out.println("Could not word find File.");
            e.printStackTrace();
            System.exit(1);
            return false;
        }

       return false;

    }


}