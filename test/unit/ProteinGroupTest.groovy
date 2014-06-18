import grails.test.mixin.TestMixin
import grails.test.mixin.domain.DomainClassUnitTestMixin
import grgx.Protein
import grgx.ProteinGroupMember
import spock.lang.Specification

/**
 * Created by drew on 6/18/14.
 */
@TestMixin(DomainClassUnitTestMixin)
class ProteinGroupTest extends Specification{
    void "can retrieve single protein" () {
        given:
            def g_id = 1
            def p_id = 3
            def pName = "footein"
            mockDomain(Protein, [
                    [name: pName, id: p_id]
            ])
            mockDomain(ProteinGroupMember, [
                    [groupId: 1, protein: p_id]
            ])

            ProteinGroup group = new ProteinGroup(g_id)
        when:
            List<Protein> proteins = group.getProteins()

        then:
            assert proteins != null
            assert proteins.size() == 1
            assert proteins[0].name == pName
            assert proteins[0].id == p_id
    }
}
