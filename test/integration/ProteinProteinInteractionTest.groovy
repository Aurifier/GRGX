import grgx.InteractionType
import grgx.Literature
import grgx.Protein
import grgx.ProteinGroupMember
import grgx.ProteinProteinInteraction

/**
 * Created by drew on 6/19/14.
 */
class ProteinProteinInteractionTest extends GroovyTestCase {
    void testCanRetrieveSourceProteinList() {
        def g_id = 9845
        def p1 = new Protein().save(flush: true, failOnError: true)
        new ProteinGroupMember(fkProteinId: p1.id, protein: p1, groupId: g_id).save(flush: true, failOnError: true)
        def iType = new InteractionType()
        iType.id = 1
        iType.save(failOnError: true)
        def lit = new Literature().save(failOnError: true)
        def inter = new ProteinProteinInteraction(fkSourceProteinGroup: g_id, fkTargetProteinGroup: g_id, interactionType: iType, literature: lit, fkInteractionTypeId: iType.id, fkLiteratureId: lit.id).save(flush: true, failOnError: true)

        def proteins = inter.sourceProteins

        assert proteins.size() == 1
        assert proteins.contains(p1)
    }

    void testCanRetrieveTargetProteinList() {
        def g_id = 478
        def foo_g_id = 45
        def p1 = new Protein().save(failOnError: true)
        def p2 = new Protein().save(failOnError: true)
        new ProteinGroupMember(protein: p1, fkProteinId: p1.id, groupId: g_id).save(flush: true, failOnError: true)
        new ProteinGroupMember(protein: p2, fkProteinId: p2.id, groupId: g_id).save(flush: true, failOnError: true)
        def iType = new InteractionType()
        iType.id = 2
        iType.save(failOnError: true)
        def lit = new Literature().save(failOnError: true)
        def inter = new ProteinProteinInteraction(
                fkSourceProteinGroup: foo_g_id, fkTargetProteinGroup: g_id,
                interactionType: iType, fkInteractionTypeId: iType.id,
                literature: lit, fkLiteratureId: lit.id
        ).save(flush: true, failOnError: true)

        def proteins = inter.targetProteins

        assert proteins.size() == 2
        assert proteins.contains(p1)
        assert proteins.contains(p2)
    }
}
