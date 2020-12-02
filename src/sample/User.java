package sample;

public class User {
    private String Namn;
    private String anvNamn;
    private String Losenord;
    private String Email;
    private int arbetsId;
    private String position;
    private String telephone;

    public User(String namn, String anvNamn, String losenord, String email, int arbetsId, String position, String telePhone) {
        this.Namn = namn;
        this.anvNamn = anvNamn;
        this.Losenord = losenord;
        this.Email = email;
        this.arbetsId = arbetsId;
        this.position = position;
        this.telephone = telePhone;
    }

    @Override
    public String toString() {
        return Namn + " " + Losenord + " " + Email + " " + arbetsId + " " + position;

    }

    public String getNamn() {
        return Namn;
    }

    public void setNamn(String namn) {
        Namn = namn;
    }

    public String getAnvNamn() {
        return anvNamn;
    }

    public void setAnvNamn(String uName) {
        anvNamn = uName;
    }

    public String getLosenord() {
        return Losenord;
    }

    public void setLosenord(String losenord) {
        Losenord = losenord;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getArbetsId() {
        return arbetsId;
    }

    public void setArbetsId(int arbetsId) {
        this.arbetsId = arbetsId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}