MATCH(n) DETACH DELETE n

// Create Entities ////////////////////////////////////////////////////////////////////////////////////////////////////

// Create People
MERGE (jamie:Person:`Software Engineer` {name: 'Jamie'})
MERGE (cheryl:Person {name: 'Cheryl'})
MERGE (damon:Person:`Technical Architect` {name: 'Damon'})
MERGE (mike:Person:`Software Engineer` {name: 'Mike'})
MERGE (ralph:Person:`Software Engineer` {name: 'Ralph'})
MERGE (daryl:Person:`Software Engineer` {name: 'Daryl'})

// Create Squads
MERGE (api:Squad {name: 'API'})

// Create Tribe
MERGE (platform:Tribe {name: 'Platform'})

// Create Chapter
MERGE (dev:Chapter {name: 'Java Developers'})
MERGE (kev:Chapter {name: 'Kotlin Developers'})

// Create Guild
MERGE (groovy:Guild {name: 'Groovy Fanatics!'})

// Create skills
MERGE (java:Skill {name: 'Java'})
MERGE (kotlin:Skill {name: 'Kotlin'})

// Create Relationships ///////////////////////////////////////////////////////////////////////////////////////////////

// Create Squad MEMBERS
MERGE (mike)-[:MEMBER_OF]->(api)
MERGE (ralph)-[:MEMBER_OF]->(api)
MERGE (daryl)-[:MEMBER_OF]->(api)

MERGE (cheryl)<-[:PRODUCT_OWNER]-(api)

// Create Tribe
MERGE (jamie)-[:TRIBE_LEAD]-(platform)
MERGE (api)-[:PART_OF]-(platform)

// Create Chapter members
MERGE (mike)-[:MEMBER_OF]->(dev)
MERGE (ralph)-[:MEMBER_OF]->(dev)
MERGE (jamie)<-[:MANAGER_OF]-(dev)

MERGE (daryl)-[:MEMBER_OF]->(kev)
MERGE (damon)<-[:MANAGER_OF]-(kev)

// Create Guild members
MERGE (jamie)<-[:COORDINATOR_OF]-(groovy)
MERGE (damon)-[:MEMBER_OF]->(groovy)
MERGE (mike)-[:MEMBER_OF]->(groovy)
MERGE (ralph)-[:MEMBER_OF]->(groovy)

// Create some skills
MERGE (jamie)-[:HAS_SKILL]-(java)
MERGE (jamie)-[:HAS_SKILL]-(kotlin)
MERGE (mike)-[:HAS_SKILL]-(java)
MERGE (ralph)-[:HAS_SKILL]-(java)
MERGE (daryl)-[:HAS_SKILL]-(kotlin)
