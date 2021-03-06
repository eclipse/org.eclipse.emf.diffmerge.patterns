/*********************************************************************
 * Copyright (c) 2010-2018 Thales Global Services S.A.S.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Thales Global Services S.A.S. - initial API and implementation
 **********************************************************************/
package org.eclipse.emf.diffmerge.patterns.core.util.locations;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.diffmerge.patterns.core.api.locations.IAttributeLocation;


/**
 * A simple implementation of IAttributeLocation.
 * @author Olivier Constant
 */
public class BasicAttributeLocation extends AbstractFeatureRelativeLocation implements IAttributeLocation {
  
  /**
   * Constructor
   * @param element_p the non-null element of this location
   * @param attribute_p the non-null attribute of this location
   */
  public BasicAttributeLocation(EObject element_p, EAttribute attribute_p) {
    super(element_p, attribute_p);
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.IAttributeLocation#getAttribute()
   */
  public EAttribute getAttribute() {
    return (EAttribute)getFeature();
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.ILocation#supportsAddition()
   */
  public boolean supportsAddition() {
    return false;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.locations.ILocation#supportsMerge()
   */
  public boolean supportsMerge() {
    return false;
  }
  
}
