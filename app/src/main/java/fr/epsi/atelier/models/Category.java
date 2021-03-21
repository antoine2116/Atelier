package fr.epsi.atelier.models;

import org.json.JSONObject;

public class Category {
    private int id;
    private String title;
    private String url;

    public Category(JSONObject o) {
        this.id = o.optInt("category_id",0);
        this.title = o.optString("title","");
        this.url = o.optString("products_url","");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
