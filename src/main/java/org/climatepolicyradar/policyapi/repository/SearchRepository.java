package org.climatepolicyradar.policyapi.repository;

import org.climatepolicyradar.policyapi.model.Policy;

import java.util.List;

public interface SearchRepository {

    List<Policy> fetch(List<String> terms);

}
