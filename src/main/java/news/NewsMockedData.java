package news;

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
        news.add(new News(1, "Go up, up and away with your Google Assistant",
                "With holiday travel coming up, and 2018 just around the corner, " +
                        "you may be already thinking about getaways for next year. Consider " +
                        "the Google Assistant your new travel buddy, ready at the drop of a hat—or a passport", new Date(), ""));
        news.add(new News(2, "Get local help with your Google Assistant",
                "No matter what questions you’re asking—whether about local traffic or " +
                        "a local business—your Google Assistant should be able to help. And starting " +
                        "today, it’s getting better at helping you, if you’re looking for nearby services " +
                        "like an electrician, plumber, house cleaner and more", new Date(), ""));
        news.add(new News(3, "The new maker toolkit: IoT, AI and Google Cloud Platform",
                "Voice interaction is everywhere these days—via phones, TVs, laptops and smart home devices " +
                        "that use technology like the Google Assistant. And with the availability of maker-friendly " +
                        "offerings like Google AIY’s Voice Kit, the maker community has been getting in on the action " +
                        "and adding voice to their Internet of Things (IoT) projects.", new Date(), ""));
        news.add(new News(4, "Learn more about the world around you with Google Lens and the Assistant",
                "Looking at a landmark and not sure what it is? Interested in learning more about a movie as " +
                        "you stroll by the poster? With Google Lens and your Google Assistant, you now have a helpful " +
                        "sidekick to tell you more about what’s around you, right on your Pixel.", new Date(), ""));
        news.add(new News(5, "7 ways the Assistant can help you get ready for Turkey Day",
                "Thanksgiving is just a few days away and, as always, your Google Assistant is ready to help. " +
                        "So while the turkey cooks and the family gathers, here are some questions to ask your Assistant.", new Date(), ""));
    }

    // return all news
    public List<News> fetchNews() {
        return news;
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
    public News createNews(int id, String title, String content, Date date, String linkToPicture) {
        News newsArticle = new News(id, title, content, date, "");
        news.add(newsArticle);
        return newsArticle;
    }

    // edit news article
    public News editNewsArticle(int id, String title, String content) {
        for (News n : news) {
            if (n.getId() == id) {
                int blogIndex = news.indexOf(n);
                n.setTitle(title);
                n.setText(content);
                return n;
            }

        }

        return null;
    }

    // delete news article by id
    public boolean delete(int id) {
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
        return true;
    }

}