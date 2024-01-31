import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class FileInputOutput {

    public static void main(String[] args) {
//       1) Open the given file inside src called moviesDataSet.csv
//       2) Read each row in the dataset
//       3) Print each row to the screen
//       4) Print only the name of the movie
//       5) Add exception handling (try & catch) when needed
//       6) Close the files after finishing the processing
//       7) Commit your code and push it to the GitHub

        FileInputStream myFile = null;
        try {
            myFile = new FileInputStream("src/moviesDataset.csv");
        }
        catch (FileNotFoundException e) {
            System.out.println("Could not open input file");
            System.exit(1);
        }

        PrintWriter fileWriter;
        FileOutputStream outputFile = null;
        try {
            outputFile = new FileOutputStream("output.txt", false);
        } catch (FileNotFoundException e)
        {
            System.out.println ("File could not be opened for output");
            System.exit(1);
        }
        fileWriter=new PrintWriter(outputFile);

        ArrayList<String> titleList = new ArrayList<String>();

        Scanner fileReader = new Scanner(myFile);
        while (fileReader.hasNextLine()) {
            String str = fileReader.nextLine();
            System.out.println(str);

            String[] arrOfStr = str.split(",");
            titleList.add(arrOfStr[2]);

            int year;
            boolean foundYear = false;
            for (int i=0; i<arrOfStr.length; i++) {

                if (arrOfStr[i].length()==4) {
                    try {
                        year = Integer.parseInt(arrOfStr[i]);
                        foundYear=true;
                        fileWriter.println(year);
                    }
                    catch (NumberFormatException e) {
                        //pass
                    }
                }

                if (i == arrOfStr.length-1 && !foundYear) {
                    fileWriter.println("N/A");
                }
            }
        }
        for (String item : titleList)
            System.out.println(item);

        fileWriter.close();
        fileReader.close();

    }

}