package grgx

import grails.transaction.Transactional

@Transactional
class InteractionsService {

    def neighbors(Gene gene) {
        def inters = gene.proteinGeneInteractions

        [
            [sources: inters[0].sourceProteins, target: gene]
        ]
    }
}
