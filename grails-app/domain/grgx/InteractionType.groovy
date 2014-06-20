package grgx

class InteractionType {

	String regulation
	Boolean isConfirmed

	static hasMany = [proteinGenes: ProteinGeneInteraction,
	                  proteinProteins: ProteinProteinInteraction]

	static mapping = {
        table 'interactions'
		id column: "interaction_id", generator: "assigned", sqlType: "int"
        isConfirmed column: "isConfirmed"
		version false
	}

	static constraints = {
		regulation nullable: true, maxSize: 50
		isConfirmed nullable: true
	}
}
