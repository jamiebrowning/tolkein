package org.jb.tolkien.domain.entities

import org.springframework.data.neo4j.core.schema.GeneratedValue
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Relationship

data class Squad(
    @Id @GeneratedValue
    var id: Long? = null,
    var name: String,
    @Relationship(type = "PRODUCT_OWNER")
    var productOwner: Person?,
    @Relationship(type = "MEMBER_OF", direction = Relationship.Direction.INCOMING)
    var members: ArrayList<Person> = ArrayList()
)
