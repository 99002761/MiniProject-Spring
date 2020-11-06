package com.sportsapp.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sportsapp.model.Sports;


@Repository
public interface SportRepository extends MongoRepository<Sports,Integer>{
	List<Sports> getByStadiumName(String stadiumName);
	List<Sports> getBySportName(String sportName);
	Sports getBySportsId(Integer sportsId);
	//List<Sports> getAllSports();
	List<Sports> getByCity(String city);
	List<Sports> getByState(String state);

}
