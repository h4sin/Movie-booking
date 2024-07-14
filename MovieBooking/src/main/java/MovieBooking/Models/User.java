package MovieBooking.Models;

import java.util.ArrayList;
import java.util.List;

import MovieBooking.Enum.Gender;
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
@Table(name="user")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="name",nullable = false)
	private String name;
	@Column(name="age")
	private int age;
	@Column(name="address")
	private String address;
	@Column(name="gender")
	@Enumerated(value=EnumType.STRING)
	private Gender gender;
	@Column(name="mobileNumber")
	private String mobileNumber;
	@Column(name="emailId",unique = true)
	private String emailId;
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<Ticket>ticketList = new ArrayList<>();
}
