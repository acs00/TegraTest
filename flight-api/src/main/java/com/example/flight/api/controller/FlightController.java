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
		System.out.print(ninetyList);
		List<UberAir> uberList = new ArrayList<>();
		try (CSVReader csvReader = new CSVReader(new FileReader("/csv/uberAir.csv"));) {
		    String[] values = null;
		    while ((values = csvReader.readNext()) != null) {
		    	List<String> list = Arrays.asList(values);
		    	UberAir uberAir = new UberAir(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5),
		    			Double.valueOf(list.get(7)));
		    	uberList.add(uberAir);
//		        records.add(Arrays.asList(values));
		    }
		}
//		TypeReference<List<UberAir>> uberType = new TypeReference<List<UberAir>>() {};
//		inputStream = TypeReference.class.getResourceAsStream("/csv/uberAir.csv");
//		mapper = new ObjectMapper();
//		List<UberAir> uberList = mapper.readValue(inputStream, uberType);
		System.out.print(uberList);
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
