package com.jp.jhipster.microservice.repository;

import com.jp.jhipster.microservice.domain.Authority;
import java.util.List;
import org.neo4j.springframework.data.repository.Neo4jRepository;

/**
 * Spring Data Neo4j RX repository for the {@link Authority} entity.
 */
public interface AuthorityRepository extends Neo4jRepository<Authority, String> {
    // See https://github.com/neo4j/sdn-rx/issues/51    List<Authority> findAll();
}
