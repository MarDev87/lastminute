package it.mardev.lastminute;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import it.mardev.lastminute.factory.ArticleFactory;
import it.mardev.lastminute.model.Article;
import it.mardev.lastminute.model.Receipt;
import it.mardev.lastminute.model.ShoppingBasket;

@Profile("!test")
@Component
public class LastMinuteCommandLineRunner implements CommandLineRunner {

	@Autowired
	private ArticleFactory factory;

	private ShoppingBasket shoppingBasket = new ShoppingBasket();

	// Command line application for managing a simple Shopping Basket and printing
	// the receipt with tax calculation
	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		while (true) {

			System.out.println("Please select an operation");
			System.out.println("1: Show Basket");
			System.out.println("2: Add Article");
			System.out.println("3: Remove Article");
			System.out.println("4: Print Receipt");
			System.out.println("5: Empty Basket");
			System.out.println("9: Exit");

			String choice = scanner.nextLine();
			try {
				int intChoice = Integer.parseInt(choice);
				switch (intChoice) {
				case 1:
					System.out.println(shoppingBasket.printWithLineNumber());
					break;
				case 2:
					Article article = readArticle(scanner);
					if (article != null) {
						shoppingBasket.addArticle(article);
					}
					break;
				case 3:
					removeArticle(scanner);
					break;
				case 4:
					Receipt receipt = new Receipt(shoppingBasket);
					receipt.printToConsole();
					break;
				case 5:
					shoppingBasket = new ShoppingBasket();
					System.out.println("Basket emptied");
					break;
				case 9:
					System.out.println("Closing program");
					scanner.close();
					return;
				default:
					System.err.println("Choice incorrect!!!");
					break;
				}
			} catch (Exception e) {
				System.err.println("Choice incorrect!!!");
			}
		}

	}

	private void removeArticle(Scanner scanner) {
		System.out.print("\nInsert article number:");
		String index = scanner.nextLine();
		if (index.equalsIgnoreCase("EXIT")) {
			System.out.println("Operation aborted");
		}
		try {
			int iIndex = Integer.parseInt(index) - 1;
			if (iIndex > shoppingBasket.getArticles().size()) {
				System.err.println("Invalid line inserted");
				removeArticle(scanner);
			} else {
				System.out.println("Article removed");
				System.out.println(shoppingBasket.removeArticle(iIndex).print());
			}
		} catch (Exception e) {
			System.err.println("Invalid line inserted");
			removeArticle(scanner);
		}
	}

	private Article readArticle(Scanner scanner) {
		System.out.print("\nInsert article name or 'EXIT' to return to menu:");
		String name = scanner.nextLine();
		if (name.equalsIgnoreCase("EXIT")) {
			System.out.println("Operation aborted");
			return null;
		}
		float salesPrice = getPrice(scanner);
		if (salesPrice == -1) {
			System.out.println("Operation aborted");
			return null;
		}
		return factory.getArticle(1, name, salesPrice);
	}

	private float getPrice(Scanner scanner) {
		System.out.print("\nInsert sales price [###,##] or 'EXIT' to return to menu");
		String salesPrice = scanner.nextLine();
		if (salesPrice.equalsIgnoreCase("EXIT")) {
			return -1;
		}
		try {
			float fSalesPrice = Float.parseFloat(salesPrice);
			return fSalesPrice;
		} catch (Exception e) {
			System.err.println("Invalid format inserted");
			getPrice(scanner);
		}
		return -1;
	}

}
