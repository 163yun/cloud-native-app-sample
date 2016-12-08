package com.bingohuang.info;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.kohsuke.github.GitHub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Optional;

/**
 * Author: bingohuang
 * Date: 06/12/2016
 * Time: 11:48
 */
@Service
public class GitHubServiceImpl implements GitHubService {
    private final Log log = LogFactory.getLog(GitHubService.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    private final GitHub github;
    private final UserRepository userRepository;

    @Autowired
    public GitHubServiceImpl(UserRepository userRepository) throws IOException {
        this.github = GitHub.connect();
        this.userRepository = userRepository;
    }

    @Override
    public User discoverUserByScreenName(String screenName) {
        User user = null;

        try {
            user = Optional.of(github.getUser(screenName))
                .map(User::new)
                .get();

            userRepository.save(user);
            log.info(String.format("Discover user: %s", user.getScreenName()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return user;
    }

}
