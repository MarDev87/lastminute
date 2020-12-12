package it.mardev.lastminute.model;

import java.util.List;

public class Receipt implements Printable {

	private static final String NEW_LINE = "\n";
	private static final String SALES_TAXES = "Sales Taxes";
	private static final String TOTAL = "Total";
	private static final String BLANK_SPACE = " ";
	private static final String COLON = ":";

	private List<Article> articles;
	private float total;
	private float salesTaxes;
	@Override
	public String print() {
		// TODO Auto-generated method stub
		return null;
	}

}
