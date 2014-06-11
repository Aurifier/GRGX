package grgx

class Families {

	String name
	String abbr
	Boolean isCoRegulator

	static hasMany = [geneNameses: GeneNames,
	                  tfRuleses: TfRules]

	static mapping = {
		id column: "family_id"
		version false
	}
}
