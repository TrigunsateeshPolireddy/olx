package com.zensar.olxmaster.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.olxmaster.entity.Status;

@RestController
public class MyControllerStatus {
	static List<Status> statuslist= new ArrayList<Status>();
	
	static {
		statuslist.add(new Status(1, "OPEN"));
		statuslist.add(new Status(2, "CLOSED"));
		statuslist.add(new Status(3, "OPEN"));
		statuslist.add(new Status(4, "OPEN"));
		statuslist.add(new Status(5, "CLOSED"));
		
		
	}
	@GetMapping("/advertise/status")
	public List<Status> getAllStatus() {
		return statuslist;
	}
	
	

}
