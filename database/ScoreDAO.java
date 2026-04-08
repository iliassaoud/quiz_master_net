import java.sql.*;

public class ScoreDAO {
    public void saveScore(Score score) {
        String sql = "INSERT INTO scores (studentId, score, examDate) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, score.getStudentId());
            pstmt.setInt(2, score.getScoreValue());
            pstmt.setTimestamp(3, score.getExamDate());
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}