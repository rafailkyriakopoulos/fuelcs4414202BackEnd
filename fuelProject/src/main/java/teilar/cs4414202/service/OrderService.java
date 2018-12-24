package teilar.cs4414202.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import teilar.cs4414202.model.Order;
import teilar.cs4414202.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;
	
	public Long addOrder(Order order) {
		return orderRepository.save(order).getOrderID();
	}
	public List<Order> getOrders(Long gasStationID){
		return orderRepository.getOrders(gasStationID);
	}
}
