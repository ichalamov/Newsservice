package data;

import news.News;
import news.Picture;
import org.springframework.core.io.ClassPathResource;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PicturesMockedData {

    //list of news
    private List<Picture> pictures;
    private static PicturesMockedData instance = null;

    public static PicturesMockedData getInstance() throws IOException {
        if (instance == null) {
            instance = new PicturesMockedData();
        }
        return instance;
    }

    public PicturesMockedData() throws IOException {
        pictures = new ArrayList<Picture>();
        HashMap<String, String> pic1 = new HashMap<String, String>() {{ put("File Size","77 kB"); put("Mime Type","image/jpeg"); put("Encoding Process","Baseline DCT, Huffman coding");}};
        HashMap<String, String> pic2 = new HashMap<String, String>() {{ put("File Size","132 kB"); put("Mime Type","image/jpeg"); put("Encoding Process","Baseline DCT, Huffman coding");}};
        HashMap<String, String> pic3 = new HashMap<String, String>() {{ put("File Size","242 kB"); put("Mime Type","image/jpeg"); put("Encoding Process","Baseline DCT, Huffman coding");}};
        HashMap<String, String> pic4 = new HashMap<String, String>() {{ put("File Size","68 kB"); put("Mime Type","image/jpeg"); put("Encoding Process","Baseline DCT, Huffman coding");}};
        HashMap<String, String> pic5 = new HashMap<String, String>() {{ put("File Size","183 kB"); put("Mime Type","image/jpeg"); put("Encoding Process","Progressive DCT, Huffman coding");}};


        pictures.add(new Picture(1, "191022172803-shisalanga-1-exlarge-169.jpg", new ClassPathResource("images/191022172803-shisalanga-1-exlarge-169.jpg"), pic1));
        pictures.add(new Picture(2, "1000x-1.jpg", new ClassPathResource("images/1000x-1.jpg"), pic2));
        pictures.add(new Picture(3, "ai-2.jpg", new ClassPathResource("images/AI-2017.jpg"), pic3));
        pictures.add(new Picture(4, "money-coins-cash-generic.jpg", new ClassPathResource("images/money-coins-cash-generic.jpg"), pic4));
        pictures.add(new Picture(5, "Norway-oil-fund.jpg", new ClassPathResource("images/Norway-oil-fund.jpg"), pic5));

    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }

    // return picture by id
    public Picture getPictureById(int id) {
        for (Picture p : pictures) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
}
