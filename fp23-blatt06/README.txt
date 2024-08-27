########################################
### Compile and run the java classes ###
########################################

## List all Java files in directory 'src' and store (redirect output via '>') that list in a file named 'sources'

# Microsoft windows
dir /s /b src\*.java > sources

# Unix
find src -type f -name *.java > sources

## Create directory path 'build -->> classes'

# Microsoft windows
mkdir build\classes

# Unix
mkdir -p build/classes

## Compile the sources listed in file 'sources' (annotation processing) and store resulting Class files to directory 'build\classes'.

# Microsoft windows
javac -d build\classes @sources

# Unix
javac -d build/classes @sources

## Run the Main class. Note, yy stands for two digits that denote the year, e.g., 23, <nr> stands for the number of the assignment with two digits, e.g., 01 and <param> stands for the commandline paratmeter that you would like to pass to the main method.
## The flag '-cp' determines the classpath, i.e., the path where to find the so called 'user specified classes'.

# Microsoft windows
java -cp build\classes de.unitrier.st.fp.s<yy>.blatt<nr>.matrix.Main <param>

java -cp build\classes de.unitrier.st.fp.s<yy>.blatt<nr>.textart.Main <param>

# Unix
java -cp build/classes de.unitrier.st.fp.s<yy>.blatt<nr>.matrix.Main <param>

java -cp build/classes de.unitrier.st.fp.s<yy>.blatt<nr>.textart.Main <param>


## References

https://docs.oracle.com/en/java/javase/17/docs/specs/man/javac.html

