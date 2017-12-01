package org.eclipse.epsilon.eol.compile.m3;

import java.util.ArrayList;
import java.util.List;

public class Package extends NamedElement {
	
	protected List<Package> subPackages = new ArrayList<Package>();
	protected List<MetaType> metaTypes = new ArrayList<MetaType>();
	
	public List<Package> getSubPackages() {
		return subPackages;
	}
	
	public List<MetaType> getTypes() {
		return metaTypes;
	}
	
}
