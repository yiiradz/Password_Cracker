package password_crackers;

import java.io.*;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.*;

public class Dictionary_Generator {

    public List<String> getUniqueBibleWords(String fileName) {

        FileInputStream fis = null;
        DataInputStream dis = null;
        BufferedReader br = null;
        List<String> wordList = new ArrayList<String>();
        try {
            fis = new FileInputStream(fileName);
            dis = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(dis));
            String line = null;
            while ((line = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, " ,.;:[]?!'1234567890\"");
                while (st.hasMoreTokens()) {
                    String tmp = st.nextToken().toLowerCase();
                    if (!wordList.contains(tmp)) {
                        wordList.add(tmp);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (Exception ex) {
            }
        }
        return wordList;
    }

    //TODO: instead of having the generator change all the words in the file, work on each line of the file and send it through a bunch of mutations.
    // however, after all the changes are done to it, add each mutation to a file and compile a MASSIVE file of all these possible combinations.

    public static void appendSymbolsToWords(String input) throws IOException {

            String[] symbolsToAppend = {"!","@","#","$","%","^","&","*","(",")","_"};
            String inputMutation = "";
            String[] appendedInput = new String[symbolsToAppend.length];

            for (int i = 0; i < symbolsToAppend.length; i ++){
            // Append the ith symbol in the array to every line in the file

                StringBuffer sb = new StringBuffer(input);
                sb.append(symbolsToAppend[i]);
                inputMutation = sb.toString();
                appendedInput[i] = inputMutation;
                }
            for (int i = 0; i < appendedInput.length; i++){
                System.out.println(appendedInput[i]); // TODO: Write to file instead of printing
            }

    }

    public void prependSymbolsToWords(String fileName) throws IOException {
        // For every line of the file, add the symbol to the beginning of that line.
    }

    public static void l33tSp34kTranslation(String input){
        // Search in given file and replace E -> 3,  o -> 0, a -> @, $" for "s", "1" for "l" and so on

        /* BufferedWriter writer = new BufferedWriter(
                                        new FileWriter("/Users/yiradz/College/JUN_SEM1/SECURITY/PA4/src/password_crackers/l33tSp34kTranslationWordList.txt"", true)  //Set true for append mode
                                    );
        for (String fn : fileName) {
            String s = new String(Files.readAllBytes(Paths.get(fn)));
            s = s.replace("E", "3");
                writer.write(s);
            }
        }
         */
        String[] sp34kT0L33t = {"e","o","a","s","l","g","b","t","i"};
        String inputMutation = input;
        String[] l33tSp34kInput = new String [sp34kT0L33t.length];

        for (int i = 0; i < sp34kT0L33t.length; i ++){
            // Replace the letters with common translations.

            //StringBuffer sb = new StringBuffer(input);
            String temp = "";
            if(input.contains(sp34kT0L33t[i])) {
                switch (sp34kT0L33t[i]){
                    case "e":
                        temp = inputMutation.replace('e', '3');
                        break;
                    case "o":
                        temp = inputMutation.replace('o', '0');
                       break;
                    case "a":
                        temp = inputMutation.replace('a', '@');
                        break;
                    case "s":
                        temp = inputMutation.replace('s', '$');
                        break;
                    case "l":
                        temp = inputMutation.replace('l', '1');
                        break;
                    case "g":
                        temp = inputMutation.replace('g', '9');
                        break;
                    case "b":
                        temp = inputMutation.replace('b', '8');
                        break;
                    case "t":
                        temp = inputMutation.replace('t', '7');
                        break;
                    case "i":
                        temp = inputMutation.replace('i', '1');
                        break;

                    default: break;

                }
                //inputMutation = sb.toString();
                l33tSp34kInput[i] = temp;
            }
        }
        for (int i = 0; i < l33tSp34kInput.length; i++){
            if(l33tSp34kInput[i] != null)
            System.out.println(l33tSp34kInput[i]); // TODO: Write to file instead of printing
        }

    }

    public static void capitalizeEachLetter(String input){

        // TODO: Think of a strategic way to capitalize letters

    }
    
    public static void addDates(String input){

    }

    public static void main(String a[]) throws IOException {

        Dictionary_Generator distinctFileWords = new Dictionary_Generator();
        //List<String> wordList = distinctFileWords.getUniqueBibleWords("/Users/yiradz/College/JUN_SEM1/SECURITY/PA4/src/password_crackers/PA4_Word_List.txt");
       // BufferedWriter uniqueBibleWordList = new BufferedWriter(new FileWriter("/Users/yiradz/College/JUN_SEM1/SECURITY/PA4/src/password_crackers/uniqueBibleWordList.txt"));

        List<String> wordList = distinctFileWords.getUniqueBibleWords("/Users/yiradz/College/JUN_SEM1/SECURITY/PA4/src/password_crackers/test.txt");
        BufferedWriter uniqueBibleWordList = new BufferedWriter(new FileWriter("/Users/yiradz/College/JUN_SEM1/SECURITY/PA4/src/password_crackers/maybe.txt"));

        for (String str : wordList) {
            uniqueBibleWordList.write(str);
            uniqueBibleWordList.write("\n");
        }
        uniqueBibleWordList.close();

        Scanner scanner = new Scanner(new File("/Users/yiradz/College/JUN_SEM1/SECURITY/PA4/src/password_crackers/maybe.txt"));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
           appendSymbolsToWords(line);
           l33tSp34kTranslation(line);
        }
    }

}
