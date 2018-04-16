package DaSilvaOzturk;

import java.io.IOException;
import java.util.ArrayList;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class ColonneTest extends TestCase {

	public ColonneTest( String testName )
    {
        super( testName );
    }

	public static Test suite()
    {
        return new TestSuite( ColonneTest.class );
    }

	public void testsize(){
	    ArrayList<Integer> l1=new ArrayList<Integer>();
	    Colonne<Integer> c1=new Colonne<Integer>("Pouet",l1);
	    assert(c1.size()==0);
	}
	
	public void testsize2(){
	    ArrayList<Integer> l1=new ArrayList<Integer>();
	    l1.add(0);l1.add(0);l1.add(0);l1.add(0);
	    Colonne<Integer> c1=new Colonne<Integer>("Pouet",l1);
	    assert(c1.size()==4);
	} 
	
	public void testadd(){
	    ArrayList<Integer> l1=new ArrayList<Integer>();
	    Colonne<Integer> c1=new Colonne<Integer>("Pouet",l1);
	    c1.add(3);
	    assert(c1.getListe().get(0)==3);
	}
	
	public void testadd2(){
	    ArrayList<Integer> l1=new ArrayList<Integer>();
	    Colonne<Integer> c1=new Colonne<Integer>("Pouet",l1);
	    c1.add(3);c1.add(4);
	    assert(c1.getListe().get(0)==3);
	}
	
	public void testadd3(){
	    ArrayList<Integer> l1=new ArrayList<Integer>();
	    Colonne<Integer> c1=new Colonne<Integer>("Pouet",l1);
	    c1.add(3);c1.add(4);
	    assert(c1.getListe().get(1)==4);
	}
	
	public void testgetLabel(){
	    Colonne<Integer> c1=new Colonne<Integer>("Pouet",null);
	    assert(c1.getLabel()=="Pouet");
	}
	
	public void testrien(){
	    Colonne<Integer> c1=new Colonne<Integer>();
	    assert(c1.getLabel()==null);
	}
	
	public void testrien2(){
	    Colonne<Integer> c1=new Colonne<Integer>();
	    assert(c1.getListe()==null);
	}
	
	public void testget(){
	    ArrayList<Integer> l1=new ArrayList<Integer>();
	    Colonne<Integer> c1=new Colonne<Integer>("Pouet",l1);
	    c1.add(1);c1.add(2);c1.add(3);c1.add(4);
	    assert((c1.get(1))==2);
	}
	
	public void testget2(){
	    ArrayList<Boolean> l1=new ArrayList<Boolean>();
	    Colonne<Boolean> c1=new Colonne<Boolean>("Pouet",l1);
	    c1.add(true);c1.add(false);c1.add(false);c1.add(false);
	    assert((c1.get(2))==false);
	}
	
}
