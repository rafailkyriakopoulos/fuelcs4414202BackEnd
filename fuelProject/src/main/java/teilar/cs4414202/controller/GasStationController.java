package teilar.cs4414202.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import teilar.cs4414202.model.GasStation;
import teilar.cs4414202.model.PriceData;
import teilar.cs4414202.service.GasStationService;

@RestController
public class GasStationController {

	@Autowired
	private GasStationService gasStationService;
	
	//Λήψη δεδομένων πρατηρίων και τιμών επιλεγμένου καυσίμου.
	@GetMapping("/gasstations/pricedata/{fuelTypeID}")
	List<GasStation> getGastationByFuelTypeID(@PathVariable short fuelTypeID){
		return gasStationService.getGasStationByFuelTypeID(fuelTypeID);
	}
	//Λήψη τιμοκαταλόγου ενός πρατηρίου
	@GetMapping("/gasstations/{gasStationID}/pricelist")
	List<PriceData> getPriceList(@PathVariable Long gasStationID){
		return gasStationService.getPriceList(gasStationID);
	}
}
