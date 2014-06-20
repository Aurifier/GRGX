package grgx

class Literature {

	Integer pubmedId
	String webAddress
	Date date
	String firstAuthor

	static hasMany = [proteinGenes: ProteinGeneInteraction,
	                  proteinProteins: ProteinProteinInteraction]

	static mapping = {
		id column: "literature_id", sqlType: "int"
		version false
	}

	static constraints = {
		pubmedId nullable: true
		webAddress nullable: true, maxSize: 500
		date nullable: true
		firstAuthor nullable: true
	}
}
