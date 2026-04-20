compile: $(patsubst %.java, %.class, $(wildcard *.java))

%.class: %.java Makefile
	javac $< 
	java $* < /home/andrews/Documents/teste.txt
                
clean:
	rm *.class

