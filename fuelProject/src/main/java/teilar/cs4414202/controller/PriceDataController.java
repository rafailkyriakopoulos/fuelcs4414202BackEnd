package teilar.cs4414202.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import teilar.cs4414202.exception.ResourceNotFoundException;
import teilar.cs4414202.model.PriceData;
import teilar.cs4414202.service.PriceDataService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class PriceDataController {

	@Autowired
	private PriceDataService priceDataService;
	
	//Αλλαγή τιμής σε καύσιμο
	@PutMapping("/pricedata/{productID}")
	public String updatePriceData(@PathVariable Long productID,@RequestBody PriceData priceData) {
		if(!priceDataService.existsById(productID)) {
			throw new ResourceNotFoundException("pricedata", "productID", productID);
		}
		priceDataService.save(priceData);
		return "{ \"message\":\"Your order has been updated\","
				+"\"orderID\":\""+productID+"\""+"}";
	}
	
}
