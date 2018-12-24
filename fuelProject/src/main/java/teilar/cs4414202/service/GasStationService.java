package teilar.cs4414202.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import teilar.cs4414202.exception.ResourceNotFoundException;
import teilar.cs4414202.model.GasStation;
import teilar.cs4414202.model.PriceData;
import teilar.cs4414202.repository.GasStationRepository;


@Service
public class GasStationService {
	@Autowired
	private GasStationRepository gasStationRepository;
	//Λήψη δεδομένων πρατηρίων και τιμών επιλεγμένου καυσίμου
	public List<GasStation> getGasStationByFuelTypeID(short fuelTypeID){
		return gasStationRepository.findGasStationByFuelTypeId(fuelTypeID);
	}

	//Λήψη τιμοκαταλόγου ενός πρατηρίου.
	public List<PriceData> getPriceList(Long gasStationID) {
		if (!gasStationRepository.existsById(gasStationID)) {
			throw new ResourceNotFoundException("gasstation", "gasStationID", gasStationID);
		}
		return gasStationRepository.findById(gasStationID).get().getPricesData();
	}

}
