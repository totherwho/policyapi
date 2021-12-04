package org.climatepolicyradar.policyapi.model;

import java.util.List;

public class Policy {

    private String id;
    private String title;
    private List<String> sectors;
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getSectors() {
        return sectors;
    }

    public void setSectors(List<String> sectors) {
        this.sectors = sectors;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
