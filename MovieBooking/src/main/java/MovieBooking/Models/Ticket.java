package MovieBooking.Models;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "ticket")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ticketId;
	@Column(name="totalticketprice")
	private Integer totalTicketsPrice;
	@Column(name="bookedseats")
	private String bookedSeats;
	@Column(name="bookedat",updatable = false)
	@CreationTimestamp
	private Date bookedAt;

	@ManyToOne
	@JoinColumn(name="show")
	private Show show;

	@ManyToOne
	@JoinColumn(name="user")
	private User user;
}
