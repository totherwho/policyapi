package org.climatepolicyradar.policyapi.repository;

import org.climatepolicyradar.policyapi.model.Policy;
import org.climatepolicyradar.policyapi.model.PolicySector;

import java.util.List;

public interface EtlRepository {
    void flush();
    void savePolicies(List<Policy> policies);
    void savePolicySectors(List<PolicySector> policySectors);
}
