package com.zensar.olxadvertise.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Advertise {
	private String title;
	private long price;
	private String description;
	private int categoryId;

}
