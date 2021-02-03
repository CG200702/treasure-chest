/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treasure.hunt;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author tim
 */
public class TreasureHunt {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random random = new Random();
        Scanner input = new Scanner(System.in);

        String[][] board = new String[10][8];
        //set up board
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = "[  ]";

            }
        }
        //in random positions in the array store a random amount of coins
        int AmountOfTreasure = random.nextInt((20 - 10) + 1) + 10;//generates random number
        System.out.println(AmountOfTreasure);

        for (int i = 0; i < AmountOfTreasure; i++) {
            //get random location on board
            int randX = random.nextInt(10);
            int randY = random.nextInt(8);
            //get random amount of treasure and put it in a location
            board[randX][randY] = "[" + Integer.toString(random.nextInt((99 - 10) + 1) + 10) + "]";
        }

        int randX = random.nextInt(10);
        int randY = random.nextInt(8);
        board[randX][randY] = "[" + "M" + "]";

        int rand1X = random.nextInt(11);
        int rand1Y = random.nextInt(9);
        board[rand1X][rand1Y] = "[" + "B" + "]";

        //print out board
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println("");

        }

        System.out.println("You each get 5 plays");
        System.out.println("");
        int treasuretotal1 = 0;
        int treasuretotal2 = 0;
        for (int i = 0; i <= 5; i++) {

            //get the user to type in coordinates
            System.out.println("Player 1:");
            System.out.println("Please type in y coordinate");
            int xCoord = input.nextInt();
            System.out.println("Please type in the x coordinate");
            int yCoord = input.nextInt();

            if (xCoord < 10 && xCoord >= 0 && yCoord < 8 && yCoord >= 0) { // if it is a valid coordinate on the board

                if (!board[xCoord][yCoord].equals("[  ]")) { // if string is not empty
                    if (!board[xCoord][yCoord].equals("[M]")) {
                        if (!board[xCoord][yCoord].equals("[B]")) {

                            String treasureNumber = board[xCoord][yCoord].charAt(1) + "" + board[xCoord][yCoord].charAt(2);
                            treasuretotal1 = treasuretotal1 + Integer.parseInt(treasureNumber);
                        } else {
                            System.out.println("You found a bonus! All your points have been doubled!");
                            treasuretotal1 = treasuretotal1 * 2;
                        }
                    } else {
                        System.out.println("You found a monster! You lose all your points!");
                        treasuretotal1 = 0;
                    }

//        if(xCoord<10 && xCoord>0 && yCoord<0 && yCoord>=0){
//           if(!board[xCoord][yCoord].equals("[  ]")){ 
//            System.out.println(board[xCoord][yCoord].substring(1, 3));
//            treasuretotal=treasuretotal+Integer.parseInt(board[xCoord][yCoord].substring(1,3));
                }
                if (board[xCoord][yCoord].equals("[  ]")) {
                    if (!board[xCoord][yCoord + 1].equals("[  ]")) {
                        System.out.println("Your coordinates were warm");
                    } else {
                        System.out.println("Your coordinates were cold");
                    }
                    if (!board[xCoord][yCoord - 1].equals("[  ]")) {
                        System.out.println("Your coordinates were warm");

                    } else {
                        System.out.println("Your coordinates were cold");

                    }

                }

                System.out.println("Player 1's treasure total is: " + treasuretotal1);
                System.out.println("");
            }
            System.out.println("Player 2");
            System.out.println("Please type in y coordinate");
            int xCoord2 = input.nextInt();
            System.out.println("Please type in the x coordinate");
            int yCoord2 = input.nextInt();

            if (xCoord2 < 10 && xCoord2 >= 0 && yCoord2 < 8 && yCoord2 >= 0) { // if it is a valid coordinate on the board

                if (!board[xCoord2][yCoord2].equals("[  ]")) { // if string is not empty
                    if (!board[xCoord2][yCoord2].equals("[M]")) {
                        if (!board[xCoord][yCoord].equals("[B]")) {

                            String treasureNumber = board[xCoord2][yCoord2].charAt(1) + "" + board[xCoord2][yCoord2].charAt(2);
                            treasuretotal2 = treasuretotal2 + Integer.parseInt(treasureNumber);
                        } else {
                            System.out.println("You found a bonus! All your points have been doubled!");
                            treasuretotal2 = treasuretotal2 * 2;
                        }
                    } else {
                        System.out.println("You found a monster! You lose all your points!");
                        treasuretotal2 = 0;
                    }

                }
                if (board[xCoord2][yCoord2].equals("[  ]")) {
                    if (!board[xCoord2][yCoord2 + 1].equals("[  ]")) {
                        System.out.println("Your coordinates were warm");
                    }
                    if (!board[xCoord2][yCoord2 - 1].equals("[  ]")) {
                        System.out.println("Your coordinates were warm");
                    }
                    if (board[xCoord2][yCoord2 - 1].equals("[  ]")) {
                        System.out.println("Your coordinates were cold");
                    }
                    if (board[xCoord2][yCoord2 + 1].equals("[  ]")) {
                        System.out.println("Your coordinates were cold");
                    }
                }
                System.out.println("Player 2's treasure total is: " + treasuretotal2);
            }
            System.out.println("");

        }
    }
}
