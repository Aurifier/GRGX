package grgx

import org.apache.commons.lang.builder.EqualsBuilder
import org.apache.commons.lang.builder.HashCodeBuilder

class ProteinFuncat implements Serializable {

	Integer fkProteinId
	Integer fkFuncatId
	Proteins proteins
	Funcat funcat

	int hashCode() {
		def builder = new HashCodeBuilder()
		builder.append fkProteinId
		builder.append fkFuncatId
		builder.toHashCode()
	}

	boolean equals(other) {
		if (other == null) return false
		def builder = new EqualsBuilder()
		builder.append fkProteinId, other.fkProteinId
		builder.append fkFuncatId, other.fkFuncatId
		builder.isEquals()
	}

	static belongsTo = [Funcat, Proteins]

	static mapping = {
		id composite: ["fkProteinId", "fkFuncatId"]
		version false
	}

	static constraints = {
		fkProteinId nullable: true
		fkFuncatId nullable: true
	}
}
