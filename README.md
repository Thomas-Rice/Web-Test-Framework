# Web-Test-Framework
A testing framework written in Java designed to be lightweight and test websites for regressions based on a criteria set. 

baseTest.java:
This is the base class for all tests. It has two methods, setup and teardown.

Setup:
The user will need to pass in what internet browser they want to use ("FireFox", "IE", "Chrome", "Safari", "Opera").
If using FireFox or Chrome then the user will need to download the correct driver for this:
Chrome -- https://sites.google.com/a/chromium.org/chromedriver/downloads
Firefox -- https://github.com/mozilla/geckodriver/releases

Within the setup method you will need to set the property to the downloaded file path, e.g. 
    System.setProperty("webdriver.chrome.driver", "/Users/Tom/Downloads/chromedriver");
