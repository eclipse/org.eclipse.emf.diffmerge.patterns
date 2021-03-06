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
package org.eclipse.emf.diffmerge.patterns.diagrams.operations;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.diffmerge.patterns.core.operations.AbstractModelOperation;
import org.eclipse.emf.diffmerge.patterns.diagrams.PatternCoreDiagramPlugin;
import org.eclipse.emf.diffmerge.patterns.diagrams.util.AbstractDiagramUtil;
import org.eclipse.emf.diffmerge.util.ModelsUtil;

/**
 * An operation for altering diagram elements based on specific criteria on semantic elements.
 * @author Olivier Constant
 * @author Skander Turki
 */
public abstract class AbstractFilteredGraphicalUpdateOperation extends AbstractModelOperation<Collection<Object>> {

  /**
   * The [non-null iff _diagramElements is null] diagram in which update must occur
   */
  protected final Object _diagram;

  /**
   * The [non-null iff _diagram is null], potentially empty set of diagram elements to update
   */
  protected final Collection<Object> _diagramElements;

  /**
   * The [non-null iff _diagramElements is null] filter for semantic elements whose representation must be updated
   */
  private final ModelsUtil.IElementFilter _filter;

  /** Instance of inner class used to simulate multiple inheritance for leaf operations*/
  protected AbstractGraphicalUpdateOperation _innerGraphicalOperation;
  
  /** Utility class instance used to call diagram-related services from the graphical framework (Sirius for example) */
  protected AbstractDiagramUtil _diagramUtil;

  /**
   * Constructor
   * @param name_p an optional name
   * @param diagram_p the non-null diagram to update
   * @param filter_p the non-null filter for semantic elements whose representation must be updated
   * @param isDirtying_p whether the operation is dirtying
   * @param sourceContext_p an optional context object for the source side of the operation
   */
  protected AbstractFilteredGraphicalUpdateOperation(String name_p, Object diagram_p, 
      ModelsUtil.IElementFilter filter_p, boolean isDirtying_p, Object sourceContext_p) {
    super(name_p, null, isDirtying_p, false, true, diagram_p, sourceContext_p);
    _diagramUtil = PatternCoreDiagramPlugin.getDefault().getDiagramUtilityClass();
    _diagram = diagram_p;
    _filter = filter_p;
    _diagramElements = null;
  }

  /**
   * Constructor
   * @param name_p an optional name
   * @param diagramElements_p the non-null, potentially empty set of diagram elements to update
   */
  protected AbstractFilteredGraphicalUpdateOperation(String name_p, 
      Collection<Object> diagramElements_p, 
      boolean isDirtying_p, Object sourceContext_p) {
    super(name_p, null, isDirtying_p, false, true, diagramElements_p, sourceContext_p);
    _diagramUtil = PatternCoreDiagramPlugin.getDefault().getDiagramUtilityClass();
    _diagram = null;
    _filter = null;
    _diagramElements = diagramElements_p;
  }

  /**
   * Update the given decorator if relevant
   * @param decorator_p a non-null semantic decorator
   * @return whether the decorator was actually updated
   */
  protected final boolean checkUpdate(Object decorator_p, boolean isMerged) {
    boolean result = false;
    if (mustBeUpdated(decorator_p)) {
      update(decorator_p, isMerged);
      result = true;
    }
    return result;
  }

  /**
   * Return the diagram in which update must occur
   * @return a non-null diagram
   */
  public final Object getDiagram() {
    return _diagram;
  }

  /**
   * Return the filter for the semantic elements whose representation must be updated
   * @return a non-null filter
   */
  protected final ModelsUtil.IElementFilter getFilter() {
    return _filter;
  }

  /**
   * Return whether the given decorator must be updated
   * @param decorator_p a non-null semantic decorator
   */
  protected abstract boolean mustBeUpdated(Object decorator_p);


  /**
   * Update the given decorator
   * @param decorator_p a non-null semantic decorator
   */
  protected abstract void update(Object decorator_p, boolean isMerged);


  /**
   * Returns a list of all diagram elements in the given roots.
   * @param roots_p a non-null collection
   * @return a non-null list
   */
  protected abstract List<Object> getAllDiagramElements(Collection<Object> roots_p);


}
