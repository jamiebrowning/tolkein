package org.jb.tolkien.domain

import org.springframework.data.neo4j.core.schema.RelationshipId
import org.springframework.data.neo4j.core.schema.RelationshipProperties
import org.springframework.data.neo4j.core.schema.TargetNode


@RelationshipProperties
data class Member(@RelationshipId var id: Long? = null,
                  @TargetNode var person: Person,
                  var role: String)