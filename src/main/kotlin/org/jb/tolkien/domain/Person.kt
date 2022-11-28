package org.jb.tolkien.domain

import org.springframework.data.neo4j.core.schema.DynamicLabels
import org.springframework.data.neo4j.core.schema.GeneratedValue
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Relationship
import org.springframework.data.neo4j.core.schema.Relationship.Direction

data class Person (@Id @GeneratedValue var id: Long? = null,
                   var name: String,
                   @DynamicLabels val labels: HashSet<String> = HashSet()) {
    fun addLabel(label: String) {
        this.labels.add(label)
    }
}
