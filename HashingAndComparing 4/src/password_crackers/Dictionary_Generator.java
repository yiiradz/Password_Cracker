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

import static java.lang.Integer.parseInt;

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

        String[] symbolsToAppend = {"!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "_", "123", "abc"};
        String inputMutation = "";
        String[] appendedInput = new String[symbolsToAppend.length];

        for (int i = 0; i < symbolsToAppend.length; i++) {
            // Append the ith symbol in the array to every line in the file

            StringBuffer sb = new StringBuffer(input);
            sb.append(symbolsToAppend[i]);
            inputMutation = sb.toString();
            appendedInput[i] = inputMutation;
            return appendedInput[i];
        }
        for (int i = 0; i < appendedInput.length; i++) {
            //System.out.println(appendedInput[i]); // TODO: Write to file instead of printing
            //return appendedInput[i];
        }
        return "ERROR";
    }

    public void prependSymbolsToWords(String fileName) throws IOException {
        // For every line of the file, add the symbol to the beginning of that line.
    }

    public static String l33tSp34kTranslation(String input) {
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
        String[] sp34kT0L33t = {"e", "o", "a", "s", "l", "g", "b", "t", "i"};
        String inputMutation = input;
        String[] l33tSp34kInput = new String[sp34kT0L33t.length];

        for (int i = 0; i < sp34kT0L33t.length; i++) {
            // Replace the letters with common translations.

            //StringBuffer sb = new StringBuffer(input);
            String temp = "";

            if (input.contains(sp34kT0L33t[i])) {
                switch (sp34kT0L33t[i]) {


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

                    default:
                        break;

                }

                //inputMutation = sb.toString();
                l33tSp34kInput[i] = temp;
                return temp;
            }
            return "";
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

    public static void toUpperCase(String input){ // TODO: change the output to return instead of system.out

        // every letter individually
        String result = "";
        char[] inputArray = input.toCharArray();
        for (int i = 0; i < inputArray.length; i++) {

            inputArray[i]= Character.toUpperCase(inputArray[i]);
            result = new String(inputArray);
            System.out.println(result);

        }
        System.out.println(result);

    }

    public static void addDates(String input) { // TODO: change the output to return instead of system.out

        //use day/month/year
        // two numbers two numbers two numbers
        //days up to 31, months up to 12
        //years start at 50 to 20 (50 - 00,00 - 20)
        //concatnate

        // Initial variables and numbers
        int days = 31;
        int months = 12;
        int years_1 = 50; // years '50 - '00
        int year_2 = 0; // years '00 - '20
        int years_2 =  parseInt(String.format("%02d", year_2));
        String inputWithDayMonthYear = "";
        String inputWithDayMonth = "";
        String inputWithMonthDay = "";


        // for years '50 - '00
        for (int i = years_1; i < 100; i++) {
            for (int j = 1; j <= months; j++) {
                for (int k = 1; k <= days; k++) {

                    // Add leading zeros if needed
                    String a =  String.format("%02d", i);
                    String b =  String.format("%02d", j);
                    String c =  String.format("%02d", k);

                    // Appending Dates to String
                    inputWithDayMonthYear = input + c + b + a;
                    inputWithDayMonth = input + c + b;
                    inputWithMonthDay = input + b + c;

                    // Print out in different forms
                    System.out.println(inputWithMonthDay);
                    System.out.println(inputWithDayMonth);
                    System.out.println(inputWithDayMonthYear);

                }
            }

            // for years '00 - '20
            if (i == 99){
                for (int x = years_2; x <= 20; x++) {
                    for (int j = 1; j <= months; j++) {
                        for (int k = 1; k <= days; k++) {

                            // Add leading zeros if needed
                            String a =  String.format("%02d", x);
                            String b =  String.format("%02d", j);
                            String c =  String.format("%02d", k);

                            // Appending Dates to String
                            inputWithDayMonthYear = input + c + b + a;
                            inputWithDayMonth = input + c + b;
                            inputWithMonthDay = input + b + c;

                            // Print out in different forms
                            System.out.println(inputWithMonthDay);
                            System.out.println(inputWithDayMonth);
                            System.out.println(inputWithDayMonthYear);

                        }
                    }
                }

            }

        }

    }

    // Java program to calculate MD5 hash value
    public static String getMd5(String input) {
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

        int hashCount = 0;

        String usernames[] = new String[20];
        usernames[0] = "alice";
        usernames[1] = "bob";
        usernames[2] = "chuck";
        usernames[3] = "dan";
        usernames[4] = "ed";
        usernames[5] = "frank";
        usernames[6] = "george";
        usernames[7] = "harry";
        usernames[8] = "isaac";
        usernames[9] = "jack";
        usernames[10] = "ken";
        usernames[11] = "laura";
        usernames[12] = "mary";
        usernames[13] = "nancy";
        usernames[14] = "oprah";
        usernames[15] = "pam";
        usernames[16] = "quin";
        usernames[17] = "rob";
        usernames[18] = "sam";
        usernames[19] = "tom";

        //EVENTUALLY automate the entry of the passwords
        String hashes[] = new String[20];
        hashes[0] = "8f5140bee08ae5847615c9b55e40e56f";
        hashes[1] = "f32fb20d098584d7cfc39a40a0dce4f2";
        hashes[2] = "cc4d706ba1c3017a156eeea9070dd9a9";
        hashes[3] = "725321a069c71ab4a0d73b66f3a32544";
        hashes[4] = "798b8202a9ccd2b5271daf804bfcd45d";
        hashes[5] = "00fcb586544c2be44180cd85eaf24921";
        hashes[6] = "6234e99a2940fa0eaa7d1f82537dfbb4";
        hashes[7] = "2f5f7d26aee6df8c0d7d5fe5ea09e98c";
        hashes[8] = "b95ddb19c0ea2ca56778720a138aa0ce";
        hashes[9] = "97c6be63844d947564b8687a019cc0f3";
        hashes[10] = "4002e83daccc6a776c125d80b35e621c";
        hashes[11] = "94b3f5c480dbba6c169bbc149269da14";
        hashes[12] = "c33dff9a774add5dcad530b3a85facc9";
        hashes[13] = "5e084369ef95582a8b8690f1dc3ab8f4";
        hashes[14] = "11c65b1362122712dfd665a483e394d0";
        //these all have salt
        hashes[15] = "3dff33dcb40d5cf35be5d11f033fc895";
        hashes[16] = "12c45f723d4a80dd89645b0fd05b6c5a";
        hashes[17] = "e6fac5ee63591a415aa71616c86e9cae";
        hashes[18] = "17cec957462e3ba4d167943ebd50bc93";
        hashes[19] = "850a7a3142acce590dc7a8ee02765358";

        //eventually automate the entry of salts
        //found erty
        String salt1 = "erty";
        //found zxcv
        String salt2 = "zxcv";
        //found hjkl
        String salt3 = "hjkl";
        //found uiop
        String salt4 = "uiop";
        //found asdf
        String salt5 = "asdf";

        Dictionary_Generator distinctFileWords = new Dictionary_Generator();
        //List<String> wordList = distinctFileWords.getUniqueBibleWords("/Users/yiradz/College/JUN_SEM1/SECURITY/PA4/src/password_crackers/PA4_Word_List.txt");
        //BufferedWriter uniqueBibleWordList = new BufferedWriter(new FileWriter("/Users/yiradz/College/JUN_SEM1/SECURITY/PA4/src/password_crackers/uniqueBibleWordList.txt"));

        List<String> wordList = distinctFileWords.getUniqueBibleWords("/Users/yiradz/College/JUN_SEM1/SECURITY/PA4/HashingAndComparing 4/src/password_crackers/PA4_Word_List.txt");
        BufferedWriter uniqueBibleWordList = new BufferedWriter(new FileWriter("/Users/yiradz/College/JUN_SEM1/SECURITY/PA4/HashingAndComparing 4/src/password_crackers/uniqueBibleWordList.txt"));

        for (String str : wordList) {
            uniqueBibleWordList.write(str);
            uniqueBibleWordList.write("\n");
        }
        uniqueBibleWordList.close();

        Scanner scanner = new Scanner(new File("/Users/yiradz/College/JUN_SEM1/SECURITY/PA4/HashingAndComparing 4/src/password_crackers/BibleWords.txt"));


        String[] appendedWords = new String[13000];
        String[] hashedAppended = new String[13000];
        String[] leetWords = new String[13000];
        String[] hashedLeet = new String[13000];
        String[] plainWords = new String[13000];
        String[] hashedPlain = new String[13000];
        String[] salt1Words = new String[13000];
        String[] hashed1Salts = new String[13000];
        String[] salt2Words = new String[13000];
        String[] hashed2Salts = new String[13000];
        String[] salt3Words = new String[13000];
        String[] hashed3Salts = new String[13000];
        String[] salt4Words = new String[13000];
        String[] hashed4Salts = new String[13000];
        String[] salt5Words = new String[13000];
        String[] hashed5Salts = new String[13000];
        String[] s1a = new String[13000];
        String[] hasheds1a = new String[13000];
        String[] s2a = new String[13000];
        String[] hasheds2a = new String[13000];
        String[] s3a = new String[13000];
        String[] hasheds3a = new String[13000];
        String[] s4a = new String[13000];
        String[] hasheds4a = new String[13000];
        String[] s5a = new String[13000];
        String[] hasheds5a = new String[13000];
        String[] sWith$ = new String[13000];
        String[] hasheds$ = new String[13000];
        String[] sWith5 = new String[13000];
        String[] hasheds5 = new String[13000];
        //capatilizing first letter
        String [] firstUpper = new String [13000];
        String [] hashedFU = new String [13000];
        String [] fuara = new String [13000];
        String [] hashedfuara = new String [13000];
        String [] fuaabc = new String [13000];
        String [] hashedfuaabc = new String [13000];
        //capatilizing last letter
        String [] lastUpper = new String[13000];
        String [] hashedLU = new String [13000];
        //salt stuff
        String[] salt1CapWords = new String[13000];
        String[] hashed1CapSalts = new String[13000];
        String[] salt2CapWords = new String[13000];
        String[] hashed2CapSalts = new String[13000];
        String[] salt3CapWords = new String[13000];
        String[] hashed3CapSalts = new String[13000];
        String[] salt4CapWords = new String[13000];
        String[] hashed4CapSalts = new String[13000];
        String[] salt5CapWords = new String[13000];
        String[] hashed5CapSalts = new String[13000];
        String [] salt3ReplaceA = new String [13000];
        String [] hashedS3RA = new String [13000];
        String [] salt4ReplaceA = new String [13000];
        String [] hashedS4RA = new String [13000];
        String [] salt4ReplaceE = new String [13000];
        String [] hashedS4RE = new String [13000];
        String [] salt4AppendEx = new String [13000];
        String [] hashedS4AEx = new String [13000];
        String [] salt4CapAndAppendQ = new String [13000];
        String [] hashedS4CAAQ = new String [13000];
        String [] appendNums = new String [13000];
        String [] hashedANum = new String [13000];
        String [] capANum = new String [13000];
        String [] hashedCapANum = new String [13000];
        String [] justNum = new String [13000];
        String [] hashedJustNum = new String [13000];
        String [] salt4AndNums = new String [13000];
        String [] hashedS4AN = new String [13000];
        String [] yAppend = new String [13000];
        String [] hashedYAppend = new String [13000];
        String [] yUAppend = new String [13000];
        String [] hashedYUAppend = new String[13000];
        String [] replaceLett = new String [13000];
        String [] hashedReplacedLett = new String [13000];

        int place = 0;
        String[] sp34kT0L33t = {"e", "o", "a", "s", "l", "g", "b", "t", "i"};
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            //plain words hashed
            plainWords[place] = line;
            hashedPlain[place] = getMd5(line);
            //plain salted
            salt1Words[place] = line + salt1;
            hashed1Salts[place] = getMd5(salt1Words[place]);
            salt2Words[place] = line + salt2;
            hashed2Salts[place] = getMd5(salt2Words[place]);
            salt3Words[place] = line + salt3;
            hashed3Salts[place] = getMd5(salt3Words[place]);
            salt4Words[place] = line + salt4;
            hashed4Salts[place] = getMd5(salt4Words[place]);
            salt5Words[place] = line + salt5;
            hashed5Salts[place] = getMd5(salt5Words[place]);
            //first to uppercase
            firstUpper[place]=plainWords[place].substring(0, 1).toUpperCase() + plainWords[place].substring(1);
            hashedFU[place]=getMd5(firstUpper[place]);
            //last to uppercase
            lastUpper[place]=plainWords[place].substring((plainWords[place].length() - 1), plainWords[place].length()).toUpperCase();
            hashedLU[place]=getMd5(lastUpper[place]);
            //first to uppercase and replace a with @ - not useful
            fuara[place]=(plainWords[place].substring(0, 1).toUpperCase() + plainWords[place].substring(1)).replace('a', '@');
            hashedfuara[place]=getMd5(fuara[place]);
            //salt4CapAndAppendQ
            salt4CapAndAppendQ[place]=plainWords[place].substring(0, 1).toUpperCase() + plainWords[place].substring(1)+"?";
            hashedS4CAAQ[place]=getMd5(salt4CapAndAppendQ[place]);
            //salted plus first uppercase
            salt1CapWords[place]=salt1Words[place].substring(0, 1).toUpperCase() + salt1Words[place].substring(1);
            hashed1CapSalts[place]=getMd5(salt1CapWords[place]);
            salt2CapWords[place]=salt2Words[place].substring(0, 1).toUpperCase() + salt2Words[place].substring(1);
            hashed2CapSalts[place]=getMd5(salt2CapWords[place]);
            salt3CapWords[place]=salt3Words[place].substring(0, 1).toUpperCase() + salt3Words[place].substring(1);
            hashed3CapSalts[place]=getMd5(salt3CapWords[place]);
            salt4CapWords[place]=salt4Words[place].substring(0, 1).toUpperCase() + salt4Words[place].substring(1);
            hashed4CapSalts[place]=getMd5(salt4CapWords[place]);
            salt5CapWords[place]=salt5Words[place].substring(0, 1).toUpperCase() + salt5Words[place].substring(1);
            hashed5CapSalts[place]=getMd5(salt5CapWords[place]);
            //salt3 and 4 replace a with @ - useful for 3
            salt3ReplaceA[place]=salt3Words[place].replace('a', '@');
            hashedS3RA[place]=getMd5(salt3ReplaceA[place]);
            salt4ReplaceA[place]=salt4Words[place].replace('a', '@');
            hashedS4RA[place]=getMd5(salt4ReplaceA[place]);
            //salt4 replace e with 3 - not useful
            salt4ReplaceE[place]=salt4Words[place].replace('e', '3');
            hashedS4RE[place]=getMd5(salt4ReplaceE[place]);
            //salt4 append ! - not useful
            salt4AppendEx[place]=salt4Words[place]+"!";
            hashedS4AEx[place] = getMd5(salt4AppendEx[place]);
            //leet stuff
            //leetWords[place]=l33tSp34kTranslation(plainWords[place]);
            //hashedLeet[place]=getMd5(leetWords[place]);
            //replace s with $
            //sWith$[place] = plainWords[place].replace('s', '$');
            //hasheds$[place] = getMd5(sWith$[place]);
            //replace s with 5
            sWith5[place] = plainWords[place].replace('s', '5');
            hasheds5[place] = getMd5(sWith5[place]);
            //appending everything and testing it all, to all lowercase
            String[] symbolsToAppend = {"!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "_", "123", "abc"};
            for (int i = 0; i < symbolsToAppend.length; i++) {
                // Append the ith symbol in the array to every line in the file
                yAppend[place]=plainWords[place]+symbolsToAppend[i];
                hashedYAppend[place]=getMd5(yAppend[place]);
                for(int j=0; j<20; j++)
                {
                    if (hashedYAppend[place].equals(hashes[j])) {
                        System.out.println(usernames[j] + ":" + yAppend[place]);
                        break;
                    }
                }
            }
            //appending everything and testing it all, to the first uppercased
            for (int i = 0; i < symbolsToAppend.length; i++) {
                // Append the ith symbol in the array to every line in the file
                yUAppend[place]=plainWords[place].substring(0, 1).toUpperCase() + plainWords[place].substring(1)+symbolsToAppend[i];
                hashedYUAppend[place]=getMd5(yUAppend[place]);
                for(int j=0; j<20; j++)
                {
                    if (hashedYUAppend[place].equals(hashes[j])) {
                        System.out.println(usernames[j] + ":" + yUAppend[place]);
                        break;
                    }
                }
            }
            //System.out.println(leetWords[place]);
            //append stuff
            //append 000-999
            for(int i=0; i<=999; i++)
            {
                String num;
                if(i==0)
                {
                    num="000";
                }
                else if(i<=9&&i>0)
                {
                    num="00"+Integer.toString(i);
                }
                else if(i>9&&i<=99)
                {
                    num="0"+Integer.toString(i);
                }
                else
                {
                    num=Integer.toString(i);
                }
                appendNums[place]=plainWords[place]+num;
                //System.out.println(appendNums[place]);
                hashedANum[place]=getMd5(appendNums[place]);
                for(int j=0; j < 20; j++)
                {
                    if (hashedANum[place].equals(hashes[j])) {
                        System.out.println(usernames[j] + ":" + appendNums[place]);
                        break;
                    }
                }
            }
            //uppercase first and append 000-999
            for(int i=0; i<=999; i++)
            {
                String num;
                if(i==0)
                {
                    num="000";
                }
                else if(i<=9&&i>0)
                {
                    num="00"+Integer.toString(i);
                }
                else if(i>9&&i<=99)
                {
                    num="0"+Integer.toString(i);
                }
                else
                {
                    num=Integer.toString(i);
                }
                capANum[place]=plainWords[place].substring(0, 1).toUpperCase() + plainWords[place].substring(1)+num;
                //System.out.println(appendNums[place]);
                hashedCapANum[place]=getMd5(capANum[place]);
                for(int j=0; j < 20; j++)
                {
                    if (hashedCapANum[place].equals(hashes[j])) {
                        System.out.println(usernames[j] + ":" + hashedCapANum[place]);
                        break;
                    }
                }
            }
            //append 0-999 and uppercase first
            for(int i=0; i<=999; i++)
            {
                String num;
                num=Integer.toString(i);
                capANum[place]=plainWords[place].substring(0, 1).toUpperCase() + plainWords[place].substring(1)+num;
                //System.out.println(appendNums[place]);
                hashedCapANum[place]=getMd5(capANum[place]);
                for(int j=0; j < 20; j++)
                {
                    if (hashedCapANum[place].equals(hashes[j])) {
                        System.out.println(usernames[j] + ":" + capANum[place]);
                        break;
                    }
                }
            }
            //just append nums 0-999
            for(int i=0; i<=999; i++)
            {
                String num;
                num=Integer.toString(i);
                justNum[place]=plainWords[place]+num;
                //System.out.println(appendNums[place]);
                hashedJustNum[place]=getMd5(justNum[place]);
                for(int j=0; j < 20; j++)
                {
                    if (hashedJustNum[place].equals(hashes[j])) {
                        System.out.println(usernames[j] + ":" + justNum[place]);
                        break;
                    }
                }
            }
            //salt4 and append nums
            //tried word salt num then word num salt
            for(int i=0; i<=999; i++)
            {
                String num;
                num=Integer.toString(i);
                salt4AndNums[place]=plainWords[place]+num + salt4;
                //System.out.println(appendNums[place]);
                hashedS4AN[place]=getMd5(salt4AndNums[place]);
                for(int j=0; j < 20; j++)
                {
                    if (hashedS4AN[place].equals(hashes[j])) {
                        System.out.println(usernames[j] + ":" + salt4AndNums[place]);
                        break;
                    }
                }
            }
            //replace everything
            replaceLett[place]=plainWords[place];
            // Replace the letters with common translations.
            if (replaceLett[place].contains("s")) {
                replaceLett[place] = plainWords[place].replace('s', '$');
            }
            else if (replaceLett[place].contains("e")) {
                replaceLett[place] = plainWords[place].replace('e', '3');
            }
            else if (replaceLett[place].contains("o")) {
                replaceLett[place] = plainWords[place].replace('o', '0');
           }
            else if (replaceLett[place].contains("a")) {
                replaceLett[place] = plainWords[place].replace('a', '@');
            }
            else if (replaceLett[place].contains("l")) {
                replaceLett[place] = plainWords[place].replace('l', '1');
            }
            else if (replaceLett[place].contains("g")) {
                replaceLett[place] = plainWords[place].replace('g', '9');
            }
            else if (replaceLett[place].contains("b")) {
                replaceLett[place] = plainWords[place].replace('b', '8');
            }
            else if (replaceLett[place].contains("t")) {
                replaceLett[place] = plainWords[place].replace('t', '7');
            }
            else if (replaceLett[place].contains("i")) {
                replaceLett[place] = plainWords[place].replace('i', '1');
            }
            hashedReplacedLett[place]=getMd5(replaceLett[place]);
            //goes through and tests the hashed passwords against the created hashes
            for (int i = 0; i < 20; i++) {
                if (hashedPlain[place].equals(hashes[i])) {
                    System.out.println(usernames[i] + ":" + plainWords[place]);
                    break;
                }
                if (hashed2Salts[place].equals(hashes[i])) {
                    System.out.println(usernames[i] + ":" + salt2Words[place]);
                    break;
                }
                if (hashed3Salts[place].equals(hashes[i])) {
                    System.out.println(usernames[i] + ":" + salt3Words[place]);
                    break;
                }
                if (hashed4Salts[place].equals(hashes[i])) {
                    System.out.println(usernames[i] + ":" + salt4Words[place]);
                    break;
                }
                if (hashed5Salts[place].equals(hashes[i])) {
                    System.out.println(usernames[i] + ":" + salt5Words[place]);
                    break;
                }
                if (hasheds5[place].equals(hashes[i])) {
                    System.out.println(usernames[i] + ":" + sWith5[place]);
                    break;
                }
                if (hashedFU[place].equals(hashes[i])) {
                    System.out.println(usernames[i] + ":" + firstUpper[place]);
                    break;
                }
                if (hashed1CapSalts[place].equals(hashes[i])) {
                    System.out.println(usernames[i] + ":" + salt1CapWords[place]);
                    break;
                }
                if (hashed2CapSalts[place].equals(hashes[i])) {
                    System.out.println(usernames[i] + ":" + salt2CapWords[place]);
                    break;
                }
                if (hashed3CapSalts[place].equals(hashes[i])) {
                    System.out.println(usernames[i] + ":" + salt3CapWords[place]);
                    break;
                }
                if (hashed4CapSalts[place].equals(hashes[i])) {
                    System.out.println(usernames[i] + ":" + salt4CapWords[place]);
                    break;
                }
                if (hashed5CapSalts[place].equals(hashes[i])) {
                    System.out.println(usernames[i] + ":" + salt5CapWords[place]);
                    break;
                }
                if (hashedS3RA[place].equals(hashes[i])) {
                    System.out.println(usernames[i] + ":" + salt3ReplaceA[place]);
                    break;
                }
                if (hashedS4RA[place].equals(hashes[i])) {
                    System.out.println(usernames[i] + ":" + salt4ReplaceA[place]);
                    break;
                }
                if (hashedS4RE[place].equals(hashes[i])) {
                    System.out.println(usernames[i] + ":" + salt4ReplaceE[place]);
                    break;
                }
                if (hashedS4AEx[place].equals(hashes[i])) {
                    System.out.println(usernames[i] + ":" + salt4AppendEx[place]);
                    break;
                }
                if (hashedfuara[place].equals(hashes[i])) {
                    System.out.println(usernames[i] + ":" + fuara[place]);
                    break;
                }
                if (hashedS4CAAQ[place].equals(hashes[i])) {
                    System.out.println(usernames[i] + ":" + salt4CapAndAppendQ[place]);
                    break;
                }
                if (hashedLU[place].equals(hashes[i])) {
                    System.out.println(usernames[i] + ":" + lastUpper[place]);
                    break;
                }
                if (hashedReplacedLett[place].equals(hashes[i])) {
                    System.out.println(usernames[i] + ":" + replaceLett[place]);
                    break;
                }
               // if (hashedlandf[place].equals(hashes[i])) {
               //    System.out.println(usernames[i] + ":" + landf[place]);
               //     break;
               // }
            }
                place++;

            }
        //System.out.println("Hashes made and compared: " + hashCount);
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