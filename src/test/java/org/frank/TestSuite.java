package org.frank;

import org.junit.platform.suite.api.IncludePackages;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages({"org.frank.acceptanceTest", "org.frank"})
public class TestSuite {
}
