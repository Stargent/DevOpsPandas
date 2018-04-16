package DaSilvaOzturk;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class DataframeTest extends TestCase {

	public DataframeTest( String testName )
    {
        super( testName );
    }

	public static Test suite()
    {
        return new TestSuite( DataframeTest.class );
    }

    public void testDataframeInit()
    {
    
		Dataframe test;
		ArrayList<Integer> l1=new ArrayList<Integer>();
	    Colonne<Integer> c1=new Colonne<Integer>("Pouet",l1);
	    c1.add(1);c1.add(2);c1.add(3);c1.add(4);
	    
	    ArrayList<Integer> l2=new ArrayList<Integer>();
	    Colonne<Integer> c2=new Colonne<Integer>("Coucou",l2);
	    c2.add(1);c2.add(2);c2.add(3);c2.add(4);
	    
	    test = new Dataframe(c1, c2);
	
	    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
	    
	    test.afficherTout();
	    
	    System.setOut(System.out);
	   
	    assert(outContent.toString().contains("Pouet Coucou"));	    
	    assert(outContent.toString().contains("1 1"));	    
	    assert(outContent.toString().contains("2 2"));	    
	    assert(outContent.toString().contains("3 3"));	    
	    assert(outContent.toString().contains("4 4"));

	    
		
    }
    
    public void testDataframeFichier()
    {
    	Dataframe test;
		try {
			test = new Dataframe("fichier.csv");
			
			ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		    System.setOut(new PrintStream(outContent));
			
			test.afficherTout();
			
			assert(outContent.toString().contains("Sexe Prénom Année de naissance"));	    
		    assert(outContent.toString().contains("M Alphonse 1932"));	    
		    assert(outContent.toString().contains("F Béatrice 1964"));	    
		    assert(outContent.toString().contains("F Charlotte 1988"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
