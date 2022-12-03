package org.jb.tolkien.domain.entities

import org.springframework.data.neo4j.core.schema.GeneratedValue
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Relationship

data class Chapter(
    @Id @GeneratedValue
    var id: Long? = null,
    var name: String,
    @Relationship(type = "LED_BY")
    var leader: Person,
    @Relationship(type = "BELONGS_TO", direction = Relationship.Direction.INCOMING)
    var members: ArrayList<Person>  = ArrayList()
)

