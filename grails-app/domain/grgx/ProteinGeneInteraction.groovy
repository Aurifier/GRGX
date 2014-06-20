package grgx

import org.apache.commons.lang.builder.EqualsBuilder
import org.apache.commons.lang.builder.HashCodeBuilder

class ProteinGeneInteraction implements Serializable {

    Gene gene
	InteractionType interactionType
	Literature literature

    Integer fkSourceProteinGroup
    Integer fkGeneTarget
    Integer fkInteractionTypeId
    Integer fkLiteratureId

    def getSourceProteins() {
        def group = new ProteinGroup(fkSourceProteinGroup)
        group.proteins
    }

	int hashCode() {
		def builder = new HashCodeBuilder()
		builder.append fkSourceProteinGroup
		builder.append fkGeneTarget
		builder.append fkInteractionTypeId
		builder.append fkLiteratureId
		builder.toHashCode()
	}

	boolean equals(other) {
		if (other == null) return false
		def builder = new EqualsBuilder()
		builder.append fkSourceProteinGroup, other.fkSourceProteinGroup
		builder.append fkGeneTarget, other.fkGeneTarget
		builder.append fkInteractionTypeId, other.fkInteractionTypeId
		builder.append fkLiteratureId, other.fkLiteratureId
		builder.isEquals()
	}

	static belongsTo = [Gene, InteractionType, Literature]

	static mapping = {
		id composite: ["fkSourceProteinGroup", "fkGeneTarget", "fkInteractionTypeId", "fkLiteratureId"]
        gene column: "fk_gene_target", insertable: false, updateable: false
        interactionType column: "fk_interaction_id", insertable: false, updateable: false
        fkInteractionTypeId column: "fk_interaction_id", insertable: false, updateable: false
        literature column: "fk_literature_id", insertable: false, updateable: false

		version false
	}

	static constraints = {
		fkSourceProteinGroup nullable: true
		fkGeneTarget nullable: true
		fkInteractionTypeId nullable: true
		fkLiteratureId nullable: true
	}
}
