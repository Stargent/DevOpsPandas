package DaSilvaOzturk;

import java.util.ArrayList;

public class Colonne<T> {


  private ArrayList<T> liste;
  private String label;
        
  //Constructeur par défaut
  public Colonne(){
    this.liste=null;
    this.label=null;
  }

  public Colonne(String label, ArrayList<T> liste){
    this.label = label;
    this.liste=liste;
  }

  public int size(){
	return this.liste.size();
  }
  
  public void add(T t){
	this.liste.add(t);
  }
  
  public T get(int i){
	return this.liste.get(i);
  }

  public String getLabel(){
    return this.label;
  }
  
  public ArrayList<T> getListe(){
    return this.liste;
  }
}