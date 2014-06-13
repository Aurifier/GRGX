package grgx

class Tfome {

	String name
	String family
	String vector
	String insert
	String fivePrimeName
	String fivePrimeSeq
	BigDecimal fivePrimeTemp
	String threePrimeName
	String threePrimeSeq
	BigDecimal threePrimeTemp
	String pcrCondition
	String sequence
	String translation
	String requestInfo
	String pi
	Transcripts transcripts

	static belongsTo = [Transcripts]

	static mapping = {
		version false
	}

	static constraints = {
		name nullable: true, maxSize: 50
		family nullable: true, maxSize: 50
		vector nullable: true, maxSize: 50
		insert nullable: true, maxSize: 50
		fivePrimeName nullable: true, maxSize: 50
		fivePrimeSeq nullable: true, maxSize: 50
		fivePrimeTemp nullable: true, scale: 1
		threePrimeName nullable: true, maxSize: 50
		threePrimeSeq nullable: true, maxSize: 50
		threePrimeTemp nullable: true, scale: 1
		pcrCondition nullable: true, maxSize: 50
		sequence nullable: true, maxSize: 65535
		translation nullable: true, maxSize: 65535
		requestInfo nullable: true, maxSize: 50
		pi nullable: true, maxSize: 50
	}
}
