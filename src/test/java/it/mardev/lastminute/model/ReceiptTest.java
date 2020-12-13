package it.mardev.lastminute.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import it.mardev.lastminute.factory.ArticleFactory;

@ActiveProfiles("test")
@SpringBootTest
class ReceiptTest {

	@Autowired
	private ArticleFactory factory;
	
	@Test
	void given_a_shopping_basket_print_the_correct_receipt() {
		System.out.println("given_a_shopping_basket_print_the_correct_receipt");
		ShoppingBasket sb = new ShoppingBasket();
		sb.addArticle(new Article(1, "generic", 11, false));
		sb.addArticle(new DutyFreeArticle(1, "imported generic", 21, true));
		Receipt receipt = new Receipt(sb);
		assertEquals("1 generic: 12.10\n1 imported generic: 22.05\nSales Taxes:2.15\nTotal: 34.15", receipt.print());
		receipt.printToConsole();
		System.out.println("\n");
	}

	@Test
	void input_1() {
		System.out.println("INPUT 1");
		ShoppingBasket shoppingBasket = new ShoppingBasket();
		shoppingBasket.addArticle(factory.getArticle(1, "book", 12.49f));
		shoppingBasket.addArticle(factory.getArticle(1, "music CD", 14.99f));
		shoppingBasket.addArticle(factory.getArticle(1, "book", 0.85f));
		
		Receipt receipt = new Receipt(shoppingBasket);
		receipt.printToConsole();
		System.out.println("\n");
	}
	
	@Test
	void input_2() {
		System.out.println("INPUT 2");
		ShoppingBasket shoppingBasket = new ShoppingBasket();
		shoppingBasket.addArticle(factory.getArticle(1, "imported box of chocolates", 10.00f));
		shoppingBasket.addArticle(factory.getArticle(1, "imported bottle of perfume", 47.50f));
		
		Receipt receipt = new Receipt(shoppingBasket);
		receipt.printToConsole();
		System.out.println("\n");
	}

	@Test
	void input_3() {
		System.out.println("INPUT 3");
		ShoppingBasket shoppingBasket = new ShoppingBasket();
		shoppingBasket.addArticle(factory.getArticle(1, "imported bottle of perfume", 27.99f));
		shoppingBasket.addArticle(factory.getArticle(1, "bottle of perfume", 18.99f));
		shoppingBasket.addArticle(factory.getArticle(1, "packet of headache pills", 9.75f));
		shoppingBasket.addArticle(factory.getArticle(1, "box of imported chocolates", 11.25f));
		
		Receipt receipt = new Receipt(shoppingBasket);
		receipt.printToConsole();
		System.out.println("\n");
	}
	
}

