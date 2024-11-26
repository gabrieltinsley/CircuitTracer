****************
* Project number/name
* Class
* Date
* Your name
**************** 
ANALYSIS:
How does the choice of Storage configuration (stack vs queue) affect the sequence in which paths are explored in the search algorithm? (This requires more than a "stacks are LIFOs and queues are FIFOs" answer.)
Stack is depth first search, which means it goes through every possible path for the last element in the stack, and goes through the stack until complete. Queue is a breadth first search, which means the first element is looked at, then the second element in the queue and so on. The queue always guarantees the shortest path when found while stack does not.
Is the total number of search states (possible paths) affected by the choice of stack or queue?
Yes, queue guarantees the shortest possible number of paths found while stack does not because queue goes from the first possible step then the second step and so on.

Is using one of the storage structures likely to find a solution in fewer steps than the other? Always?
Using one storage solution over the other will result in the same number of steps found for a solution, both would go over the same number of steps also.

Does using either of the storage structures guarantee that the first solution found will be a shortest path?
Yes, queue guarantees that the first solution found will be the shortest path.

How is memory use (the maximum number of states in Storage at one time) affected by the choice of underlying structure?
Stack uses less memory because in depth first search the computer goes as far as it possibly can down one route, while queue uses more memory because the computer looks at every route at the same pace.


What is the Big-O runtime order for the search algorithm?
N because there are no nested for loops just nested if statements

What does the order reflect? (Maximum size of Storage? Number of board positions? Number of paths explored? Maximum path length? Something else?)
The search is quick and the maximum size of storage cannot exceed the board size, the number of board positions can be found instantly.

What is 'n', the single primary input factor that increases the difficulty of the task?
The amount of possible paths increases ‘n’.


OVERVIEW:

 Concisely explain what the program does. If this exceeds a couple
 of sentences, you're going too far. The details go in other
 sections.


INCLUDED FILES:

 List the files required for the project with a brief
 explanation of why each is included.

 e.g.
 * Class1.java - source file
 * Class2.java - source file
 * README - this file


COMPILING AND RUNNING:

 Give the command for compiling the program, the command
 for running the program, and any usage instructions the
 user needs.
 
 These are command-line instructions for a system like onyx.
 They have nothing to do with Eclipse or any other IDE. They
 must be specific - assume the user has Java installed, but
 has no idea how to compile or run a Java program from the
 command-line.
 
 e.g.
 From the directory containing all source files, compile the
 driver class (and all dependencies) with the command:
 $ javac Class1.java

 Run the compiled class file with the command:
 $ java Class1

 Console output will give the results after the program finishes.


PROGRAM DESIGN AND IMPORTANT CONCEPTS:

 This is the sort of information someone who really wants to
 understand your program - possibly to make future enhancements -
 would want to know.

 Explain the main concepts and organization of your program so that
 the reader can understand how your program works. This is not a repeat
 of javadoc comments or an exhaustive listing of all methods, but an
 explanation of the critical algorithms and object interactions that make
 up the program.

 Explain the main responsibilities of the classes and interfaces that make
 up the program. Explain how the classes work together to achieve the program
 goals. If there are critical algorithms that a user should understand, 
 explain them as well.
 
 If you were responsible for designing the program's classes and choosing
 how they work together, why did you design the program this way? What, if 
 anything, could be improved? 

TESTING:

 How did you test your program to be sure it works and meets all of the
 requirements? What was the testing strategy? What kinds of tests were run?
 Can your program handle bad input? Is your program  idiot-proof? How do you 
 know? What are the known issues / bugs remaining in your program?


DISCUSSION:
 
 Discuss the issues you encountered during programming (development)
 and testing. What problems did you have? What did you have to research
 and learn on your own? What kinds of errors did you get? How did you 
 fix them?
 
 What parts of the project did you find challenging? Is there anything
 that finally "clicked" for you in the process of working on this project?
 
 
EXTRA CREDIT:

 If the project had opportunities for extra credit that you attempted,
 be sure to call it out so the grader does not overlook it.


----------------------------------------------------------------------------

All content in a README file is expected to be written in clear English with
proper grammar, spelling, and punctuation. If you are not a strong writer,
be sure to get someone else to help you with proofreading. Consider all project
documentation to be professional writing for your boss and/or potential
customers.
