package mcq;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LoadFiles extends CalculateMark
{
    public String username;

    public String currentDir;

    public Set<String> csvFiles;

    public String questionTitles = "";

    public int totalTitles = 0;

    public BufferedReader csvReader;

    // Run the program and load the csv files to display the subject from the csv file
    public LoadFiles(String username)
    {
        super(username);
        this.username   = username;
        this.currentDir = System.getProperty("user.dir") + "\\csv";

        try 
        {
            csvFiles = listFilesUsingFilesList(currentDir);

            totalTitles = csvFiles.size();

            System.out.println("\nChoose your Multiple Choice Question Set. The Options are :");

            for(int i = 0; i < totalTitles; i++)
            {
                String[] title = csvFiles.toArray()[i].toString().split("\\.");

                System.out.println(i + 1 + ". " + title[0]);
            }

            System.out.println("\nChoose the question with number.");
            
            selectSubject();

        } catch (IOException e) 
        {
            e.printStackTrace();
        }

    }

    // This method is use for the user to select the subject
    public void selectSubject()
    {
        try 
        {
            String selectedSubject = System.console().readLine().trim();

            int numberSelected = Integer.parseInt(selectedSubject);

            if(numberSelected > totalTitles || numberSelected <= 0)
            {
                System.out.println("Please choose number between 1 ~ " + totalTitles);

                selectSubject();

            } else 
            {
                questionTitles = csvFiles.toArray()[numberSelected - 1].toString().split("\\.")[0];

                System.out.println("\nName: " + username + "\n" + "Subject: " + questionTitles + "\n");

                loadQuestions(numberSelected);
            }
            
        } catch (Exception e) 
        {
            System.out.println("Please select the subject using number only");

            selectSubject();
        }
    }

    // This method is use for display the question and the selection answers
    public void loadQuestions(int index)
    {
        try 
        {
            String dirCsvFile = currentDir + "\\" + csvFiles.toArray()[index -1];
            
            String line;

            csvReader = new BufferedReader(new FileReader(dirCsvFile));

            while((line = csvReader.readLine()) != null)
            {
                String[] col = line.split(";");

                String correctAnswer = "";

                String alpAnswer = "";

                String answer = "";

                boolean existedAlp = false;

                List<String> alps = new ArrayList<String>();

                for(int i = 0; i < col.length; i++)
                {
                    if(i < col.length - 2)
                    {
                        System.out.println(col[i]);

                        if(i != 0) alps.add(col[i].split("\\.")[0].trim());
                    }

                    if(i >= col.length - 2)
                    {
                        if(i == col.length - 1)
                        {
                            correctAnswer = col[i];

                        } else 
                        {
                            alpAnswer = col[i];
                        }
                    }


                    if(i == col.length - 1) System.out.print("\n");
                }

                System.out.print("Choose answer: ");

                while(!existedAlp)
                {
                    answer = System.console().readLine().trim();

                    if(alps.contains(answer))
                    {
                        existedAlp = true;

                    } else 
                    {
                        System.out.println("Please select the existed answers by using alphabet.");
                    }
                }

                if(answer.equals(alpAnswer))
                {
                    System.out.println("Correct answer: The answer is " + correctAnswer + "\n");

                    int currentCorrectAns = getCorrectAnswers();

                    setCorrectAnswers(++currentCorrectAns);

                } else 
                {
                    System.out.println("Wrong answer: The correct answer is " + correctAnswer + "\n");

                    int currentWrongAns = getWrongAnswers();

                    setWrongAnswers(++currentWrongAns);
                }
                
            }

        } catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

    // This method get all the csv files information
    public Set<String> listFilesUsingFilesList(String dir) throws IOException
    {
        try (Stream<Path> stream = Files.list(Paths.get(dir))) 
        {
            return stream
            .filter(file -> !Files.isDirectory(file))
            .map(Path::getFileName)
            .map(Path::toString)
            .collect(Collectors.toSet());
        }
    }
}
