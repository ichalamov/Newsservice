package news;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class News {

    private int id;
    private String title;
    private String text;
    private Date creationDate;
    private String linkToPicture;
    private LocalDate validFrom;
    private LocalDate validTo;
    private List<Integer> readStatus;

    public News(int id, String title, String text, Date creationDate, String linkToPicture, LocalDate validFrom, LocalDate validTo, List<Integer> readStatus) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.creationDate = creationDate;
        this.linkToPicture = linkToPicture;
        this.validFrom = validFrom;
        this.validTo = validTo;
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

    public LocalDate getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(LocalDate validFrom) {
        this.validFrom = validFrom;
    }

    public LocalDate getValidTo() {
        return validTo;
    }

    public void setValidTo(LocalDate validTo) {
        this.validTo = validTo;
    }

    public List<Integer> getReadStatus() {
        return readStatus;
    }

    public void setReadStatus(List<Integer> readStatus) {
        this.readStatus = readStatus;
    }
}
