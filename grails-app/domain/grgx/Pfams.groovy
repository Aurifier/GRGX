package grgx

class Pfams {

	String type

	static hasMany = [domainses: Domains]

	static mapping = {
		id column: "pfam_id"
		version false
	}

	static constraints = {
		type nullable: true, maxSize: 10
	}
}
