import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 * Search for shortest paths between start and end points on a circuit board
 * as read from an input file using either a stack or queue as the underlying
 * search state storage structure and displaying output to the console or to
 * a GUI according to options specified via command-line arguments.
 * 
 * @author mvail
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
		// case "-g" :
		// 	throw new UnsupportedOperationException("Sorry, -g GUI output option is not supported at this time.");
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
		Storage<TraceState> stateStore;
		//TODO: initialize the Storage to use either a stack or queue
		if(args[0] == "-s") {
			stateStore = new Storage<TraceState>(Storage.DataStructure.stack);
		}
		if(args[0] == "-q") {
			stateStore = new Storage<TraceState>(Storage.DataStructure.queue);
		}

		List<TraceState> bestPaths = new ArrayList<>();

		//use if statements to check every possible direction for TraceState objects
		

		//TraceState object = stateStore.retrieve();
		//TODO: read in the CircuitBoard from the given file

		//TODO: run the search for best paths
		//TODO: output results to console or GUI, according to specified choice
	}
	
} // class CircuitTracer
