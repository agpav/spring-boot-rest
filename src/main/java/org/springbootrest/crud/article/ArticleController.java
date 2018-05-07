package org.springbootrest.crud.article;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/service/articles")
public class ArticleController {

	@Autowired
	private ArticleService service;

	@GetMapping("")
	public List<Article> getAll() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public Article get(@PathVariable long id) throws ArticleNotFoundException {
		Article article = service.findById(id);
		if (article == null) {
			throw new ArticleNotFoundException("id : " + id);
		}
		return article;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) throws ArticleNotFoundException {
		Article article = service.delete(id);
		if (article == null) {
			throw new ArticleNotFoundException("id : " + id);
		}
	}

	@PostMapping("")
	public ResponseEntity<Object> create(@RequestBody Article article) {
		Article savedArticle = service.create(article);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedArticle.getId()).toUri();

		return ResponseEntity.created(location).build();

	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@RequestBody Article article, @PathVariable long id) {
		article = service.update(article, id);
		if (article == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.noContent().build();
	}
}
