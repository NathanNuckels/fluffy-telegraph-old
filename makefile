jar:
	java -d build/ -verbose src/*.java
	jar cvef build/fluffy-telegraph.jar Main build/*
	@echo Finished.

run:
	java -jar build/fluffy-telegraph.jar

dev:
	java -d build/dev/ -verbose src/*.java
	python runlog.py start
	java build.dev.main
	python runlog.py stop
