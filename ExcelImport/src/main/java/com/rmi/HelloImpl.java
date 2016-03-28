package com.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年3月28日下午5:41:23
 * @version 1.0 定义一个远程接口，必须继承Remote接口，其中需要远程调用的方法必须抛出RemoteException异常
 */
public class HelloImpl extends UnicastRemoteObject implements IHello {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 因为UnicastRemoteObject的构造方法抛出了RemoteException异常，因此这里默认的构造方法必须写，
	 * 必须声明抛出RemoteException异常
	 * 
	 * @throws RemoteException
	 */
	public HelloImpl() throws RemoteException {
	}

	/**
	 * 简单的返回“Hello World！"字样
	 * 
	 * @return 返回“Hello World！"字样
	 * @throws java.rmi.RemoteException
	 */
	public String helloWorld() throws RemoteException {
		return "Hello World!";
	}

	/**
	 * 一个简单的业务方法，根据传入的人名返回相应的问候语
	 * 
	 * @param someBodyName
	 *            人名
	 * @return 返回相应的问候语
	 * @throws java.rmi.RemoteException
	 */
	public String sayHelloToSomeBody(String someBodyName)
			throws RemoteException {
		return "你好，" + someBodyName + "!";
	}
}