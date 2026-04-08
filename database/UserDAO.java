import java.sql.*;

public class UserDAO {
    
    public User authenticate(String cne, String password) {
        String sql = "SELECT * FROM students WHERE cne = ? AND password = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, cne);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                return new User(
                    rs.getInt("id"), 
                    rs.getString("cne"), 
                    rs.getString("password"), 
                    rs.getString("fullname")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean register(String cne, String password, String fullname) {
        String sql = "INSERT INTO students (cne, password, fullname) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, cne);
            pstmt.setString(2, password);
            pstmt.setString(3, fullname);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}