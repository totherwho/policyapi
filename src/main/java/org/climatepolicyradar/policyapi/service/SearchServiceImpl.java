package org.climatepolicyradar.policyapi.service;

import org.climatepolicyradar.policyapi.model.Policy;
import org.climatepolicyradar.policyapi.model.SearchResponse;
import org.climatepolicyradar.policyapi.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SearchServiceImpl implements SearchService {

    @Autowired
    SearchRepository searchRepository;

    @Override
    public SearchResponse search(List<String> terms) {

        List<Policy> policies = searchRepository.fetch(terms);

        SearchResponse searchResponse = new SearchResponse();
        searchResponse.setTotalMatches(policies.size());
        searchResponse.setMatches(policies);
        return searchResponse;
    }

}
