package grgx

class Tissues {

	String name

	static hasMany = [cisMotifses: CisMotifs,
	                  transcriptTissueExpressions: TranscriptTissueExpression,
	                  transcriptTrasncriptCoexpressions: TranscriptTranscriptCoexpression]

	static mapping = {
		id column: "tissue_id", sqlType: "int"
		version false
	}

	static constraints = {
		name nullable: true
	}
}
