package org.jb.tolkien.domain.entities

import org.springframework.data.neo4j.core.schema.GeneratedValue
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Relationship

data class Tribe(
    @Id @GeneratedValue
    var id: Long? = null,
    var name: String,
    @Relationship(type = "TRIBE_LEAD")
    var tribeLead: Person?,
    @Relationship(type = "PART_OF", direction = Relationship.Direction.INCOMING)
    var squads: ArrayList<Squad> = ArrayList()
)
