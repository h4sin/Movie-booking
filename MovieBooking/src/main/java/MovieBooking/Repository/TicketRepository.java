package MovieBooking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import MovieBooking.Models.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
	
}
