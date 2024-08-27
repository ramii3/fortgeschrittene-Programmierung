########################################
### Compile and run the java classes ###
########################################

## List all Java files in directory 'src' and store (redirect output via '>') that list in a file named 'sources'

# Microsoft windows
dir /s /b src\*.java > sources

# Unix
find src -type f -name *.java > sources

## Create directory 'build\classes'

# Microsoft windows
mkdir build\classes

# Unix
mkdir -p build/classes

## Compile

# Microsoft windows
javac -d build\classes -cp obfuscated @sources

# Unix
javac -d build/classes -cp obfuscated @sources

## Run the Main class. Note, <yy> stands for two digits that denote the year, e.g., 23.

# Microsoft windows
java -cp build\classes;obfuscated de.unitrier.st.fp.s<yy>.blatt05.Main

# Unix
java -cp build/classes:obfuscated de.unitrier.st.fp.s<yy>.blatt05.Main

# Note, on Linux systems, multiple entries to pass to the classpath option are separated with a ':' (colon) instead of a ';' (semicolon)


