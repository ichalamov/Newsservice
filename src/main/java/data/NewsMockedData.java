package data;

import news.News;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewsMockedData {
    //list of news
    private List<News> news;

    private static NewsMockedData instance = null;

    public static NewsMockedData getInstance() {
        if (instance == null) {
            instance = new NewsMockedData();
        }
        return instance;
    }


    public NewsMockedData() {
        news = new ArrayList<News>();
        news.add(new News(1, "Recycled plastic milk bottles to repave roads in South Africa.",
                "Plastic milk bottles are being recycled to make roads in South Africa, " +
                        "with the hope of helping the country tackle its waste problem and improve the quality of its roads. " +
                        "Potholes cost the country's road users an estimated $3.4 billion per year in vehicle repairs.", new Date(), "http://localhost:8080/picture/1", new ArrayList<Integer>()));
        news.add(new News(2, "General Electric is weathering a stormy environment better than feared",
                "Prompting the struggling conglomerate to boost its guidance " +
                        "Despite the US-China trade war and its exposure to the Boeing 737 Max crisis, " +
                        "GE (GE) posted adjusted profit and revenue on Wednesday that topped expectations. " +
                        "The maker of jet engines, MRI machines and light bulbs also stopped burning through cash.", new Date(), "http://localhost:8080/picture/2", new ArrayList<Integer>()));
        news.add(new News(3, "The new maker toolkit: IoT, AI and Google Cloud Platform",
                "Voice interaction is everywhere these days—via phones, TVs, laptops and smart home devices " +
                        "that use technology like the Google Assistant. And with the availability of maker-friendly " +
                        "offerings like Google AIY’s Voice Kit, the maker community has been getting in on the action " +
                        "and adding voice to their Internet of Things (IoT) projects.", new Date(), "http://localhost:8080/picture/3", new ArrayList<Integer>()));
        news.add(new News(4, "De La Rue Plc can’t Stop Losing Money For Its Shareholders",
                "De La Rue Plc shares plummeted again on Wednesday. " +
                        "The stock has now lost about 80% of its market value in two years after the loss of a major contract. " +
                        "It didn’t provide a reason and a spokesman declined to comment further when contacted by Bloomberg.", new Date(), "http://localhost:8080/picture/4", new ArrayList<Integer>()));
        news.add(new News(5, "CEO of Norway’s $1 Trillion Wealth Fund to Resign",
                "The chief executive officer of Norway’s sovereign wealth fund, Yngve Slyngstad, " +
                        "is stepping down after spending the past 12 years building a $1.1 trillion fortune.", new Date(), "http://localhost:8080/picture/5", new ArrayList<Integer>()));
    }

    // return all news which are not yet read by the user
    public List<News> fetchNews(int userId) {
        List<News> actualNewsForUser = new ArrayList<News>();
        for (int i=0; i<news.size(); i++) {
            if (!news.get(i).getReadStatus().contains(userId)) {
                actualNewsForUser.add(news.get(i));
            }
        }
        return actualNewsForUser;
    }

    // return news article by id
    public News getNewsById(int id) {
        for (News n : news) {
            if (n.getId() == id) {
                return n;
            }
        }
        return null;
    }

    // create news article
    public News createNews(int id, String title, String content, Date date, String linkToPicture, List<Integer> readStatus) {
        News newsArticle = new News(id, title, content, date, "", readStatus);
        news.add(newsArticle);
        return newsArticle;
    }

    // edit news article
    public News editNewsArticle(int id, String title, String content, String linkToPicture) {
        for (News n : news) {
            if (n.getId() == id) {
        //      int newsArticleIndex = news.indexOf(n);
                n.setTitle(title);
                n.setText(content);
                n.setLinkToPicture(linkToPicture);
                return n;
            }

        }

        return null;
    }

    // delete news article by id
    public String delete(int id) {
        int newsIndex = -1;
        for (News n : news) {
            if (n.getId() == id) {
                newsIndex = news.indexOf(n);
                continue;
            }
        }
        if (newsIndex > -1) {
            news.remove(newsIndex);
        }
        return "Article deleted succesfully.";
    }

}