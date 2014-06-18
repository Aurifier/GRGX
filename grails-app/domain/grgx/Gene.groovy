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
		id column: "gene_id", sqlType: "int"
        geneTypes column: "fk_gene_type_id", sqlType: "int"
        ranges column: "fk_range_id", sqlType: "int"
		version false
	}
}
