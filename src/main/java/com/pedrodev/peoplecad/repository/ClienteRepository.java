package com.pedrodev.peoplecad.repository;

import com.pedrodev.peoplecad.orm.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
