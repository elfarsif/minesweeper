package org.frank;

import org.frank.acceptanceTest.UserStoryNine;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages({"org.frank.acceptanceTest", "org.frank"})
@SelectClasses({UserStoryNine.class})
public class TestSuite {
}
