package org.frank;

import org.frank.acceptanceTest.UserStoryNine;
import org.frank.acceptanceTest.UserStorySixteen;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages({"org.frank.acceptanceTest", "org.frank"})
@SelectClasses({UserStoryNine.class, UserStorySixteen.class})
public class TestSuite {
}
