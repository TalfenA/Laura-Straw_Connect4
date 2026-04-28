# Laura-Straw Connect4

# Choice of technology
Java was chosen due to it's object oriented nature, making it possible to separate aspects of the game into individual classes to reduce duplication and improve readability. The ability to create Javadoc comments was also an additional factor, as this makes the system easier to understand without having to look into the code itself. <br>
Choosing Maven as the build system allowed for much easier integration of automatic testing using JUnit, as well as simplifying some import processes to save time.<br>

# Running and testing instructions
The Solution and tests can be found in the V1.0 folder.<br>
The game should be run using the org.example.main class.<br>
To run tests, the class org.example.tests.GameTest should be used. Testing methods include:<br>
- testGettingLines
- testPrintingBoard
- testWinConditions
<br>
There are no special requirements to run this solution on Linux/Mac.<br>

# Known issues
- Checking for winning conditions in the final column of the game returns an error, and does not change the current player
- Winning conditions cannot be successfully checked for
- To run a full game without these errors, running version V.05 is recommended.
