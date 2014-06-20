package grgx

class Families {

	String name
	String abbr
	Boolean isCoRegulator
    Integer id

	static hasMany = [geneNameses: GeneName,
	                  tfRuleses: TfRules]

	static mapping = {
		id column: "family_id", sqlType: "int"
        isCoRegulator column: "isCoRegulator"
		version false
	}
}
