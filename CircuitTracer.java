import java.io.FileNotFoundException;
import java.util.ArrayList;


/**
 * Search for shortest paths between start and end points on a circuit board
 * as read from an input file using either a stack or queue as the underlying
 * search state storage structure and displaying output to the console or to
 * a GUI according to options specified via command-line arguments.
 * 
 * @author mvail
 * @author Gabriel Tinsley
 */
public class CircuitTracer {

	/** Launch the program. 
	 * 
	 * @param args three required arguments:
	 *  first arg: -s for stack or -q for queue
	 *  second arg: -c for console output or -g for GUI output
	 *  third arg: input file name 
	 */
	public static void main(String[] args) {
		new CircuitTracer(args); //create this with args
	}

	/** Print instructions for running CircuitTracer from the command line. */
	private void printUsage() {
		//TODO: print out clear usage instructions when there are problems with
		// any command line args
		System.out.println("Usage: java CircuitTracer storageChoice displayChoice inputFile \n" + //
						"\twhere storageChoice is either -s for a stack or -q for a queue,\n" + //
						"\tdisplayChoice is either -c for console-only output or -g for GUI output,\n" + //
						"\tand inputFile is the name of a file containing a layout to complete.");
	}
	
	/** 
	 * Set up the CircuitBoard and all other components based on command
	 * line arguments.
	 * 
	 * @param args command line arguments passed through from main()
	 */
	public CircuitTracer(String[] args) {
		//TODO: parse and validate command line args - first validation provided
		if (args.length != 3) {
			printUsage();
			return; //exit the constructor immediately
		}
		if (!args[0].equals("-s") && !args[0].equals("-q")) {
			printUsage();
			return; //exit the constructor immediately
		}
		if (!args[1].equals("-c") && !args[1].equals("-g")) {
			printUsage();
			return; //exit the constructor immediately
		}

		CircuitBoard board = null;

		//TODO: initialize the Storage to use either a stack or queue
		Storage<TraceState> stateStore = null;
		
		switch(args[0]) {
			case "-s":
				stateStore = Storage.getStackInstance();
				break;
			case "-q":
				stateStore = Storage.getQueueInstance();
				break;
			default:
				printUsage();
				return;
		}

		
		
		//TODO: read in the CircuitBoard from the given file
		try{
			board = new CircuitBoard(args[2]);
		} catch(FileNotFoundException e) {
			System.out.println(e);
			return;
		} catch(InvalidFileFormatException e) {
			System.out.println(e);
			return;
		}
		
		ArrayList<TraceState> bestPaths = new ArrayList<>();
		//TODO: run the search for best paths
		//use if statements to check every possible direction for TraceState objects

		int x = board.getStartingPoint().x;
		int y = board.getStartingPoint().y;

		// check left
		if(board.isOpen(x-1, y)) {
			stateStore.store(new TraceState(board, x-1, y));
		}

		// check right
		if(board.isOpen(x+1, y)) {
			stateStore.store(new TraceState(board, x+1, y));
		}

		// check down
		if(board.isOpen(x, y-1)) {
			stateStore.store(new TraceState(board, x, y-1));
		}

		// check up
		if(board.isOpen(x, y+1)) {
			stateStore.store(new TraceState(board, x, y+1));
		}

		while(!stateStore.isEmpty()) {
			TraceState currState = stateStore.retrieve();
			if(currState.isSolution()) {
				// The first found path, or a path of the same length as the first found path
				if(bestPaths.isEmpty() || currState.pathLength() == bestPaths.get(0).pathLength()) {
					bestPaths.add(currState);
				} 
				// shorter path is found
				else if(currState.pathLength() < bestPaths.get(0).pathLength()) {
					bestPaths.clear();
					bestPaths.add(currState);
				}
			} else {
				x = currState.getRow();
				y = currState.getCol();

				if(currState.isOpen(x-1, y)) {
					stateStore.store(new TraceState(currState, x-1, y));
				}

				if(currState.isOpen(x+1, y)) {
					stateStore.store(new TraceState(currState, x+1, y));
				}

				if(currState.isOpen(x, y-1)) {
					stateStore.store(new TraceState(currState, x, y-1));
				}

				if(currState.isOpen(x, y+1)) {
					stateStore.store(new TraceState(currState, x, y+1));
				}
			}
		}
		//TODO: output results to console or GUI, according to specified choice
		switch (args[1]) {
			case "-c":
				for (TraceState path : bestPaths) {
					System.out.println(path.getBoard().toString());
				}
				break;
			case "-g":
				// Initialize GUI with CircuitBoard and best paths
				System.out.println("GUI not yet implemented.");
				break;
			default:
				printUsage();
				return;
		}
	}
	
} // class CircuitTracer
