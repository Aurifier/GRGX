package grgx

class Tss {

	TssCluster tssCluster
	Integer totalTags
	Boolean isDom
	Float expressionTpm
	Integer location

	static mapping = {
		id column: "fk_cluster_id"
		version false
	}

	static constraints = {
		tssCluster unique: true
		totalTags nullable: true
		isDom nullable: true
		expressionTpm nullable: true
		location nullable: true
	}
}
