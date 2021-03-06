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
package org.eclipse.emf.diffmerge.patterns.diagrams.misc;

import org.eclipse.swt.graphics.RGB;


/**
 * A specification of how to highlight a pattern instance.
 * @author Olivier Constant
 * @author Skander Turki
 */
public class HighlightingSpecification {
  /** The default highlighting color */
  private static final RGB DEFAULT_HIGHLIGHTING_COLOR = new RGB(255, 0, 0);
  /** The default specification used by the default constructor */
  private static final HighlightingSpecification __default = new HighlightingSpecification(DEFAULT_HIGHLIGHTING_COLOR);
  /** The color for instance highlighting */
  public RGB color;
  /** Whether edges are covered when highlighting */
  public boolean coverEdges;
  /** Whether containers are covered when highlighting */
  public boolean coverNodes;
  /** Whether ports are covered when highlighting */
  public boolean coverPorts;

  /**
   * Default constructor
   */
  public HighlightingSpecification() {
    color = __default.color;
    coverEdges = __default.coverEdges;
    coverNodes = __default.coverNodes;
    coverPorts = __default.coverPorts;
  }

  /**
   * Constructor
   * @param color_p a non-null color
   */
  private HighlightingSpecification(RGB color_p) {
    color = color_p;
    coverEdges = true;
    coverNodes = true;
    coverPorts = true;
  }

  /**
   * Set the receiver as the default specification
   */
  public void setAsDefault() {
    __default.color = color;
    __default.coverEdges = coverEdges;
    __default.coverNodes = coverNodes;
    __default.coverPorts = coverPorts;
  }
}
