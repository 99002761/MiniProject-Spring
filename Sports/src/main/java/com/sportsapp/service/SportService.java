package com.sportsapp.service;

import java.util.List;


import com.sportsapp.exceptions.SportNotFoundException;
import com.sportsapp.model.Sports;

public interface SportService {
	List<Sports> getAllSports();

	List<Sports> getByStadiumName(String stadiumName) throws SportNotFoundException;
	List<Sports> getBySportName(String sportName) throws SportNotFoundException;
	Sports getBySportsId(Integer sportsId) throws SportNotFoundException;

	List<Sports> getByCity(String city) throws SportNotFoundException;

	List<Sports> getByState(String state) throws SportNotFoundException;
	Sports add(Sports sport);
	Sports updateSports(Sports sport);
	boolean deleteSports (Integer sportsId) throws SportNotFoundException;
	


}
