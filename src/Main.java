
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Stuff doSomeAction = new Stuff();
        char[][] board = new char[5][9];
        Scanner sc = new Scanner(System.in);
        String inputGrid = "         ";
        char[] arrayOfImput = inputGrid.toCharArray();
        doSomeAction.fullFillBoard(board, arrayOfImput);
        doSomeAction.printBoard(board);


        while (doSomeAction.gameIsStillOn == true || doSomeAction.draw == false || doSomeAction.impossible == false || doSomeAction.doWeHaveAWinner == false) {
            System.out.println("Enter the coordinates:");
            int[] newMove = doSomeAction.updateTheArrayOfImput();

            doSomeAction.updateTheGrid(newMove, arrayOfImput);
            doSomeAction.fullFillBoard(board, arrayOfImput);
            doSomeAction.checkAllTheStuff(board, arrayOfImput);
        }

    }
}

class Stuff {

    public int[] updateTheArrayOfImput() {

        Scanner sc = new Scanner(System.in);
        int[] integerArrayOfCoordinates = new int[2];

        try {
            String[] input = sc.nextLine().split(" ");

            integerArrayOfCoordinates[0] = Integer.parseInt(input[0]);
            integerArrayOfCoordinates[1] = Integer.parseInt(input[1]);
        } catch (Exception e) {
            System.out.println("You should enter numbers!");
            return updateTheArrayOfImput();

        }


        if (integerArrayOfCoordinates[0] >= 1 && integerArrayOfCoordinates[0] <= 3 && integerArrayOfCoordinates[1] >= 1 && integerArrayOfCoordinates[1] <= 3) {
            return integerArrayOfCoordinates;
        } else {
            System.out.println("Coordinates should be from 1 to 3!");
            return updateTheArrayOfImput();
        }
    }


    public char[] updateTheGrid(int[] cor, char[] arrayOfInput) {
        int cordinates = 0;

        if (cor[0] == 1 && cor[1] == 1) {
            cordinates = 0;
        } else if (cor[0] == 1 && cor[1] == 2) {
            cordinates = 1;
        } else if (cor[0] == 1 && cor[1] == 3) {
            cordinates = 2;
        } else if (cor[0] == 2 && cor[1] == 1) {
            cordinates = 3;
        } else if (cor[0] == 2 && cor[1] == 2) {
            cordinates = 4;
        } else if (cor[0] == 2 && cor[1] == 3) {
            cordinates = 5;
        } else if (cor[0] == 3 && cor[1] == 1) {
            cordinates = 6;
        } else if (cor[0] == 3 && cor[1] == 2) {
            cordinates = 7;
        } else if (cor[0] == 3 && cor[1] == 3) {
            cordinates = 8;
        }

        if (arrayOfInput[cordinates] != 'X' && arrayOfInput[cordinates] != 'O') {
            makeAMove();
            arrayOfInput[cordinates] = nextToMove;
        } else {
            System.out.println("This cell is occupied! Choose another one!");
            arrayOfInput = updateTheGrid(updateTheArrayOfImput(), arrayOfInput);
        }

        return arrayOfInput;
    }


    boolean doWeHaveAWinner = false;
    boolean gameIsStillOn = false;
    boolean impossible = false;
    boolean draw = false;
    char theWinner = 'X';
    char nextToMove = ' ';
    int howManyWinners = 0;


    public void makeAMove() {
        if (nextToMove == ' ') {
            nextToMove = 'X';
        } else if (nextToMove == 'O') {
            nextToMove = 'X';
        } else if (nextToMove == 'X') {
            nextToMove = 'O';
        }

    }

    public void drawCheck(char[] arrayOfMoves) {
        int counter = 0;
        for (Character element : arrayOfMoves) {

            if (element.equals('X') || element.equals('O')) {
                counter++;
            }
        }

        if (counter == 9) {
            draw = true;
        }

    }


