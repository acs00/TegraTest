package com.example.flight.api.controller;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.flight.api.model.Airport;
import com.example.flight.api.model.NinetyNinePlanes;
import com.example.flight.api.model.UberAir;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;

@RestController
@RequestMapping("/flight")
public class FlightController {
	@GetMapping
	@RequestMapping("/scale")
	public void getFlights() throws JsonParseException, JsonMappingException, IOException {
		TypeReference<List<NinetyNinePlanes>> ninetyType = new TypeReference<List<NinetyNinePlanes>>() {
		};
		InputStream inputStream = TypeReference.class.getResourceAsStream("/json/99Planes.json");
		ObjectMapper mapper = new ObjectMapper();
		List<NinetyNinePlanes> ninetyList = mapper.readValue(inputStream, ninetyType);
		List<UberAir> uberList = new ArrayList<>();
		try (CSVReader csvReader = new CSVReader(new FileReader("src/main/resources/csv/uberAir.csv"));) {
		    String[] values = null;
		    int i = 0;
		    while ((values = csvReader.readNext()) != null) {
		    	if (i > 0) {
		    		String[] value = values[0].split("[ \t]");
			    	UberAir uberAir = new UberAir(value[0], value[1], value[2], value[3], value[4], value[5],
			    			Double.valueOf(value[6]));
			    	uberList.add(uberAir);
		    	}
		    	i++;
		    }
		}
		
	}

	@GetMapping
	@RequestMapping("/airports")
	public List<Airport> getAirports() throws JsonParseException, JsonMappingException, IOException {
		TypeReference<List<Airport>> typeReference = new TypeReference<List<Airport>>() {
		};
		InputStream inputStream = TypeReference.class.getResourceAsStream("/json/aeroportos.json");
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(inputStream, typeReference);
	}
}
