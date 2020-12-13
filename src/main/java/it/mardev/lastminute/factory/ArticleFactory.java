package it.mardev.lastminute.factory;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import it.mardev.lastminute.model.Article;
import it.mardev.lastminute.model.DutyFreeArticle;

@Component
public class ArticleFactory {

	@Value("#{'${products.dutyfree}'.split(',')}")
	private List<String> dutyFree;

	/**
	 * Return an article instance with different tax rate following the schema:\n
	 * Basic sales tax is applicable at a rate of 10% on all goods, except books,
	 * food, and medical products that are exempt. Import duty is an additional
	 * sales tax applicable on all imported goods at a rate of 5%, with no
	 * exemptions
	 * 
	 * @param quantity   Article quantity
	 * @param name       Article name
	 * @param salesPrice Sales Price tax excluded
	 * @return An article instance with correct tax calculation and normalized name
	 */
	public Article getArticle(int quantity, String name, float salesPrice) {
		Article article = null;
		String lcName = name.toLowerCase();

		if (isDutyFree(lcName)) {
			article = new DutyFreeArticle(quantity, name, salesPrice, isImported(lcName));
		} else {
			article = new Article(quantity, name, salesPrice, isImported(lcName));
		}

		return article;
	}

	protected boolean isImported(String lcName) {
		return lcName.contains("imported");
	}

	private boolean isDutyFree(String lcName) {
		for (String category : dutyFree) {
			if (lcName.contains(category))
				return true;
		}
		return false;
	}

}
