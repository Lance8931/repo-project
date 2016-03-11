package org.mybatis.generator.api;

public abstract interface ProgressCallback
{
  public abstract void introspectionStarted(int paramInt);

  public abstract void generationStarted(int paramInt);

  public abstract void saveStarted(int paramInt);

  public abstract void startTask(String paramString);

  public abstract void done();

  public abstract void checkCancel()
    throws InterruptedException;
}

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.api.ProgressCallback
 * JD-Core Version:    0.6.0
 */