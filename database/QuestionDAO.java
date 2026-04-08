import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuestionDAO {
    
    public List<Question> get20Questions() {
        List<Question> list = new ArrayList<>();
        String sql = "SELECT * FROM questions ORDER BY RAND() LIMIT 20";
        
        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                list.add(new Question(
                    rs.getInt("id"),
                    rs.getString("question"),
                    rs.getString("optionA"),
                    rs.getString("optionB"),
                    rs.getString("optionC"),
                    rs.getString("optionD"),
                    rs.getString("correctOption")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}