jar:
	java -d build/ -verbose src/*.java
	jar cvef build/fluffy-telegraph.jar Main build/*
	@echo Finished.

run:
	java -jar build/fluffy-telegraph.jar

