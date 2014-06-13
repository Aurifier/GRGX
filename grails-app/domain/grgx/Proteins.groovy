package grgx

class Proteins {

	String name
	Integer fkFamilyId
	Transcripts transcripts

	static hasMany = [proteinDomains: ProteinDomain,
	                  funcats: Funcat,
	                  proteinGroups: ProteinGroup]
	static belongsTo = [Transcripts, Funcat]

	static mapping = {
		id column: "protein_id"
        funcats joinTable: [name: "protein_funcat",
                            key: "fk_protein_id"]
		version false
	}

	static constraints = {
		name nullable: true, maxSize: 50
		fkFamilyId nullable: true
	}
}
