//Problem 3.
//  Write a function that asks the user for a file name(file path) and prints to command line if the
// file exists or not.

import java.io.File;
import java.util.Scanner;

public class CheckFile {

    public static boolean FileExist(String fileName) {
        File myFile = new File(fileName);
        return myFile.exists();
    }
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a file name");

        String fileName = sc.nextLine();
            if(FileExist(fileName)){
                System.out.println("File exist");
            }
            else{
                System.out.println("File doesn't exist");
            }
    }
}

