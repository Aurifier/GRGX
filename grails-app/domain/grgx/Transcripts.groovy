package grgx

class Transcripts {

	Gene genes

	static hasMany = [proteinses: Proteins,
	                  tfomes: Tfome,
	                  transcriptClusters: TranscriptCluster,
	                  transcriptPartses: TranscriptParts,
	                  transcriptTissueExpressions: TranscriptTissueExpression,
	                  transcriptTrasncriptCoexpressionsForFkTranscript1: TranscriptTrasncriptCoexpression,
	                  transcriptTrasncriptCoexpressionsForFkTranscript2: TranscriptTrasncriptCoexpression]
	static belongsTo = [Gene]

	// TODO you have multiple hasMany references for class(es) [TranscriptTrasncriptCoexpression] 
	//      so you'll need to disambiguate them with the 'mappedBy' property:
	static mappedBy = [transcriptTrasncriptCoexpressionsForFkTranscript1: "TODO",
	                   transcriptTrasncriptCoexpressionsForFkTranscript2: "TODO"]

	static mapping = {
		id column: "transcript_id"
		version false
	}
}
