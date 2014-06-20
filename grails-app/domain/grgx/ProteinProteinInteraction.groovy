package grgx

import org.apache.commons.lang.builder.EqualsBuilder
import org.apache.commons.lang.builder.HashCodeBuilder

//TODO: Getter for the protein groups
class ProteinProteinInteraction implements Serializable {

	Integer fkSourceProteinGroup
	Integer fkTargetProteinGroup
	Integer fkInteractionTypeId
	Integer fkLiteratureId
	InteractionType interactionType
	Literature literature

    def getSourceProteins() {
        def group = new ProteinGroup(fkSourceProteinGroup)
        group.proteins
    }

    def getTargetProteins() {
        def group = new ProteinGroup(fkTargetProteinGroup)
        group.proteins
    }

	int hashCode() {
		def builder = new HashCodeBuilder()
		builder.append fkSourceProteinGroup
		builder.append fkTargetProteinGroup
		builder.append fkInteractionTypeId
		builder.append fkLiteratureId
		builder.toHashCode()
	}

	boolean equals(other) {
		if (other == null) return false
		def builder = new EqualsBuilder()
		builder.append fkSourceProteinGroup, other.fkSourceProteinGroup
		builder.append fkTargetProteinGroup, other.fkTargetProteinGroup
		builder.append fkInteractionTypeId, other.fkInteractionTypeId
		builder.append fkLiteratureId, other.fkLiteratureId
		builder.isEquals()
	}

	static belongsTo = [InteractionType, Literature, ProteinGroupMember]

	static mapping = {
        table "protein_protein"
		id composite: ["fkSourceProteinGroup", "fkTargetProteinGroup", "fkInteractionTypeId", "fkLiteratureId"]
        fkSourceProteinGroup column: "fk_protein_group_1"
        fkTargetProteinGroup column: "fk_protein_group_2"
        fkInteractionTypeId column: "fk_interaction_id"
        interactionType column: "fk_interaction_id", insertable: false, updateable: false
        literature column: "fk_literature_id", insertable: false, updateable: false

		version false
	}

	static constraints = {
		fkSourceProteinGroup nullable: true
		fkTargetProteinGroup nullable: true
		fkInteractionTypeId nullable: true
		fkLiteratureId nullable: true
	}
}
