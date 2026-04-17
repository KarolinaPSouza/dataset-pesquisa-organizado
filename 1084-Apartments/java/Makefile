compile: $(patsubst %.java, %.class, $(wildcard *.java))

%.class: %.java Makefile
	javac $< 
	java $* < ../test/entry05.txt
                
clean:
	rm *.class

