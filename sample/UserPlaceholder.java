package sample;

public final class UserPlaceholder {

    private static UserPlaceholder INSTANCE;

    private User user;

    public static UserPlaceholder getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new UserPlaceholder();
        }
        return INSTANCE;
    }

    private UserPlaceholder() {
    }

    public void setUser(User u) {
        this.user = u;
    }

    public User getUser() {
        return this.user;
    }
}
