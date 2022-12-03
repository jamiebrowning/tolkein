package org.jb.tolkien.repository

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class RepositoryTests {

    val PERSON_NAME = "Jamie"
    val PERSON_LABEL = "Software Engineer"
    val SKILL_NAME = "Java"
    val SQUAD_NAME = "API"
    val SQUAD_PRODUCT_OWNER_NAME = "Cheryl"
    val TRIBE_NAME = "Platform"
    val TRIBE_LEAD_NAME = "Jamie"
    val GUILD_NAME = "Groovy Fanatics!"
    val GUILD_COORDINATOR = "Jamie"
    val CHAPTER_NAME = "Java Developers"
    val CHAPTER_LEAD_NAME = "Jamie"

    @Autowired
    lateinit var personRepository: PersonRepository

    @Autowired
    lateinit var squadRepository: SquadRepository

    @Autowired
    lateinit var tribeRepository: TribeRepository

    @Autowired
    lateinit var guildRepository: GuildRepository

    @Autowired
    lateinit var chapterRepository: ChapterRepository

    @Test
    fun testFindPersonByName() {
        val person = personRepository.findByName(PERSON_NAME)

        Assertions.assertNotNull(person)
        Assertions.assertEquals(PERSON_NAME, person!!.name)
    }

    @Test
    fun testFindAllPeopleWithLabel() {
        val personList = personRepository.findAllWithLabel(PERSON_LABEL)

        Assertions.assertNotNull(personList)
        Assertions.assertEquals(4, personList.size)
    }

    @Test
    fun testFindAllPeopleWithSkill() {
        val personList = personRepository.findAllWithSkill(SKILL_NAME)

        Assertions.assertNotNull(personList)
        Assertions.assertEquals(3, personList.size)
    }

    @Test
    fun testFindSquadByName() {
        val squad = squadRepository.findByName(SQUAD_NAME)

        Assertions.assertEquals(3, squad!!.members.size)

        val productOwner = squad!!.productOwner
        Assertions.assertEquals(productOwner!!.name, SQUAD_PRODUCT_OWNER_NAME)
    }

    @Test
    fun testFindTribeByName() {
        val tribe = tribeRepository.findByName(TRIBE_NAME)

        Assertions.assertEquals(1, tribe!!.squads.size)

        val tribeLead = tribe!!.tribeLead
        Assertions.assertEquals(tribeLead!!.name, TRIBE_LEAD_NAME)
    }

    @Test
    fun testFindGuildByName() {
        val guild = guildRepository.findByName(GUILD_NAME)

        Assertions.assertEquals(3, guild!!.contributors.size)

        val coordinator = guild!!.coordinator
        Assertions.assertEquals(coordinator!!.name, GUILD_COORDINATOR)
    }

    @Test
    fun testFindChapterByName() {
        val chapter = chapterRepository.findByName(CHAPTER_NAME)

        Assertions.assertEquals(2, chapter!!.members.size)

        val leader = chapter!!.leader
        Assertions.assertEquals(leader!!.name, CHAPTER_LEAD_NAME)
    }

}
