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
package org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns;

import org.eclipse.emf.diffmerge.patterns.core.api.IPatternVersion;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pattern Version</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.PatternVersion#getPatternSymbol <em>Pattern Symbol</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.CorepatternsPackage#getPatternVersion()
 * @model superTypes="org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.AbstractVersionedElement org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.predefined.IPatternVersion"
 * @generated
 */
public interface PatternVersion extends AbstractVersionedElement, IPatternVersion {
	/**
	 * Returns the value of the '<em><b>Pattern Symbol</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pattern Symbol</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pattern Symbol</em>' containment reference.
	 * @see #setPatternSymbol(PatternSymbol)
	 * @see org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.CorepatternsPackage#getPatternVersion_PatternSymbol()
	 * @model containment="true" required="true"
	 * @generated
	 */
	PatternSymbol getPatternSymbol();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.PatternVersion#getPatternSymbol <em>Pattern Symbol</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pattern Symbol</em>' containment reference.
	 * @see #getPatternSymbol()
	 * @generated
	 */
	void setPatternSymbol(PatternSymbol value);

} // PatternVersion
