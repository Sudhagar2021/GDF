package com.book.managent.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.sun.istack.NotNull;

@Entity
@Table(name="book")
public class Book {

	@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	 @Column(length = 150,unique = true) 
	 @NotNull
	private String title;
	 @Column(length = 150) 
	 @NotNull
	private String genre;
	 @Column(length = 150) 
	 @NotNull
	private String pulicationName;
	 @Column(length = 1500) 
	 @NotNull
	private String summary;
	 @ManyToOne(fetch = FetchType.LAZY)
	 private Author author;
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + ((pulicationName == null) ? 0 : pulicationName.hashCode());
		result = prime * result + ((summary == null) ? 0 : summary.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (pulicationName == null) {
			if (other.pulicationName != null)
				return false;
		} else if (!pulicationName.equals(other.pulicationName))
			return false;
		if (summary == null) {
			if (other.summary != null)
				return false;
		} else if (!summary.equals(other.summary))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Book [title=" + title + ", genre=" + genre + ", pulicationName=" + pulicationName + ", summary="
				+ summary + "]";
	}
	public Book(String title, String genre, String pulicationName, String summary) {
		super();
		this.title = title;
		this.genre = genre;
		this.pulicationName = pulicationName;
		this.summary = summary;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getPulicationName() {
		return pulicationName;
	}
	public void setPulicationName(String pulicationName) {
		this.pulicationName = pulicationName;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
}
	