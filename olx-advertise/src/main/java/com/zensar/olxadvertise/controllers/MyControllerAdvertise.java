package com.zensar.olxadvertise.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.olxadvertise.entity.Advertise;

@RestController
public class MyControllerAdvertise {
	static List<Advertise> advertiselist = new ArrayList<Advertise>();

	@PostMapping("/advertise")
	public ResponseEntity<Advertise> createAdvertise(@RequestBody Advertise advertise){
	advertiselist.add(advertise);
	return new ResponseEntity<Advertise>(advertise, HttpStatus.CREATED);
	}

	@GetMapping("/advertise/{id}")
	public Advertise getAdvertise(@PathVariable int id) {
		Optional<Advertise> advertise1 = advertiselist.stream().filter(Advertise->Advertise.getCategoryId()==id).findAny();
		
		if(advertise1.isPresent()) {
			return advertise1.get();
		}else {
			return advertise1.orElseGet(()->{return new Advertise();});
		}
		
}
	
	@GetMapping("/user/advertise")
	public List<Advertise> getAllAdvertise(@RequestHeader("anand") String token){
		if(token.equals("anand123")) {
			return advertiselist;	
		}
		else {
			return null;
		}
	}
		
		@GetMapping("/user/advertise/{postid}")
		public Advertise getAdvertise(@PathVariable int postid,@RequestHeader("anand") String token1) {
			if(token1.equals("anand123")) {
				Optional<Advertise> List = advertiselist.stream().filter(Advertise->Advertise.getCategoryId()==postid).findAny();
				
				if(List.isPresent()) {
					return List.get();
				}
				else {
					return List.orElseGet(()->{return new Advertise();});
				}
				
			}
			return null;
		}
		
		@DeleteMapping("/user/advertise/{postid}")
		public Advertise deleteStock (@PathVariable long postid,@RequestHeader("anand") String token2){
			if(token2.equals("anand123")) {
			Optional<Advertise> List1 = advertiselist.stream().filter(Advertise->Advertise.getCategoryId()==postid).findAny();
			
			if(List1.isPresent()) {
				advertiselist.remove(List1);
			}
			else {
				return List1.orElseThrow();
			}
			
		}
			return null;
			
		}
		@GetMapping("/advertise/search/filtercriteria")
		public List<Advertise> getAdvertise(@PathVariable String filtercriteria){
			//Optional<Advertise> searchlist = advertiselist.stream().filter(Advertise->Advertise.getTitle()==filtercriteria).filter(Advertise->Advertise.getTitle()==filtercriteria).findAny();
			for(Advertise advertise:advertiselist) {
				if(advertise.getTitle()==filtercriteria||advertise.getTitle()==filtercriteria||advertise.getDescription()==filtercriteria) {
					return advertiselist;
				}else {
					return null;
				}
			}
			return null;
		}
		
		@GetMapping("advertise/{postid}")
		public Advertise getAdvertise(@PathVariable long postid,@RequestHeader("anand") String token) {
			if(token.equals("anand123")) {
				for(Advertise advertise: advertiselist) {
					if(advertise.getCategoryId()==postid) {
						return advertise;
					}else {
						return null;
					}
				}
			}
			return null;
		}
		
		
	
}
