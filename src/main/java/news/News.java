package news;

import java.util.Date;
import java.util.List;

public class News {

    private int id;
    private String title;
    private String text;
    private Date creationDate;
    private String linkToPicture;
    private Date validFrom;
    private Date validTo;
    private List<Integer> readStatus;

    public News(int id, String title, String text, Date creationDate, String linkToPicture, List<Integer> readStatus) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.creationDate = creationDate;
        this.linkToPicture = linkToPicture;
        this.readStatus = readStatus;
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

    public void setId(int id) {
        this.id = id;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidTo() {
        return validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }

    public List<Integer> getReadStatus() {
        return readStatus;
    }

    public void setReadStatus(List<Integer> readStatus) {
        this.readStatus = readStatus;
    }
}
