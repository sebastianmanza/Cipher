package edu.grinnell.csc207.main;

import java.io.PrintWriter;
import edu.grinnell.csc207.util.CipherUtils;

/**
 * class Cipher checks your input and outputs a correctly
 * ciphered or deciphered string with either a caesar or
 * vigenere cipher.
 */
public class Cipher {
  public static final int NUM_ARGS = 4;
  /**
   * main method runs the program
   * @param args
   */
  public static void main(String[] args) { 
    PrintWriter pen = new PrintWriter(System.out, true);
    if (args.length != NUM_ARGS) {
      System.err.println("Error: Incorrect number of parameters");
      return;
    } //Checks that appropriate number of parameters have been entered
    String caseNumber = "";
    for (int i = 0; i < args.length; i++) {
      if (args[i].equals("-encode")) {
        caseNumber += 'e';
      } else if (args[i].equals("-decode")) {
        caseNumber += 'd';
      } else if (args[i].equals("-caesar")) {
        caseNumber += 'c';
      } else if (args[i].equals("-vigenere")) {
        caseNumber += 'v';
      } //If statements checking if a valid command is entered
    } //A loop checking the entries and storing them
    int val = 0;
    if (caseNumber.equals("ce") || caseNumber.equals("ec")) {
      val = 1;
    } else if (caseNumber.equals("cd") || caseNumber.equals("dc")) {
      val = 2;
    } else if (caseNumber.equals("ve") || caseNumber.equals("ev")) {
      val = 3;
    } else if (caseNumber.equals("vd") || caseNumber.equals("dv")) {
      val = 4;
    } //Sorting the four possible cases and assigning values

    String str = new String(""); //Initializing an empty string to hold the unencrypted message
    String key = new String(""); //Initializing an empty string to store the key
    boolean stringnotFound = true; //A boolean to determine if the string has been found

    for (int i = 0; i < args.length; i++) {
      if (stringnotFound) {
        if (args[i].charAt(0) != '-') {
          str = args[i];
          stringnotFound = false;
        } //assigning the string value to the first non command and flipping the boolean
      } else {
        if (args[i].charAt(0) != '-') {
          key = args[i];
          break;
        } //assigning a key to the second non command value
      } //Checking if the string has already been found
    } //Looking through the array for strings

    String result = new String("");//initializing a string to store an encrypted message

    switch (val) {
      case 0:
        System.err.println("Error: Invalid parameters");//If parameters weren't entered correctly
        return;
      case 1:
        if (key.length() != 1) {
          System.err.println("Error: A caesar cipher needs a single character key.");
          return;
        } //Checking the key for a single character
        result = CipherUtils.caesarEncrypt(str, key.charAt(0));//encrypting with caesarcipher
        break;
      case 2:
        if (key.length() != 1) {
          System.err.println("Error: A caesar cipher needs a single character key.");
          return;
        } //Checking the key for a single character
        result = CipherUtils.caesarDecrypt(str, key.charAt(0));
        break;
      case 3:
        result = CipherUtils.vigenereEncrypt(str, key);
        break;
      case 4:
        result = CipherUtils.vigenereDecrypt(str, key);
        break;
      default:
        return;
    } //A switch statement deciding the proper combination to use and calling it    
    pen.println(result);
  } //end of main method
} //class Cipher
