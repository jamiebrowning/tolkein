package org.jb.tolkien.repository

import org.jb.tolkien.domain.entities.Guild
import org.springframework.data.neo4j.repository.Neo4jRepository
import org.springframework.data.repository.query.Param

interface GuildRepository : Neo4jRepository<Guild, Long> {
    fun findByName(@Param("name") name: String): Guild?
}