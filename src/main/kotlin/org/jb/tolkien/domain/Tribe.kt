package org.jb.tolkien.domain

import org.springframework.data.neo4j.core.schema.GeneratedValue
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Relationship

data class Tribe(
    @Id @GeneratedValue var id: Long? = null,
    var name: String,
    @Relationship(type = "SQUADS") var squads: ArrayList<Squad> = ArrayList(),
    @Relationship(type = "MEMBERS") var member: ArrayList<Member> = ArrayList())
