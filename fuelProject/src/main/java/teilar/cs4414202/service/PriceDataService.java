package teilar.cs4414202.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import teilar.cs4414202.model.PriceData;
import teilar.cs4414202.repository.PriceDataRepository;

@Service
public class PriceDataService {
	@Autowired
	private PriceDataRepository priceDataRepository;
	
	public boolean existsById(Long productID) {
		return priceDataRepository.existsById(productID);
	}
	
	public void save(PriceData priceData) {
		priceDataRepository.save(priceData);
	}
	
}
