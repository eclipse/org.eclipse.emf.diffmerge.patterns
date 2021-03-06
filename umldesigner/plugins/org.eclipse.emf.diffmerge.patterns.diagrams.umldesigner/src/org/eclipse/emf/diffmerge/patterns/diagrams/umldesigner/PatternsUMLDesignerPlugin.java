/*********************************************************************
 * Copyright (c) 2010-2014 Thales Global Services S.A.S.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Thales Global Services S.A.S. - initial API and implementation
 **********************************************************************/
package org.eclipse.emf.diffmerge.patterns.diagrams.umldesigner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;


/**
 * The activator class for this plug-in.
 * @author Skander Turki
 */
public class PatternsUMLDesignerPlugin implements BundleActivator {
  
  /** The bundle context, non-null after activation */
	private static BundleContext context;
	
	/**
	 * Return the bundle context
	 * @return a bundle context which is not null after activation
	 */
	static BundleContext getContext() {
		return context;
	}
	
	/**
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		PatternsUMLDesignerPlugin.context = bundleContext;
	}
	
	/**
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		PatternsUMLDesignerPlugin.context = null;
	}
	
}
