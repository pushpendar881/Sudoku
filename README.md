
Description of the Game: 
The game initializes a 9x9 Sudoku board with some pre-filled numbers and empty spaces (represented by 0). Players can make moves by entering the row, column, and the number they want to place on the board.The game checks if the move is valid by verifying whether the number can be placed in the given row, column, and 3x3 subgrid. The game includes an undo feature, which allows players to revert their last move.There is also a solve feature, which uses a recursive backtracking algorithm to attempt solving the puzzle. The game ends when the puzzle is solved (i.e., all cells are filled correctly).


Data Structures Used: 
1. 2D Array (board[][]):
•	This 9x9 array represents the Sudoku board, with numbers 1-9 filling cells and 0 indicating an empty space.
•	It stores the initial puzzle setup and updates as players make moves or when the solver fills the cells.
•	The array helps check if a number can be placed at a specific position, ensuring no duplicate numbers in rows, columns, or 3x3 subgrids.
•	Functions like DisplayBoard() read this array to visually output the current state of the board.
•	The solve() function modifies this array during the backtracking process to fill the puzzle.


3. Stack (moveHistory):
•	The stack stores the history of player moves as an array [row, column, previous value], with each push representing a new move.
•	This structure follows the Last In, First Out (LIFO) principle, making it ideal for the undo function.
•	When a player makes a move, the previous value in the cell is stored in the stack, and the new move is made on the board.
•	When undoMove() is called, the stack pops the latest move, restoring the board's previous state.
•	It ensures that players can correct their moves without altering earlier steps, providing flexibility in gameplay.


5. Recursion (solve()):
•	The solve() method uses recursive backtracking to solve the puzzle by filling empty cells.
•	It scans the board for the first empty cell (0) and tries placing numbers 1 through 9, checking if they are valid.
•	If a valid number is found, it places the number and recursively calls itself to fill the next cell.
•	If a dead end is reached (i.e., no valid number works), the function backtracks by resetting the cell to 0 and trying the next possible number.
•	This approach systematically explores all possible solutions, making recursion an efficient method for solving Sudoku.


Logic of the Game:
 Board Initialization: A 9x9 grid is initialized with some pre-filled numbers and empty cells (represented by 0).
 Move Input and Validation: The player inputs the row, column, and number they want to place. The game checks if the number can be placed by ensuring:
The number doesn't already exist in the same row, column, or 3x3 subgrid (checked by the isValid() function).
Stack for Undo: Each move is recorded in a stack, allowing players to undo their last move by popping from the stack and restoring the previous state of the cell.
Backtracking Solver: If the player types "solve," the game uses recursive backtracking (solve() function) to fill the empty cells by trying numbers 1-9. If a number works, it moves to the next empty cell. If no number works, it backtracks and resets the previous cell, trying a different number.
Completion Check: The game continuously checks if all cells are filled to declare the puzzle solved.


