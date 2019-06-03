package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class SupplyAux {

	List<Supply> supplies = new ArrayList<Supply>();
}
