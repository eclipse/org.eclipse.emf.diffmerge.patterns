/*******************************************************************************
 * Copyright (c) 2014 Thales Global Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 * Thales Global Services S.A.S - initial API and implementation
 ******************************************************************************/
package org.eclipse.emf.diffmerge.patterns.templates.engine.specifications;

import org.eclipse.emf.diffmerge.patterns.core.api.IPatternProvider;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePattern;
import org.eclipse.emf.diffmerge.patterns.templates.gen.templatepatterns.TemplatePatternRole;


/**
 * An observable object dealing with the selection of a pattern role.
 * @author O. CONSTANT
 */
public interface IRoleSelection extends IPatternProvider {
  
  /**
   * An interface for observers which are concerned with the role currently selected
   */
  public static interface IRoleChangedListener {
    /**
     * Notifies that the selected role changed
     * @param newRole_p a potentially null role
     */
    void roleChanged(TemplatePatternRole newRole_p);
  }
  
  
  /**
   * Add a listener on the selected role
   * @param listener_p a non-null listener
   */
  void addSelectedRoleListener(IRoleChangedListener listener_p);
  
  /**
   * Refinement by covariance of IPatternProvider.getPattern()
   * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternProvider#getPattern()
   */
  TemplatePattern getPattern();
  
  /**
   * Return the selected role
   * @return a potentially null role
   */
  TemplatePatternRole getRole();
  
  /**
   * Notify that the selected role was not changed but updated
   */
  void roleUpdated();
  
  /**
   * Set the selected role
   * @param pattern_p a potentially null role
   */
  void setRole(TemplatePatternRole role_p);
  
}
