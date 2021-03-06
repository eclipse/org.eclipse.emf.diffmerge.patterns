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
package org.eclipse.emf.diffmerge.patterns.ui.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.diffmerge.patterns.core.CorePatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.PatternRepository;
import org.eclipse.emf.diffmerge.patterns.repositories.catalogs.operations.OpenCatalogOperation;
import org.eclipse.emf.diffmerge.patterns.ui.util.UIUtil;
import org.eclipse.emf.diffmerge.patterns.ui.wizards.PatternWizardDialog;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;


/**
 * An action for opening catalogs.
 * @author Olivier Constant
 * @author Skander Turki
 */
public class OpenCatalogAction extends AbstractContextualAction<IFile> {

  /**
   * Constructor
   */
  public OpenCatalogAction() {
    super(IFile.class);
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.actions.AbstractModelBasedAction#coreRun(java.util.List)
   */
  @Override
  protected void coreRun(List<Object> selection_p) {
    if (!selection_p.isEmpty()) {
      Object context = selection_p.get(0);
      EditingDomain domain = null;
      if(context instanceof IFile){
        domain = CorePatternsPlugin.getDefault().getModelEnvironment().getEditingDomain((IFile)context);
      }else if(context instanceof EObject){
        domain = CorePatternsPlugin.getDefault().getModelEnvironment().getEditingDomain((EObject)context);
      }
      if (domain instanceof TransactionalEditingDomain) {
        Collection<PatternRepository> repositories = new ArrayList<PatternRepository>();
        Iterator<Object> it = selection_p.iterator();
        while(it.hasNext()){
          Object current = it.next();
          OpenCatalogOperation operation =
              new OpenCatalogOperation(current, (TransactionalEditingDomain)domain);
          Collection<PatternRepository> result = executeOperation(operation);
          if(result != null && !result.isEmpty()){
            repositories.add(result.iterator().next()); 
          }
          if (!operation.getErrors().isEmpty()) {
            UIUtil.informRepositoryOpeningError(getShell(), operation.getErrors());
            return;
          }
        }
        PatternRepository repository = repositories.isEmpty()? null: repositories.iterator().next();
        if (repository != null) {
          PatternWizardDialog dialog = new PatternWizardDialog(getShell(),
              _dialogAndWizardFactory.instantiatePatternBrowsingWizard(domain.getResourceSet(), repository), true, null);
          dialog.open();
        }
      }
    }
  }

  /**
   * @see org.eclipse.emf.diffmerge.patterns.ui.actions.AbstractContextualAction#mustBeEnabled()
   */
  @Override
  protected boolean mustBeEnabled() {
    return true; //TODO refine
  }

}
