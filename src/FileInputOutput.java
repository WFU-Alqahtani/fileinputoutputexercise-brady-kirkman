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

        ArrayList<Movie> movieList = new ArrayList<>();

        Scanner fileReader = new Scanner(myFile);

        while (fileReader.hasNextLine()) {
            Movie currentMovie = new Movie();

            String str = fileReader.nextLine();
            System.out.println(str);

            String[] arrOfStr = str.split(",");
            currentMovie.setTitle(arrOfStr[2]);

            String year = currentMovie.findYear(arrOfStr);
            currentMovie.setYear(year);

            movieList.add(currentMovie);
        }

        for (Movie movie : movieList) {
            System.out.println(movie.getTitle());
            fileWriter.println(movie.getYear());
        }

        fileWriter.close();
        fileReader.close();

    }

}