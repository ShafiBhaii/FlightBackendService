package com.project.FlightBackendService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin
@RestController
public class FlightController {
	@Autowired
	private FlightRepo fRepo;
	
	@GetMapping("/api/flight/{id}")
	public FlightModel getFlight(@PathVariable("id") Integer id){
		return fRepo.findById(id).get();
	}
	
	@GetMapping("/api/flight")
	public List<FlightModel> getFlights() {
		return fRepo.findAll();
	}
	
	@PostMapping("/api/flight")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public FlightModel addFlight(@RequestBody FlightModel fm) {
		if(fm.getFlightNo()==0) {
			int c = (int)fRepo.count() + 1;
			fm.setFlightNo(c);
		}
		fRepo.save(fm);
		return fm;
	}
	
	@DeleteMapping("/api/flight/{id}")
	public List<FlightModel> deleteFlightById(@PathVariable("id") Integer id){
		fRepo.deleteById(id);
		return fRepo.findAll();
	}
	
	@DeleteMapping("/api/flight")
	public List<FlightModel> deleteAllFlight() {
		fRepo.deleteAll();
		return fRepo.findAll();
	}
	
	@GetMapping("/api/flight/{source}/{dest}/{date}")
	public List<FlightModel> search(@PathVariable("source") String source,
			@PathVariable("dest") String dest,
			@PathVariable("date") String date) throws ParseException {
		SimpleDateFormat format1=new SimpleDateFormat("yyyy-MM-dd");
		Date dt1=format1.parse(date);
		DateFormat format2=new SimpleDateFormat("EEEE"); 
		String day=format2.format(dt1);
		
		List<FlightModel> all = fRepo.findAll();
		List<FlightModel> finalFlights = new ArrayList<FlightModel>();
		
		for(FlightModel fm : all) {
			if(fm.getSource().equals(source) &&
					fm.getDestination().equals(dest)) {
				finalFlights.add(fm);
			}
		}
		
		return finalFlights;		
	}
}
