package it.mardev.lastminute.model;

public interface Taxable {

	static int STANDARD_TAX_RATE = 10;
	static int IMPORT_DUTY_RATE = 5;

	/**
	 * Return the actual sales tax rate of the article considering
	 * the Standard Tax Rate and Import Duty when applicable
	 * @return the actual Sales Tax Rate
	 */
	public int getTaxRate();

	/**
	 * Return the calculated sales tax.
	 * The rounding rules for sales tax are that for a tax rate of n%,
	 * a shelf price of p contains (np/100 rounded up to the nearest 0.05)
	 * amount of sales tax
	 * 
	 * @return the sales tax
	 */
	public float getSalesTax();
}
