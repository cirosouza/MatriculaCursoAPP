package org.javaexercises.matriculacursosapp.repository;

import org.javaexercises.matriculacursosapp.model.MaterialDidatico;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialDidaticoRepository extends MongoRepository<MaterialDidatico,String> {
}
