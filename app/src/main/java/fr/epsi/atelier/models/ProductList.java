package fr.epsi.atelier.models;

import org.json.JSONObject;

import java.util.Optional;

public class ProductList {
    private String name;
    private String description;
    private String pictureUrl;

    public ProductList(JSONObject o) {
        name = o.optString("name", "");
        description = o.optString("description", "");
        pictureUrl = o.optString("picture_url", "");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
}
