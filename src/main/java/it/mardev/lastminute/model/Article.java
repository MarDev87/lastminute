package it.mardev.lastminute.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
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
		float salesTax = salesPrice / (100 + getTaxRate()) * getTaxRate();
		salesTax = Math.round(salesTax * 20) / 20;

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
		return String.format("%d %s%s: %.2f", quantity, !imported ? "" : "imported ", name, salesPrice);
	}

}
