public class ScoreManager {
    private ScoreDAO scoreDAO;

    public ScoreManager() {
        this.scoreDAO = new ScoreDAO();
    }

    public void persistScore(int userId, int points) {
        Score score = new Score(userId, points);
        scoreDAO.saveScore(score);
    }
}