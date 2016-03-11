package org.mybatis.generator.logging;

public abstract interface Log
{
  public abstract boolean isDebugEnabled();

  public abstract void error(String paramString, Throwable paramThrowable);

  public abstract void error(String paramString);

  public abstract void debug(String paramString);

  public abstract void warn(String paramString);
}

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.logging.Log
 * JD-Core Version:    0.6.0
 */