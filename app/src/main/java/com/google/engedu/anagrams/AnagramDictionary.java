package com.google.engedu.anagrams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.*;

public class AnagramDictionary {

    private static final int MIN_NUM_ANAGRAMS = 5;
    private static final int DEFAULT_WORD_LENGTH = 3;
    private static final int MAX_WORD_LENGTH = 7;
    private Random random = new Random();
    private HashSet wordSet = new HashSet();
    private ArrayList wordList = new ArrayList();
    private HashMap lettersToWord = new HashMap();

    public AnagramDictionary(InputStream wordListStream) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(wordListStream));
        String line;
        String alphString;
        while((line = in.readLine()) != null) {
            String word = line.trim();
            wordSet.add(word);
            wordList.add(word);
            alphString = helperFunction(word);
            if(lettersToWord.containsKey(alphString)==false){
                // create new arraylist
                ArrayList arrayList = new ArrayList();
                lettersToWord.put(arrayList.add(alphString),word);

            }
            else {
                // Find existing arraylist
                ArrayList arrayList = (ArrayList)lettersToWord.get(alphString);
                lettersToWord.put(arrayList.add(alphString),word);
            }

        }
    }

    public String helperFunction(String inputString){
        char charArray[] = inputString.toCharArray();
        Arrays.sort(charArray);
        String outputString =  new String(charArray);
        return outputString;
    }

    public boolean isGoodWord(String word, String base) {
        if(base.contains(word)==true) {
            return false;
        }
        else {
            if(wordSet.contains(word)==true) {
                return true;
            }
            else {
                return false;
            }
        }
    }

    public ArrayList<String> getAnagramsWithOneMoreLetter(String word) {
        ArrayList<String> result = new ArrayList<String>();
        char start;
        String charaddedString;
        // Add one letter from alphabet to word anywhere
        for(start='a'; start <= 'z'; start++) {
            charaddedString = addchar(start,word);
            result.add(charaddedString);
        }
        // check if it is a valid anagram
        // check if it is a good word
        // if all nice, add to the result

        return result;
    }

    public String addchar(char start, String word) {
        //for(int i=1; i<=word.length(); i++) {
        String newWord =  word + Character.toString(start);
        return newWord;
        //}

    }

    public String pickGoodStarterWord() {
        return "foo";
    }
}
