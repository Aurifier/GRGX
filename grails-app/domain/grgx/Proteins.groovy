package grgx

class Proteins {

	String name
	Integer fkFamilyId
	Transcripts transcripts

	static hasMany = [proteinDomains: ProteinDomain,
	                  funcats: Funcat,
	                  proteinGroups: ProteinGroupMember]
	static belongsTo = [Transcripts, Funcat]

	static mapping = {
		id column: "protein_id", sqlType: "int"
        transcripts column: "fk_transcript_id", sqlType: "int"
        funcats joinTable: [name: "protein_funcat",
                            key: "fk_protein_id"],
                sqlType: "int"
		version false
	}

	static constraints = {
		name nullable: true, maxSize: 50
		fkFamilyId nullable: true
	}
}
