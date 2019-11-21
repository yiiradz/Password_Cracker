package password_crackers;

import java.io.*;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.io.File;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

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

    public static String appendSymbolsToWords(String input) throws IOException {

        String[] symbolsToAppend = {"!","@","#","$","%","^","&","*","(",")","_","123","abc"};
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
            //System.out.println(appendedInput[i]); // TODO: Write to file instead of printing
            return appendedInput[i];
        }
        return "ERROR";
    }

    public void prependSymbolsToWords(String fileName) throws IOException {
        // For every line of the file, add the symbol to the beginning of that line.
    }

    public static String l33tSp34kTranslation(String input){
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
                        //changed to 5 from $
                    case "s":
                        temp = inputMutation.replace('s', '5');
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
                return temp;
            }
        }
        /*
        for (int i = 0; i < l33tSp34kInput.length; i++){
            if(l33tSp34kInput[i] != null) {
                //System.out.println(l33tSp34kInput[i]); // TODO: Write to file instead of printing
                return l33tSp34kInput[i];
            }
        }
        */
        return "";
    }

    public static void capitalizeEachLetter(String input){

        // TODO: Think of a strategic way to capitalize letters

    }

    public static void addDates(String input){

    }

    // Java program to calculate MD5 hash value
        public static String getMd5(String input)
        {
            try {

                // Static getInstance method is called with hashing MD5
                MessageDigest md = MessageDigest.getInstance("MD5");

                // digest() method is called to calculate message digest
                //  of an input digest() return array of byte
                byte[] messageDigest = md.digest(input.getBytes());

                // Convert byte array into signum representation
                BigInteger no = new BigInteger(1, messageDigest);

                // Convert message digest into hex value
                String hashtext = no.toString(16);
                while (hashtext.length() < 32) {
                    hashtext = "0" + hashtext;
                }
                return hashtext;
            }

            // For specifying wrong message digest algorithms
            catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }

    public static void main(String a[]) throws IOException {

        String usernames [] = new String[20];
        usernames[0]="alice";
        usernames[1]="bob";
        usernames[2]="chuck";
        usernames[3]="dan";
        usernames[4]="ed";
        usernames[5]="frank";
        usernames[6]="george";
        usernames[7]="harry";
        usernames[8]="isaac";
        usernames[9]="jack";
        usernames[10]="ken";
        usernames[11]="laura";
        usernames[12]="mary";
        usernames[13]="nancy";
        usernames[14]="oprah";
        usernames[15]="pam";
        usernames[16]="quin";
        usernames[17]="rob";
        usernames[18]="sam";
        usernames[19]="tom";

        //EVENTUALLY automate the entry of the passwords
        String hashes [] = new String[20];
        hashes[0]="8f5140bee08ae5847615c9b55e40e56f";
        hashes[1]="f32fb20d098584d7cfc39a40a0dce4f2";
        hashes[2]="cc4d706ba1c3017a156eeea9070dd9a9";
        hashes[3]="725321a069c71ab4a0d73b66f3a32544";
        hashes[4]="798b8202a9ccd2b5271daf804bfcd45d";
        hashes[5]="00fcb586544c2be44180cd85eaf24921";
        hashes[6]="6234e99a2940fa0eaa7d1f82537dfbb4";
        hashes[7]="2f5f7d26aee6df8c0d7d5fe5ea09e98c";
        hashes[8]="b95ddb19c0ea2ca56778720a138aa0ce";
        hashes[9]="97c6be63844d947564b8687a019cc0f3";
        hashes[10]="4002e83daccc6a776c125d80b35e621c";
        hashes[11]="94b3f5c480dbba6c169bbc149269da14";
        hashes[12]="c33dff9a774add5dcad530b3a85facc9";
        hashes[13]="5e084369ef95582a8b8690f1dc3ab8f4";
        hashes[14]="11c65b1362122712dfd665a483e394d0";
        //these all have salt
        hashes[15]="3dff33dcb40d5cf35be5d11f033fc895";
        hashes[16]="12c45f723d4a80dd89645b0fd05b6c5a";
        hashes[17]="e6fac5ee63591a415aa71616c86e9cae";
        hashes[18]="17cec957462e3ba4d167943ebd50bc93";
        hashes[19]="850a7a3142acce590dc7a8ee02765358";

        //eventually automate the entry of salts
        String salt1="erty";
        String salt2="zxcv";
        String salt3="hjkl";
        String salt4="uiop";
        String salt5="asdf";

        Dictionary_Generator distinctFileWords = new Dictionary_Generator();
        //List<String> wordList = distinctFileWords.getUniqueBibleWords("/Users/yiradz/College/JUN_SEM1/SECURITY/PA4/src/password_crackers/PA4_Word_List.txt");
        //BufferedWriter uniqueBibleWordList = new BufferedWriter(new FileWriter("/Users/yiradz/College/JUN_SEM1/SECURITY/PA4/src/password_crackers/uniqueBibleWordList.txt"));

        List<String> wordList = distinctFileWords.getUniqueBibleWords("C:\\Users\\mrose\\Desktop\\Cedarville 19-20\\Cyber\\PA4\\PA4_Word_List.txt");
        BufferedWriter uniqueBibleWordList = new BufferedWriter(new FileWriter("C:\\Users\\mrose\\Desktop\\Cedarville 19-20\\Cyber\\PA4\\maybe.txt"));

        for (String str : wordList) {
            uniqueBibleWordList.write(str);
            uniqueBibleWordList.write("\n");
        }
        uniqueBibleWordList.close();

        Scanner scanner = new Scanner(new File("C:\\Users\\mrose\\Desktop\\Cedarville 19-20\\Cyber\\PA4\\BibleWords.txt"));


        String [] appendedWords = new String[13000];
        String [] hashedAppended = new String[13000];
        String [] leetWords = new String [13000];
        String [] hashedLeet = new String [13000];
        String [] plainWords = new String [13000];
        String [] hashedPlain = new String [13000];
        String [] salt1Words = new String [13000];
        String [] hashed1Salts = new String [13000];
        String [] salt2Words = new String [13000];
        String [] hashed2Salts = new String [13000];
        String [] salt3Words = new String [13000];
        String [] hashed3Salts = new String [13000];
        String [] salt4Words = new String [13000];
        String [] hashed4Salts = new String [13000];
        String [] salt5Words = new String [13000];
        String [] hashed5Salts = new String [13000];
        String [] s1a = new String [13000];
        String [] hasheds1a = new String [13000];
        String [] s2a = new String [13000];
        String [] hasheds2a = new String [13000];
        String [] s3a = new String [13000];
        String [] hasheds3a = new String [13000];
        String [] s4a = new String [13000];
        String [] hasheds4a = new String [13000];
        String [] s5a = new String [13000];
        String [] hasheds5a = new String [13000];

        int place = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            //plain words hashed
            plainWords[place]=line;
            hashedPlain[place]=getMd5(line);
            //plain salted
            salt1Words[place]=line+salt1;
            hashed1Salts[place]=getMd5(salt1Words[place]);
            salt2Words[place]=line+salt2;
            hashed2Salts[place]=getMd5(salt2Words[place]);
            salt3Words[place]=line+salt3;
            hashed3Salts[place]=getMd5(salt3Words[place]);
            salt4Words[place]=line+salt4;
            hashed4Salts[place]=getMd5(salt4Words[place]);
            salt5Words[place]=line+salt5;
            hashed5Salts[place]=getMd5(salt5Words[place]);
            //salted with append
            s1a[place] = appendSymbolsToWords(salt1Words[place]);
            System.out.println(s1a[place]);
            hasheds1a[place]=getMd5(s1a[place]);
            s2a[place] = appendSymbolsToWords(salt2Words[place]);
            hasheds2a[place]=getMd5(s2a[place]);
            s3a[place] = appendSymbolsToWords(salt3Words[place]);
            hasheds3a[place]=getMd5(s3a[place]);
            s4a[place] = appendSymbolsToWords(salt4Words[place]);
            hasheds4a[place]=getMd5(s4a[place]);
            s5a[place] = appendSymbolsToWords(salt5Words[place]);
            hasheds5a[place]=getMd5(s5a[place]);
            //leet stuff
            leetWords[place]=l33tSp34kTranslation(plainWords[place]);
            hashedLeet[place]=getMd5(leetWords[place]);
            //System.out.println(leetWords[place]);
            //append stuff
            appendedWords[place]=appendSymbolsToWords(plainWords[place]);
            hashedAppended[place]=getMd5(appendSymbolsToWords(plainWords[place]));
            for(int i=0; i <20; i++)
            { if(hashedPlain[place].equals(hashes[i])) {
                    System.out.println(usernames[i]+":"+plainWords[place]);
                    break; }
                if(hashedLeet[place].equals(hashes[i])) {
                    System.out.println(usernames[i]+":"+leetWords[place]);
                    break; }
                if(hashedAppended[place].equals(hashes[i])) {
                    System.out.println(usernames[i]+":"+appendedWords[place]);
                    break; }
                if(hashed2Salts[place].equals(hashes[i])) {
                    System.out.println(usernames[i]+":"+salt2Words[place]);
                    break; }
                if(hashed3Salts[place].equals(hashes[i])) {
                    System.out.println(usernames[i]+":"+salt3Words[place]);
                    break; }
                if(hashed4Salts[place].equals(hashes[i])) {
                    System.out.println(usernames[i]+":"+salt4Words[place]);
                    break; }
                if(hashed5Salts[place].equals(hashes[i])) {
                    System.out.println(usernames[i]+":"+salt5Words[place]);
                    break; }
                if(hasheds1a[place].equals(hashes[i])) {
                    System.out.println(usernames[i]+":"+s1a[place]);
                    break; }
                if(hasheds2a[place].equals(hashes[i])) {
                    System.out.println(usernames[i]+":"+s2a[place]);
                    break; }
                if(hasheds3a[place].equals(hashes[i])) {
                    System.out.println(usernames[i]+":"+s3a[place]);
                    break; }
                if(hasheds4a[place].equals(hashes[i])) {
                    System.out.println(usernames[i]+":"+s4a[place]);
                    break; }
                if(hasheds5a[place].equals(hashes[i])) {
                    System.out.println(usernames[i]+":"+s5a[place]);
                    break; }}
            place++;
        }
    }

}

/*
            plainWords[place]=line;
            hashedPlain[place]=getMd5(plainWords[place]);
            appendedWords[place]=appendSymbolsToWords(line);
            //System.out.println(appendedWords[place]);
            hashedAppended[place]=getMd5(appendedWords[place]);
            //System.out.println(hashedAppended[place]);
            appendSymbolsToWords(line);
            leetWords[place]=l33tSp34kTranslation(line);
            hashedLeet[place]=getMd5(leetWords[place]);
            l33tSp34kTranslation(line);
            for(int i = 0; i <20; i++) {
                if(hashes[i].equals(hashedPlain[place])) {
                    System.out.println(usernames[place]+":"+plainWords[place]);
                    break; }
                if(hashes[i].equals(hashedAppended[place])) {
                    System.out.println(usernames[place]+":"+appendedWords[place]);
                    break; }
                if(hashes[i].equals(hashedLeet[place])) {
                    System.out.println(usernames[place]+":"+leetWords[place]);
                    break; }
            }
            place++;
            */
