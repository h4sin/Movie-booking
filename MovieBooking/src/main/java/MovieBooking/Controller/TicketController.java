package MovieBooking.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import MovieBooking.Reponse.TicketResponse;
import MovieBooking.Request.TicketRequest;
import MovieBooking.Service.TicketService;

@RestController
@RequestMapping("ticket")
public class TicketController {
	@Autowired
	TicketService ticketService;
	
	@PostMapping("/book")
	public ResponseEntity<Object> ticketBooking (@RequestBody TicketRequest ticketReq){
		try {
			TicketResponse result = ticketService.ticketBooking(ticketReq);
			return new ResponseEntity<>(result,HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
}
