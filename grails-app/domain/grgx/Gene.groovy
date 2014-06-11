package grgx

class Gene {

	Ranges ranges
	GeneTypes geneTypes

	static hasMany = [geneNameses: GeneNames,
	                  proteinGenes: ProteinGene,
	                  transcriptses: Transcripts]
	static belongsTo = [GeneTypes, Ranges]

	static mapping = {
        table 'genes'
		id column: "gene_id"
		version false
	}
}
