/*******************************************************************************
 * Copyright (c) 2014 Thales Global Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 * Thales Global Services S.A.S - initial API and implementation
 ******************************************************************************/
package org.eclipse.emf.diffmerge.patterns.templates.engine.specifications;

import java.util.Collection;
import java.util.HashSet;

import org.eclipse.emf.diffmerge.patterns.core.api.IPatternRepository;


/**
 * An straightforward implementation of IRepositorySelection.
 * @author O. CONSTANT
 */
public abstract class AbstractRepositorySelection implements IRepositorySelection {
  
  /** The potentially null repository which is selected */
  private IPatternRepository _selectedRepository;
  
  /** The observers */
  private final Collection<IRepositoryChangedListener> _listeners;
  
  
  /**
   * Constructor
   */
  public AbstractRepositorySelection() {
    _selectedRepository = null;
    _listeners = new HashSet<IRepositoryChangedListener>();
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.IRepositorySelection#addSelectedRepositoryListener(org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.IRepositorySelection.IRepositoryChangedListener)
   */
  public void addSelectedRepositoryListener(IRepositoryChangedListener listener_p) {
    _listeners.add(listener_p);
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.IRepositorySelection#getRepository()
   */
  public IPatternRepository getRepository() {
    return _selectedRepository;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.patterns.templates.engine.specifications.IRepositorySelection#setRepository(org.eclipse.emf.diffmerge.patterns.core.api.IPatternRepository)
   */
  public void setRepository(IPatternRepository repository_p) {
    _selectedRepository = repository_p;
    for (IRepositoryChangedListener listener : _listeners)
      listener.repositoryChanged(repository_p);
  }
  
}
