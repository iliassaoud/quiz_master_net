public class User {
    private int id;
    private String cne;       // Matches 'cne' column in 'students'
    private String password;
    private String fullname;  // Matches 'fullname' column in 'students'

    public User(int id, String cne, String password, String fullname) {
        this.id = id;
        this.cne = cne;
        this.password = password;
        this.fullname = fullname;
    }

    public int getId() { return id; }
    public String getCne() { return cne; }
    public String getPassword() { return password; }
    public String getFullname() { return fullname; }
}