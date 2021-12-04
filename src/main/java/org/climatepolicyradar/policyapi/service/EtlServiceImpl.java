package org.climatepolicyradar.policyapi.service;

import com.opencsv.CSVReader;
import org.climatepolicyradar.policyapi.model.Policy;
import org.climatepolicyradar.policyapi.model.PolicySector;
import org.climatepolicyradar.policyapi.repository.EtlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EtlServiceImpl implements EtlService {

    @Autowired
    EtlRepository etlRepository;

    @PostConstruct
    public void init() throws Exception {
        List<Policy> policyList = new ArrayList<>();

        CSVReader csvReader = new CSVReader(new FileReader("src/main/resources/policies.csv"));
        csvReader.skip(1);

        String[] values;
        while ((values = csvReader.readNext()) != null) {

            // TODO consider streaming direct to DB with batching rather than loading the entire dataset into memory

            Policy policy = new Policy();
            policy.setId(values[0]);
            policy.setTitle(values[1]);
            policy.setSectors(Arrays.asList(values[2].split(";"))); // assumes its safe to delimit on `;`
            policy.setDescription(values[3]);

            policyList.add(policy);
        }

        List<PolicySector> policySectors =
                policyList.stream()
                        .flatMap(policy -> policy.getSectors().stream().map(sector-> new PolicySector(policy.getId(), sector)))
                        .collect(Collectors.toList());

        etlRepository.flush();
        etlRepository.savePolicies(policyList);
        etlRepository.savePolicySectors(policySectors);
    }

}
