package it.mardev.lastminute.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;

class ShoppingBasketTest {

	@Test
	void given_a_shopping_basket_return_unmodifiable_article_list() {
		ShoppingBasket basket = new ShoppingBasket();
		List<Article> articles = basket.getArticles();
		assertThrows(UnsupportedOperationException.class, () -> articles.add(new Article(0, null, 0, false)),
				"The list should not be editable");
	}

	@Test
	void given_a_shopping_basket_print_the_articles_list() {
		ShoppingBasket basket = new ShoppingBasket();
		basket.addArticle(new Article(1, "generic", 10, true));
		basket.addArticle(new Article(1, "generic", 12, false));
		assertEquals("1 imported generic: 10.00\n1 generic: 12.00\n", basket.print());
	}

}
