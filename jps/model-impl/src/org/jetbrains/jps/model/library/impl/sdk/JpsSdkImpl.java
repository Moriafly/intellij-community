// Copyright 2000-2024 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package org.jetbrains.jps.model.library.impl.sdk;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.jps.model.JpsElement;
import org.jetbrains.jps.model.JpsElementFactory;
import org.jetbrains.jps.model.ex.JpsCompositeElementBase;
import org.jetbrains.jps.model.library.impl.JpsLibraryImpl;
import org.jetbrains.jps.model.library.sdk.JpsSdk;
import org.jetbrains.jps.model.library.sdk.JpsSdkReference;
import org.jetbrains.jps.model.library.sdk.JpsSdkType;

import java.util.Objects;

public class JpsSdkImpl<P extends JpsElement> extends JpsCompositeElementBase<JpsSdkImpl<P>> implements JpsSdk<P> {
  private final JpsSdkType<P> mySdkType;
  private String myHomePath;
  private String myVersionString;

  public JpsSdkImpl(String homePath, String versionString, JpsSdkType<P> type, P properties) {
    myHomePath = homePath;
    myVersionString = versionString;
    mySdkType = type;
    myContainer.setChild(type.getSdkPropertiesRole(), properties);
  }

  private JpsSdkImpl(JpsSdkImpl<P> original) {
    super(original);
    mySdkType = original.mySdkType;
    myHomePath = original.myHomePath;
    myVersionString = original.myVersionString;
  }

  @Override
  public @NotNull JpsSdkImpl<P> createCopy() {
    return new JpsSdkImpl<>(this);
  }

  @Override
  public P getSdkProperties() {
    return myContainer.getChild(mySdkType.getSdkPropertiesRole());
  }

  @Override
  public JpsSdkReference<P> createReference() {
    return JpsElementFactory.getInstance().createSdkReference(getParent().getName(), mySdkType);
  }

  @Override
  public JpsSdkType<P> getSdkType() {
    return mySdkType;
  }

  @Override
  public @NotNull JpsLibraryImpl<JpsSdk<P>> getParent() {
    //noinspection unchecked
    return (JpsLibraryImpl<JpsSdk<P>>)super.getParent();
  }

  @Override
  public String getHomePath() {
    return myHomePath;
  }

  @Override
  public void setHomePath(String homePath) {
    if (!Objects.equals(myHomePath, homePath)) {
      myHomePath = homePath;
    }
  }

  @Override
  public String getVersionString() {
    return myVersionString;
  }

  @Override
  public void setVersionString(String versionString) {
    if (!Objects.equals(myVersionString, versionString)) {
      myVersionString = versionString;
    }
  }
}
