compile: $(patsubst %.java, %.class, $(wildcard *.java))

%.class: %.java Makefile
	javac $< 
	java $* < ../test/entry11.txt
                
clean:
	rm *.class

