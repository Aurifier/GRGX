package grgx

class Literature {

	Integer pubmedId
	String webAddress
	Date date
	String firstAuthor

	static hasMany = [proteinGenes: ProteinGene,
	                  proteinProteins: ProteinProtein]

	static mapping = {
		id column: "literature_id"
		version false
	}

	static constraints = {
		pubmedId nullable: true
		webAddress nullable: true, maxSize: 500
		date nullable: true
		firstAuthor nullable: true
	}
}
