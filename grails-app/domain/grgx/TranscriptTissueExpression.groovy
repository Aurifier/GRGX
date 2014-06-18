package grgx

import org.apache.commons.lang.builder.EqualsBuilder
import org.apache.commons.lang.builder.HashCodeBuilder

class TranscriptTissueExpression implements Serializable {

	Integer fkTissueId
	Integer fkTranscriptId
	BigDecimal expressValue
	Transcripts transcripts
	Tissues tissues

	int hashCode() {
		def builder = new HashCodeBuilder()
		builder.append fkTissueId
		builder.append fkTranscriptId
		builder.toHashCode()
	}

	boolean equals(other) {
		if (other == null) return false
		def builder = new EqualsBuilder()
		builder.append fkTissueId, other.fkTissueId
		builder.append fkTranscriptId, other.fkTranscriptId
		builder.isEquals()
	}

	static belongsTo = [Tissues, Transcripts]

	static mapping = {
		id composite: ["fkTissueId", "fkTranscriptId"]
        transcripts column: "fk_transcript_id", insertable: false, updateable: false
        tissues column: "fk_tissue_id", insertable: false, updateable: false
		version false
	}

	static constraints = {
		expressValue nullable: true, scale: 3
	}
}
