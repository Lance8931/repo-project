package org.mybatis.generator.api.dom.java;

import java.util.List;
import java.util.Set;

public abstract interface CompilationUnit
{
  public abstract String getFormattedContent();

  public abstract Set<FullyQualifiedJavaType> getImportedTypes();

  public abstract FullyQualifiedJavaType getSuperClass();

  public abstract boolean isJavaInterface();

  public abstract boolean isJavaEnumeration();

  public abstract Set<FullyQualifiedJavaType> getSuperInterfaceTypes();

  public abstract FullyQualifiedJavaType getType();

  public abstract void addImportedType(FullyQualifiedJavaType paramFullyQualifiedJavaType);

  public abstract void addImportedTypes(Set<FullyQualifiedJavaType> paramSet);

  public abstract void addFileCommentLine(String paramString);

  public abstract List<String> getFileCommentLines();
}

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.api.dom.java.CompilationUnit
 * JD-Core Version:    0.6.0
 */