package com.manager.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.manager.exception.InventoryNotFoundException;

import com.manager.model.Inventory;

@FeignClient(name = "inventory-service", url = "http://localhost:3001/inventory")
public interface InventoryFeignClient {

	@GetMapping("/all")
	public ResponseEntity<List<Inventory>> showAllInventory(@RequestHeader("Authorization") String token);

	@GetMapping("/{id}")
	public ResponseEntity<Inventory> showById(@PathVariable("id") int id, @RequestHeader("Authorization") String token)
			throws InventoryNotFoundException;

	@PostMapping("/addInventory")
	public ResponseEntity<Inventory> addInventory(@RequestBody Inventory inventoryDetails,
			@RequestHeader("Authorization") String token) throws InventoryNotFoundException;

	@PutMapping("/updateInventory")
	public ResponseEntity<Inventory> updateInventory(@RequestBody Inventory inventoryDetails,
			@RequestHeader("Authorization") String token) throws InventoryNotFoundException;

	@DeleteMapping("/deleteInventory/{id}")
	public ResponseEntity<String> deleteInventory(@PathVariable("id") int id,
			@RequestHeader("Authorization") String token) throws InventoryNotFoundException;

}
