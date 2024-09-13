package edu.grinnell.csc207.util;

/**
 * Class cipherutils provides all the methods needed for a cipher.
 */
public class CipherUtils {
  public static final int ALPH_SIZE = 26;
  private static int letter2int(char letter) {
    int result = (int) letter - (int) 'a';
    return result;
  } // letter2int takes a char as an input and returns the letter value (with a being 0)

  private static char int2letter(int i) {
    char result = (char) (i + (int) 'a');
    return result;
  } // int2letter takes an int as an input and returns the corresponding letter

  /**
   * isntLowercase returns true if a string is not lowercase.
   * @param str
   */
  public static boolean isntLowercase(String str){
    for (int i = 0; i < str.length(); i++){
      if (str.charAt(i) < (int) 'a' || str.charAt(i) > (int) 'z'){
        return true;
      } //Checks if the value at i is less than or greater than a-z
    } //Loops to check the entire string
    return false;
  } //bool isntLowercase

  /**
   * caesarEncrypt encrypts a message using a char and a caesar cipher.
   * @param str
   * @param letter
   */
  public static String caesarEncrypt(String str, char letter) {
    String cEncStr = "";
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      cEncStr += int2letter((letter2int(c) + letter2int(letter)) % ALPH_SIZE);      
    } //iterates through and copies an encrypted character to a new string
    return cEncStr;
  } //caesarEncrypt

  public static String caesarDecrypt(String str, char letter) {
    String cDecStr = "";
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      cDecStr += int2letter((letter2int(c) - letter2int(letter) + ALPH_SIZE) % ALPH_SIZE);      
    } //iterates through and copies the decrypted character to a new string
    return cDecStr;
  } //caesarDecrypt

  /**
   * vigenereEncrypt encrypts a string using a vigenere cypher and a key.
   * @param str
   * @param key
   */
  public static String vigenereEncrypt(String str, String key) {
    String vEncStr = "";
    for (int i = 0, j = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      char keyc = key.charAt(j);
      vEncStr += int2letter((letter2int(c) + letter2int(keyc)) % ALPH_SIZE);
      j++;
      j = j % key.length();      
    } //Copies the encrypted values of each char into a new stirng
    return vEncStr;
  } //vigenereEncrypt

  /**
   * vigenereDecrypt decrypts a string using a vigenere cypher and a key.
   * @param str
   * @param key
   */
  public static String vigenereDecrypt(String str, String key) {
    String vDecStr = "";
    for (int i = 0, j = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      char keyc = key.charAt(j);
      vDecStr += int2letter((letter2int(c) - letter2int(keyc) + ALPH_SIZE) % ALPH_SIZE);
      j++;
      j = j % key.length();
    } //Copies the decrypted value of each char into a new string
    return vDecStr;
  } //vigenereDecrypt
} //class CipherUtils
