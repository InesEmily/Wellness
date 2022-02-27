package com.welness.welness.repositories;

import com.welness.welness.model.Room;
import org.springframework.data.jpa.repository.support.CrudMethodMetadata;
import org.springframework.data.repository.CrudRepository;

public interface RoomRepository extends CrudRepository<Room,Integer> {
}
