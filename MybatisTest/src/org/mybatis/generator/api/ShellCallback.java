package org.mybatis.generator.api;

import java.io.File;
import org.mybatis.generator.exception.ShellException;

public abstract interface ShellCallback
{
  public abstract File getDirectory(String paramString1, String paramString2)
    throws ShellException;

  public abstract String mergeJavaFile(String paramString1, String paramString2, String[] paramArrayOfString)
    throws ShellException;

  public abstract void refreshProject(String paramString);

  public abstract boolean isMergeSupported();

  public abstract boolean isOverwriteEnabled();
}

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.api.ShellCallback
 * JD-Core Version:    0.6.0
 */