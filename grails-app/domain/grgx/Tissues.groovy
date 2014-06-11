package grgx

class Tissues {

	String name

	static hasMany = [cisMotifses: CisMotifs,
	                  transcriptTissueExpressions: TranscriptTissueExpression,
	                  transcriptTrasncriptCoexpressions: TranscriptTrasncriptCoexpression]

	static mapping = {
		id column: "tissue_id"
		version false
	}

	static constraints = {
		name nullable: true
	}
}
