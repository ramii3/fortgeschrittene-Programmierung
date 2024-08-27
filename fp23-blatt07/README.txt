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

## Set the environment variable 'PATH_TO_FX' that points to whereever you stores the JavaFX library. Here, we for eyample use "C:\Program Files\Java\javafx-sdk-17.0.2\lib" (MS windows) and "/home/<user>/Java/javafx-sdk-17.0.2/lib"

# Microsoft windows
set PATH_TO_FX="C:\Program Files\Java\javafx-sdk-17.0.2\lib"

# Unix. Note, replace <user> with your user account name
PATH_TO_FX="/home/<user>/Java/javafx-sdk-17.0.2/lib"

## Compile

# Microsoft windows
javac -d build\classes --module-path %PATH_TO_FX% --add-modules=javafx.controls,javafx.fxml @sources

# Unix
javac -d build/classes --module-path $PATH_TO_FX --add-modules=javafx.controls,javafx.fxml @sources

## Run the Main class. Note, yy stands for two digits that denote the year, e.g., 23, <nr> stands for the number of the assignment with two digits, e.g., 01 and <param> stands for the commandline paratmeter that you would like to pass to the main method.

# Microsoft windows
java -cp build\classes --module-path %PATH_TO_FX% --add-modules=javafx.controls,javafx.fxml de.unitrier.st.fp.s<yy>.blatt<nr>.Main <param>

# Unix
java -cp build/classes --module-path $PATH_TO_FX --add-modules=javafx.controls,javafx.fxml de.unitrier.st.fp.s<yy>.blatt<nr>.Main <param>

