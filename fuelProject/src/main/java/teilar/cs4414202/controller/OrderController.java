package teilar.cs4414202.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import teilar.cs4414202.exception.ResourceNotFoundException;
import teilar.cs4414202.model.Order;
import teilar.cs4414202.service.OrderService;
import teilar.cs4414202.service.UserService;


@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private UserService userService;
	
	//Αποστολή δεδομένων παραγγελίας από πλευράς χρήστη (ποσότητα)
	@PostMapping("/orders")
	public String addOrder(@RequestBody Order order) {
		if(!userService.userExist(order.getUser().getUsername())) {
			throw new ResourceNotFoundException("users", "username", order.getUser().getUsername());
		}
		Long orderId = orderService.addOrder(order);
		return "{ \"message\":\"Your order has been stored\","
				+"\"orderID\":\""+orderId+"\""+"}";
	}
	
	//Λήψη παραγγελιών πρατηρίου
	@GetMapping("/orders/{gasStationID}")
	public List<Order> getOrders(@PathVariable Long gasStationID){
		return orderService.getOrders(gasStationID);
	}
}
