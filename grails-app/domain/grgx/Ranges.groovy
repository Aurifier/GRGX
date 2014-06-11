package grgx

class Ranges {

	Integer start
	Integer end
	String posFlank
	String negFlank
	Byte chromosomes
	String sequence

	static hasMany = [cisMotifses: CisMotifs,
	                  geneses: Gene,
	                  transcriptPartses: TranscriptParts,
	                  tssClusters: TssCluster]

	static mapping = {
		id column: "range_id"
		version false
	}

	static constraints = {
		posFlank nullable: true
		negFlank nullable: true
		sequence maxSize: 65535
	}
}
