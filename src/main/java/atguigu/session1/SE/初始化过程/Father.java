package atguigu.session1.SE.初始化过程;
public class Father{
	//这个方法被子类重写，类初始化是父类被重写的不执行，调到执行子类重写的方法
	private int i = test();
	private static int j = method();

	//2 静态代码块
	static{
		System.out.print("(1)");
	}

	// 7 父类构造方法
	Father(){

		System.out.print("(2)");
	}
	//6 非静态代码块
	{
		System.out.print("(3)");
	}
	//这个方法被子类重写，类初始化是父类被重写的不执行
	public int test(){
		System.out.print("(4)");
		return 1;
	}
	//1 执行静态方法
	public static int method(){
		System.out.print("(5)");
		return 1;
	}
}