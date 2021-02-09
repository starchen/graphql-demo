package com.evtech.mdq.ro.graphql.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.stream.Stream;

@Repository
public interface LoginRepository extends CrudRepository<Login, Long> {
    @Query("select l from Login l")
    Collection<Login> getAll();
}
