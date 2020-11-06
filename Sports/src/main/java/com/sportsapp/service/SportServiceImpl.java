package com.sportsapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.sportsapp.dao.SportRepository;
import com.sportsapp.exceptions.SportNotFoundException;
import com.sportsapp.model.Sports;

@Service
public class SportServiceImpl implements SportService{
	
	@Autowired
	SportRepository sportRepository;

	

	@Override
	public List<Sports> getByStadiumName(String stadiumName) throws SportNotFoundException {
		// TODO Auto-generated method stub
		List<Sports> sportList=sportRepository.getByStadiumName(stadiumName);
		if( sportList.isEmpty()) {
			throw new SportNotFoundException("book not available");
		}
		return sportList;
	}

	@Override
	public List<Sports> getBySportName(String sportName) throws SportNotFoundException {
		List<Sports> sportList=sportRepository.getBySportName(sportName);
		if( sportList.isEmpty()) {
			throw new SportNotFoundException("Game not available");
		}
		return sportList;
	}

	@Override
	public Sports getBySportsId(Integer sportsId) throws SportNotFoundException {
		return sportRepository.findById(sportsId)
				.orElseThrow(()->new SportNotFoundException("ID not available"));
		
	}

	@Override
	public Sports add(Sports sport) {
		Sports newsport= sportRepository.save(sport);
		return newsport;
	}

	@Override
	public Sports updateSports(Sports sport) {
		// TODO Auto-generated method stub
		return sportRepository.save(sport);
	}

	@Override
	public boolean deleteSports(Integer sportsId) throws SportNotFoundException {
		sportRepository.deleteById(sportsId);
		return true;
	}
	@Override
	public List<Sports> getByCity(String city) throws SportNotFoundException {
		List<Sports> sportList=sportRepository.getByCity(city);
		if( sportList.isEmpty()) {
			throw new SportNotFoundException("City not available");
		}
		return sportList;
	}
	@Override
	public List<Sports> getByState(String state) throws SportNotFoundException {
		List<Sports> sportList=sportRepository.getByState(state);
		if( sportList.isEmpty()) {
			throw new SportNotFoundException("State not available");
		}
		return sportList;
	}

	@Override
	public List<Sports> getAllSports() {
		// TODO Auto-generated method stub
		return sportRepository.findAll();
	}

	
	

}
