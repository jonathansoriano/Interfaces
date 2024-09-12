import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

public class ShorterLister {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String rec = "";
        ArrayList<String> shortWords = new ArrayList<>(); //This array takes items from the "words" Array and stores them in arraylist.
        ShortWordFilter filter = new ShortWordFilter();

        File workingDirectory = new File(System.getProperty("user.dir")); // Can this be outside the try block
        chooser.setCurrentDirectory(workingDirectory);

        try
        {

            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath(); //Converting file "selectedFile" to Path?
                // Typical java pattern of inherited classes
                // we wrap a BufferedWriter around a lower level BufferedOutputStream
                InputStream in =
                        new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(in));

                // Finally, we can read the file LOL!

                while(reader.ready())
                {
                    rec = reader.readLine(); // This takes all the words read from the file selected and converts them to a String type.
                    String[] words = rec.split(" "); // Here we are taking the String rec that contains what the
                                                        // file has and splitting the words by a space. (Can also use regex pattern "\\s+" )
                                                        //All these split words go into the array called "words".
                    for (String word : words){ // Here we are going through the items in the "words" array.
                        if (filter.accept(word)){// and as we go through, we are check to see if any one of the words( which are an instance of the class String )
                                                // is less than 5 character, if not they won't be added to the arraylist called
                                                 // "shortWords".
                            shortWords.add(word);
                        }
                    }


                }
                reader.close(); // must close the file to seal it and flush buffer
                System.out.println("\n\nData file read!");
                System.out.println("These are short words with less than 5 characters:");
                for (int x = 0; x < shortWords.size(); x++){
                    System.out.println(shortWords.get(x));//This just prints the items that passed the accept() method
                                                        // which are words that are less than 5 characters.
                }




            }
            else  // user closed the file dialog without choosing
            {
                System.out.println("Failed to choose a file to process");
                System.out.println("Run the program again!");
                System.exit(0);
            }
        }  // end of TRY
        catch (FileNotFoundException e)
        {
            System.out.println("File not found!!!");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
