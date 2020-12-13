package it.mardev.lastminute.model;

import java.util.Locale;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
public class Article implements Taxable, Printable {

	protected int quantity;
	protected String name;
	protected float salesPrice;
	protected boolean imported;

	@Override
	public float getSalesTax() {
		// TODO CALCOLARE LE TASSE A PARTIRE DAL RATE E DAL PREZZO DI VENDITA
		float salesTax = salesPrice / (100) * getTaxRate();
		salesTax = Math.round(salesTax * 20) / 20f;

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
		return String.format(Locale.UK, "%d %s%s: %.2f", quantity, !imported ? "" : "imported ", name,
				salesPrice + getSalesTax());
	}

}
