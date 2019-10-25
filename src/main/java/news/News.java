package news;

import java.util.Date;

public class News {

    private int id;
    private String title;
    private String text;
    private Date creationDate;
    private String linkToPicture;
    private Date validFrom;
    private Date validTo;
    private int unOrAllowedRole;

    public News(int id, String title, String text, Date creationDate, String linkToPicture) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.creationDate = creationDate;
        this.linkToPicture = linkToPicture;
    }

    public int getId() {
        return id;
    }
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getLinkToPicture() {
        return linkToPicture;
    }

    public void setLinkToPicture(String linkToPicture) {
        this.linkToPicture = linkToPicture;
    }

}
