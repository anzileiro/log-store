package com.anzileiro.challenge.infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.*;

import com.anzileiro.challenge.ChallengeApplication;
import com.anzileiro.challenge.application.container.UseCase;
import com.anzileiro.challenge.infrastructure.repository.LogRepositoryImplementation;


@Configuration
@ComponentScan(basePackageClasses = ChallengeApplication.class)
public class InfrastructureConfiguration {

    @Bean
    UseCase useCase(final LogRepositoryImplementation repository) {
        return new UseCase(repository);
    }

}
