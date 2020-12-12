package it.mardev.lastminute.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShoppingBasket implements Printable {

	private List<Article> articles;

	public ShoppingBasket(List<Article> articles) {
		this.articles = articles;
	}

	public ShoppingBasket() {
		this.articles = new ArrayList<Article>();
	}

	public boolean addArticle(Article article) {
		return this.articles.add(article);
	}

	public boolean removeArticle(Article article) {
		return this.articles.remove(article);
	}

	public List<Article> getArticles() {
		return Collections.unmodifiableList(articles);
	}

	@Override
	public String print() {
		// TODO Auto-generated method stub
		return null;
	}

}