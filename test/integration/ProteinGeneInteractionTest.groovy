import grgx.Gene
import grgx.InteractionType
import grgx.Literature
import grgx.Protein
import grgx.ProteinGeneInteraction
import grgx.ProteinGroupMember

/**
 * Created by drew on 6/20/14.
 */
class ProteinGeneInteractionTest extends GroovyTestCase {
    void testCanRetrieveSourceProteinList() {
        def g_id = 45
        def p1 = new Protein().save(flush: true, failOnError: true)
        new ProteinGroupMember(fkProteinId: p1.id, protein: p1, groupId: g_id).save(flush: true, failOnError: true)
        def iType = new InteractionType()
        iType.id = 65478
        iType.save(failOnError: true)
        def lit = new Literature().save(failOnError: true)
        def gene = new Gene().save(failOnError: true)
        def inter = new ProteinGeneInteraction(
                fkSourceProteinGroup: g_id, gene: gene, fkGeneTarget: gene.id,
                interactionType: iType, fkInteractionTypeId: iType.id,
                literature: lit, fkLiteratureId: lit.id
        ).save(flush: true, failOnError: true)

        def proteins = inter.sourceProteins

        assert proteins.size() == 1
        assert proteins.contains(p1)
    }
}
