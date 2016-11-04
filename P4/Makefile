#
#
# This Makefile can be used to make a parser for the cats language
# (parser.class) and to make a program (P3.class) that tests the parser and
# the unparse methods in ast.java.
#
# make clean removes all generated files.
#
###

JC = javac
CP = -cp ./deps

P4.class: P4.java parser.class Yylex.class ASTnode.class
	$(JC) -g   P4.java

parser.class: parser.java ASTnode.class Yylex.class ErrMsg.class
	$(JC)      parser.java

parser.java: harambe.cup
	java $(CP)  java_cup.Main < harambe.cup

Yylex.class: cats.jlex.java sym.class ErrMsg.class
	$(JC)   cats.jlex.java

ASTnode.class: ast.java
	$(JC) -g ast.java

cats.jlex.java: cats.jlex sym.class
	java  $(CP)  JLex.Main cats.jlex

sym.class: SemSym.java
	$(JC)  -g  SemSym.java

SemSym.java: harambe.cup
	java $(CP)   java_cup.Main < harambe.cup

ErrMsg.class: ErrMsg.java
	$(JC) ErrMsg.java

##test
test:
	java   P4 test.cf test.out

###
# clean
###
clean:
	rm -f *~ *.class parser.java cats.jlex.java sym.java
