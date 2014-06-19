import grgx.Protein
import grgx.ProteinGroupMember

/**
 * Created by drew on 6/18/14.
 */
class ProteinGroup {
    def proteins
    def id

    ProteinGroup(int id) {
        this.id = id
    }

    def getProteins() {
        def groups = ProteinGroupMember.findAllByGroupId(id)
        groups.collect {
            it.protein
        }
    }
}
