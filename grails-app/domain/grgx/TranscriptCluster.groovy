package grgx

class TranscriptCluster {

	TssCluster tssCluster
	String moreToComePossibly
	Transcripts transcripts

	static belongsTo = [Transcripts]

	static mapping = {
		id column: "fk_cluster_id"
		version false
	}

	static constraints = {
		tssCluster unique: true
		moreToComePossibly nullable: true
	}
}
