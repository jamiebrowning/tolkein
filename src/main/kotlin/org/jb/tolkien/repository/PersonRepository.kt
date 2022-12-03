package org.jb.tolkien.repository

import org.jb.tolkien.domain.entities.Person
import org.springframework.data.neo4j.repository.Neo4jRepository
import org.springframework.data.neo4j.repository.query.Query
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(collectionResourceRel = "people", path = "people")
interface PersonRepository: Neo4jRepository<Person, Long> {

    fun findByName(@Param("name") name: String): Person?

    @Query("MATCH (p:Person)-[r:HAS_SKILL]-(s:Skill {name: \$skill}) return p")
    fun findAllWithSkill(@Param("skill") name: String): List<Person>

    @Query("MATCH (p:`:#{literal(#label)}`) RETURN p")
    fun findAllWithLabel(@Param("label") label: String): List<Person>

}