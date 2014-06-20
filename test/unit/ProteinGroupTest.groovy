import grails.test.GrailsUnitTestCase
import grails.test.mixin.Mock
import grails.test.mixin.TestMixin
import grgx.Protein
import grgx.ProteinGroup
import grgx.ProteinGroupMember
import grgx.Transcript
import spock.lang.Specification

/**
 * Created by drew on 6/18/14.
 */
@Mock([Protein,ProteinGroupMember,Transcript])
@TestMixin(GrailsUnitTestCase)
class ProteinGroupTest extends Specification {
    void "can retrieve single protein" () {
        given:
            def g_id = 1
            def pName = "footein"
            def protein = new Protein(name: pName).save(flush: true, failOnError: true)
            new ProteinGroupMember(groupId: g_id, fkProteinId: protein.id, protein: protein).save(flush: true, failOnError: true)

            ProteinGroup group = new ProteinGroup(g_id)
        when:
            List<Protein> proteins = group.getProteins()

        then:
            assert proteins != null
            assert proteins.size() == 1
            assert proteins.contains(protein)
    }

    void "can retrieve two proteins" () {
        given:
            def g_id = 4

            def p1 = new Protein().save(flush: true, failOnError: true)
            def p2 = new Protein().save(flush: true, failOnError: true)

            new ProteinGroupMember(groupId: g_id, fkProteinId: p1.id, protein: p1).save(flush: true, failOnError: true)
            new ProteinGroupMember(groupId: g_id, fkProteinId: p2.id, protein: p2).save(flush: true, failOnError: true)

            def group = new ProteinGroup(g_id)
        when:
            List<Protein> proteins = group.getProteins()

        then:
            assert proteins != null
            assert proteins.size() == 2
            assert proteins.contains(p1)
            assert proteins.contains(p2)
    }
}
