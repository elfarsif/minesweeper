package org.frank;

import org.frank.acceptanceTest.UserStoryFourteen;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages({"org.frank.acceptanceTest", "org.frank"})
@SelectClasses({UserStoryFourteen.class})
public class TestSuite {
}
