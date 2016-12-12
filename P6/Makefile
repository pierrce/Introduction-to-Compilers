###
# This Makefile can be used to make a parser for the cats language
# (parser.class) and to make a program (P3.class) that tests the parser and
# the unparse methods in ast.java.
#
# make clean removes all generated files.
#
###

JC = javac
CP = -cp ./deps/java_cup:./deps:.


P4.class: P5.java parser.class Yylex.class ASTnode.class
	$(JC)    P5.java

parser.class: parser.java ASTnode.class Yylex.class ErrMsg.class
	$(JC)      parser.java

parser.java: harambe.cup
	java $(CP)  java_cup.Main < harambe.cup

Yylex.class: harambe.jlex.java sym.class ErrMsg.class
	$(JC)   harambe.jlex.java

ASTnode.class: ast.java
	$(JC)  ast.java

harambe.jlex.java: harambe.jlex sym.class
	java  $(CP)  JLex.Main harambe.jlex

sym.class: sym.java
	$(JC)    sym.java

sym.java: harambe.cup
	java  $(CP)  java_cup.Main < harambe.cup

ErrMsg.class: ErrMsg.java
	$(JC) ErrMsg.java

##test
test:
	java   P5 typeErrors.cf test.out

###
# clean
###
clean:
	rm -f *~ *.class parser.java cats.jlex.java sym.java
