package org.springbootrest.crud.article;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServieImpl implements ArticleService {

	@Autowired
	private ArticleRepository repository;

	@Override
	public Article create(Article article) {
		return repository.save(article);
	}

	@Override
	public Article delete(long id) {
		Article article = findById(id);
		if (article != null) {
			repository.delete(article);
		}
		return article;
	}

	@Override
	public List<Article> findAll() {
		return repository.findAll();
	}

	@Override
	public Article findById(long id) {
		Optional<Article> article = repository.findById(id);
		if (!article.isPresent()) {
			return null;
		}
		return article.get();
	}

	@Override
	public Article update(Article article, long id) {
		Article savedArticle = findById(id);
		if (savedArticle == null) {
			return null;
		}
		article.setId(id);
		repository.save(article);
		return article;
	}
}
