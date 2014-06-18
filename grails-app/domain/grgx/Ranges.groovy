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
		id column: "range_id", sqlType: "int"
        posFlank column: "posFlank"
        negFlank column: "negFlank"
        sequence sqlType: "text"
		version false
	}

	static constraints = {
		posFlank nullable: true
		negFlank nullable: true
	}
}
