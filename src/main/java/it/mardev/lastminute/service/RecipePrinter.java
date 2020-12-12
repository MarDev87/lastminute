package it.mardev.lastminute.service;

import java.util.List;

import org.springframework.stereotype.Service;

import it.mardev.lastminute.to.Article;
import it.mardev.lastminute.to.Receipt;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RecipePrinter {

	public Receipt printReceipt(List<Article> articles) {
		log.debug("Creating receipt for articles\n" + articles);
		Receipt receipt = new Receipt(articles);
		log.debug(receipt.toString());
		return receipt;
	}

}
