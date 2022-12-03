package org.jb.tolkien.domain.entities

import org.springframework.data.neo4j.core.schema.GeneratedValue
import org.springframework.data.neo4j.core.schema.Id

data class Skill (
    @Id @GeneratedValue
    var id: Long? = null,
    var name: String
)
