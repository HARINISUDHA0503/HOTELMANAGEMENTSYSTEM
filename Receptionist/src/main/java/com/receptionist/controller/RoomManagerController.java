package com.receptionist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.receptionist.exception.RoomNotFoundException;
import com.receptionist.feignclient.RoomFeignClient;
import com.receptionist.model.Room;

@RestController
@RequestMapping("/receptionist/room")
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

}