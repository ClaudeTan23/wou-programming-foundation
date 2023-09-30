package mcq;

public abstract class CalculateMark
{
    private double score = 0;

    private int correctAnswers = 0;

    private int wrongAnswers = 0;

    private String username;

    public CalculateMark(String username)
    {
        this.username = username;
    }

    // Setter for the correctAnswer properties
    public int setCorrectAnswers(int correctAnswer)
    {
        this.correctAnswers = correctAnswer;

        return this.correctAnswers;
    }

    // Getter for the correctAnswer properties
    public int getCorrectAnswers()
    {
        return this.correctAnswers;
    }

    // Setter for the wrongAnswer properties
    public int setWrongAnswers(int wrongAnswer)
    {
        this.wrongAnswers = wrongAnswer;

        return this.wrongAnswers;
    }

    // Getter for the wrongAnswer properties
    public int getWrongAnswers()
    {
        return this.wrongAnswers;
    }

    // This method use for calculate the score and display it on the console
    public void showScore()
    {
        double totalQuestion = this.correctAnswers + this.wrongAnswers;
        double cal = this.correctAnswers / totalQuestion;
        this.score = cal * 100;

        System.out.println("<" + this.username + "> you answered " + this.correctAnswers + " Questions Right, " + this.wrongAnswers + " Questions Wrong for a Total of " + (this.correctAnswers + this.wrongAnswers) + " Questions.");
        System.out.println("You score " + this.score + "%");
    }
}
