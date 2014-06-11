package grgx

import org.apache.commons.lang.builder.EqualsBuilder
import org.apache.commons.lang.builder.HashCodeBuilder

class TranscriptTrasncriptCoexpression implements Serializable {

	Integer fkTranscript1
	Integer fkTranscript2
	BigDecimal coexpressValue
	String cluster
	Integer fkTissueId
	Transcripts transcriptsByFkTranscript2
	Transcripts transcriptsByFkTranscript1
	Tissues tissues

	int hashCode() {
		def builder = new HashCodeBuilder()
		builder.append fkTranscript1
		builder.append fkTranscript2
		builder.append coexpressValue
		builder.append cluster
		builder.append fkTissueId
		builder.toHashCode()
	}

	boolean equals(other) {
		if (other == null) return false
		def builder = new EqualsBuilder()
		builder.append fkTranscript1, other.fkTranscript1
		builder.append fkTranscript2, other.fkTranscript2
		builder.append coexpressValue, other.coexpressValue
		builder.append cluster, other.cluster
		builder.append fkTissueId, other.fkTissueId
		builder.isEquals()
	}

	static belongsTo = [Tissues, Transcripts]

	static mapping = {
		id composite: ["fkTranscript1", "fkTranscript2", "coexpressValue", "cluster", "fkTissueId"]
		version false
	}

	static constraints = {
		fkTranscript1 nullable: true
		fkTranscript2 nullable: true
		coexpressValue nullable: true, scale: 3
		cluster nullable: true
		fkTissueId nullable: true
	}
}
