****************
* CircuitTracer
* CS221-3
* 12/06/2024
* Gabriel Tinsley
****************


ANALYSIS:

How does the choice of Storage configuration (stack vs queue) affect the sequence in which paths are explored in the search algorithm? (This requires more than a "stacks are LIFOs and queues are FIFOs" answer.)

Stack is depth first search, which means it goes through every possible path for the last element in the stack, and goes through the stack until complete. Queue is a breadth first search, which means the first element is looked at, then the second element in the queue and so on. The queue always guarantees the shortest path when found while stack does not.

Is the total number of search states (possible paths) affected by the choice of stack or queue?

Yes, the queue at its peak will hold every possible path before checking for solutions and the stack at its peak will hold the longest path on the board possible, so the queue will hold a lot more than the stack at their peaks.

Is using one of the storage structures likely to find a solution in fewer steps than the other? Always?

Using stack will result in the solution being found faster since a stack goes depth first meaning a solution will be found until moving onto the next part of the call stack. Queue moves breadth first which means the solution will take a long time to be found because every possible next move is made before finding a solution.

Does using either of the storage structures guarantee that the first solution found will be a shortest path?

Yes, queue guarantees that the first solution found will be the shortest path.

How is memory use (the maximum number of states in Storage at one time) affected by the choice of underlying structure?

Stack uses less memory because in depth first search the computer goes as far as it possibly can down one route, while queue uses more memory because the computer looks at every route at the same pace.


What is the Big-O runtime order for the search algorithm?

3^n for Stack and Queue but Stack holds a lot less memory while running because Queue holds every possible solution so Stack is faster than Queue.

What does the order reflect? (Maximum size of Storage? Number of board positions? Number of paths explored? Maximum path length? Something else?)

The order reflects that for a queue the maximum size of storage will be all the possible states at one time. And for a stack the maximum size of storage is all the board positions in a path. So Stack is a much faster search when compared to Queue even though both of them go over every possible path. 

What is 'n', the single primary input factor that increases the difficulty of the task?

‘n’ is the number of elements on a board.


OVERVIEW:

CircuitTracer implements a brute force search algorithm using command line arguments while managing exceptions from parsing an input file. Allows others to analyze the impact of using a stack or queue while supplying a fully functional graphical user interface.


INCLUDED FILES:

* CircuitBoard.java - source file
* CircuitTracer.java - source file
* CircuitTracerGUI.java - source file
* InvalidFileFormatException.java - source file
* OccupiedPositionException.java - source file
* Storage.java - source file
* TraceState.java - source file
* README - this file


COMPILING AND RUNNING:

From the directory containing all source files, compile the
driver class (and all dependencies) with the command:
$ javac CircuitTracer.java

Run the compiled class file with the command:
$ java CircuitTracer storageChoice displayChoice inputFile

storageChoice is either -s for a stack or -q for a queue
displayChoice is either -c for console-only output or -g for GUI output 
inputFile is the name of a file containing a layout to complete

Console output (-c) will show all shortest paths for files that are valid while invalid files show the reason for them throwing InvalidFileFormatException.

GUI output (-g) will display all the possible shortest paths as buttons labeled in ascending order for files that are valid while invalid files show the reason for them throwing InvalidFileFormatException.


PROGRAM DESIGN AND IMPORTANT CONCEPTS:

CircuitTracer is the main entry point for the program by parsing command-line arguments, instantiating a CircuitBoard as well as the solving process and managing the output options. CircuitBoard represents the circuit’s layout including walls, start points and end points. Also, CircuitBoard validates input files format making sure there are valid start points and ends points and allowed characters.

Storage puts data structures into either a stack or queue and used to manage TraceState objects during brute-force search. TraceState represents a potential path on a CircuitBoard and checks for valid solutions. CircuitTracer uses TraceState to check if a next possible path is open, then creating another TraceState object until all the possible paths are explored. 

CircuitTracerGUI provides a graphical user interface for displaying the shortest possible paths. Allows users to interact with the solutions visually by seeing them displayed on screen by pressing buttons labeled “Solution number” where the number is in ascending order.

Brute-force search is the critical algorithm to understand. This starts by creating a Storage object that holds TraceStates in either a Stack or Queue. Then creating a list to hold the best possible paths. The first possible moves are TraceState that get added to the Storage object. The TraceState checks if there is a valid solution before creating the next TraceState. If there is a valid solution that gets added to the list holding the best possible paths. All possible paths will be checked by both the stack and queue. 


TESTING:

I tested CircuitTracer using the unit test class CircuitTracerTester, which performs tests covering all possible scenarios including command line arguments. There are 86 total tests that include checking creating a CircuitBoard, running CircuitTracer with valid input files, running CircuitTracer with invalid input files, and running CircuitTracer with invalid Command Line arguments. There are two tests that check if a GUI can be opened then exit cleanly, but I tested my GUI manually to make sure it was up to standard. My program is idiot proof because only the specific commands explained in the usage message can be run, anything more or less than that will output a usage message and continue my program. No one can kill my program from the command line and I am confident of that. There are no known issues or bugs.


DISCUSSION:

An issue I encountered while programming was adding a new initial TraceState object to Storage for each position adjacent to the starting position. Sitting there puzzled I was helped by a kind TA for cs121 named Brady. I am thankful for Brady’s explanation because he knows how to work with Points in Java. Working with points finally clicked when I was able to generate all valid next TraceState objects from current TraceState and add them to Storage.

EXTRA CREDIT:

I attempted extra credit by crediting a functional GUI.

----------------------------------------------------------------------------
