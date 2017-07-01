/*
 * Copyright (C) by Courtanet, All Rights Reserved.
 */
package sebapp.server;

import java.util.ArrayList;

public class Article {

    private Long id;
    private String title;
    private ArrayList<String> pictureUrls;
    private ArrayList<String> subtitles;
    private ArrayList<String> keywords;
    private String content;

    public Article(Long id, String title, ArrayList<String> pictureUrls, ArrayList<String> subtitles,
                    ArrayList<String> keywords, String content) {
        this.id = id;
        this.title = title;
        this.pictureUrls = pictureUrls;
        this.subtitles = subtitles;
        this.keywords = keywords;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public Long getId() {
        return id;
    }

    public ArrayList<String> getKeywords() {
        return keywords;
    }

    public ArrayList<String> getPictureUrls() {
        return pictureUrls;
    }

    public ArrayList<String> getSubtitles() {
        return subtitles;
    }

    public String getTitle() {
        return title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setKeywords(ArrayList<String> keywords) {
        this.keywords = keywords;
    }

    public void setPictureUrls(ArrayList<String> pictureUrls) {
        this.pictureUrls = pictureUrls;
    }

    public void setSubtitles(ArrayList<String> subtitles) {
        this.subtitles = subtitles;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
