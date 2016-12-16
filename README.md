# Web-Test-Framework
A testing framework written in Java designed to be lightweight and test websites for regressions based on a criteria set. 


<h1>Prerequisites</h1>
<ul>
<li>You'll need to be able to complie and run Java.</li>
<li>Install Selenium Webdriver for Java</li>
</ul>

<h1>How to Run</h1>
<strong>TLDR:</strong>
<ul>
<li>Create a testSuite or use exisiting Google_testSuite.java</li>
<li>Run testRunner.java</li>
<li>Observe the terminal output.....Enjoy</li>
</ul>


<h2>baseTest.java:</h2>
This is the base class for all tests. It has two methods, 
<ul>
<li>testSetup()</li>
<li>teardown()</li>
</ul>

<h3>testSetup:</h3>
The user will need to pass in what internet browser they want to use ("FireFox", "IE", "Chrome", "Safari", "Opera").
If using FireFox or Chrome then the user will need to download the correct driver for this:
Chrome -- https://sites.google.com/a/chromium.org/chromedriver/downloads
Firefox -- https://github.com/mozilla/geckodriver/releases

Within the setup method you will need to set the property to the downloaded file path, e.g. 
<em>System.setProperty("webdriver.chrome.driver", "/Users/Tom/Downloads/chromedriver");</em>


<h2>Google_testSuite.java:</h2>
TestSuites are classes which extend from baseTest.java and are designed to encompass all tests for a certain site/category. The testSuite is interpreted via the TestRunner class, all methods in this class will be run, therefore each method should be a test. 

The <strong>Google_testSuite.java </strong>file contains an example of tests that can be written and the layout/format.
Each Test Should Use:
<ul>
<li>return a boolean <strong>testResult</strong></li>
<li>testSetup to return the correct driver for the specified website</li>
<li>perform some operations which make the test</li>
<li>evaluate via any evaluation method in <strong>baseTestTypes.java</strong></li> (You can make your own)</li>
<li>call tearDown() after each test</li>
</ul>

<h2>baseTestTypes.java:</h2>
baseTestTypes is a class that holds methods to return the test result after an evaluation. 
You can create your own evaluation methods if needed as long as they follow the same format/output of the current ones.

<h2>TestRunner.java:</h2>
This Class is responsible for running all tests in a suite. It uses reflection to call all methods in a class. If all methods are written correctly in a suite then they will return the correct testdata and the output will be processed and printed to the terminal.
