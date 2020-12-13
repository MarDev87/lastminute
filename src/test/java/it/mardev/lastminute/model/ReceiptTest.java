package it.mardev.lastminute.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ReceiptTest {

	@Test
	void given_a_shopping_basket_print_the_correct_receipt() {
		ShoppingBasket sb = new ShoppingBasket();
		sb.addArticle(new Article(1, "generic", 11, false));
		sb.addArticle(new DutyFreeArticle(1, "generic", 21, true));
		Receipt receipt = new Receipt(sb);
		assertEquals("1 generic: 11.00\n1 imported generic: 21.00\nSales Taxes:2.00\nTotal: 32.00", receipt.print());
		receipt.printToConsole();
	}

}