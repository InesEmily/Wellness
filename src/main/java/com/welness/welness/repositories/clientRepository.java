package com.welness.welness.repositories;

import com.welness.welness.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface clientRepository extends CrudRepository<Client,Integer> {
}
