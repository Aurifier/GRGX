package grgx

import org.apache.commons.lang.builder.EqualsBuilder
import org.apache.commons.lang.builder.HashCodeBuilder

class FuncatFuncat implements Serializable {

	Integer fkFuncatId1
	Integer fkFuncatId2
	Funcat funcatByFkFuncatId1
	Funcat funcatByFkFuncatId2

	int hashCode() {
		def builder = new HashCodeBuilder()
		builder.append fkFuncatId1
		builder.append fkFuncatId2
		builder.toHashCode()
	}

	boolean equals(other) {
		if (other == null) return false
		def builder = new EqualsBuilder()
		builder.append fkFuncatId1, other.fkFuncatId1
		builder.append fkFuncatId2, other.fkFuncatId2
		builder.isEquals()
	}

	static belongsTo = [Funcat]

	static mapping = {
		id composite: ["fkFuncatId1", "fkFuncatId2"]
		version false
	}

	static constraints = {
		fkFuncatId1 nullable: true
		fkFuncatId2 nullable: true
	}
}
