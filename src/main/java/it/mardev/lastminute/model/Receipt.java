package it.mardev.lastminute.model;

import java.util.Locale;

public class Receipt implements Printable {

	private ShoppingBasket shoppingBasket;
	private float total;
	private float salesTaxes;

	public Receipt(ShoppingBasket shoppingBasket) {
		this.shoppingBasket = shoppingBasket;
		this.total = 0;
		for (Article article : shoppingBasket.getArticles()) {
			float artSalesTaxes = article.getSalesTax();
			salesTaxes += artSalesTaxes;
			total += article.getSalesPrice() + artSalesTaxes;
		}
	}

	@Override
	public String print() {
		StringBuilder sb = new StringBuilder();
		sb.append(shoppingBasket.print());
		sb.append(String.format(Locale.UK, "Sales Taxes:%.2f\n", salesTaxes));
		sb.append(String.format(Locale.UK, "Total: %.2f", total));
		return sb.toString();
	}

	public void printToConsole() {
		System.out.println(print());
	}

}
