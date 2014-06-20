package grgx

import grails.transaction.Transactional

@Transactional
class InteractionsService {

    def neighbors(Gene gene) {
        def inters = gene.proteinGeneInteractions
        inters.collect {
            [sources: it.sourceProteins, target: gene]
        }
    }
}
