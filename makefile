jar:
	java -d com/fluffy-telegraph/build/ -verbose src/*.java
	jar cvef build/fluffy-telegraph.jar Main build/*

run:
	java -jar com/fluffy-telegraph/build/fluffy-telegraph.jar

dev:
	java -d com/fluffy-telegraph/dev/ -verbose src/*.java
	java com.fluffy-telegraph.dev
