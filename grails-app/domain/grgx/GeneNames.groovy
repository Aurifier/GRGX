package grgx

class GeneNames {

	String type
	String name
	Boolean isAccepted
	String comments
	Families families
	Gene genes

	static belongsTo = [Families, Gene]

	static mapping = {
		id column: "name_id"
		version false
	}

	static constraints = {
		type nullable: true, maxSize: 50
		name nullable: true, maxSize: 50
		isAccepted nullable: true
		comments nullable: true
	}
}
