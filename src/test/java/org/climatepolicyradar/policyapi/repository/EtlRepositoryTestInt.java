package org.climatepolicyradar.policyapi.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EtlRepositoryTestInt {

    @Autowired
    EtlRepository etlRepository;

    @Test
    public void test(){

        System.out.println("blah");

//        Integer result = policyRepository.getInt();
//        Assertions.assertEquals(1, result);

    }

}
