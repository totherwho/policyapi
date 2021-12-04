package org.climatepolicyradar.policyapi.api;

import org.climatepolicyradar.policyapi.model.SearchResponse;
import org.climatepolicyradar.policyapi.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value = "/policyapi/", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class SearchController {

    @Autowired
    SearchService searchService;

    @GetMapping(value = "search")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<SearchResponse> runPreEtl(@RequestParam(value = "terms", required = false, defaultValue = "") List<String> terms) {
        return new ResponseEntity<SearchResponse>(
                searchService.search(terms),
                HttpStatus.OK
        );
    }
}
