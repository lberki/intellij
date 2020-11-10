/*
 * Copyright 2020 The Bazel Authors. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.idea.blaze.android.sync.model.idea;

import com.android.builder.model.SourceProvider;
import com.intellij.openapi.project.Project;
import java.io.File;

/** Blaze model for an androidp project. #api42. */
public class BlazeAndroidModel extends BlazeAndroidModelBase {
  private final SourceProvider sourceProvider;
  private final List<SourceProvider> sourceProviders; // Singleton list of sourceProvider

  public BlazeAndroidModel(
      Project project,
      File rootDirPath,
      SourceProvider sourceProvider,
      String applicationId,
      int minSdkVersion,
      boolean desugarJava8Libs) {
    super(project, rootDirPath, applicationId, minSdkVersion, desugarJava8Libs);
    this.sourceProvider = sourceProvider;
    this.sourceProviders = ImmutableList.of(sourceProvider);
  }

  // @Override #api3.6
  public List<SourceProvider> getActiveSourceProviders() {
    return sourceProviders;
  }

  // @Override #api3.6
  public List<SourceProvider> getTestSourceProviders() {
    return sourceProviders;
  }

  // @Override #api3.6
  public List<SourceProvider> getAllSourceProviders() {
    return sourceProviders;
  }

  // @Override #api3.6
  public SourceProvider getDefaultSourceProvider() {
    return sourceProvider;
  }

  @Override
  public AaptOptions.Namespacing getNamespacing() {
    return AaptOptions.Namespacing.DISABLED;
  }
}
