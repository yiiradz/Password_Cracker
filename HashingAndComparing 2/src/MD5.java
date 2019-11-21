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
        String salt1="erty";
        String salt2="zxcv";
        String salt3="hjkl";
        String salt4="uiop";
        String salt5="asdf";

        File file = new File("C:\\Users\\mrose\\Desktop\\Cedarville 19-20\\Cyber\\PA4\\BibleWords.txt");
        Scanner scanner = new Scanner(file);

        String myHashedWords [] = new String[12700];
        String myWords [] = new String[12700];
        //put exclamation point at end
        String exclamationPoint [] = new String[12700];
        String xMyWords [] = new String [12700];
        //put asterisk at end
        String aMyWords [] = new String [12700];
        String asterisk [] = new String [12700];
        //replace o with 0
        String oMyWords [] = new String [12700];
        String oWithZero [] = new String [12700];
        //replace i with 1
        String iMyWords [] = new String [12700];
        String iWithOne [] = new String [12700];
        //replace e with 3
        String eMyWords [] = new String [12700];
        String eWithThree [] = new String [12700];
        //replace a with @
        String atMyWords [] = new String [12700];
        String aWithAt [] = new String [12700];
        //replace s with $
        String sMyWords [] = new String [12700];
        String dollarSign [] = new String [12700];
        //add 123 at end
        String ottMyWords [] = new String [12700];
        String oneTT [] = new String [12700];
        //add 1 at end
        String addOneMyWords [] = new String [12700];
        String appendOne [] = new String [12700];
        //replace s with 5
        String fiveMyWords[] = new String [12700];
        String fiveForS [] = new String [12700];
        //replace o with 0, a with @, i with 1, s with $
        String oaisMyWords [] = new String [12700];
        String oaisReplace [] = new String [12700];
        //prepend !
        String pexMyWords [] = new String [12700];
        String prependEx [] = new String [12700];
        //replace l with 1
        String lMyWords [] = new String [12700];
        String lWithOne [] = new String [12700];
        //replace i with L
        String ilMyWords[] = new String [12700];
        String iWithL [] = new String [12700];
        //replace g with 9
        String gMyWords [] = new String [12700];
        String gWithNine [] = new String [12700];
        //replace g with 6
        String ggMyWords [] = new String [12700];
        String gWithSix [] = new String [12700];
        //replace b with 8
        String bMyWords [] = new String [12700];
        String bWith8 [] = new String [12700];
        //append ?
        String qMyWords [] = new String [12700];
        String qAtEnd [] = new String [12700];
        //replace t with 7
        String tMyWords [] = new String [12700];
        String tWithSeven [] = new String [12700];
        //salted
        String salted1 [] = new String [12700];
        String hashedS1 [] = new String [12700];
        String salted2 [] = new String [12700];
        String hashedS2 [] = new String [12700];
        String salted3 [] = new String [12700];
        String hashedS3 [] = new String [12700];
        String salted4 [] = new String [12700];
        String hashedS4 [] = new String [12700];
        String salted5 [] = new String [12700];
        String hashedS5 [] = new String [12700];

        //reads in all words and stores hashes in a new file
        int i = 0;

        while(scanner.hasNextLine()||scanner.hasNextInt())
        {
            //go through and compare aPw to each hashed pw from the list of Bible words
            myWords[i] = scanner.next();
            //salted stuff
            salted1[i] = myWords[i]+salt1;
            hashedS1[i]=getMd5(salted1[i]);
            salted2[i] = myWords[i]+salt2;
            hashedS2[i]=getMd5(salted2[i]);
            salted3[i] = myWords[i]+salt3;
            hashedS3[i]=getMd5(salted3[i]);
            salted4[i] = myWords[i]+salt4;
            hashedS4[i]=getMd5(salted4[i]);
            salted5[i] = myWords[i]+salt5;
            hashedS5[i]=getMd5(salted5[i]);
            //straight hashing
            myHashedWords[i]=getMd5(myWords[i]);
            //add ! at end
            xMyWords[i] = myWords[i]+"!";
            exclamationPoint[i]=getMd5(xMyWords[i]);
            //add * at end
            aMyWords[i] = myWords[i]+"*";
            asterisk[i] = getMd5(aMyWords[i]);
            //replace o with 0
            oMyWords[i] = myWords[i].replace('o', '0');
            oWithZero[i]= getMd5(oMyWords[i]);
            //replace i with 1
            iMyWords[i]=myWords[i].replace('i', '1');
            iWithOne[i]= getMd5(iMyWords[i]);
            //replace e with 3
            eMyWords[i]=myWords[i].replace('e', '3');
            eWithThree[i]=getMd5(eMyWords[i]);
            //replace a with @
            atMyWords[i]=myWords[i].replace('a', '@');
            aWithAt[i]=getMd5(atMyWords[i]);
            //replace s with $
            sMyWords[i]=myWords[i].replace('s', '$');
            dollarSign[i] = getMd5(sMyWords[i]);
            //add 123 at end
            ottMyWords[i]=myWords[i]+"123";
            oneTT[i] = getMd5(ottMyWords[i]);
            //add 1 at end
            addOneMyWords[i]=myWords[i]+"1";
            appendOne[i]=getMd5(addOneMyWords[i]);
            //replace s with 5
            fiveMyWords[i]=myWords[i].replace('s', '5');
            fiveForS[i]=getMd5(fiveMyWords[i]);
            //replace o with 0, a with @, i with 1, s with $
            oaisMyWords[i]=myWords[i].replace('o', '0');
            oaisMyWords[i]=oaisMyWords[i].replace('a', '@');
            oaisMyWords[i]=oaisMyWords[i].replace('i', '1');
            oaisMyWords[i]=oaisMyWords[i].replace('s', '$');
            oaisReplace[i]=getMd5(oaisMyWords[i]);
            //prepend !
            pexMyWords[i]="!"+myWords[i];
            prependEx[i]=getMd5(pexMyWords[i]);
            //replace l with 1
            lMyWords[i]=myWords[i].replace('l', '1');
            lWithOne[i]=getMd5(lMyWords[i]);
            //replace i with L
            ilMyWords[i]=myWords[i].replace('i', 'l');
            iWithL[i]=getMd5(ilMyWords[i]);
            //replace g with 9
            gMyWords[i]=myWords[i].replace('g', '9');
            gWithNine[i]=getMd5(gMyWords[i]);
            //replace g with 6
            ggMyWords[i]=myWords[i].replace('g', '6');
            gWithSix[i]=getMd5(ggMyWords[i]);
            //replace b with 8
            bMyWords[i]=myWords[i].replace('b', '8');
            bWith8[i]=getMd5(bMyWords[i]);
            //append ?
            qMyWords[i] = myWords[i]+"?";
            qAtEnd[i]=getMd5(qMyWords[i]);
            tMyWords[i]=myWords[i].replace('t', '7');
            tWithSeven[i]=getMd5(tMyWords[i]);

            //System.out.println(myHashedWords[i]);
            for(int place=0; place < 20; place++)
            {
                if(myHashedWords[i].equals(hashes[place])) {
                    System.out.println(usernames[place]+":"+myWords[i]);
                    break;
                }
                if(exclamationPoint[i].equals(hashes[place])) {
                    System.out.println(usernames[place]+":"+xMyWords[i]);
                    break;
                }
                if(asterisk[i].equals(hashes[place])) {
                    System.out.println(usernames[place]+":"+aMyWords[i]);
                    break;
                }
                if(oWithZero[i].equals(hashes[place])) {
                    System.out.println(usernames[place]+":"+oMyWords[i]);
                    break;
                }
                if(iWithOne[i].equals(hashes[place])) {
                    System.out.println(usernames[place]+":"+iMyWords[i]);
                    break;
                }
                if(eWithThree[i].equals(hashes[place])) {
                    System.out.println(usernames[place]+":"+eMyWords[i]);
                    break;
                }
                if(aWithAt[i].equals(hashes[place])) {
                    System.out.println(usernames[place]+":"+atMyWords[i]);
                    break;
                }
                if(dollarSign[i].equals(hashes[place])) {
                    System.out.println(usernames[place]+":"+sMyWords[i]);
                    break;
                }
                if(oneTT[i].equals(hashes[place])) {
                    System.out.println(usernames[place]+":"+ottMyWords[i]);
                    break;
                }
                if(appendOne[i].equals(hashes[place])) {
                    System.out.println(usernames[place]+":"+addOneMyWords[i]);
                    break;
                }
                if(fiveForS[i].equals(hashes[place])) {
                    System.out.println(usernames[place]+":"+fiveMyWords[i]);
                    break;
                }
                if(oaisReplace[i].equals(hashes[place])) {
                    System.out.println(usernames[place]+":"+oaisMyWords[i]);
                    break;
                }
                if(prependEx[i].equals(hashes[place])) {
                    System.out.println(usernames[place]+":"+pexMyWords[i]);
                    break;
                }
                if(lWithOne[i].equals(hashes[place])) {
                    System.out.println(usernames[place]+":"+lMyWords[i]);
                    break;
                }
                if(iWithL[i].equals(hashes[place])) {
                    System.out.println(usernames[place]+":"+ilMyWords[i]);
                    break;
                }
                if(gWithNine[i].equals(hashes[place])) {
                    System.out.println(usernames[place]+":"+gMyWords[i]);
                    break;
                }
                if(gWithSix[i].equals(hashes[place])) {
                    System.out.println(usernames[place]+":"+ggMyWords[i]);
                    break;
                }
                if(bWith8[i].equals(hashes[place])) {
                    System.out.println(usernames[place]+":"+bMyWords[i]);
                    break;
                }
                if(qAtEnd[i].equals(hashes[place])) {
                    System.out.println(usernames[place]+":"+qMyWords[i]);
                    break;
                }
                if(tWithSeven[i].equals(hashes[place])) {
                    System.out.println(usernames[place]+":"+tMyWords[i]);
                    break;
                }
                if(hashedS1[i].equals(hashes[place])) {
                    System.out.println(usernames[place]+":"+salted1[i]);
                    break;
                }
                if(hashedS2[i].equals(hashes[place])) {
                    System.out.println(usernames[place]+":"+salted2[i]);
                    break;
                }
                if(hashedS3[i].equals(hashes[place])) {
                    System.out.println(usernames[place]+":"+salted3[i]);
                    break;
                }
                if(hashedS4[i].equals(hashes[place])) {
                    System.out.println(usernames[place]+":"+salted4[i]);
                    break;
                }
                if(hashedS5[i].equals(hashes[place])) {
                    System.out.println(usernames[place]+":"+salted5[i]);
                    break;
                }
            }
            i++;
        }



    }
} 