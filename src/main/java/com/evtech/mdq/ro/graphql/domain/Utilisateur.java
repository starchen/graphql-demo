package com.evtech.mdq.ro.graphql.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Utilisateur {
    @Id
    private Long id;

    @Column
    private String login;

    @Column
    private String prenom;

    @Column
    private String nom;

    @Column
    private String type;

    @Column(name="numero_c_p")
    private String numeroCp;

    @Column(name = "adresse_email")
    private String email;
}
