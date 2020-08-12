package com.uabc.edu.pa.recordando.spring.recordando_springboot.model;

import lombok.Data;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Data
@Table(name="articles")
public class Article implements Serializable { 
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="article_id")
	private long articleId;
	@Column(name="title")
	private String title;
	@Column(name="category")	
	private String category;
}