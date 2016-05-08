package toothpick;

import java.util.regex.Pattern;
import org.hamcrest.text.MatchesPattern;
import org.junit.Test;
import toothpick.config.Module;
import toothpick.data.Bar;
import toothpick.data.Foo;

import static org.junit.Assert.assertThat;

public class ScopeImplDumpTest extends ToothPickBaseTest {

  @Test
  public void testToString() {
    //GIVEN
    ScopeImpl scope = new ScopeImpl("root");
    scope.installModules(new TestModule1());
    ScopeImpl childScope = new ScopeImpl("child");
    scope.addChild(childScope);

    //WHEN
    childScope.getInstance(Bar.class);
    String dump = scope.toString();

    //THEN
    Pattern expected = Pattern.compile("root:\\d+.*"
        + "Providers: \\[toothpick.data.Foo,toothpick.Scope\\].*"
        + "\\\\---child:\\d+.*"
        + "Providers:.*\\[toothpick.Scope\\].*"
        + "UnScoped providers: \\[toothpick.data.Bar\\].*", Pattern.DOTALL);
    assertThat(dump, MatchesPattern.matchesPattern(expected));
  }

  private static class TestModule1 extends Module {
    public TestModule1() {
      bind(Foo.class).to(Foo.class);
    }
  }
}