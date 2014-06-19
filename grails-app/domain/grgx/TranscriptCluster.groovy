package grgx

class TranscriptCluster {

	TssCluster tssCluster
	String moreToComePossibly
	Transcript transcripts

	static belongsTo = [Transcript]

	static mapping = {
		id column: "fk_cluster_id", sqlType: "int"
        transcripts column: "fk_transcript_id", sqlType: "int"
        tssCluster column: "fk_cluster_id", insertable: false, updateable: false
		version false
	}

	static constraints = {
		tssCluster unique: true
		moreToComePossibly nullable: true
	}
}
