package com.jp.jhipster.microservice.repository;

import com.jp.jhipster.microservice.domain.User;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import org.neo4j.springframework.data.repository.Neo4jRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

/**
 * Spring Data Neo4j RX repository for the {@link User} entity.
 */
@Repository
public interface UserRepository extends Neo4jRepository<User, String> {
    String USERS_BY_LOGIN_CACHE = "usersByLogin";

    String USERS_BY_EMAIL_CACHE = "usersByEmail";

    Optional<User> findOneByEmailIgnoreCase(String email);

    Optional<User> findOneByLogin(String login);

    // See https://github.com/neo4j/sdn-rx/issues/51
    List<User> findAll();

    Page<User> findAllByLoginNot(Pageable pageable, String login);
}
