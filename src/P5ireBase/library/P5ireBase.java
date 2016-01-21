/**
 * P5ireBase
 * A collection of utilities for solving this and that problem.
 * http://yourlibraryname.com
 *
 * Copyright (c) 2013 Your Name http://yoururl.com
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General
 * Public License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place, Suite 330,
 * Boston, MA  02111-1307  USA
 * 
 * @author      Your Name http://yoururl.com
 * @modified    01/21/2016
 * @version     1.0.0 (1)
 */

package P5ireBase.library;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;



import processing.core.*;

/**
 * This is a template class and can be used to start a new processing library or tool.
 * Make sure you rename this class as well as the name of the example package 'template' 
 * to your own library or tool naming convention.
 * 
 * @example Hello 
 * 
 * (the tag @example followed by the name of an example included in folder 'examples' will
 * automatically include the example in the javadoc.)
 *
 */

public class P5ireBase {

	
	// myParent is a reference to the parent sketch
	PApplet myParent;
	Firebase myFirebaseRef;
	String elValor;

	int myVariable = 0;
	public final static String VERSION = "1.0.0";
	

	/**
	 * a Constructor, usually called in the setup() method in your sketch to
	 * initialize and start the library.
	 * 
	 * @example Hey
	 * @param theParent
	 */
	public P5ireBase(PApplet theParent,String ruta) {
		myFirebaseRef = new Firebase(ruta);//My cloudDB
		myParent = theParent;
		welcome();
		
	}
	
	
	public void setValue(String key,String valor){
		myFirebaseRef.child(key).setValue(valor);//Put
	}
	
	public String getValue(String key){
		 //Get
		  myFirebaseRef.child(key).addValueEventListener(new ValueEventListener() {
			@Override
		      public void onDataChange(DataSnapshot snapshot) {
		    System.out.println(snapshot.getValue());  //prints "Do you have data? You'll love Firebase."
		    elValor = snapshot.getValue().toString();
		    }

		    @Override public void onCancelled(FirebaseError error) {
		    }
		  }
		  );

		  return elValor;
	}
	
	private void welcome() {
		System.out.println("##P5ireBase## ##1.0## by ##Mario Alzate##");
	}
	
	
	public String sayHello() {
		return "hello p5ireBase.";
	}
	/**
	 * return the version of the library.
	 * 
	 * @return String
	 */
	public static String version() {
		return VERSION;
	}

	/**
	 * 
	 * @param theA
	 *          the width of test
	 * @param theB
	 *          the height of test
	 */
	public void setVariable(int theA, int theB) {
		myVariable = theA + theB;
	}

	/**
	 * 
	 * @return int
	 */
	public int getVariable() {
		return myVariable;
	}
}

