package com.bingohuang.api;

import com.bingohuang.info.GitHubService;
import com.bingohuang.info.User;
import com.google.common.base.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

/**
 * GitHub API 接口
 *
 * @author bingohuang
 */
@RestController
@RequestMapping("v1")
public class GitHubApiController {

    private final GitHubService gitHubService;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    public GitHubApiController(GitHubService gitHubService) {
        this.gitHubService = gitHubService;
    }

    @GetMapping("user/{screenName}")
    public ResponseEntity<User> discoverUserByScreenName(@PathVariable("screenName")  String screenName) {
        return Optional.of(ResponseEntity.ok(gitHubService.discoverUserByScreenName(screenName)))
                .or(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }
}
