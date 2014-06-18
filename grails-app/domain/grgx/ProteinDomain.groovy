package grgx

import org.apache.commons.lang.builder.EqualsBuilder
import org.apache.commons.lang.builder.HashCodeBuilder

class ProteinDomain implements Serializable {

	Integer fkProteinId
	Integer fkDomainId
	Integer start
	Integer end
	String eval
	BigDecimal bitscore
	String sequence
	String hmm
	String match
	String pp
	Protein proteins
	Domains domains

	int hashCode() {
		def builder = new HashCodeBuilder()
		builder.append fkProteinId
		builder.append fkDomainId
		builder.toHashCode()
	}

	boolean equals(other) {
		if (other == null) return false
		def builder = new EqualsBuilder()
		builder.append fkProteinId, other.fkProteinId
		builder.append fkDomainId, other.fkDomainId
		builder.isEquals()
	}

	static belongsTo = [Domains, Protein]

	static mapping = {
		id composite: ["fkProteinId", "fkDomainId"]
        domains column: "fk_domain_id", insertable: false, updateable: false
        proteins column: "fk_protein_id", insertable: false, updateable: false
		version false
	}

	static constraints = {
		start nullable: true
		end nullable: true
		eval nullable: true, maxSize: 50
		bitscore nullable: true, scale: 3
		sequence nullable: true
		hmm nullable: true
		match nullable: true
		pp nullable: true
	}
}
