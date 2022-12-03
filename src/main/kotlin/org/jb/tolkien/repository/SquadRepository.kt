package org.jb.tolkien.repository

import org.jb.tolkien.domain.entities.Squad
import org.springframework.data.neo4j.repository.Neo4jRepository
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.RestResource

interface SquadRepository : Neo4jRepository<Squad, Long> {
    @RestResource(path = "names")
    fun findByName(@Param("name") name: String): Squad?
}