package grgx

import org.apache.commons.lang.builder.EqualsBuilder
import org.apache.commons.lang.builder.HashCodeBuilder

class TranscriptParts implements Serializable {

	Integer partId
	Integer fkTranscriptId
	String partType
	Ranges ranges
	Transcripts transcripts

	int hashCode() {
		def builder = new HashCodeBuilder()
		builder.append partId
		builder.append fkTranscriptId
		builder.toHashCode()
	}

	boolean equals(other) {
		if (other == null) return false
		def builder = new EqualsBuilder()
		builder.append partId, other.partId
		builder.append fkTranscriptId, other.fkTranscriptId
		builder.isEquals()
	}

	static belongsTo = [Ranges, Transcripts]

	static mapping = {
		id composite: ["partId", "fkTranscriptId"]
		version false
	}

	static constraints = {
		partType nullable: true, maxSize: 8
	}
}
