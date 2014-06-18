package grgx

class Transcripts {

	Gene genes

	static hasMany = [proteinses: Proteins,
	                  tfomes: Tfome,
	                  transcriptClusters: TranscriptCluster,
	                  transcriptPartses: TranscriptParts,
	                  transcriptTissueExpressions: TranscriptTissueExpression,
	                  transcriptTrasncriptCoexpressionsForFkTranscript1: TranscriptTranscriptCoexpression,
	                  transcriptTrasncriptCoexpressionsForFkTranscript2: TranscriptTranscriptCoexpression]
	static belongsTo = [Gene]

	static mappedBy = [transcriptTrasncriptCoexpressionsForFkTranscript1: "transcriptsByFkTranscript1",
	                   transcriptTrasncriptCoexpressionsForFkTranscript2: "transcriptsByFkTranscript2"]

	static mapping = {
		id column: "transcript_id", sqlType: "int"
        genes column: "fk_gene_id", sqlType: "int"
		version false
	}
}
