import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.NoSuchElementException;
import java.util.Scanner;

// Java program to calculate MD5 hash value 
public class MD5 {
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

    // Driver code 
    public static void main(String args[]) throws NoSuchAlgorithmException, FileNotFoundException {

        //EVENTUALLY automate the process of setting the username
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
        String pSalt="erty";
        String qSalt="zxcv";
        String rSalt="hjkl";
        String sSalt="uiop";
        String tSalt="asdf";

        File file = new File("C:\\Users\\mrose\\Desktop\\Cedarville 19-20\\Cyber\\PA4\\BibleWords.txt");
        Scanner scanner = new Scanner(file);

        String myHashedWords [] = new String[12700];
        String myWords [] = new String[12700];
        String exclamationPoint [] = new String[12700];
        String xMyWords [] = new String [12700];
        String aMyWords [] = new String [12700];
        String asterisk [] = new String [12700];
        String oMyWords [] = new String [12700];
        String oWithZero [] = new String [12700];
        String iMyWords [] = new String [12700];
        String iWithOne [] = new String [12700];
        String eMyWords [] = new String [12700];
        String eWithThree [] = new String [12700];
        String atMyWords [] = new String [12700];
        String aWithAt [] = new String [12700];
        String sMyWords [] = new String [12700];
        String dollarSign [] = new String [12700];
        //int place = 0;

        //reads in all words and stores hashes in a new file
        int i = 0;

        while(scanner.hasNextLine()||scanner.hasNextInt())
        {
            //go through and compare aPw to each hashed pw from the list of Bible words
            myWords[i] = scanner.next();
            //System.out.println(myWords[i]);
            myHashedWords[i]=getMd5(myWords[i]);
            xMyWords[i] = myWords[i]+"!";
            exclamationPoint[i]=getMd5(xMyWords[i]);
            aMyWords[i] = myWords[i]+"*";
            asterisk[i] = getMd5(aMyWords[i]);
            oMyWords[i] = myWords[i].replace('o', '0');
            oWithZero[i]= getMd5(oMyWords[i]);
            iMyWords[i]=myWords[i].replace('i', '1');
            iWithOne[i]= getMd5(iMyWords[i]);
            eMyWords[i]=myWords[i].replace('e', '3');
            eWithThree[i]=getMd5(eMyWords[i]);
            atMyWords[i]=myWords[i].replace('a', '@');
            aWithAt[i]=getMd5(atMyWords[i]);
            sMyWords[i]=myWords[i].replace('s', '$');
            dollarSign[i] = getMd5(sMyWords[i]);
            //System.out.println(myHashedWords[i]);
            for(int place=0; place < 20; place++)
            {
                if(myHashedWords[i].equals(hashes[place]))
                {
                    System.out.println(usernames[place]+":"+myWords[i]);
                    System.out.println("STRAIGHT");
                    break;
                }
                if(exclamationPoint[i].equals(hashes[place]))
                {
                    System.out.println(usernames[place]+":"+xMyWords[i]);
                    System.out.println("!!!!");
                    break;
                }
                if(asterisk[i].equals(hashes[place]))
                {
                    System.out.println(usernames[place]+":"+aMyWords[i]);
                    System.out.println("***");
                    break;
                }
                if(oWithZero[i].equals(hashes[place]))
                {
                    System.out.println(usernames[place]+":"+oMyWords[i]);
                    System.out.println("o with 0");
                    break;
                }
                if(iWithOne[i].equals(hashes[place]))
                {
                    System.out.println(usernames[place]+":"+iMyWords[i]);
                    System.out.println("I in place of 1");
                    break;
                }
                if(eWithThree[i].equals(hashes[place]))
                {
                    System.out.println(usernames[place]+":"+eMyWords[i]);
                    System.out.println("3 in the place of e");
                    break;
                }
                if(aWithAt[i].equals(hashes[place]))
                {
                    System.out.println(usernames[place]+":"+atMyWords[i]);
                    System.out.println("@ in the place of a");
                    break;
                }
                if(dollarSign[i].equals(hashes[place]))
                {
                    System.out.println(usernames[place]+":"+sMyWords[i]);
                    System.out.println("$ in the place of s");
                    break;
                }
            }
            i++;
        }



    }
} 