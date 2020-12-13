package it.mardev.lastminute;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import it.mardev.lastminute.model.Article;
import it.mardev.lastminute.model.Receipt;
import it.mardev.lastminute.model.ShoppingBasket;

@Profile("!test")
@Component
public class LastMinuteCommandLineRunner implements CommandLineRunner {

	private ShoppingBasket shoppingBasket = new ShoppingBasket();
	
	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		while (true) {

			System.out.println("Please select an operation");
			System.out.println("1: Show Basket");
			System.out.println("2: Add Article");
			System.out.println("3: Remove Article");
			System.out.println("4: Print Receipt");
			System.out.println("5: Exit");

			String choice = scanner.next();
			try {
				int intChoice = Integer.parseInt(choice);
				switch (intChoice) {
				case 1:
					shoppingBasket.print();
					break;
				case 2:
					shoppingBasket.addArticle(readArticle(scanner));
					break;
				case 3:
					shoppingBasket.removeArticle(removeArticle(scanner));
					break;
				case 4:
					Receipt receipt = new Receipt(shoppingBasket);
					receipt.printToConsole();
					break;
				case 5:
					System.out.println("Closing program");
					return;
				default:
					System.out.println("Choice incorrect!!!");
					break;
				}
			} catch (Exception e) {
				System.out.println("Choice incorrect!!!");
			}
		}

	}

	private Article removeArticle(Scanner scanner) {
		// TODO Auto-generated method stub
		return null;
	}

	private Article readArticle(Scanner scanner) {
		// TODO Auto-generated method stub
		return null;
	}

}
