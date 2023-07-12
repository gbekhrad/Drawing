public class Drawing {
    public static void main(String[] args){

        char[][] canvas = createCanvas(7,10); 
        // the function createCanvas returns a char 2d array, returned into the var canvas
        
        addCharacter(canvas, 'D', 4, 2); // paint the frown
        addCharacter(canvas, ',', 5, 2); // paint the tear
        addCharacter(canvas, ':', 6, 2); // paint the eyes

        printCanvas(canvas); // calls printCanvas method on the canvas
        // add character takes in the reference to the canvas, the character
    }     

    public static char[][] createCanvas(int height, int width){
        /* 
        createCanvas returns a 2D char array with corner borders with '+' chars, top and bottom rows with '=' chars, 
        and the left and right columns with '|' chars.

        Parameters in include the dimensions of the array, or in context of the program, width and height of 
        the canvas the method returns.
        */
        
        char[][] board = new char[height][width]; // creates a "board", or a 2D char array.
        
        for (int row = 0; row < board.length; row++){ 
            for (int col = 0; col < board[row].length; col++){ //iterates through the rows and columns of the board, element by element
                if ((row == 0 && col == 0) || (row == board.length-1 && col == board[row].length-1) || (row == board.length-1 && col == 0) || (row == 0 && col == board[row].length-1)){ 
                    //checks indices of borders, for corner indices
                    board[row][col] = '+'; // sets each corner to '+' 
                } else if ((col == 0 && row != 0 && row != board.length-1) || (col == board[row].length-1 && row != 0 && row != board.length-1)) { 
                    //checks for sides, if corner or middle then does not execute
                    board[row][col] = '|'; // sets the sides to '|'
                } else if ((row == 0 || row == board.length-1) && (col != 0 && col != board[row].length-1)){ 
                    //if the index is a top edge but not a corner,
                    board[row][col] = '='; // set the top border to '='
                } else { // for every other piece that is not a border,
                    board[row][col] = ' '; //leave whitespace
                }
            }
        }
        return board; // returns the board with borders completed
    }

    public static void addCharacter(char[][] board, char charPainted, int xCoord, int yCoord){
        /* addCharacter is a void method, so it does not return anything, but updates the index of the x and y coordinate
        indicated by the method called with the character that the method passes in to be painted.
        
        The parameters include the x coordinate and y coordinate of the character to be placed, as well as the character.
         */
        
        board[yCoord][xCoord] = charPainted;
    }

    public static void printCanvas(char[][] board){
        /*
        printCanvas does not return anything, but rather executes the function of printing the entire canvas.

        The parameter is a 2D char array, or in this program, the canvas. 
         */

        for (int row = 0; row < board.length; row++){ 
            for (int col = 0; col < board[row].length; col++){ // iterate through each index of each array
                System.out.print(board[row][col] + " "); //prints each item in arrays
            }
            System.out.println(""); //once it finishes one array, it sets a new line and starts the next array
        }
    }
}
