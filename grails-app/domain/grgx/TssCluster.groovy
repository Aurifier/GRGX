package grgx

class TssCluster {

	Float lowDensity
	Float highDensity
	Float expressionTpm
	Float shapeIndex
	String clusterShape
	Integer fkTissueId
	Ranges ranges

	static belongsTo = [Ranges]

	static mapping = {
		id column: "tss_cluster_id", sqlType: "int"
        ranges column: "fk_range_interquartile", sqlType: "int"
		version false
	}

	static constraints = {
		lowDensity nullable: true
		highDensity nullable: true
		expressionTpm nullable: true
		shapeIndex nullable: true
		clusterShape nullable: true, maxSize: 10
		fkTissueId nullable: true
	}
}
