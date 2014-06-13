package grgx

class CisMotifs {

	String matrix
	String logo
	String name
	Integer posWindow
	Integer negWindow
	String source
	Ranges ranges
	Tissues tissues

	static belongsTo = [Ranges, Tissues]

	static mapping = {
		id column: "cis_id", generator: "assigned", sqlType: "int"
        ranges column: "fk_range_id", sqlType: "int"
        tissues column: "fk_tissue_id", sqlType: "int"
		version false
	}

	static constraints = {
		matrix nullable: true, maxSize: 50
		logo nullable: true, maxSize: 50
		name nullable: true, maxSize: 50
		posWindow nullable: true
		negWindow nullable: true
		source nullable: true, maxSize: 125
	}
}