    public void countMoves(char[] arrayOfMoves) {

        int[] XsAndOs = {0, 0, 0};// {X,O,_}

        for (Character element : arrayOfMoves) {

            if (element.equals('X')) {
                XsAndOs[0] = XsAndOs[0] + 1;
                XsAndOs[2] = XsAndOs[2] + 1;
            } else if (element.equals('O')) {
                XsAndOs[1] = XsAndOs[1] + 1;
                XsAndOs[2] = XsAndOs[2] + 1;
            } else if (element.equals(' ')) {
                if (XsAndOs[2] != 9)
                    gameIsStillOn = true;
                else {
                    gameIsStillOn = false;
                }
            }
        }

    }


    public void doWeHaveAWinnerChecker(char[] ar) {
        if (ar[0] != ' ' && ar[0] == ar[1] && ar[1] == ar[2]) {
            doWeHaveAWinner = true;
            theWinner = ar[0];
            howManyWinners++;

        }
        if (ar[3] != ' ' && ar[3] == ar[4] && ar[4] == ar[5]) {
            doWeHaveAWinner = true;
            theWinner = ar[3];
            howManyWinners++;
        }
        if (ar[6] != ' ' && ar[6] == ar[7] && ar[7] == ar[8]) {
            doWeHaveAWinner = true;
            theWinner = ar[6];
            howManyWinners++;
        }
        if (ar[6] != ' ' && ar[6] == ar[7] && ar[7] == ar[8]) {
            doWeHaveAWinner = true;
            theWinner = ar[6];
            howManyWinners++;
        }
        if (ar[0] != ' ' && ar[0] == ar[3] && ar[3] == ar[6]) {
            doWeHaveAWinner = true;
            theWinner = ar[0];
            howManyWinners++;
        }
        if (ar[1] != ' ' && ar[1] == ar[4] && ar[4] == ar[7]) {
            doWeHaveAWinner = true;
            theWinner = ar[1];
            howManyWinners++;
        }
        if (ar[2] != ' ' && ar[2] == ar[5] && ar[5] == ar[8]) {
            doWeHaveAWinner = true;
            theWinner = ar[2];
            howManyWinners++;
        }
        if (ar[0] != ' ' && ar[0] == ar[4] && ar[4] == ar[8]) {
            doWeHaveAWinner = true;
            theWinner = ar[0];
            howManyWinners++;
        }
        if (ar[2] != ' ' && ar[2] == ar[4] && ar[4] == ar[6]) {
            doWeHaveAWinner = true;
            theWinner = ar[2];
            howManyWinners++;

        }


    }



    public char[][] fullFillBoard(char[][] boardToFullFill, char[] arrayOfImput) {
        int counter = 0;
//drawing the grid
        for (int i = 0; i < boardToFullFill.length; i++) {
            for (int j = 0; j < boardToFullFill[0].length; j++) {
                if (i == 0) {
                    boardToFullFill[0][j] = '-';
                }
                if (i == (boardToFullFill.length - 1)) {
                    boardToFullFill[boardToFullFill.length - 1][j] = '-';
                }
                if (i != 0 && i != boardToFullFill.length - 1 && j == 0 || i != 0 && i != boardToFullFill.length - 1 && j == boardToFullFill[0].length - 1) {
                    boardToFullFill[i][j] = '|';
                }

            }

        }

//fullfill board with moves

        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j < 8; j++) {
                if ((j % 2) != 0) {
                    boardToFullFill[i][j] = ' ';
                } else {
                    boardToFullFill[i][j] = arrayOfImput[counter];
                    counter++;
                }
            }
        }


        return boardToFullFill;

    }

    public void checkAllTheStuff(char[][] boardToFullFill, char[] arrayOfImput) {
        doWeHaveAWinnerChecker(arrayOfImput);
        printBoard(boardToFullFill);
        countMoves(arrayOfImput);
        drawCheck(arrayOfImput);


        if (impossible == false && doWeHaveAWinner == true) {
            System.out.println(theWinner + " wins");
            System.exit(1);
        }
        if (impossible == false && doWeHaveAWinner == false && gameIsStillOn == false || draw == true) {
            System.out.println("Draw");
            System.exit(1);
        }
        if (impossible == true) {
            System.out.println("Impossible");
            System.exit(1);
        }
        if (gameIsStillOn == true && doWeHaveAWinner == false && impossible == false) {
            System.out.println("Game not finished");
        }
    }

    public void printBoard(char[][] board) {


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
