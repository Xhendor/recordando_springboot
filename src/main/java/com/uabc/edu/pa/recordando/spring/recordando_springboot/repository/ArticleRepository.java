package com.uabc.edu.pa.recordando.spring.recordando_springboot.repository;

import com.uabc.edu.pa.recordando.spring.recordando_springboot.model.Article;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
//Create Read Update Delete (CRUD)
@Repository
public interface ArticleRepository extends CrudRepository<Article, Long> {

    List<Article> findByTitle(String title);
    List<Article> findByCategory(String category);
    List<Article> findDistinctByCategory(String category);
    List<Article> findByTitleAndCategory(String title, String category);
    List<Article> findArticleByArticleIdEqualsAndAndCategory(Long id,String category);

    @Query("SELECT a FROM Article a WHERE a.title=:title and a.category=:category")
    List<Article> fetchArticles(@Param("title") String title,
                                @Param("category") String category);

}

