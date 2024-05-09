# Phone Words
## Introduction
Phonewords are alphanumeric representations of phone numbers, often used by companies as their phone numbers for easy recall. This command-line program processes a list of phone numbers and a dictionary of words, outputting all possible word replacements for each phone number based on the provided dictionary.
Both the list of phone numbers and the dictionary are provided as files, and their paths should be passed as program arguments.
This project will deliver 2 deliverables upon  a successful build which are
* The application jar file
* The application distribution as a zip file


### Terminology
Input File: Refers to the file containing phone numbers.

## Installation and Usage

### Build From Source Code
This project is built with Maven. To build:
Clone or download the project from the repository.
Navigate to the project directory in the terminal.
Run the following command:

```
mvn clean install
```

### Running the Application

#### Using an IDE:
1. Import the project into your preferred IDE.
2. Add the paths to the dictionary file and the input file as program arguments in the following format:
```
-dictionary={dictionary_file_path} -input={input_file_path}
```
3. 

#### Command Line:
Run the following command using the executable jar 

```
java -jar phone-words-1.0-SNAPSHOT.jar -dictionary={dictionary_file_path} -input={input_file_path}
```

#### Using the Distribution:
1. After a successful build, locate the distribution ZIP file in the `target` folder (e.g., `phone-words-{VERSION}-distribution.zip`).We can use this distribion add the required files in the folders and execute the program using the scripts provided in the distribution
2. Unzip the folder.
3. Inside the unzipped folder, you'll find:
   - `input/input.txt`: Add phone numbers to this file.
   - dictionary/dictionary.txt:  Add dictionary words to this file.
   - `lib`: Contains the application JAR.
   - `start.bat`: Execute this file to run the application on Windows.
   - `start.sh`: Execute this file to run the application on Unix-based systems.
