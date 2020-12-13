package it.mardev.lastminute.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ArticleTest {

	@Test
	void given_generic_article_not_imported_get_standard_duty_rate_of_10() {
		Article article = new Article(1, "generic", 10, false);
		assertEquals(10, article.getTaxRate(), "Standard duty rate should be 10%");
	}

	@Test
	void given_generic_article_imported_get_standard_duty_rate_of_15() {
		Article article = new Article(1, "generic", 10, true);
		assertEquals(15, article.getTaxRate(), "Standard duty rate for Imported should be 15%");
	}

	@Test
	void given_generic_article_not_imported_with_sales_price_of_11_get_sales_tax_of_1() {
		Article article = new Article(1, "generic", 11, false);
		assertEquals(1, article.getSalesTax(), "Standard Sales Tax should be 1€");
	}

	@Test
	void given_generic_article_imported_with_sales_price_of_23_get_sales_tax_of_3() {
		Article article = new Article(1, "generic", 23, true);
		assertEquals(3, article.getSalesTax(), "Standard Sales Tax for Imported should be 3€");
	}

	@Test
	void given_generic_article_not_imported_should_print() {
		Article article = new Article(1, "generic", 10, false);
		assertEquals("1 generic: 10.00", article.print());
	}

	@Test
	void given_generic_article_imported_should_print() {
		Article article = new Article(1, "generic", 10, true);
		assertEquals("1 imported generic: 10.00", article.print());
	}

}
