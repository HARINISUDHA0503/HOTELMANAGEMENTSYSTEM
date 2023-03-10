package com.roomservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.roomservice.exception.RoomNotFoundException;
import com.roomservice.model.Room;
import com.roomservice.repository.RoomRepository;
import com.roomservice.service.RoomServiceImplementation;

@SpringBootTest
class RoomServiceApplicationTests {

	@Autowired
	private RoomServiceImplementation service;

	@MockBean
	private RoomRepository roomRepository;

	@Test
	public void ShowAllRoomTest() {
		List<Room> room = new ArrayList<>();
		Room r = new Room();

		r.setRoomNumber(1);
		r.setRoomStatus(true);
		r.setTotalRooms(100);

		room.add(r);

		when(roomRepository.findAll()).thenReturn(room);
		assertEquals(1, service.showAllRoom().size());
	}

	@Test
	public void ShowRoomById() throws RoomNotFoundException {

		Room r = new Room();

		r.setRoomNumber(1);
		r.setRoomStatus(true);
		r.setTotalRooms(100);

		Optional<Room> room = Optional.of(r);
		when(roomRepository.findById(1)).thenReturn(room);
		assertEquals(r, service.showRoomById(1));

	}

	@Test

	public void addRoomTest() throws RoomNotFoundException {

		Room r = new Room();

		r.setRoomNumber(1);
		r.setRoomStatus(true);
		r.setTotalRooms(100);

		when(roomRepository.insert(r)).thenReturn(r);
		assertEquals(r, service.addRoom(r));

	}

	@Test
	public void updateRoomTest() throws RoomNotFoundException {
		Room r1 = new Room();
		Room r2 = new Room();

		r1.setRoomNumber(1);
		r1.setRoomStatus(true);
		r1.setTotalRooms(100);

		r2.setRoomNumber(1);
		r2.setRoomStatus(true);
		r2.setTotalRooms(100);

		Optional<Room> room = Optional.of(r1);

		when(roomRepository.findById(1)).thenReturn(room);
		when(roomRepository.save(r2)).thenReturn(r2);
		assertEquals(r2, service.updateRoom(r2));
	}

	@Test

	public void deleteRoomTest() throws RoomNotFoundException {
		Room r = new Room();

		r.setRoomNumber(1);
		r.setRoomStatus(true);
		r.setTotalRooms(100);

		Optional<Room> room = Optional.of(r);
		when(roomRepository.findById(1)).thenReturn(room);
		assertEquals("Room with the 1 Deleted Successfully!", service.deleteRoom(1));
	}

}