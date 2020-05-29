// 
// Decompiled by Procyon v0.5.36
// 

package rps;

import java.util.List;
import java.util.Collections;
import java.awt.Component;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Game
{
    static String[] options;
    static String[] choices;
    static String[] restart;
    static String rock;
    static String paper;
    static String scissors;
    static int cnt;
    static boolean continueGame;
    static ArrayList<Integer> highScore;
    static ArrayList<Integer> highScoreP2;
    static int loss;
    static int win;
    static int totalWins;
    static int totalWinsP2;
    static boolean keepPlaying;
    
    static {
        Game.options = new String[] { "Player vs Player", "Player vs Computer", "Exit" };
        Game.choices = new String[] { "Rock", "Paper", "Scissors", "HighScore", "Exit" };
        Game.restart = new String[] { "Yes", "No" };
        Game.cnt = 0;
        Game.continueGame = true;
        Game.highScore = new ArrayList<Integer>();
        Game.highScoreP2 = new ArrayList<Integer>();
        Game.keepPlaying = true;
    }
    
    public static void main(final String[] args) {
        Game.loss = 0;
        Game.win = 0;
        Game.totalWins = 0;
        final int x = Window.option(Game.options, "Welcome to Rock Paper Scissors! \n What mode do you want to play?");
        if (x == 0) {
            JOptionPane.showMessageDialog(null, "You've chosen to play player vs player, /n make sure your friend is nearby so you can start!");
            while (Game.continueGame) {
                while (Game.keepPlaying) {
                    final int a = Window.option(Game.choices, "Player one's choice\nCurrent Scores: P1: " + Game.win + " P2: " + Game.loss + "\nPlayer One's score: " + Game.totalWins + " Player Two's score: " + Game.totalWinsP2);
                    if (a == 0) {
                        Game.rock = "Rock";
                        final int p2 = Window.option(Game.choices, "Player two's choice\nCurrent Score: Player One's score: " + Game.win + " Player Two's score: " + Game.loss + "\n" + "Player One's score: " + Game.totalWins + " Player Two's score: " + Game.totalWinsP2);
                        if (p2 == 0) {
                            JOptionPane.showMessageDialog(null, "You chose the same thing, so nothing happens!");
                        }
                        else if (p2 == 1) {
                            ++Game.loss;
                            if (Game.loss != 3) {
                                continue;
                            }
                            updateList(Game.totalWins);
                            Game.totalWins = 0;
                            ++Game.totalWinsP2;
                            Game.win = 0;
                            Game.loss = 0;
                        }
                        else if (p2 == 2) {
                            ++Game.win;
                            if (Game.win != 3) {
                                continue;
                            }
                            updateListP2(Game.totalWinsP2);
                            Game.totalWinsP2 = 0;
                            ++Game.totalWins;
                            Game.win = 0;
                            Game.loss = 0;
                        }
                        else {
                            if (p2 != 3) {
                                Game.cnt = 1;
                                break;
                            }
                            JOptionPane.showMessageDialog(null, "HighScores:\n" + Game.highScoreP2);
                        }
                    }
                    else if (a == 1) {
                        Game.paper = "Paper";
                        final int p2 = Window.option(Game.choices, "Player two's choice\nCurrent Score: Player One's score: " + Game.win + " Player Two's score: " + Game.loss + "\n" + "Player One's score: " + Game.totalWins + " Player Two's score: " + Game.totalWinsP2);
                        if (p2 == 1) {
                            JOptionPane.showMessageDialog(null, "You chose the same thing, so nothing happens!");
                        }
                        else if (p2 == 2) {
                            ++Game.loss;
                            if (Game.loss != 3) {
                                continue;
                            }
                            updateList(Game.totalWins);
                            Game.totalWins = 0;
                            ++Game.totalWinsP2;
                            Game.win = 0;
                            Game.loss = 0;
                        }
                        else if (p2 == 0) {
                            ++Game.win;
                            if (Game.win != 3) {
                                continue;
                            }
                            updateListP2(Game.totalWinsP2);
                            Game.totalWinsP2 = 0;
                            ++Game.totalWins;
                            Game.win = 0;
                            Game.loss = 0;
                        }
                        else {
                            if (p2 != 3) {
                                Game.cnt = 1;
                                break;
                            }
                            JOptionPane.showMessageDialog(null, "HighScores:\n" + Game.highScoreP2);
                        }
                    }
                    else if (a == 2) {
                        Game.scissors = "Scissors";
                        final int p2 = Window.option(Game.choices, "Player two's choice\nCurrent Score: Player One's score: " + Game.win + " Player Two's score: " + Game.loss + "\n" + "Player One's WinStreak: " + Game.totalWins + " Player Two's WinStreak: " + Game.totalWinsP2);
                        if (p2 == 2) {
                            JOptionPane.showMessageDialog(null, "You chose the same thing, so nothing happens!");
                        }
                        else if (p2 == 0) {
                            ++Game.loss;
                            if (Game.loss != 3) {
                                continue;
                            }
                            updateList(Game.totalWins);
                            Game.totalWins = 0;
                            ++Game.totalWinsP2;
                            Game.win = 0;
                            Game.loss = 0;
                        }
                        else if (p2 == 1) {
                            ++Game.win;
                            if (Game.win != 3) {
                                continue;
                            }
                            updateListP2(Game.totalWinsP2);
                            Game.totalWinsP2 = 0;
                            ++Game.totalWins;
                            Game.win = 0;
                            Game.loss = 0;
                        }
                        else {
                            if (p2 != 3) {
                                Game.cnt = 1;
                                break;
                            }
                            JOptionPane.showMessageDialog(null, "HighScores:\n" + Game.highScoreP2);
                        }
                    }
                    else {
                        if (a != 3) {
                            Game.cnt = 1;
                            break;
                        }
                        JOptionPane.showMessageDialog(null, "HighScores:\n" + Game.highScore);
                    }
                }
                if (Game.cnt == 1) {
                    Game.continueGame = false;
                    System.exit(0);
                }
            }
        }
        else if (x == 1) {
            JOptionPane.showMessageDialog(null, "You chose to play against the computer! Get ready to play.");
            while (Game.continueGame) {
                while (Game.keepPlaying) {
                    final int b = Window.option(Game.choices, "Choose what you want to use\nCurrent Scores: P: " + Game.win + " C: " + Game.loss + "\nRounds Won: " + Game.totalWins);
                    final String computer = Game.choices[(int)(Math.random() * 3.0)];
                    if (b == 0) {
                        Game.rock = "Rock";
                        if (Game.rock.equals(computer)) {
                            JOptionPane.showMessageDialog(null, "You chose the same thing, so nothing happens!");
                        }
                        else if (computer.equals("Paper")) {
                            ++Game.win;
                            if (Game.win != 3) {
                                continue;
                            }
                            ++Game.totalWins;
                            Game.loss = 0;
                            Game.win = 0;
                        }
                        else {
                            if (!computer.equals("Scissors")) {
                                continue;
                            }
                            ++Game.loss;
                            if (Game.loss != 3) {
                                continue;
                            }
                            Game.keepPlaying = false;
                            updateList(Game.totalWins);
                            Game.loss = 0;
                            Game.win = 0;
                            Game.totalWins = 0;
                        }
                    }
                    else if (b == 1) {
                        Game.paper = "Paper";
                        if (Game.paper.equals(computer)) {
                            JOptionPane.showMessageDialog(null, "You chose the same thing, so nothing happens!");
                        }
                        else if (computer.equals("Rock")) {
                            ++Game.win;
                            if (Game.win != 3) {
                                continue;
                            }
                            ++Game.totalWins;
                            Game.loss = 0;
                            Game.win = 0;
                        }
                        else {
                            if (!computer.equals("Scissors")) {
                                continue;
                            }
                            ++Game.loss;
                            if (Game.loss != 3) {
                                continue;
                            }
                            Game.keepPlaying = false;
                            updateList(Game.totalWins);
                            Game.loss = 0;
                            Game.win = 0;
                            Game.totalWins = 0;
                        }
                    }
                    else if (b == 2) {
                        Game.scissors = "Scissors";
                        if (Game.scissors.equals(computer)) {
                            JOptionPane.showMessageDialog(null, "You chose the same thing, so nothing happens!");
                        }
                        if (computer.equals("Paper")) {
                            ++Game.win;
                            if (Game.win == 3) {
                                ++Game.totalWins;
                                Game.loss = 0;
                                Game.win = 0;
                            }
                        }
                        if (!computer.equals("Rock")) {
                            continue;
                        }
                        ++Game.loss;
                        if (Game.loss != 3) {
                            continue;
                        }
                        Game.keepPlaying = false;
                        updateList(Game.totalWins);
                        Game.loss = 0;
                        Game.win = 0;
                        Game.totalWins = 0;
                    }
                    else {
                        if (b != 3) {
                            Game.cnt = 1;
                            break;
                        }
                        JOptionPane.showMessageDialog(null, "Scores: " + Game.highScore);
                    }
                }
                if (Game.cnt == 1) {
                    Game.continueGame = false;
                    System.exit(0);
                }
                final int re = Window.option(Game.restart, "Do you want to restart the game?");
                if (re == 0) {
                    Game.keepPlaying = true;
                }
                else {
                    Game.continueGame = false;
                    System.exit(0);
                }
            }
        }
    }
    
    public static void updateList(final int number) {
        if (number > 0) {
            Game.highScore.add(number);
            Collections.sort(Game.highScore);
            Collections.reverse(Game.highScore);
        }
    }
    
    public static void updateListP2(final int number) {
        if (number > 0) {
            Game.highScoreP2.add(number);
            Collections.sort(Game.highScoreP2);
            Collections.reverse(Game.highScoreP2);
        }
    }
}
