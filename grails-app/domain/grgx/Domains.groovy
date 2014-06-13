package grgx

class Domains {

	String hmmName
	String hmmAcc
	Pfams pfams

	static hasMany = [proteinDomains: ProteinDomain,
	                  tfRuleses: TfRules]
	static belongsTo = [Pfams]

	static mapping = {
		id column: "domain_id", sqlType: "int"
        pfams column: "fk_pfam_id", sqlType: "int"
		version false
	}
}
