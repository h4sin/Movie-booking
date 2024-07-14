package MovieBooking.Models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "ticket")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Theater {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="name")
	private String name;

	@Column(name="address",unique = true)
	private String address;

	@OneToMany(mappedBy = "theater", cascade = CascadeType.ALL)
	private List<TheaterSeats> theaterSeatList = new ArrayList<>();

	@OneToMany(mappedBy = "theater", cascade = CascadeType.ALL)
	private List<Show> showList = new ArrayList<>();
}
