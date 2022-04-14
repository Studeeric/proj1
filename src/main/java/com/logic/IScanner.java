package com.logic;

public interface IScanner {
  /**Implementation of {@code nextInt()} in our scanner classes.
   * <p>Depending on the object implementing this method, it can either:
   * <p>A) Act like a user input scanner, read the line as a string & if the string contains digits, parse those and return an int value
   * <p>   It will keep requesting input until a string containing only numbers is put in, otherwise it wil print a reminder to do so.   
   * <p>B) Fake the user input and output a stored int
   * <p>   Stored ints can be changed by using the method {@code setInt()} on a valid object.
   */
  int nextInt();
  /**Implementation of {@code nextLine()} in our scanner classes.
   * <p>Depending on the object implementing this method, it can either
   * <p>A) Act like a normal scanner and Read the current line until \n is encounterd then skip to the next line.
   * <p>B) Fake the user input and output a stored String
   * <p>   Stored Strings can be changed by using the method {@code setString()} on a valid object.
   */
  String nextLine();
}
