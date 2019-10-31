package news;

import org.springframework.core.io.ClassPathResource;

import java.awt.image.BufferedImage;
import java.util.HashMap;

public class Picture {

    private int id;
    private String pictureName;
    private ClassPathResource pictureData;
    private HashMap<String, String> metaData;

    public Picture(int id, String pictureName, ClassPathResource pictureData, HashMap metaData) {
        this.id = id;
        this.pictureName = pictureName;
        this.pictureData = pictureData;
        this.metaData = metaData;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    public ClassPathResource getPictureData() {
        return pictureData;
    }

    public void setPictureData(ClassPathResource pictureData) {
        this.pictureData = pictureData;
    }

    public HashMap getMetaData() {
        return metaData;
    }

    public void setMetaData(HashMap metaData) {
        this.metaData = metaData;
    }
}
