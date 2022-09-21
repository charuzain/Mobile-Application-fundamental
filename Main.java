/* Problem 2.
Write a Method that takes 2 file names and 2 strings, method will read from the old file and
replace all the occurrences or old string with new string and enters it in the new file.
replaceStringFromSourceToTarget(String sourceFileName, String targetFileName,
String oldString, String newString ) throws FileNotFoundException */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner; 

public class Main {
  public static void replaceStringFromSourceToTarget(String sourceFileName, String targetFileName, String oldString,
      String newString) {

    // check if source file exist or not. If not display error message
    File sourceFile = new File(sourceFileName);
    if (!sourceFile.exists()) {
      System.out.println("File couldn't be found. Enter a valid file name");
    } else {

      // check if destination file exist or not , if not create a new file

      File targetFile = new File(targetFileName);
      if (targetFile.exists()) {
        System.out.println("file  already exist. Please provide a different file name");
      } else {
        // create a target file
        try {
          targetFile.createNewFile();
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }

      // read the old file and write to target file
      File myFile = new File(sourceFileName);
      try {
        Scanner sc = new Scanner(myFile);
        FileWriter fileWriter = new FileWriter(targetFileName);
        while (sc.hasNextLine()) {
          String line = sc.nextLine();
          if (line.contains(oldString)) {
            System.out.println("it contains " + oldString);

            String newLine = line.replaceAll(oldString, newString);
            fileWriter.write(newLine + "\n");
          } else {
            fileWriter.write(line + "\n");
          }
        }
        fileWriter.close();
        sc.close();

      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }
  }

  public static void main(String[] args) {

    // take source file and destination file , old string and new string as input
    // from user
    Scanner sc = new Scanner(System.in);
    System.out.println("Provide a source file name");
    String sourceFileNAme = sc.nextLine();

    System.out.println("Provide a target file name");
    String targetFileName = sc.nextLine();

    System.out.println("Enter the string you want to replace");
    String strToReplace = sc.nextLine();

    System.out.println("Enter the new string");
    String newString = sc.nextLine();

    // pass the variables as a parameter to method

    replaceStringFromSourceToTarget(sourceFileNAme, targetFileName, strToReplace, newString);
  }

}