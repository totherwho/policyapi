package org.climatepolicyradar.policyapi.service;

import org.climatepolicyradar.policyapi.model.SearchResponse;

import java.util.List;

public interface SearchService {
    SearchResponse search(List<String> terms);
}
