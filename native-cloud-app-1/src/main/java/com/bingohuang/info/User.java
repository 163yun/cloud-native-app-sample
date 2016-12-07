package com.bingohuang.info;

import org.kohsuke.github.GHUser;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

/**
 * Author: bingohuang
 * Date: 06/12/2016
 * Time: 11:33
 */
@NodeEntity
public class User implements Serializable {
    @GraphId
    private Long id;

    private String profileId;

    private String screenName;
    private String name;
    private String url;
    private String profileImageUrl;
    private String description;
    private String location;
    private Date createdDate;
    private Integer followerCount;
    private Integer followsCount;

    public User() {
    }

    public User(Long id, String profileId) {
        this.id = id;
        this.profileId = profileId;
    }

    public User(GHUser ghUser) {
        this.profileId = String.valueOf(ghUser.getId());
        this.screenName = ghUser.getLogin();
        this.url = ghUser.getHtmlUrl().toString();
        this.profileImageUrl = ghUser.getAvatarUrl();
        try {
            this.name = ghUser.getName();
            this.location = ghUser.getLocation();
            this.followerCount = ghUser.getFollowersCount();
            this.followsCount = ghUser.getFollowingCount();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getFollowerCount() {
        return followerCount;
    }

    public void setFollowerCount(Integer followerCount) {
        this.followerCount = followerCount;
    }

    public Integer getFollowsCount() {
        return followsCount;
    }

    public void setFollowsCount(Integer followsCount) {
        this.followsCount = followsCount;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", profileId=" + profileId +
                ", screenName='" + screenName + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", profileImageUrl='" + profileImageUrl + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", createdDate=" + createdDate +
                ", followerCount=" + followerCount +
                ", followsCount=" + followsCount +
                '}';
    }
}
