package com.bingohuang.info;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

/**
 * Author: bingohuang
 * Date: 06/12/2016
 * Time: 11:37
 */
public interface UserRepository extends GraphRepository<User> {
    @Query("MATCH (user:User) WHERE has(user.screenName)\n" +
            "WITH user\n" +
            "ORDER BY user.screenName ASC\n" +
            "SKIP {skip}\n" +
            "LIMIT {limit}\n" +
            "RETURN user")
    Set<User> findAllUsers(@Param("skip") Integer skip, @Param("limit") Integer limit);
}
