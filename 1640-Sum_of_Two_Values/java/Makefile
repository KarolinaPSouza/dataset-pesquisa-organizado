compile: $(patsubst %.java, %.class, $(wildcard *.java))

%.class: %.java Makefile
	javac $< 
	java $* < /home/andrews/Documents/entry07.txt
                
clean:
	rm *.class

