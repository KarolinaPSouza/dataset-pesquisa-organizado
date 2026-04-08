compile: $(patsubst %.java, %.class, $(wildcard *.java))

%.class: %.java Makefile
	javac $< 
	java $* < ../test/entry01.txt > /tmp/nada.txt
	
clean:
	rm *.class
