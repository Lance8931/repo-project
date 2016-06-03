package com.chapter.nine.interfaces.nesting;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年6月3日上午9:27:05
 * @version 1.0
 */
public class NestingInterfaces {
	public class BImp implements A.B {
		public void f() {
		}
	}

	class CImp implements A.C {
		public void f() {
		}
	}

	// 不能实现一个声明在类里的private类型的接口
	// class DImp implements A.D {
	// public void f() {
	// }
	// }
	class EImp implements E {
		public void g() {
		}
	}

	class EGImp implements E.G {
		public void f() {
		}
	}

	class EGImp2 implements E {
		public void g() {
		}

		class EG implements E.G {
			public void f() {
			}
		}
	}

	public static void main(String[] args) {
		A a = new A();
		// 不能直接访问类A里的private接口D
		// A.D ad = a.getD();
		// 不能返回任何
		// A.DImp2 di2 = a.getD();
		// 不能访问一个接口成员
		// a.getD().f();
		A a2 = new A();
		a2.receiveD(a.getD());
	}
}

class A {
	interface B {
		void f();
	}

	public class BImp implements B {
		public void f() {
		}
	}

	private class BImp2 implements B {
		public void f() {
		}
	}

	public interface C {
		void f();
	}

	class CImp implements C {
		public void f() {
		}
	}

	private class CImp2 implements C {
		public void f() {
		}
	}

	private interface D {
		void f();
	}

	private class DImp implements D {
		public void f() {
		}
	}

	private class DImp2 implements D {
		public void f() {
		}
	}

	public D getD() {
		return new DImp2();
	}

	private D dRef;

	public void receiveD(D d) {
		dRef = d;
		dRef.f();
	}

}

interface E {
	interface G {
		void f();
	}

	// 这里的“public”是多余的
	public interface H {
		void f();
	}

	void g();

	// 不能声明一个为private的接口
	// private interface I { }
}
