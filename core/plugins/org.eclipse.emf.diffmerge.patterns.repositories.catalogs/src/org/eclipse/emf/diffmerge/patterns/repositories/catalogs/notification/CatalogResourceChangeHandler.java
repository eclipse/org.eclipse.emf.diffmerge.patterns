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
package org.eclipse.emf.diffmerge.patterns.repositories.catalogs.notification;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.diffmerge.patterns.core.CorePatternsPlugin;
import org.eclipse.emf.diffmerge.patterns.core.gen.corepatterns.PatternRepository;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.change.util.ChangeRecorder;

/**
 * A change handler for pattern catalog resources.
 * Resolves unexpected resource unloading and manual resource deletion.
 * @author Skander Turki
 *
 */
public class CatalogResourceChangeHandler extends ChangeRecorder{

  /** The watched repository */
  private PatternRepository _patternRepository;

  /**
   * Constructor
   * @param repository_p a non-null PatternRepository
   */
  public CatalogResourceChangeHandler(PatternRepository repository_p){
    super(repository_p);
    _patternRepository = repository_p;
  }

  /**
   * 
   * @see org.eclipse.emf.ecore.change.util.ChangeRecorder#shouldRecord(org.eclipse.emf.ecore.EStructuralFeature, org.eclipse.emf.ecore.EReference, org.eclipse.emf.common.notify.Notification, org.eclipse.emf.ecore.EObject)
   */
  @Override
  protected boolean shouldRecord(EStructuralFeature feature, EReference containment, Notification notification, EObject eObject)
  {
    return shouldRecord(feature, eObject) &&
        notification.getEventType() != Notification.RESOLVE
        && notification.getNotifier() instanceof PatternRepository &&
        (((EObject)notification.getNotifier()).eResource() == null)
        ;
  }

  /**
   * 
   * @see org.eclipse.emf.ecore.change.util.ChangeRecorder#notifyChanged(org.eclipse.emf.common.notify.Notification)
   */
  @Override
  public void notifyChanged(Notification notification)
  {
    Object notifier = notification.getNotifier();
    if (notifier instanceof PatternRepository)
    {
      PatternRepository pat = (PatternRepository) notifier;
      if(pat.eResource() == null)
        //Action to be taken when PatternRepository's resource becomes null
        CorePatternsPlugin.getDefault().getRepositoryRegistry().unregister(_patternRepository);
    }
  }

}
