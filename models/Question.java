public class Question {
    private int id;
    private String question;     // Matches 'question' column
    private String optionA;      // Matches 'optionA'
    private String optionB;
    private String optionC;
    private String optionD;
    private String correctOption; // Matches 'correctOption'

    public Question(int id, String question, String optionA, String optionB, String optionC, String optionD, String correctOption) {
        this.id = id;
        this.question = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.correctOption = correctOption;
    }

    // Formats the question for the Client: "QuestionText;A;B;C;D"
    public String toProtocolString() {
        return question + ";" + optionA + ";" + optionB + ";" + optionC + ";" + optionD;
    }
    
    public String getCorrectOption() { return correctOption; }
}