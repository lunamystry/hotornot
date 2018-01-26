package com.bbd;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Version;
import java.net.URL;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Celebrity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	@Version
	@Column(name = "version")
	private int version;

	@Column
	@NotNull
	private String firstname;

	@Column
	@NotNull
	private String lastname;

	@Column
	private URL imageUrl;

	@Column(length = 2000)
	@Size(max = 2000)
	private String bio;

	@Column
	@Min(1)
	@Max(10)
	private Integer rating;

	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(final int version) {
		this.version = version;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Celebrity)) {
			return false;
		}
		Celebrity other = (Celebrity) obj;
		if (id != null) {
			if (!id.equals(other.id)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public URL getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(URL imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (firstname != null && !firstname.trim().isEmpty())
			result += "firstname: " + firstname;
		if (lastname != null && !lastname.trim().isEmpty())
			result += ", lastname: " + lastname;
		if (bio != null && !bio.trim().isEmpty())
			result += ", bio: " + bio;
		if (rating != null)
			result += ", rating: " + rating;
		return result;
	}
}
