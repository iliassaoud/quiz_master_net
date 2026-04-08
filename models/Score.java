import java.sql.Timestamp;

public class Score {
    private int studentId;
    private int score;
    private Timestamp examDate; // Matches 'examDate' column

    public Score(int studentId, int score) {
        this.studentId = studentId;
        this.score = score;
        this.examDate = new Timestamp(System.currentTimeMillis());
    }

    public int getStudentId() { return studentId; }
    public int getScoreValue() { return score; }
    public Timestamp getExamDate() { return examDate; }
}