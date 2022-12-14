package org.jb.tolkien.domain.entities

import org.springframework.data.neo4j.core.schema.DynamicLabels
import org.springframework.data.neo4j.core.schema.GeneratedValue
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Relationship

data class Person (
    @Id @GeneratedValue
    var id: Long? = null,
    var name: String,
    @DynamicLabels
    val labels: HashSet<String> = HashSet(),
    @Relationship("HAS_SKILL")
    var skills: ArrayList<Skill> = ArrayList()
)
