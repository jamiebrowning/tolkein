package org.jb.tolkien.repository

import org.jb.tolkien.domain.Tribe
import org.springframework.data.neo4j.repository.Neo4jRepository
import org.springframework.data.repository.query.Param

interface TribeRepository : Neo4jRepository<Tribe, Long> {
    fun findByName(@Param("name") name: String): Tribe?
}