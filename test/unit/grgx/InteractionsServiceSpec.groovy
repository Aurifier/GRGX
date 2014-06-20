package grgx

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(InteractionsService)
@Mock([Gene,Protein,ProteinGroupMember,InteractionType,Literature,ProteinGeneInteraction])
class InteractionsServiceSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test neighbors finds neighbors of gene with single interaction"() {
        given:
            def g_id = 435
            def iTId = 2
            def gene = new Gene().save(failOnError: true)
            def p1 = new Protein().save()
            def group = new ProteinGroupMember(protein: p1, fkProteinId: p1.id, groupId: g_id).save()
            def iType = new InteractionType(id: iTId).save()
            def lit = new Literature().save()
            new ProteinGeneInteraction(
                fkSourceProteinGroup: group.groupId, gene: gene, fkGeneTarget: gene.id,
                interactionType: iType, fkInteractionTypeId: iType.id,
                literature: lit, fkLiteratureId: lit.id
            ).save(flush: true, failOnError: true)

        when:
            def interactions = service.neighbors(gene)

        then:
            assert interactions.size() == 1
            assert interactions[0].sources.size() == 1
            assert interactions[0].sources.contains(p1)
            assert interactions[0].target == gene
    }

    void "test neighbors finds neighbors of gene with two interactions"() {
        given:
            def g1_id = 4
            def g2_id = 5
            def iTId = 4
            def gene = new Gene().save(failOnError: true)
            def p1 = new Protein().save()
            def p2 = new Protein().save()
            def p3 = new Protein().save()
            new ProteinGroupMember(protein: p1, fkProteinId: p1.id, groupId: g1_id).save()
            new ProteinGroupMember(protein: p2, fkProteinId: p2.id, groupId: g2_id).save()
            new ProteinGroupMember(protein: p3, fkProteinId: p3.id, groupId: g2_id).save()
            def iType = new InteractionType(id: iTId).save()
            def lit = new Literature().save()
            new ProteinGeneInteraction(
                    fkSourceProteinGroup: g1_id, gene: gene, fkGeneTarget: gene.id,
                    interactionType: iType, fkInteractionTypeId: iType.id,
                    literature: lit, fkLiteratureId: lit.id
            ).save(flush: true, failOnError: true)
            new ProteinGeneInteraction(
                    fkSourceProteinGroup: g2_id, gene: gene, fkGeneTarget: gene.id,
                    interactionType: iType, fkInteractionTypeId: iType.id,
                    literature: lit, fkLiteratureId: lit.id
            ).save(flush: true, failOnError: true)

        when:
            def interactions = service.neighbors(gene)

        then:
            assert interactions.size() == 2
            assert interactions.contains(
                    [sources: [p1], target: gene]
            )
    }
}
