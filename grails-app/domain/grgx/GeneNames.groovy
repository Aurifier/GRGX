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
		id column: "name_id", sqlType: "int"
        families column: "fk_family_id"
        genes column: "fk_gene_id", sqlType: "int"
		version false
	}

	static constraints = {
		type nullable: true, maxSize: 50
		name nullable: true, maxSize: 50
		isAccepted nullable: true
		comments nullable: true
	}
}
