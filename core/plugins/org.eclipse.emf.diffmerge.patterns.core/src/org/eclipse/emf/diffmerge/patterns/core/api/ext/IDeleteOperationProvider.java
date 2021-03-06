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
package org.eclipse.emf.diffmerge.patterns.core.api.ext;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.diffmerge.patterns.core.api.ext.IModelOperation;
import org.eclipse.emf.diffmerge.patterns.core.api.status.IModelTransformationStatus;


/**
 * A provider of delete operations.
 * @author Olivier Constant
 */
public interface IDeleteOperationProvider {
  
  /**
   * Return a new delete operation.
   * @param toDelete_p a non-null, potentially empty collection of the elements to delete
   * @param skipConfirmation_p whether the user should never be prompted for confirmation
   * @param isExpensive_p whether the operation should be considered as expensive
   * @return a non-null delete operation
   */
  IModelOperation<IModelTransformationStatus> getDeleteOperation(
      Collection<? extends EObject> toDelete_p, boolean skipConfirmation_p, boolean isExpensive_p,
      Object context_p);
  
  /**
   * Return whether the given element belongs to a model.
   * This method is assumed to return false on elements which have been deleted.
   * @param element_p a non-null element
   */
  boolean isInModel(EObject element_p);
  
}
