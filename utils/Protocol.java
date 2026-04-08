public class Protocol {
    public static final String SEPARATOR = "\\|";
    public static final String SEPARATOR_CHAR = "|";
    
    // Commands
    public static final String LOGIN = "LOGIN";
    public static final String REGISTER = "REGISTER";
    public static final String AUTH_SUCCESS = "AUTH_SUCCESS";
    public static final String AUTH_FAIL = "AUTH_FAIL";
    
    // Quiz Flow
    public static final String QUESTION = "QUESTION"; // QUESTION|username|text;A);B);C);D)
    public static final String ANSWER = "ANSWER";     // ANSWER|username|B
    public static final String SCORE = "SCORE";       // SCORE|username|16/20
    public static final String END = "END";
}