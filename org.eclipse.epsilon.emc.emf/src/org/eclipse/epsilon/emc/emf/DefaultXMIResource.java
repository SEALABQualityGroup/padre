package org.eclipse.epsilon.emc.emf;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

public class DefaultXMIResource extends XMIResourceImpl {
	
	protected boolean useXmiIds = super.useUUIDs();
	
	public DefaultXMIResource() {
		super();
	}

	public DefaultXMIResource(URI uri) {
		super(uri);
	}

	@Override
	protected boolean useUUIDs() {
		return useXmiIds;
	}
	
	public void setUseXmiIds(boolean useXmiIds) {
		this.useXmiIds = useXmiIds;
	}
	
	public boolean isUseXmiIds() {
		return useXmiIds;
	}
	
	public static class Factory implements Resource.Factory {

		@Override
		public Resource createResource(URI uri) {
			return new DefaultXMIResource(uri);
		}
		
	}
	
}
