package it.mardev.lastminute.model;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
public class DutyFreeArticle extends Article {

	public DutyFreeArticle(int quantity, String name, float salesPrice, boolean imported) {
		super(quantity, name, salesPrice, imported);
	}

	@Override
	public int getTaxRate() {
		int taxRate = 0;
		if (isImported())
			taxRate += IMPORT_DUTY_RATE;
		return taxRate;
	}

}
