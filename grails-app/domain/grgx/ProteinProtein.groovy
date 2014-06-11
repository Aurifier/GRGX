package grgx

import org.apache.commons.lang.builder.EqualsBuilder
import org.apache.commons.lang.builder.HashCodeBuilder

class ProteinProtein implements Serializable {

	Integer fkProteinGroup1
	Integer fkProteinGroup2
	Integer fkInteractionId
	Integer fkLiteratureId
	InteractionType interactions
	ProteinGroup proteinGroupByFkProteinGroup2
	ProteinGroup proteinGroupByFkProteinGroup1
	Literature literature

	int hashCode() {
		def builder = new HashCodeBuilder()
		builder.append fkProteinGroup1
		builder.append fkProteinGroup2
		builder.append fkInteractionId
		builder.append fkLiteratureId
		builder.toHashCode()
	}

	boolean equals(other) {
		if (other == null) return false
		def builder = new EqualsBuilder()
		builder.append fkProteinGroup1, other.fkProteinGroup1
		builder.append fkProteinGroup2, other.fkProteinGroup2
		builder.append fkInteractionId, other.fkInteractionId
		builder.append fkLiteratureId, other.fkLiteratureId
		builder.isEquals()
	}

	static belongsTo = [InteractionType, Literature, ProteinGroup]

	static mapping = {
		id composite: ["fkProteinGroup1", "fkProteinGroup2", "fkInteractionId", "fkLiteratureId"]
		version false
	}

	static constraints = {
		fkProteinGroup1 nullable: true
		fkProteinGroup2 nullable: true
		fkInteractionId nullable: true
		fkLiteratureId nullable: true
	}
}
