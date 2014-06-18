package grgx

import org.apache.commons.lang.builder.EqualsBuilder
import org.apache.commons.lang.builder.HashCodeBuilder

class TfRules implements Serializable {

	Integer fkFamilyId
	Integer fkDomainId
	Integer groupingId
	Boolean isNot
	Families families
	Domains domains

	int hashCode() {
		def builder = new HashCodeBuilder()
		builder.append fkFamilyId
		builder.append fkDomainId
		builder.append groupingId
		builder.toHashCode()
	}

	boolean equals(other) {
		if (other == null) return false
		def builder = new EqualsBuilder()
		builder.append fkFamilyId, other.fkFamilyId
		builder.append fkDomainId, other.fkDomainId
		builder.append groupingId, other.groupingId
		builder.isEquals()
	}

	static belongsTo = [Domains, Families]

	static mapping = {
		id composite: ["fkFamilyId", "fkDomainId", "groupingId"]
        domains column: "fk_domain_id", insertable: false, updateable: false
        families column: "fk_family_id", insertable: false, updateable: false
		version false
	}
}
