import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class battleships 
{
    public static Scanner scanner;
    public static int totalShips = 5;

    public static int currentShips    = 0;
    public static int comCurrentShips = 0;

    public static String checkBattleships1[][] = new String[10][10];
    public static String checkBattleships2[][] = new String[10][10];

    public static int xNum = 10;
    public static int yNum = 10;

    public static void main(String[] args)
    {
        // scanner = new Scanner(System.in);
        addShips();
        
    }

    // Player adding ships
    public static void addShips()
    {
        if(currentShips >= totalShips) 
        {
            System.out.println("\nComputer is deploying the battleships...\n");
            comAddShips();

        } else 
        {
            System.out.println("\nPlace your battleships....  total of " + currentShips + "/5\n");
            addShipsX();
        }
    }

    public static void addShipsX()
    {
        map();
        System.out.print("\nEnter X coordinate: ");
        String x = System.console().readLine();
        
        try 
        {
            int nextX = Integer.parseInt(x);

            if(nextX > 9 || nextX < 0)
            {
                System.out.println("\nPlease choose the number from 0 to 9\n");
                addShipsX();

            } else 
            {
                addShipsY(nextX);
            }

        } catch (Exception e) 
        {
            System.out.println("\nPlease type number only.\n");
            addShipsX();
        }
    }

    public static void addShipsY(int x)
    {
        System.out.print("Enter Y coordinate: ");
        String y = System.console().readLine();
        
        try 
        {
            int nextY = Integer.parseInt(y);

            if(nextY > 9 || nextY < 0)
            {
                System.out.println("\nPlease choose the number from 0 to 9\n");
                addShipsY(x);

            } else if(checkBattleships1[nextY][x] == "true")
            {
                System.out.println("\nThe position of coordinate for the battleship have been choosed.\n");
                addShipsY(x);

            } 
            else 
            {
                checkBattleships1[nextY][x] = "true";
                currentShips++;
                addShips();
            }

        } catch (Exception e) 
        {
            System.out.println("\nPlease type number only.\n");
            addShipsY(x);
        }
    }

    // Computer adding ships
    public static void comAddShips()
    {
        if(comCurrentShips >= totalShips)
        {
            System.out.println("\nComputer have deployed all the battleships.\n");
            map();
            nextTurn();
            
        } else 
        {
            int comX = (int)Math.floor(Math.random() * 10);
            int comY = (int)Math.floor(Math.random() * 10);

            if(checkBattleships1[comY][comX] == "true" || checkBattleships2[comY][comX] == "true") 
            {
                comAddShips();

            } else 
            {
                checkBattleships2[comY][comX] = "true";
                comCurrentShips++;
                comAddShips();

            }
        }

    }
    
    // Player turn
    public static void nextTurn()
    {
        System.out.println("\nYour turn\n");
        nextMoveX();
    }

    // Show the board map inside the console
    public static void map()
    {
        System.out.println("    0 1 2 3 4 5 6 7 8 9    ");

        for(int n = 0; n < yNum; n++)
        {
            System.out.print(n + "|  ");
            
            for(int m = 0; m < xNum; m++)
            {
                if(checkBattleships1[n][m] == "true")
                {
                    System.out.print("@ ");

                } else if(checkBattleships2[n][m] == "true" && checkBattleships1[n][m] == null)
                {
                    System.out.print("# ");

                }  else if(checkBattleships1[n][m] == "own ship sunked")
                {
                    System.out.print("x ");

                } else if(checkBattleships1[n][m] == "misses")
                {
                    System.out.print("- ");

                } else if(checkBattleships1[n][m] == "ship sunked")
                {
                    System.out.print("! ");

                } else if(checkBattleships1[n][m] == "got sunked")
                {
                    System.out.print("! ");

                } else
                {
                    System.out.print("  ");
                }
            }

            System.out.print("|" + n + "\n");
        }

        System.out.println("    0 1 2 3 4 5 6 7 8 9    ");

    }

    // Player turn to choose the coordinate
    public static void nextMoveX()
    {
        System.out.println("Your turn");
        System.out.println("Enter X coordinate: ");
        String x = System.console().readLine();
        
        try 
        {
            int nextX = Integer.parseInt(x);

            if(nextX > 9 || nextX < 0)
            {
                System.out.println("\nPlease choose the number from 0 to 9\n");
                nextMoveX();

            } else 
            {
                nextMoveY(nextX);
            }

        } catch (Exception e) 
        {
            System.out.println("\nPlease type number only.\n");
            nextMoveX();
        }
    }

    public static void nextMoveY(int nextX)
    {
        System.out.print("Enter Y coordinate: ");
        String y = System.console().readLine();
        
        try 
        {
            int nextY = Integer.parseInt(y);

            if(nextY > 9 || nextY < 0)
            {
                System.out.println("\nPlease choose the number from 0 to 9\n");
                nextMoveX();

            } else 
            {
                match("player", nextX, nextY);
            }

        } catch (Exception e) 
        {
            System.out.println("\nPlease type number only.\n");
            nextMoveX();
        }
    }

    // battleship algorithm system
    public static void match(String player, int x, int y)
    {
        map();

        if(currentShips == 0)
        {
            System.out.println("\nLOL you lost.\n");

        } else if(comCurrentShips == 0)
        {
            System.out.println("\nohh you won.\n");

        } else 
        {
            if(player == "player")
            {
                if(checkBattleships1[y][x] == "true" && checkBattleships2[y][x] == null)
                {
                    checkBattleships1[y][x] = "own ship sunked";
                    System.out.println("\nLOL you sunk your own ship.\n");

                    currentShips--;
                    match("computer", 0, 0);

                } else if(checkBattleships1[y][x] == null && checkBattleships2[y][x] != "true")
                {
                    checkBattleships1[y][x] = "misses";
                    System.out.println("\nLOL you missed.\n");
                    match("computer", 0, 0);

                } else if(checkBattleships1[y][x] == null && checkBattleships2[y][x] == "true")
                {
                    checkBattleships1[y][x] = "ship sunked";
                    checkBattleships2[y][x] = "got sunked";
                    System.out.println("\nWOW you sunk the ship.\n");

                    comCurrentShips--;
                    match("computer", 0, 0);

               } else
               {
                   System.out.println("\nLOL, why shoot the coordinate that already marked.\n");
                   match("computer", 0, 0);
               }

            } else if(player == "computer")
            {
                System.out.println("\nComputer turn to attack.\n");
                computerTurn();
            }
        }

    }

    // Computer turn to attack the player
    public static void computerTurn()
    {
        int comX = (int)Math.floor(Math.random() * 10);
        int comY = (int)Math.floor(Math.random() * 10);

        if(checkBattleships2[comY][comX] == "true" && checkBattleships1[comY][comX] == null)
        {
            checkBattleships2[comY][comX] = "com ship sunked";
            checkBattleships1[comY][comX] = "ship sunked";
            System.out.println("\nComputer have sunk its own ship.\n");

            comCurrentShips--;
            nextMoveX();

        } else if(checkBattleships1[comY][comX] == null && checkBattleships2[comY][comX] == null)
        {
            checkBattleships2[comY][comX] = "com misses";
            System.out.println("\nComputer has missed.\n");
            nextMoveX();

        } else if(checkBattleships2[comY][comX] == null && checkBattleships1[comY][comX] == "true")
        {
            checkBattleships2[comY][comX] = "com sunked ship";
            checkBattleships1[comY][comX] = "got sunked";
            System.out.println("\nLOL computer sunk your ship.\n");

            currentShips--;
            nextMoveX();

        } else
        {
            computerTurn();
        }
    }
}