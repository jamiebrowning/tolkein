package org.jb.tolkien.domain.entities

import org.springframework.data.neo4j.core.schema.GeneratedValue
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Relationship

data class Guild(
    @Id @GeneratedValue
    var id: Long? = null,
    var name: String,
    @Relationship(type = "COORDINATOR")
    var coordinator: Person?,
    @Relationship(type = "CONTRIBUTOR_TO", direction = Relationship.Direction.INCOMING)
    var contributors: ArrayList<Person> = ArrayList()
)
