package org.jb.tolkien.repository

import org.jb.tolkien.domain.entities.Chapter
import org.springframework.data.neo4j.repository.Neo4jRepository
import org.springframework.data.repository.query.Param

interface ChapterRepository : Neo4jRepository<Chapter, Long> {
    fun findByName(@Param("name") name: String): Chapter?
}