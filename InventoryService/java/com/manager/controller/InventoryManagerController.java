package com.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manager.exception.InventoryNotFoundException;
import com.manager.feignclient.InventoryFeignClient;
import com.manager.model.Inventory;

@RestController
@RequestMapping("/manager/inventory")
public class InventoryManagerController {
	@Autowired
	private InventoryFeignClient inventoryClient;

	@GetMapping("/all")
	public ResponseEntity<List<Inventory>> showAllInventory() {
		return inventoryClient.showAllInventory();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Inventory> showInventoryById(@PathVariable("id") int id) throws InventoryNotFoundException {

		return inventoryClient.showById(id);
	}

	@PostMapping("/addInventory")
	public ResponseEntity<Inventory> addInventoryDetails(@RequestBody Inventory inventoryDetails)
			throws InventoryNotFoundException {

		return inventoryClient.addInventory(inventoryDetails);
	}

	@PutMapping("/updateInventory")
	public ResponseEntity<Inventory> updateInventoryDetails(@RequestBody Inventory inventoryDetails)
			throws InventoryNotFoundException {

		return inventoryClient.updateInventory(inventoryDetails);
	}

	@DeleteMapping("/deleteInventory/{id}")
	public ResponseEntity<String> deleteInventoryDetails(@PathVariable("id") int id) throws InventoryNotFoundException {

		return inventoryClient.deleteInventory(id);
	}
}
