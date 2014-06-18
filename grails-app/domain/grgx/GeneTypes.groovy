package grgx

class GeneTypes {

	String type

	static hasMany = [geneses: Gene]

	static mapping = {
		id column: "type_id", sqlType: "int"
		version false
	}

	static constraints = {
		type nullable: true
	}
}
