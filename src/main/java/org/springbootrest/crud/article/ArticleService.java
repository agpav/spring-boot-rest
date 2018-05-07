package org.springbootrest.crud.article;

import java.util.List;

public interface ArticleService {

	Article create(Article aticle);

	Article delete(long id);

	List<Article> findAll();

	Article findById(long id);

	Article update(Article article, long id);

}
