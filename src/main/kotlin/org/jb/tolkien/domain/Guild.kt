package org.jb.tolkien.domain

import org.springframework.data.annotation.Version
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Relationship

data class Guild(
    @Id var name: String,
    @Version var version: Long = 1L,
    @Relationship(type = "MEMBERS") var members: ArrayList<Member> = ArrayList())
