import java.util.List;

public class QuizManager {
    private List<Question> questions;
    private int currentIndex = 0;
    private int correctAnswers = 0;

    public QuizManager() {
        QuestionDAO dao = new QuestionDAO();
        this.questions = dao.get20Questions();
    }

    public Question getCurrentQuestion() {
        if (currentIndex < questions.size()) {
            return questions.get(currentIndex);
        }
        return null;
    }

    public void checkAnswer(String answer) {
        Question q = getCurrentQuestion();
        if (q != null && q.getCorrectOption().equalsIgnoreCase(answer)) {
            correctAnswers++;
        }
        currentIndex++;
    }

    public boolean isFinished() {
        return currentIndex >= questions.size();
    }

    public int getScore() { return correctAnswers; }
    public int getTotalQuestions() { return questions.size(); }
}