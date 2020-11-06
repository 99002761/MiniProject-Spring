package com.sportsapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.sportsapp.exceptions.SportNotFoundException;
import com.sportsapp.model.Sports;
import com.sportsapp.service.SportService;

@RestController
@RequestMapping("/sports-api")
public class SportResponseController {
	@Autowired
	SportService sportService;
	  @PostMapping("/sports")
	    ResponseEntity<Sports> add(@RequestBody Sports sport) {
	        Sports nsport = sportService.add(sport);
	        return ResponseEntity.ok(nsport);

}
	  @DeleteMapping("/sports/delete-one/{sportsId}")
	    ResponseEntity<Void> deleteSports(@PathVariable("sportsId")Integer sportsId) throws SportNotFoundException{
	        sportService.deleteSports(sportsId);
	        return ResponseEntity.status(HttpStatus.OK).build();
	    }
	  @PutMapping("/sports/update-one")
	    ResponseEntity<Sports> updateSports(@RequestBody Sports sport) {
	        Sports nsport = sportService.updateSports(sport);
	        HttpHeaders header = new HttpHeaders();
	        header.add("desc", "Updating sports");
	        header.add("title", "sport name");
	        return ResponseEntity.status(HttpStatus.OK)
	                .headers(header).body(nsport);
	    }
		/*
		 * @PutMapping("/sports/{sportsId}") public ResponseEntity<Sports>
		 * updateSports(@RequestBody Sports sport, @PathVariable Integer sportsId) {
		 * 
		 * List<Sportst> studentOptional = sportRepository.findById(id);
		 * 
		 * if (!studentOptional.isPresent()) return ResponseEntity.notFound().build();
		 * 
		 * student.setId(id);
		 * 
		 * studentRepository.save(sport);
		 * 
		 * return ResponseEntity.noContent().build(); }
		 */
		
		  @GetMapping("/sports")
		  ResponseEntity<List<Sports>> getAllSports(){
		  List<Sports> sportList = sportService.getAllSports();
		  return ResponseEntity.ok(sportList); }
		 
	  @GetMapping("/sports/stadiumName/{stadiumName}")
	    ResponseEntity<List<Sports>> getByStadiumName(@PathVariable("stadiumName")String stadiumName) throws SportNotFoundException{
	        List<Sports> sportList =   sportService.getByStadiumName(stadiumName);
	        return ResponseEntity.ok(sportList);
	    }
	    @GetMapping("/sports/sportName/{sportName}")
	    ResponseEntity<List<Sports>> getBySportName(@PathVariable("sportName")String sportName) throws SportNotFoundException{
	        List<Sports> sportList = sportService.getBySportName(sportName);    
	        return ResponseEntity.ok(sportList);
	    }
	    @GetMapping("/sports/get-one/{sportsId}")
	    ResponseEntity<Sports> getSportById(@PathVariable("sportsId")Integer sportsId) throws SportNotFoundException {
	        Sports nsport = sportService.getBySportsId(sportsId);
	        HttpHeaders header = new HttpHeaders();
	        header.add("desc", "Getting sports by Id");
	        header.add("title", "sport name");
	        return ResponseEntity.status(HttpStatus.OK)
	                .headers(header).body(nsport);
	    }
	    @GetMapping("/sports/city/{city}")
	    ResponseEntity<List<Sports>> getByCity(@PathVariable("city")String city) throws SportNotFoundException{
	        List<Sports> sportList = sportService.getByCity(city);    
	        return ResponseEntity.ok(sportList);
	    }
	    @GetMapping("/sports/state/{state}")
	    ResponseEntity<List<Sports>> getByState(@PathVariable("state")String state) throws SportNotFoundException{
	        List<Sports> sportList = sportService.getByState(state);    
	        return ResponseEntity.ok(sportList);
	    }
}
