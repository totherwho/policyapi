package org.climatepolicyradar.policyapi.service;

import org.climatepolicyradar.policyapi.model.SearchResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchServiceTestInt {

    @Autowired
    SearchService searchService;

    @Test
    public void test(){
        SearchResponse searchResponse = searchService.search(Arrays.asList("senegal","wales"));
        System.out.println(searchResponse);
    }

}
