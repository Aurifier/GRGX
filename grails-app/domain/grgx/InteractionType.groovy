package grgx

class InteractionType {

	String regulation
	Boolean isConfirmed

	static hasMany = [proteinGenes: ProteinGene,
	                  proteinProteins: ProteinProtein]

	static mapping = {
        table 'interactions'
		id column: "interaction_id", generator: "assigned"
		version false
	}

	static constraints = {
		regulation nullable: true, maxSize: 50
		isConfirmed nullable: true
	}
}
