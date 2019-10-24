package news;

public class Greeting {

    private int id;
    private String content;

    public Greeting(int id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}