package com.ssafy.rikey.db.entity;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String nickName;

    private String profile_pic;

    private String greeting;

    private int cumulCarlorie;

    private int cumulDistance;

    private int cumulTime;

    @Enumerated(EnumType.STRING)
    private Area area;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "auth_id", unique = true)
    private Auth auth;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Like> likeArticles = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Article> articles = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<RidingInfo> ridingInfos = new ArrayList<>();
}
