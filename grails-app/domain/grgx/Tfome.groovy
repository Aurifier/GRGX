package grgx

class Tfome {

	String name
	String family
	String vector
	String insert
	String 5primeName
	String 5primeSeq
	BigDecimal 5primeTemp
	String 3primeName
	String 3primeSeq
	BigDecimal 3primeTemp
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
		5primeName nullable: true, maxSize: 50
		5primeSeq nullable: true, maxSize: 50
		5primeTemp nullable: true, scale: 1
		3primeName nullable: true, maxSize: 50
		3primeSeq nullable: true, maxSize: 50
		3primeTemp nullable: true, scale: 1
		pcrCondition nullable: true, maxSize: 50
		sequence nullable: true, maxSize: 65535
		translation nullable: true, maxSize: 65535
		requestInfo nullable: true, maxSize: 50
		pi nullable: true, maxSize: 50
	}
}
