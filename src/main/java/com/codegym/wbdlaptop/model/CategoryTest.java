package com.codegym.wbdlaptop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "categoryTest")
public class CategoryTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameCategoryTest;
    private String avatarCategoryTest;
    private String createBy;
    @ManyToOne
    User user;
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "categoryTest_song" ,
            joinColumns = @JoinColumn(name = "categoryTest_id"),
            inverseJoinColumns = @JoinColumn(name = "song_id"))
    private List<Song> songList;

    public CategoryTest() {
    }

    public CategoryTest(Long id, String nameCategoryTest, String avatarCategoryTest, String createBy, User user, List<Song> songList) {
        this.id = id;
        this.nameCategoryTest = nameCategoryTest;
        this.avatarCategoryTest = avatarCategoryTest;
        this.createBy = createBy;
        this.user = user;
        this.songList = songList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameCategoryTest() {
        return nameCategoryTest;
    }

    public void setNameCategoryTest(String nameCategoryTest) {
        this.nameCategoryTest = nameCategoryTest;
    }

    public String getAvatarCategoryTest() {
        return avatarCategoryTest;
    }

    public void setAvatarCategoryTest(String avatarCategoryTest) {
        this.avatarCategoryTest = avatarCategoryTest;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Song> getSongList() {
        return songList;
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
    }
}
