compile: $(patsubst %.java, %.class, $(wildcard *.java))

%.class: %.java Makefile
	javac $< 
	java $* < /home/andrews/Documents/entry06.txt
                
clean:
	rm *.class

