package MovieBooking.Models;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import MovieBooking.Enum.Genre;
import MovieBooking.Enum.Language;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Movie")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "moviename", nullable = false)
	private String movieName;
	@Column(name = "duration")
	private int duration;
	@Column(name = "rating", scale = 2)
	private Double rating;
	@Column(name = "releaseDate")
	private Date releaseDate;
	@Enumerated(value = EnumType.STRING)
	@Column(name = "genre")
	private Genre genre;
	@Enumerated(value = EnumType.STRING)
	@Column(name = "language")
	private Language language;
	@OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
	private List<Show> show = new ArrayList<>();
}
