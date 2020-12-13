package it.mardev.lastminute.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DutyFreeArticleTest {

	@Test
	void given_generic_dutyfree__article_not_imported_get_standard_duty_rate_of_0() {
		DutyFreeArticle article = new DutyFreeArticle(1, "generic", 10, false);
		assertEquals(0, article.getTaxRate(), "Standard duty rate should be 10%");
	}

	@Test
	void given_generic_dutyfree_article_imported_get_standard_duty_rate_of_5() {
		DutyFreeArticle article = new DutyFreeArticle(1, "generic", 10, true);
		assertEquals(5, article.getTaxRate(), "Standard duty rate for Imported should be 15%");
	}

	@Test
	void given_generic_dutyfree_article_not_imported_with_sales_price_of_10_get_sales_tax_of_0() {
		DutyFreeArticle article = new DutyFreeArticle(1, "generic", 10, false);
		assertEquals(0, article.getSalesTax(), "Standard Sales Tax should be 0€");
	}

	@Test
	void given_generic_dutyfree_article_imported_with_sales_price_of_21_get_sales_tax_of_1() {
		DutyFreeArticle article = new DutyFreeArticle(1, "generic", 21, true);
		assertEquals(1, article.getSalesTax(), "Standard Sales Tax for Imported should be 1€");
	}

}
