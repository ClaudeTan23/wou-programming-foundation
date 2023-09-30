package mcq;

public class Main 
{
    public static LoadFiles Mcq;

    public static boolean validateName = false;
    public static void main(String[] args) 
    {
        String username = null;
        System.out.print("Enter your name: ");

        while(!validateName)
        {
            username = System.console().readLine().trim();

            if(!username.equals(null) && !username.equals(""))
            {
                validateName = true;

            } else 
            {
                System.out.println("empty name please try again.");
                System.out.print("Enter your name: ");
            }
        }

        // Call the object of the class to run the program and put the username in the parameter for the constructor to add the username in the memory 
        Mcq = new LoadFiles(username);

        // This method is to display the score it will display when the user completed the questions
        Mcq.showScore();
    }
}