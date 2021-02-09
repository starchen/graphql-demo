package com.evtech.mdq.ro.graphql.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UtilisateurRepository extends CrudRepository<Utilisateur, Long> {
    Optional<Utilisateur> findByLogin(String login);
}
