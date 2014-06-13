package grgx

import org.apache.commons.lang.builder.EqualsBuilder
import org.apache.commons.lang.builder.HashCodeBuilder

class ProteinGene implements Serializable {

    Gene gene
	InteractionType interaction
	Literature literature
	ProteinGroup proteinGroup

    Integer fkProteinGroupSource
    Integer fkGeneTarget
    Integer fkInterationId
    Integer fkLiteratureId

	int hashCode() {
		def builder = new HashCodeBuilder()
		builder.append fkProteinGroupSource
		builder.append fkGeneTarget
		builder.append fkInterationId
		builder.append fkLiteratureId
		builder.toHashCode()
	}

	boolean equals(other) {
		if (other == null) return false
		def builder = new EqualsBuilder()
		builder.append fkProteinGroupSource, other.fkProteinGroupSource
		builder.append fkGeneTarget, other.fkGeneTarget
		builder.append fkInterationId, other.fkInterationId
		builder.append fkLiteratureId, other.fkLiteratureId
		builder.isEquals()
	}

	static belongsTo = [Gene, InteractionType, Literature, ProteinGroup]

	static mapping = {
		id composite: ["fkProteinGroupSource", "fkGeneTarget", "fkInterationId", "fkLiteratureId"]
		version false
	}

	static constraints = {
		fkProteinGroupSource nullable: true
		fkGeneTarget nullable: true
		fkInterationId nullable: true
		fkLiteratureId nullable: true
	}
}
