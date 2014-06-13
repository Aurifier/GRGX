package grgx

import org.apache.commons.lang.builder.EqualsBuilder
import org.apache.commons.lang.builder.HashCodeBuilder

class ProteinGroup implements Serializable {

	Integer groupId
	Integer fkProteinId
	Proteins proteins

	int hashCode() {
		def builder = new HashCodeBuilder()
		builder.append groupId
		builder.append fkProteinId
		builder.toHashCode()
	}

	boolean equals(other) {
		if (other == null) return false
		def builder = new EqualsBuilder()
		builder.append groupId, other.groupId
		builder.append fkProteinId, other.fkProteinId
		builder.isEquals()
	}

	static hasMany = [proteinGenes: ProteinGene,
	                  proteinProteinsForFkProteinGroup1: ProteinProtein,
	                  proteinProteinsForFkProteinGroup2: ProteinProtein]
	static belongsTo = [Proteins]

	static mappedBy = [proteinProteinsForFkProteinGroup1: "sourceProteinGroupEntries",
	                   proteinProteinsForFkProteinGroup2: "targetProteinGroupEntries"]

	static mapping = {
		id composite: ["groupId", "fkProteinId"]
		version false
	}
}
