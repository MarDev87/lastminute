package it.mardev.lastminute.to;

import java.util.Collections;
import java.util.List;

public class Receipt {

	private static final String NEW_LINE = "\n";
	private static final String SALES_TAXES = "Sales Taxes";
	private static final String TOTAL = "Total";
	private static final String BLANK_SPACE = " ";
	private static final String COLON = ":";

	private List<Article> articles;
	private float total;
	private float salesTaxes;

	public Receipt(List<Article> articles) {
		this.articles = articles;
		total = 0;
		salesTaxes = 0;
		// CALCULATING RECEIPT TOTAL AND SALES TAXES
		for (Article article : articles) {
			total += article.getSalesPrice();
			salesTaxes += article.getSalesTaxes();
		}
	}

	// GET METHOD FOR IMMUTABLE CLASS
	public List<Article> getArticles() {
		return Collections.unmodifiableList(articles);
	}

	public float getTotal() {
		return total;
	}

	public float getSalesTaxes() {
		return salesTaxes;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Article article : articles) {
			sb.append(article).append(NEW_LINE);
		}
		sb.append(SALES_TAXES).append(BLANK_SPACE).append(COLON).append(BLANK_SPACE).append(salesTaxes)
				.append(NEW_LINE);
		sb.append(TOTAL).append(BLANK_SPACE).append(COLON).append(BLANK_SPACE).append(total).append(NEW_LINE);
		return sb.toString();
	}

}
