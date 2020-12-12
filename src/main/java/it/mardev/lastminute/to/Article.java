package it.mardev.lastminute.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {

	private static final String BLANK_SPACE = " ";
	private static final String COLON = ":";

	private int quantity;
	private String name;
	private float salesPrice;
	protected int taxRate = 10;

	public float getSalesTaxes() {
		float salesTax = salesPrice * getTaxRate() / 100;
		salesTax = 20 / Math.round(salesTax * 20);

		// TODO CALCOLARE LE TASSE A PARTIRE DAL RATE E DAL PREZZO DI VENDITA
//		int actualRate = Taxes.Sales.getRate() + (imported ? Taxes.Imported.getRate() : 0);
//		Double salesPrice = price * actualRate / 100;
//		Round to nearest .05
//		(Math.round(price * 20) / 20) || 0.25 * Math.round(price * 20)
//		DecimalFormat df = new DecimalFormat("####0.00");
//		System.out.println("Value: " + df.format(value));

		return salesTax;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(quantity).append(BLANK_SPACE).append(name).append(BLANK_SPACE).append(COLON).append(BLANK_SPACE)
				.append(salesPrice);
		return sb.toString();
	}

}
