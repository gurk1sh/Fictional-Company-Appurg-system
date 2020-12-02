package sample;

public class Arbetsprocedurer {

    private String title;
    private String info;

    public Arbetsprocedurer()
    {

    }

    public Arbetsprocedurer(String newTitle, String newInfo)
    {
        this.title = newTitle;
        this.info = newInfo;
    }

    public String getTitle()
    {
        return this.title;
    }

    public void setTitle(String newTitle)
    {
        this.title = newTitle;
    }

    public String getInfo()
    {
        return this.info;
    }

    public void setInfo(String newInfo)
    {
        this.info = newInfo;
    }

}
