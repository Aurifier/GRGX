package grgx

class Proteins {

	String name
	Integer fkFamilyId
	Transcripts transcripts

	static hasMany = [proteinDomains: ProteinDomain,
	                  proteinFuncats: ProteinFuncat,
	                  proteinGroups: ProteinGroup]
	static belongsTo = [Transcripts]

	static mapping = {
		id column: "protein_id"
		version false
	}

	static constraints = {
		name nullable: true, maxSize: 50
		fkFamilyId nullable: true
	}
}
