package grgx

import org.apache.commons.lang.builder.EqualsBuilder
import org.apache.commons.lang.builder.HashCodeBuilder

//TODO: Add a non-domain ProteinGroup class for the link between here and Proteins
class ProteinGroupMember implements Serializable {

	Integer groupId
	Integer fkProteinId
    Proteins protein

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

	static belongsTo = [Proteins]

	static mapping = {
        table "protein_group"
		id composite: ["groupId", "fkProteinId"]
        protein column: "fk_protein_id", insertable: false, updateable: false

		version false
	}
}
