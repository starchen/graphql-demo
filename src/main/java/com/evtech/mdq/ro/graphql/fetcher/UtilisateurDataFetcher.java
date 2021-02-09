package com.evtech.mdq.ro.graphql.fetcher;

import com.evtech.mdq.ro.graphql.domain.Login;
import com.evtech.mdq.ro.graphql.domain.Utilisateur;
import com.evtech.mdq.ro.graphql.domain.UtilisateurRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UtilisateurDataFetcher {
    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurDataFetcher(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public DataFetcher getUtilisateurDataFetcher() {
        return dataFetchingEnvironment -> {
            Login login = dataFetchingEnvironment.getSource();
            String loginInUtilisateur = login.getLogin();
            return utilisateurRepository.findByLogin(loginInUtilisateur).orElse( null);
        };
    }
}
