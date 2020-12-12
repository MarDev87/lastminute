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
