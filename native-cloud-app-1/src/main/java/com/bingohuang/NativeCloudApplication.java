package com.bingohuang;

import com.bingohuang.info.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Author: bingohuang
 * Date: 07/12/2016
 * Time: 13:48
 */
@SpringBootApplication
@EnableNeo4jRepositories(basePackageClasses = {UserRepository.class})
@EnableTransactionManagement
public class NativeCloudApplication {
    public static void main(String[] args)  {
        SpringApplication.run(NativeCloudApplication.class, args);
    }

}
