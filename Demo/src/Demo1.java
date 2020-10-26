
class a {
	public static class b {
		public static int c = 5;
	}
}

class c {
	public static class b {
		public static int a = 5;
	}
}

public class Demo1 {
	static public void main(String[] args) {
		a.b.c = c.b.a;
	}

}