package OnLine_Book_Shop;

import java.io.Serializable;
import java.time.LocalDate;

public class Book implements Serializable 
{
	public enum Category 
	{
	    FICTION, NON_FICTION, THRILLER, ROMANCE, SCIENCE_FICTION
	}
	private static final long serialVersionUID = 1L;

	private String title;
	private String author;
	private double price;
	private Category category;
	private LocalDate publishDate;

	public Book(String title, String author, double price, Category category, LocalDate publishDate) {
		this.title = title;
		this.author = author;
		this.price = price;
		this.category = category;
		this.publishDate = publishDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public LocalDate getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}

	@Override
	public String toString() {
		return "Title: " + title + ", Author: " + author + ", Price: $" + price + ", Category: " + category
				+ ", Publish Date: " + publishDate;
	}
}




