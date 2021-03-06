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


import org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelOperation;
import org.eclipse.emf.diffmerge.patterns.core.operations.AbstractModelOperation;
import org.eclipse.emf.diffmerge.patterns.diagrams.Messages;


/**
 * An abstract model operation that wraps another one and performs additional treatment
 * for graphical concerns in a certain diagram.
 * @param <T> the type parameter of this operation
 * @param <F> the type parameter of the wrapped operation
 * @author Olivier Constant
 * @author Skander Turki
 */
public abstract class AbstractGraphicalWrappingOperation<T, F> 
extends AbstractModelOperation<T> {

  /** The optional wrapped operation */
  private final IModelOperation<? extends F> _operation;

  /** The optional diagram for graphical concerns */
  private final Object _diagram;

  /**
   * Constructor
   * @param operation_p a potentially null operation to wrap
   * @param diagram_p an optional diagram to refresh
   * @param sourceContext_p an optional context object for the source side of the operation
   * @param targetContext_p an optional context object for the target side of the operation
   */
  public AbstractGraphicalWrappingOperation(IModelOperation<? extends F> operation_p, 
      Object diagram_p, Object sourceContext_p, Object targetContext_p) {
    super(
        operation_p != null? operation_p.getName(): Messages.AbstractViewpointWrappingOperation_Refresh,
        operation_p != null? operation_p.getResourceSet(): null,
        operation_p != null? operation_p.isDirtying(): true,
        operation_p != null? operation_p.isReadOnly(): false,
        operation_p != null? operation_p.isExpensive(): false,
        sourceContext_p, targetContext_p);
    _operation = operation_p;
    _diagram = diagram_p;
  }

  /**
   * Return the diagram for handling graphical concerns
   * @return a potentially null diagram
   */
  public Object getDiagram() {
    return _diagram;
  }

  /**
   * Return the operation being wrapped
   * @return a potentially null operation
   */
  protected IModelOperation<? extends F> getWrappedOperation() {
    return _operation;
  }

}
