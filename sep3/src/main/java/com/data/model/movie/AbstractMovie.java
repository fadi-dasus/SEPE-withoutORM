package com.data.model.movie;

import java.io.Serializable;

public abstract class AbstractMovie implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	private String name;
	private String director;
	private String discription;
	private String duration;
	private String urlTrailer;
	private String urlFullMovie;
	private String urlImage;
	private String category;

	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public AbstractMovie() {
		
	}
	public AbstractMovie(String name, String director, String discription, String duration, String urlTrailer,
			String urlFullMovie, String urlImage,String category) {
		this.name = name;
		this.director = director;
		this.discription = discription;
		this.duration = duration;
		this.urlTrailer = urlTrailer;
		this.urlFullMovie = urlFullMovie;
		this.urlImage = urlImage;
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getUrlTrailer() {
		return urlTrailer;
	}

	public void setUrlTrailer(String urlTrailer) {
		this.urlTrailer = urlTrailer;
	}

	public String getUrlFullMovie() {
		return urlFullMovie;
	}

	public void setUrlFullMovie(String urlFullMovie) {
		this.urlFullMovie = urlFullMovie;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	@Override
	public String toString() {
		return "AbstractMovie [name=" + name + ", director=" + director + ", discription=" + discription + ", duration="
				+ duration + ", urlTrailer=" + urlTrailer + ", urlFullMovie=" + urlFullMovie + ", urlImage=" + urlImage
				+ "]";
	}

}