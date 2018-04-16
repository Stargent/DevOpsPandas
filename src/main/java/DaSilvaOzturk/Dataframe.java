package DaSilvaOzturk;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

@SuppressWarnings("rawtypes")
public class Dataframe {
	
	
	ArrayList<Colonne> df=new ArrayList<Colonne>();
	
	public Dataframe(Colonne... args){
	    for(int i=0;i<args.length;++i){
	      df.add(args[i]);
	    }
	  }
	
	public Dataframe(String nom) throws IOException{
		InputStream is = new FileInputStream(nom);
		InputStreamReader reader = new InputStreamReader(is);
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(reader);
		
		String ligne;
		ligne=br.readLine();
		String labels[] = ligne.split(",");
			
		
		ArrayList<ArrayList<String>> liste = new ArrayList<ArrayList<String>>(); 
		for(int i = 0; i < labels.length; i++)  {
	        liste.add(new ArrayList<String>());
	    }
		
		while((ligne=br.readLine())!=null){
			String str[] = ligne.split(",");
			for(int i =0; i<str.length; i++){
				liste.get(i).add(str[i]);
			}
		}
		
		for(int i=0; i<labels.length; i++){
			@SuppressWarnings("unchecked")
			Colonne c = new Colonne(labels[i], liste.get(i));
			df.add(c);
		}
	}
	
	public void afficherTout(){
	    int max=0;
	    for(int i=0;i<this.df.size();i++){
	      if(this.df.get(i).size()>max)max=this.df.get(i).size();
	    }

	    for(int i=0;i<this.df.size();i++){
	        System.out.print(this.df.get(i).getLabel() + " ");
	    }System.out.println();
	    for(int j=0;j<max;j++){
	      for(int i=0;i<this.df.size();i++){
	        if(this.df.get(i).size()<=j)
	          System.out.print(" ");
	        else
	          System.out.print(this.df.get(i).get(j) + " ");
	      }System.out.println();
	    }
	  }
	  //Prend taille de 3 par défaut, si la taille est supérieur, ne prend que les x premiers éléments qui sont dans le tableau
	  public void afficherPremier(int... args){
	    int taille;
	    if(args.length!=1)taille=3;
	    else taille=args[0];
	    int max=0;
	    for(int i=0;i<this.df.size();i++){
	      if(this.df.get(i).size()>max)max=this.df.get(i).size();
	    }if(taille>max)taille=max;

	    for(int i=0;i<this.df.size();i++){
	        System.out.print(this.df.get(i).getLabel()+ " ");
	    }System.out.println();
	    for(int j=0;j<taille;j++){
	      for(int i=0;i<this.df.size();i++){
	        if(this.df.get(i).size()<=j)
	          System.out.print(" ");
	        else
	          System.out.print(this.df.get(i).get(j));
	      }System.out.println();
	    }
	  }
	//Prend taille de 3 par défaut, si la taille est supérieur, ne prend que les x derniers éléments qui sont dans le tableau
	  public void afficherDernier(int... args){
	    int taille;
	    if(args.length!=1)taille=3;
	    else taille=args[0];
	    int max=0;
	    for(int i=0;i<this.df.size();i++){
	      if(this.df.get(i).size()>max)max=this.df.get(i).size();
	    }if(taille>max)taille=max;

	    for(int i=0;i<this.df.size();i++){
	        System.out.print(this.df.get(i).getLabel()+ " ");
	    }System.out.println();
	    for(int j=taille-1;j>=0;j--){
	      for(int i=0;i<this.df.size();i++){
	        if(this.df.get(i).size()<=j)
	          System.out.print(" ");
	        else
	          System.out.print(this.df.get(i).get(j));
	      }System.out.println();
	    }
	  }
	  
	  @SuppressWarnings("unchecked")
	public ArrayList<Colonne> selectionLabel(String... args){
		    ArrayList<Colonne> temp=new ArrayList<Colonne>();
		    for(int i=0;i<args.length;i++){
		      for(int j=0;i<this.df.size();j++){
		        if(this.df.get(j).getLabel()==args[i]){
		          temp.add(new Colonne("args[i]",this.df.get(j).getListe()));
		        }
		      }
		    }
		    return temp;
		  }

	 @SuppressWarnings("unchecked")
	public ArrayList<Colonne> selectionindex(int... args){
		    ArrayList<Colonne> temp=new ArrayList<Colonne>();
		    int max=0;
		    for(int i=0;i<this.df.size();i++){
		      if(this.df.get(i).size()>max)
		        max=this.df.get(i).size();
		      temp.add(new Colonne(df.get(i).getLabel(),null));
		    }
		    for(int i=0;i<args.length;i++){
		      if (args[i]>=max) continue;
		      for(int j=0;j<this.df.size();j++){
		        if(df.get(j).size()>=args[i])temp.get(j).add(null);
		        else{
		          temp.get(j).add(df.get(j).get(args[i]));
		        }
		      }
		    }
		 return temp;
	 }
}

