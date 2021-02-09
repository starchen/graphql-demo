package com.evtech.mdq.ro.graphql.fetcher;

import com.evtech.mdq.ro.graphql.domain.LoginRepository;
import graphql.schema.DataFetcher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class LoginDataFetcher {
    private final LoginRepository loginRepository;

    public LoginDataFetcher(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Transactional(readOnly = true)
    public DataFetcher getLoginByIdDataFetcher() {
        return dataFetchingEnvironment -> {
            Long loginId = Long.valueOf(dataFetchingEnvironment.getArgument("id"));
            return loginRepository.getAll().stream()
                    .filter(login -> login.getId().equals(loginId))
                    .findFirst()
                    .orElse(null);
        };
    }

    @Transactional(readOnly = true)
    public DataFetcher getLoginByLoginDataFetcher() {
        return dataFetchingEnvironment -> {
            String loginArg = dataFetchingEnvironment.getArgument("login");
            return loginRepository.getAll().stream()
                    .filter(login -> login.getLogin().equals(loginArg))
                    .findFirst()
                    .orElse(null);
        };
    }
}
