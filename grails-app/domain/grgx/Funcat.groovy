package grgx

class Funcat {

	String funcatNumber

	static hasMany = [/*adjFuncats: Funcat,
                      adjFuncats2: Funcat,*/
	                  proteins: Proteins]

    /*static mappedBy = [adjFuncats: "adjFuncats2",
                       adjFuncats2: "adjFuncats"]*/

	static mapping = {
		id column: "funcat_id", sqlType: "int"
        /*adjFuncats joinTable: [name: "funcat_funcat",
                               key: "fk_funcat_id_1",
                               column: "funcat_id"]
        adjFuncats2 joinTable: [name: "funcat_funcat",
                                key: "fk_funcat_id_2",
                                column: "funcat_id"]*/
        proteins joinTable: [name: "protein_funcat",
                             key: "fk_protein_id"]
		version false
	}

	static constraints = {
		funcatNumber nullable: true
	}
}
