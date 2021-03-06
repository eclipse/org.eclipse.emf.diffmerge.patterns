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
package org.eclipse.emf.diffmerge.patterns.core.util;

import org.eclipse.emf.diffmerge.patterns.core.api.IPatternRoleSymbol;


/**
 * A simple implementation of IPatternRoleSymbol.
 * @author Olivier Constant
 */
public class BasicPatternRoleSymbol extends AbstractPatternSymbol
implements IPatternRoleSymbol{
  
  /** The ID of the role */
  private final String _roleId;
  
  /**
   * Constructor
   * @param repositoryId_p a non-null repository ID
   * @param patternId_p a non-null pattern ID
   * @param roleId_p a non-null pattern ID
   * @param lastPatternName_p the non-null last name of the pattern
   * @param lastPath_p a potentially null URI as string
   */
  public BasicPatternRoleSymbol(String repositoryId_p, String patternId_p,
      String roleId_p, String lastPatternName_p, String lastPath_p) {
    super(repositoryId_p, patternId_p, lastPatternName_p, lastPath_p);
    _roleId = roleId_p;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.api.IPatternRoleSymbol#getRoleId()
   */
  public String getRoleId() {
    return _roleId;
  }
  
  /**
   * Return whether the given pattern role symbols represent the same role
   * @param symbol1_p a potentially null role pattern symbol
   * @param symbol2_p a potentially null role pattern symbol
   * @return true iff both symbols are null or they contain the same IDs
   */
  public static boolean areEqual(IPatternRoleSymbol symbol1_p, IPatternRoleSymbol symbol2_p) {
    return
      BasicPatternSymbol.areEqual(symbol1_p, symbol2_p) &&
      symbol1_p.getRoleId().equals(symbol2_p.getRoleId());
  }

}
