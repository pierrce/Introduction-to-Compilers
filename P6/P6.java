import java_cup.runtime.*;

/**
 * Main program to test P6.
 *
 * Two command-line arguments:
 *    1) The file to be parsed
 *    2) The output file
 *
 */

public class P6 {
    public static void main(String[] args) throws IOException
    {
        // check command-line args
        if (args.length < 2 || args.length > 3) {
            System.err.println("please supply the names of file to be parsed/unparsed.");
            System.exit(-1);
        }

        // open input file
        FileReader inFile = null;
        try {
            inFile = new FileReader(args[0]);
        } catch (FileNotFoundException ex) {
            System.err.println("The File " + args[0] + " not found.");
            System.exit(-1);
        }

        // open output file
        PrintWriter outFile = null;
        if(args.length == 3 ) {
        	try {
           	 outFile = new PrintWriter(args[2]);
        	} catch (FileNotFoundException ex) {
           		System.err.println("The file " + args[2] + " could not be opened for writing.");
            	System.exit(-1);
        	}
	}

	//code gen file
        PrintWriter codeGenFile = null;
        try {
            codeGenFile = new PrintWriter(args[1]);
            // ** website specified this to be put in P6 **
            //Codegen.p = new PrintWriter(args[1]);
        } catch (FileNotFoundException ex) {
            System.err.println("The file " + args[1] + " could not be opened for writing.");
            System.exit(-1);
        }

        parser P = new parser(new Yylex(inFile));

        Symbol root = null;

        try {
            root = P.parse();
            ]// remove print after debuging
            //System.out.println ("program parsed correctly.");
        } catch (Exception ex){
            System.err.println("Exception occured during parse: " + ex);
            System.exit(-1);
        }

	// analyze the ast
      	((ProgramNode)root.value).nameAnalysis();

	if(ErrMsg.isError == true) {
	    System.err.println("Errors occured during name analyze" );
	    System.exit(-1);
        }
        else {
            // remove print after debuging
	    //System.out.println("Name analyze succeeded");
	}

        ((ProgramNode)root.value).typeCheck();

        if(ErrMsg.isError == true) {
            System.err.println("Errors occured during type check" );
            System.exit(-1);
        }
        else {
            // remove print after debuging
	    //System.out.println("No type errors, type check succeeded");
	}

	// unparse the ast
	if(args.length == 3) {
            ((ASTnode)root.value).unparse(outFile, 0);
            outFile.close();
	}

	//to code gen
	//assert(root instanceof ProgramNode);
	((ProgramNode)root.value).codeGen(codeGenFile);
	codeGenFile.close();

        return;
    }
}
