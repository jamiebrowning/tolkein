package org.jb.tolkien.repository

import org.jb.tolkien.domain.*
import org.jb.tolkien.repository.PersonRepository
import org.jb.tolkien.repository.SquadRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
class RepositoryTests {

    @Autowired
    lateinit var personRepository: PersonRepository

    @Autowired
    lateinit var squadRepository: SquadRepository

    @Autowired
    lateinit var tribeRepository: TribeRepository

    @Autowired
    lateinit var guildRepository: GuildRepository

    @BeforeEach
    fun setUp() {
        personRepository.deleteAll()
        squadRepository.deleteAll()
        tribeRepository.deleteAll()
        guildRepository.deleteAll()

        val jamie = Person(name = "Jamie")
        jamie.addLabel("Software Engineer")
        jamie.addLabel("Line Manager")
        personRepository.save(jamie)

		val krishan = Person(name = "krishan")
		krishan.addLabel("Software Engineer")
		personRepository.save(krishan)

        val varsha = Person(name = "Varsha")
		varsha.addLabel("Business Analyst")
        varsha.addLabel("Line Manager")
        personRepository.save(varsha)

        val anand = Person(name = "Anand")
        anand.addLabel("Software Engineer")
        personRepository.save(anand)

        val triage = Squad(name = "Triage")
		triage.members.add(Member(person = krishan, role = "Software Engineer"))
		triage.members.add(Member(person = varsha, role = "Technical Lead"))
        squadRepository.save(triage)

        val stability = Squad(name = "Stability")
        stability.members.add(Member(person = anand, role = "Technical Lead"))
        squadRepository.save(stability)

        val tribe = Tribe(name = "Business Platform")
        tribe.squads.add(triage)
        tribe.squads.add(stability)
        tribe.member.add(Member(person = jamie, role = "Engineering Manager"))
        tribeRepository.save(tribe)

        val guild = Guild("Cold Fusion")
        guild.members.add(Member(person = krishan, role = "Member"))
        guild.members.add(Member(person = anand, role = "Member"))
        guildRepository.save(guild)

    }

    @Test
    fun testFindPersonByName() {
        val name = "Jamie"
        val result = personRepository.findByName(name)
        Assertions.assertNotNull(result)
    }

    @Test
    fun testFindPeopleWithLabel() {
        val label = "Business Analyst"
        val result = personRepository.findAllWithLabel(label)

        Assertions.assertNotNull(result)
        Assertions.assertEquals(1, result.size)
    }

    @Test
    fun testFindSquadByName() {
        val name = "Triage"
        val result = squadRepository.findByName(name)
        Assertions.assertNotNull(result)
    }

    @Test
    fun testFindTribeById() {
        val name = "Business Platform"
        val result = tribeRepository.findByName(name)
        Assertions.assertNotNull(result)
    }

    @Test
    fun testFindGuildById() {
        val name = "Cold Fusion"
        val result = guildRepository.findByName(name)
        Assertions.assertNotNull(result)
    }
}
