package org.jb.tolkien.repository

import org.jb.tolkien.domain.Guild
import org.jb.tolkien.domain.Squad
import org.springframework.data.neo4j.repository.Neo4jRepository
import org.springframework.data.repository.query.Param

interface GuildRepository : Neo4jRepository<Guild, String> {
    fun findByName(@Param("name") name: String): Guild?
}