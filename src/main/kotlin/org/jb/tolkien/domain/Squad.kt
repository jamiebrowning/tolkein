package org.jb.tolkien.domain

import org.springframework.data.neo4j.core.schema.GeneratedValue
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Relationship

data class Squad(
    @Id @GeneratedValue var id: Long? = null,
    var name: String,
    @Relationship(type = "MEMBERS") var members: ArrayList<Member> = ArrayList())
