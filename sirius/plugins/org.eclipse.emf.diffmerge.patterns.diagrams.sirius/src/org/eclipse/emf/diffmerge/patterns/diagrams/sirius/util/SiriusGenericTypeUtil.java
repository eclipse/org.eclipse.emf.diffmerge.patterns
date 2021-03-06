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
package org.eclipse.emf.diffmerge.patterns.diagrams.sirius.util;

import org.eclipse.emf.diffmerge.patterns.core.environment.AbstractGenericTypeUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.sirius.diagram.AbstractDNode;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.diagram.DDiagramElementContainer;
import org.eclipse.sirius.diagram.DNodeContainer;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.sirius.viewpoint.RGBValues;


/**
 * This is a Sirius-specific utility class that provides "instanceof" checking for generic types. 
 * @author Skander Turki
 */
public class SiriusGenericTypeUtil 
extends AbstractGenericTypeUtil{

  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.core.environment.AbstractGenericTypeUtil#isInstanceOfColorType(java.lang.Object)
   */
  @Override
  public boolean isInstanceOfColorType(Object object_p) {
    return object_p instanceof RGBValues;
  }

  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.core.environment.AbstractGenericTypeUtil#isInstanceOfDiagramElementType(java.lang.Object)
   */
  @Override
  public boolean isInstanceOfDiagramElementType(Object object_p) {
    return object_p instanceof DDiagramElement;
  }

  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.core.environment.AbstractGenericTypeUtil#isInstanceOfDiagramType(java.lang.Object)
   */
  @Override
  public boolean isInstanceOfDiagramType(Object object_p) {
    return object_p instanceof DDiagram;
  }

  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.core.environment.AbstractGenericTypeUtil#isInstanceOfGraphicalNodeType(java.lang.Object)
   */
  @Override
  public boolean isInstanceOfGraphicalNodeType(Object object_p) {
    return object_p instanceof AbstractDNode;
  }

  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.core.environment.AbstractGenericTypeUtil#isInstanceOfGraphicalNodeType(java.lang.Object)
   */
  @Override
  public boolean isInstanceOfGraphicalNodeContainerType(Object object_p) {
    return object_p instanceof DNodeContainer;
  }

  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.core.environment.AbstractGenericTypeUtil#isInstanceOfGraphicalPartType(java.lang.Object)
   */
  @Override
  public boolean isInstanceOfGraphicalPartType(Object object_p) {
    return object_p instanceof IGraphicalEditPart;
  }

  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.core.environment.AbstractGenericTypeUtil#isInstanceOfGraphicalContainerType(java.lang.Object)
   */
  @Override
  public boolean isInstanceOfGraphicalContainerType(Object object_p) {
    return ((object_p instanceof DDiagram) || (object_p instanceof DDiagramElementContainer));
  }

  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.core.environment.AbstractGenericTypeUtil#isInstanceOfSemanticRepresentationType(java.lang.Object)
   */
  @Override
  public boolean isInstanceOfSemanticRepresentationType(Object object_p) {
    return object_p instanceof DSemanticDecorator;
  }

  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.core.environment.AbstractGenericTypeUtil#getColorTypeClass()
   */
  @Override
  public  Class<?> getColorTypeClass() {
    return RGBValues.class;
  }

  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.core.environment.AbstractGenericTypeUtil#getDiagramElementTypeClass()
   */
  @Override
  public Class<?> getDiagramElementTypeClass() {
    return DDiagramElement.class;
  }

  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.core.environment.AbstractGenericTypeUtil#getDiagramTypeClass()
   */
  @Override
  public Class<?> getDiagramTypeClass() {
    return DDiagram.class;
  }

  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.core.environment.AbstractGenericTypeUtil#getGraphicalNodeTypeClass()
   */
  @Override
  public Class<?> getGraphicalNodeTypeClass() {
    return AbstractDNode.class;
  }

  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.core.environment.AbstractGenericTypeUtil#getGraphicalPartTypeClass()
   */
  @Override
  public Class<?> getGraphicalPartTypeClass() {
    return IGraphicalEditPart.class;
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.core.environment.AbstractGenericTypeUtil#getGraphicalNodeContainerTypeClass()
   */
  @Override
  public Class<?> getGraphicalNodeContainerTypeClass(){
    return DNodeContainer.class;
  }

  /**
   * 
   * @see org.eclipse.emf.diffmerge.patterns.core.environment.AbstractGenericTypeUtil#getSemanticRepresentationTypeClass()
   */
  @Override
  public Class<?> getSemanticRepresentationTypeClass() {
    return DSemanticDecorator.class
        ;
  }


}
