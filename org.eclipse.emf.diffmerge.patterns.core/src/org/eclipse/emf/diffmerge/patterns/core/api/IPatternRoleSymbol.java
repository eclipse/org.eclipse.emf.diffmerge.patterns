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
package org.eclipse.emf.diffmerge.patterns.core.api;

/**
 * A symbol which non-ambiguously identifies a role of a pattern
 * @author Olivier Constant
 */
public interface IPatternRoleSymbol extends IPatternSymbol {
  
  /**
   * Return the ID of the role, unique within the pattern
   * @return a non-null ID
   */
  String getRoleId();
  
}
