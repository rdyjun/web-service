package dmucs.dmu.crawler;

import org.jsoup.nodes.Document;

public interface Crawler {
    public Document getDocument (String connectURL);
}
