package edu.grinnell.csc207.main;

import java.io.PrintWriter;
import edu.grinnell.csc207.util.CipherUtils;

/**
 * This class runs every possible caesar cipher for a given message.
 * @param args
 * @return The printed list of every possible cipher
 */
public class AllCaesar {
  public static void main(String[] args) { //main method
    PrintWriter pen = new PrintWriter(System.out, true);
    if (args.length != 2) {
      System.err.println("Error: Incorrect number of parameters");
      return;
    } //Checks that proper number of args have been input
    String str = new String(args[1]);
    if (CipherUtils.isntLowercase(str)) {
      System.err.println("Error: String contains characters other than lowercase letters");
      return;
    } //Checks that the string is lowercase
    if (args[0].equals("encode")) {
      for (char ch = 'a'; ch <= 'z'; ch++) {
        pen.printf("n = %c: %s\n", ch, CipherUtils.caesarEncrypt(str, ch));
      } //looping to check the cipher for every char
      pen.close();
    } else if (args[0].equals("decode")) {
      for (char ch = 'a'; ch <= 'z'; ch++) {
        pen.printf("n = %c: %s\n", ch, CipherUtils.caesarDecrypt(str, ch));
      } //Prints all possible encoded messages
      pen.close();
    } else {
      System.err.printf("Error: Invalid option: \"%s\". Valid options are \"encode\" or \"decode.\"\n", args[0]);
    } //Checks if the input is encode, decode, or other
    System.err.flush();
  } //main[args]
} //class allCaesar
