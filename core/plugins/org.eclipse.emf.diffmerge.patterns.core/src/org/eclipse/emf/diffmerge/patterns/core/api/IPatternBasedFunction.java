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
package org.eclipse.emf.diffmerge.patterns.core.api;

import java.util.List;

import org.eclipse.emf.ecore.EObject;


/**
 * A specification of data related to a given pattern including a non-injective
 * function from model elements to elements of the pattern. The function is defined
 * as the extension of a bijection.
 * @author Olivier Constant
 */
public interface IPatternBasedFunction extends IPatternBasedBijection {
  
  /**
   * Return the counterparts of the given pattern element
   * @param patternElement_p a non-null element
   * @return a non-null, potentially empty, unmodifiable list
   */
  public List<EObject> getCounterparts(EObject patternElement_p);
  
}
