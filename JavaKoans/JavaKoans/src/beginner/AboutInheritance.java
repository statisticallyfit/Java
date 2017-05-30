package beginner;

import static com.sandwich.koan.constant.KoanConstants.__;
import static com.sandwich.util.Assert.assertEquals;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.sandwich.koan.Koan;

public class AboutInheritance {

    class A{}
    class B extends A{}

	class Parent {
		public String doStuff() { return "parent"; }
        public A makeA() { return new A(); }
	}
	class Child extends Parent {
		public String doStuff() { return "child"; }
		public String doStuff(String s) { return s; }

        /**
         * @todo review again
         * This is also overriding because a 'B' is an 'A'
         */
        public B makeA() { return new B(); }
	}
	
	@Koan
	public void differenceBetweenOverloadingAndOverriding() {
		assertEquals(new Parent().doStuff(), "parent");
		assertEquals(new Child().doStuff(), "child");
		assertEquals(new Child().doStuff("oh no"), "oh no");
	}
	
	abstract class ParentTwo {
		abstract public Collection<?> doStuff();
	}
	
	class ChildTwo extends ParentTwo {
		public List<?> doStuff() { return Collections.emptyList(); };
	}
	
	@Koan
	public void overriddenMethodsMayReturnSubtype() {
		// What do you need to change in order to get rid of the type cast?
		// Why does this work?
		List<?> list = /*this is redundant (List<?>)*/ new ChildTwo().doStuff();
		assertEquals(list instanceof List, true);
	}
}
