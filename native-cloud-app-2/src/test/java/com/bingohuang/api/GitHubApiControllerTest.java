package com.bingohuang.api;

import com.bingohuang.info.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * Author: bingohuang
 * Date: 07/12/2016
 * Time: 16:28
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class GitHubApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testDiscoverUserByScreenName() throws Exception {
        ResponseEntity<User> user1 = restTemplate.getForEntity("http://localhost:" + port + "/v1/user/bingohuang", User.class);
        assertEquals(HttpStatus.OK, user1.getStatusCode());

        ResponseEntity<User> user2 = restTemplate.getForEntity("http://localhost:" + port + "/v1/user/163yun", User.class);
        assertEquals(HttpStatus.OK, user2.getStatusCode());

        ResponseEntity<User> user3 = restTemplate.getForEntity("http://localhost:" + port + "/v1/user/huangqingbing", User.class);
        assertEquals(HttpStatus.OK, user3.getStatusCode());
    }
}
