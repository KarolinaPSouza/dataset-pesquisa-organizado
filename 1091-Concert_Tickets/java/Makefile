compile: $(patsubst %.java, %.class, $(wildcard *.java))

%.class: %.java Makefile
	javac $< 
	java $* < ../test/entry03.txt
                
clean:
	rm *.class

