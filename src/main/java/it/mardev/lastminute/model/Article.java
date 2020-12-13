package it.mardev.lastminute.model;

import java.util.Locale;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
public class Article implements Taxable, Printable {

	protected int quantity;
	protected String name;
	protected float salesPrice;
	protected boolean imported;

	public Article(int quantity, String name, float salesPrice, boolean imported) {
		super();
		this.quantity = quantity;
		this.name = name.replace("imported", "").replace("  ", " ").trim();
		this.salesPrice = salesPrice;
		this.imported = imported;
	}

	@Override
	public float getSalesTax() {
		float salesTax = salesPrice / (100) * getTaxRate();
		salesTax = ((float) Math.ceil(salesTax * 20)) / 20f;

		return salesTax;
	}

	@Override
	public int getTaxRate() {
		int taxRate = 0;
		taxRate += STANDARD_TAX_RATE;
		if (isImported())
			taxRate += IMPORT_DUTY_RATE;
		return taxRate;
	}

	@Override
	public String print() {
		return String.format(Locale.UK, "%d %s%s: %.2f", quantity, imported ? "imported " : "", name,
				salesPrice + getSalesTax());
	}

}
