package com.codewithtanya.blog.entities;

import jakarta.annotation.Generated;
import jakarta.persistence.*;

import javax.xml.crypto.Data;
import java.util.Date;

@Entity
@Table
public class Post {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;
@Column(nullable = false)
    private String title;
@Column(length = 10000)
    private String Content;
    private String imageName;
 private Date addedDate;

 @ManyToOne
 @JoinColumn(name="category_id")
 private Category category;
 @ManyToOne
 private User user;

}
