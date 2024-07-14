package MovieBooking.Models;

import MovieBooking.Enum.SeatType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "showseats")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShowSeats {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="seatnumber")
	private String seatNumber;

	@Enumerated(value = EnumType.STRING)
	@Column(name="seattype")
	private SeatType seatType;
	@Column(name="price")
	private Integer price;
	@Column(name="isavailable")
	private Boolean isAvailable;
	@Column(name="isfoodcontains")
	private Boolean isFoodContains;

	@ManyToOne
	@JoinColumn(name="show")
	private Show show;
}
