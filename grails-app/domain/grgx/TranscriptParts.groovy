package grgx

import grails.util.Environment
import org.apache.commons.lang.builder.EqualsBuilder
import org.apache.commons.lang.builder.HashCodeBuilder

class TranscriptParts implements Serializable {
    enum PartType {exon, cds, five_utr, three_utr, intron}

	Integer partId
	Integer fkTranscriptId
    PartType partType
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
        ranges column: "fk_range_id", sqlType: "int"
        transcripts column: "fk_transcript_id", insertable: false, updateable: false

        if(Environment.current != Environment.TEST) {
            partType sqlType: "enum", enumType: "ordinal"
        }

		version false
	}

	static constraints = {
		partType nullable: true
	}
}
