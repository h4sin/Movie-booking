package MovieBooking.Models;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="show")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Show {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="time")
	private Time time;
	@Column(name="date")
	private Date date;
	@ManyToOne
	@JoinColumn(name="movieid")
	private Movie movie;
	@ManyToOne
	@JoinColumn(name="theaterid")
	private Theater theater;
	@OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
	private List<ShowSeats> showSeat = new ArrayList<>();
	@OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
	private List<Ticket> Ticket = new ArrayList<>();
}
