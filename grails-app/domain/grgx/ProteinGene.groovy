package grgx

import org.apache.commons.lang.builder.EqualsBuilder
import org.apache.commons.lang.builder.HashCodeBuilder

//TODO: Getter for the protein group
class ProteinGene implements Serializable {

    Gene gene
	InteractionType interaction
	Literature literature
//	ProteinGroupMember proteinGroup

    Integer fkProteinGroupSource
    Integer fkGeneTarget
    Integer fkInteractionId
    Integer fkLiteratureId

	int hashCode() {
		def builder = new HashCodeBuilder()
		builder.append fkProteinGroupSource
		builder.append fkGeneTarget
		builder.append fkInteractionId
		builder.append fkLiteratureId
		builder.toHashCode()
	}

	boolean equals(other) {
		if (other == null) return false
		def builder = new EqualsBuilder()
		builder.append fkProteinGroupSource, other.fkProteinGroupSource
		builder.append fkGeneTarget, other.fkGeneTarget
		builder.append fkInteractionId, other.fkInteractionId
		builder.append fkLiteratureId, other.fkLiteratureId
		builder.isEquals()
	}

	static belongsTo = [Gene, InteractionType, Literature]

	static mapping = {
		id composite: ["fkProteinGroupSource", "fkGeneTarget", "fkInteractionId", "fkLiteratureId"]
        gene column: "fk_gene_target", insertable: false, updateable: false
        interaction column: "fk_interaction_id", insertable: false, updateable: false
        literature column: "fk_literature_id", insertable: false, updateable: false

        //proteinGroup column: "fk_protein_group_source"
		version false
	}

	static constraints = {
		fkProteinGroupSource nullable: true
		fkGeneTarget nullable: true
		fkInteractionId nullable: true
		fkLiteratureId nullable: true
	}
}
