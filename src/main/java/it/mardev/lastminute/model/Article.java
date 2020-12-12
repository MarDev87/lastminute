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
		salesTax = 20 / Math.round(salesTax * 20);

//		int actualRate = Taxes.Sales.getRate() + (imported ? Taxes.Imported.getRate() : 0);
//		Double salesPrice = price * actualRate / 100;
//		Round to nearest .05
//		(Math.round(price * 20) / 20) || 0.25 * Math.round(price * 20)
//		DecimalFormat df = new DecimalFormat("####0.00");
//		System.out.println("Value: " + df.format(value));

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
		return String.format("%d %s %s: %f", quantity, !imported ? "" : "imported", name, salesPrice);
	}

}
