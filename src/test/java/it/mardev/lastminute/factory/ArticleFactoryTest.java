package it.mardev.lastminute.factory;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import it.mardev.lastminute.model.Article;
import it.mardev.lastminute.model.DutyFreeArticle;

@ActiveProfiles("test")
@SpringBootTest
class ArticleFactoryTest {

	@Autowired
	private ArticleFactory articleFactory;

	@Test
	void given_a_chocolate_chips_article_should_return_dutyfreearticle_instance() {
		Article art = articleFactory.getArticle(1, "chocolate chips", 15.20f);
		assertThat(art, instanceOf(DutyFreeArticle.class));
	}

	@Test
	void given_a_book_article_should_return_dutyfreearticle_instance() {
		Article art = articleFactory.getArticle(1, "tascable book", 15.20f);
		assertThat(art, instanceOf(DutyFreeArticle.class));
	}

	@Test
	void given_a_headache_pill_article_should_return_dutyfreearticle_instance() {
		Article art = articleFactory.getArticle(1, "headache pills", 15.20f);
		assertThat(art, instanceOf(DutyFreeArticle.class));
	}

	@Test
	void given_a_perfume_article_should_return_article_instance() {
		Article art = articleFactory.getArticle(1, "perfume bottle", 15.20f);
		assertThat(art, not(instanceOf(DutyFreeArticle.class)));
	}

	@Test
	void given_a_cd_article_should_return_article_instance() {
		Article art = articleFactory.getArticle(1, "artist cd", 15.20f);
		assertThat(art, not(instanceOf(DutyFreeArticle.class)));
	}

}
