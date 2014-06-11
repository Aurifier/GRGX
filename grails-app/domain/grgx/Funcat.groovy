package grgx

class Funcat {

	String funcatNumber

	static hasMany = [funcatFuncatsForFkFuncatId1: FuncatFuncat,
	                  funcatFuncatsForFkFuncatId2: FuncatFuncat,
	                  proteinFuncats: ProteinFuncat]

	// TODO you have multiple hasMany references for class(es) [FuncatFuncat] 
	//      so you'll need to disambiguate them with the 'mappedBy' property:
	static mappedBy = [funcatFuncatsForFkFuncatId1: "TODO",
	                   funcatFuncatsForFkFuncatId2: "TODO"]

	static mapping = {
		id column: "funcat_id"
		version false
	}

	static constraints = {
		funcatNumber nullable: true
	}
}
