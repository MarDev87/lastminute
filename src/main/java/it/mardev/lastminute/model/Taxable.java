package it.mardev.lastminute.model;

public interface Taxable {

	static int STANDARD_TAX_RATE = 10;
	static int IMPORT_DUTY_RATE = 5;

	public int getTaxRate();

	public float getSalesTax();
}
