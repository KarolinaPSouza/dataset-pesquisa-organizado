compile: $(patsubst %.java, %.class, $(wildcard *.java))

%.class: %.java Makefile
	javac $< 
	java $* < ../test/entry08.txt
                
clean:
	rm *.class

