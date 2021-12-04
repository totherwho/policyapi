package org.climatepolicyradar.policyapi.model;

import java.util.List;
import java.util.Map;

public class SearchResponse {

    private Map<String, Integer> sectors;
    private Integer totalMatches;
    private List<Policy> matches;

    public Map<String, Integer> getSectors() {
        return sectors;
    }

    public void setSectors(Map<String, Integer> sectors) {
        this.sectors = sectors;
    }

    public Integer getTotalMatches() {
        return totalMatches;
    }

    public void setTotalMatches(Integer totalMatches) {
        this.totalMatches = totalMatches;
    }

    public List<Policy> getMatches() {
        return matches;
    }

    public void setMatches(List<Policy> matches) {
        this.matches = matches;
    }
}
