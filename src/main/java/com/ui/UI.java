package com.ui;

public abstract class UI {
  protected static final String ANSI_RESET = "\u001B[0m";
  protected static final String ANSI_BLACK = "\u001B[30m";
  protected static final String ANSI_RED = "\u001B[31m";
  protected static final String ANSI_GREEN = "\u001B[32m";
  protected static final String ANSI_YELLOW = "\u001B[33m";
  protected static final String ANSI_BLUE = "\u001B[34m";
  protected static final String ANSI_PURPLE = "\u001B[35m";
  protected static final String ANSI_CYAN = "\u001B[36m";
  protected static final String ANSI_WHITE = "\u001B[37m";

  protected UI(){}
  
   /**The method clears the screen. This way the terminal won't be too bloated.*/
  public static void clearScreen() {
    try{
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            Runtime.getRuntime().exec("clear");
    } 
    catch (Exception e) {}
  }
}
