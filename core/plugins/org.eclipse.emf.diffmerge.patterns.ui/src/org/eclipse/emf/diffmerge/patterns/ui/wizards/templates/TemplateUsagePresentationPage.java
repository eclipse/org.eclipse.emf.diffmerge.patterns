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
package org.eclipse.emf.diffmerge.patterns.ui.wizards.templates;

import org.eclipse.emf.diffmerge.patterns.ui.Messages;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternPresentationPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

import org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.TemplateUsageSpecification;


/**
 * A wizard page for using a template.
 * @author Olivier Constant
 */
public class TemplateUsagePresentationPage extends AbstractPatternPresentationPage<TemplateUsageSpecification> {
  
  /**
   * Constructor
   * @param data_p the non-null data for template usage
   */
  public TemplateUsagePresentationPage(TemplateUsageSpecification data_p) {
    super("MainPage", Messages.PatternBrowsingPresentationPage_Name, //$NON-NLS-1$
        Messages.TemplateUsageWizard_Message,
        data_p, true, PatternSelectionKind.SELECTABLE, false);
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternPresentationPage#createPatternFilterRow(org.eclipse.swt.widgets.Composite)
   */
  @Override
  protected void createPatternFilterRow(Composite parent_p) {
    addEmptyControl(parent_p);
    final Button strictCheckbox = new Button(parent_p, SWT.CHECK);
    strictCheckbox.setText(Messages.TemplateUsagePresentationPage_CompatibilityCheckboxLabel);
    strictCheckbox.setSelection(getData().isStrictCompatibility());
    strictCheckbox.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e_p) {
        getData().setStrictCompatibility(strictCheckbox.getSelection());
      }
    });
    finishRow(parent_p, true);
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternPresentationPage#getExistingPatternRowLabel()
   */
  @Override
  protected String getExistingPatternRowLabel() {
    return Messages.AbstractPatternPresentationPage_TemplateLabel;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.wizards.AbstractPatternPage#getValidationMessage()
   */
  @Override
  protected String getValidationMessage() {
    String result = null;
    if (getData().getRepository() == null)
      result = Messages.PatternApplicationPresentationPage_ConstraintCatalog;
    else if (getData().getPattern() == null)
      result = Messages.TemplateUsagePresentationPage_ConstraintTemplate;
    return result;
  }

  
}
