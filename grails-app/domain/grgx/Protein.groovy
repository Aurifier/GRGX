package grgx

class Protein {

	String name
	Integer fkFamilyId
	Transcript transcript

	static hasMany = [proteinDomains: ProteinDomain,
	                  funcats: Funcat,
	                  proteinGroups: ProteinGroupMember]
	static belongsTo = [Transcript, Funcat]

	static mapping = {
        table "proteins"
		id column: "protein_id", sqlType: "int"
        transcript column: "fk_transcript_id", sqlType: "int"
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
