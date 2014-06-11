package grgx

class TssCluster {

	Float lowDensity
	Float highDensity
	Float expressionTpm
	Float shapeIndex
	String clusterShape
	Integer fkTissueId
	Tss tss
	TranscriptCluster transcriptCluster
	Ranges ranges

	static belongsTo = [Ranges]

	static mapping = {
		id column: "tss_cluster_id"
		version false
	}

	static constraints = {
		lowDensity nullable: true
		highDensity nullable: true
		expressionTpm nullable: true
		shapeIndex nullable: true
		clusterShape nullable: true, maxSize: 10
		fkTissueId nullable: true
		tss nullable: true, unique: true
		transcriptCluster nullable: true, unique: true
	}
}
