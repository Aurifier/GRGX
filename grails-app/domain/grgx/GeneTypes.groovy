package grgx

class GeneTypes {

	String type

	static hasMany = [geneses: Gene]

	static mapping = {
		id column: "type_id"
		version false
	}

	static constraints = {
		type nullable: true
	}
}
