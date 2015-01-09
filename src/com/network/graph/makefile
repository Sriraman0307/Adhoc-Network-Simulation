JFLAGS = -g
JC = javac
JVM = java
src = src/
cls = ../bin/

.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) *.java -d $(cls)

CLASSES = \
		Node.java
		GraphGenerator.java
		DominatingSets.java\
		Main.java

MAIN = Main
		 
default: classes

classes: $(CLASSES:.java=.class)
		
run: $(MAIN).class 
	cd $(cls); $(JVM) $(MAIN)

clean:
	$(RM) $(cls)*.class