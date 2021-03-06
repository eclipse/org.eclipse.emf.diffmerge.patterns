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
package org.eclipse.emf.diffmerge.patterns.templates.engine.specifications;

import java.util.Collection;

import org.eclipse.emf.diffmerge.patterns.core.api.IPatternBasedSpecification;
import org.eclipse.emf.diffmerge.patterns.core.api.IPatternRepository;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole;
import org.eclipse.emf.ecore.EObject;


/**
 * A specification of data related to a template pattern, but whose result is not necessarily
 * a template pattern.
 * @author Olivier Constant
 */
public interface ITemplatePatternBasedSpecification extends IPatternBasedSpecification {
  
  /**
   * Return all the elements that are concerned with the specification
   * @return a non-null, potentially empty, unmodifiable set
   */
  Collection<EObject> getAllElements();
  
  /**
   * @see ITemplatePatternBasedSpecification#getPattern()
   * Redefinition by covariance
   */
  TemplatePattern getPattern();
  
  /**
   * Return the current repository, which may be different from the repository of the pattern
   * @return a potentially null repository
   */
  IPatternRepository getRepository();
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternBasedSpecification#getRolesOf(org.eclipse.emf.ecore.EObject)
   */
  Collection<TemplatePatternRole> getRolesOf(EObject modelElement_p);
  
  /**
   * Return whether the given pattern is such that getPattern() could return it
   * @param pattern_p a non-null pattern
   */
  boolean isAcceptable(TemplatePattern pattern_p);
  
  /**
   * Return whether the given element is related to instance data
   * @param element_p a non-null element
   */
  boolean isInstanceRelated(EObject element_p);
  
}
