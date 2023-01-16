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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.manager.exception.RoomNotFoundException;
import com.manager.feignclient.RoomFeignClient;
import com.manager.model.Room;

@RestController
@RequestMapping("/manager/room")
public class RoomManagerController {
	@Autowired
	private RoomFeignClient roomClient;

	@GetMapping("/all")
	public ResponseEntity<List<Room>> showAllRoom(@RequestHeader("Authorization") String token) {
	
		return roomClient.showAllRoom(token);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Room> showRoomById(@PathVariable("id") int id,@RequestHeader("Authorization") String token) throws RoomNotFoundException {
		
		return roomClient.showById(id,token);
	}
	@PostMapping("/addroom")
	public ResponseEntity<Room> addRoomDetails(@RequestBody Room roomDetails,@RequestHeader("Authorization") String token) throws RoomNotFoundException {
	
		return roomClient.addRoomDetails(roomDetails,token);
	}

	@PutMapping("/updateroom")
	public ResponseEntity<Room> updateRoomDetails(@RequestBody Room roomDetails,@RequestHeader("Authorization") String token) throws RoomNotFoundException {
		
		return roomClient.updateRoomDetails(roomDetails,token);
	
	}

	@DeleteMapping("/deleteroom/{id}")
	public ResponseEntity<String> deleteRoomDetails(@PathVariable("id") int id,@RequestHeader("Authorization") String token) throws RoomNotFoundException {
		
		return roomClient.deleteRoomDetails(id,token);
	}

}
