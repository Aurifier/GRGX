package grgx

import org.apache.commons.lang.builder.EqualsBuilder
import org.apache.commons.lang.builder.HashCodeBuilder

//TODO: Getter for the protein groups
class ProteinProtein implements Serializable {

	Integer fkProteinGroup1
	Integer fkProteinGroup2
	Integer fkInteractionId
	Integer fkLiteratureId
	InteractionType interactions
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

	static belongsTo = [InteractionType, Literature, ProteinGroupMember]

	static mapping = {
		id composite: ["fkProteinGroup1", "fkProteinGroup2", "fkInteractionId", "fkLiteratureId"]
        fkProteinGroup1 column: "fk_protein_group_1"
        fkProteinGroup2 column: "fk_protein_group_2"
        interactions column: "fk_interaction_id", insertable: false, updateable: false
        literature column: "fk_literature_id", insertable: false, updateable: false

		version false
	}

	static constraints = {
		fkProteinGroup1 nullable: true
		fkProteinGroup2 nullable: true
		fkInteractionId nullable: true
		fkLiteratureId nullable: true
	}
}
