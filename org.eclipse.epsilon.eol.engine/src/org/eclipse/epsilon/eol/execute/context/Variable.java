/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.execute.context;

import org.eclipse.epsilon.eol.exceptions.EolIllegalVariableAssignmentException;
import org.eclipse.epsilon.eol.exceptions.EolReadOnlyVariableException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.DeprecationInfo;
import org.eclipse.epsilon.eol.types.EolAnyType;
import org.eclipse.epsilon.eol.types.EolType;

public class Variable {
	
	protected String name = "";
	protected Object value = null;
	protected EolType type = null;
	protected boolean readOnly = false;
	protected DeprecationInfo deprecationInfo;
	
	public DeprecationInfo getDeprecationInfo() {
		return deprecationInfo;
	}

	public void setDeprecationInfo(DeprecationInfo deprecationInfo) {
		this.deprecationInfo = deprecationInfo;
	}

	public Variable(){
		
	}
	
	public Variable clone() {
		Variable clone = new Variable();
		clone.name = name;
		clone.value = value;
		clone.type = type;
		clone.readOnly = readOnly;
		return clone;
	}
	
	public Variable(String name, Object value, EolType type, boolean readOnly){
		this.name = name;
		this.type = type;
		this.value = value;
		this.readOnly = readOnly;
	}
	
	public void dispose () {
		this.type = null;
		this.value = null;
	}
	
	public Variable(String name, EolType type) {
		this.name = name;
		this.type = type;
	}
	
	public Variable(String name, Object value, EolType type){
		this.name = name;
		this.type = type;
		this.value = value;
	}
	
	public Object getValue(){
		return value;
	}
	
	public void setValue(Object newValue, IEolContext context) throws EolRuntimeException {
		if (this.isReadOnly()) throw new EolReadOnlyVariableException(this);
		if (newValue!=null && !this.getType().isKind(newValue)) throw new EolIllegalVariableAssignmentException(this, this.getType(), newValue, context);
		this.value = newValue;
	}
	
	public void setValueBruteForce(Object newValue) {
		this.value = newValue;
	}
	
	public void setType(EolType type){
		this.type = type;
	}
	
	public EolType getType(){
		return type;
	}
	
	public boolean isReadOnly(){
		return readOnly;
	}
	
	public void setReadOnly(boolean readOnly){
		this.readOnly = readOnly;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Variable))
			return false;
		
		final Variable other = (Variable)obj;
		
		return equals(name,     other.name)  &&
		       equals(value,    other.value) &&
		       equals(type,     other.type)  &&
		       equals(readOnly, other.readOnly);
	}
	
	private boolean equals(Object first, Object second) {
		return first == null ? second == null : first.equals(second);
	}
	
	@Override
	public int hashCode() {
		// equal objects must have same hashcode,
		// but non-equal objects do not have to have
		// different hashcodes (although this may improve lookup
		// times in collections)
		//   => name is a decent approximation
		
		return name == null ? 0 : name.hashCode();
	}
	
	@Override
	public String toString(){
		return value + " " + type;
	}
	
	public static Variable createReadOnlyVariable(String name, Object value){
		return new Variable(name, value, EolAnyType.Instance, true);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
